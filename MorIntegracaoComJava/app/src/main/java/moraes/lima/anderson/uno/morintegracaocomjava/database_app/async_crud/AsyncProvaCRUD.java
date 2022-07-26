package moraes.lima.anderson.uno.morintegracaocomjava.database_app.async_crud;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.DatabaseApp;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.dbcallbacks.IProvaDbCallback;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Prova;
import moraes.lima.anderson.uno.morintegracaocomjava.utils_app.UtilsApp;

public class AsyncProvaCRUD extends AsyncTask<Prova, Integer, List<Prova>> {
    private static String TAG = "AsyncProvaCRUD";
    private UtilsApp.DataBaseCrudOperations dbOperations;
    private Context contextActivityOrFragment;
    private List<Prova> lista = null;

    //Evitar leak de memória
    private WeakReference<IProvaDbCallback> dbCallBack;

    public AsyncProvaCRUD(UtilsApp.DataBaseCrudOperations dbOperations
            , Context context
            , IProvaDbCallback callBack){
        this.dbOperations              = dbOperations;
        this.contextActivityOrFragment = context;
        dbCallBack                     = new WeakReference(callBack);
    }

    @Override
    protected List<Prova> doInBackground(Prova... provas) {
        try{
            DatabaseApp databaseApp = DatabaseApp.getInstance(contextActivityOrFragment);
            lista                   = null;

            switch (dbOperations){
                case CREATE:{
                    for(Prova prova : provas) {
                        databaseApp.provaDAO().insertProva(prova);
                    }
                    break;
                }
                case READ:{
                    lista = databaseApp.provaDAO().getAllProva();
                    break;
                }
                case UPDATE:{
                    databaseApp.provaDAO().updateProvas(provas[0]);
                    break;
                }
                case DELETE:{
                    databaseApp.provaDAO().deleteProva(provas[0]);
                    break;
                }
            }
        } catch (Exception e){
            Log.d(TAG, "doInBackground: FALHA - " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    protected void onPostExecute(List<Prova> provas) {
        super.onPostExecute(provas);

        if(dbOperations == UtilsApp.DataBaseCrudOperations.CREATE
                || dbOperations == UtilsApp.DataBaseCrudOperations.READ) {
            IProvaDbCallback callBack = dbCallBack.get();
            if (callBack != null) {
                callBack.getProvaFromDB(provas);
            }
        }
    }
}
