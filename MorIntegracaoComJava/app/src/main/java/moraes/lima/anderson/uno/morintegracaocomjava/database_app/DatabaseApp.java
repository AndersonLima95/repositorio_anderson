package moraes.lima.anderson.uno.morintegracaocomjava.database_app;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.concurrent.Executors;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.converter.Converters;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDAlunoDao;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDAlunoProvaDao;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDPerguntaDao;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDProvaDao;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao.ICRUDRespostaDao;

@TypeConverters({Converters.class})
public abstract class DatabaseApp extends RoomDatabase {
    private static final String TAG = "DatabaseApp";
    private static final String DB_NAME = "db_app.db";
    private static volatile DatabaseApp sInstance;

    public abstract ICRUDAlunoDao alunosDAO();
    public abstract ICRUDAlunoProvaDao alunoProvaDAO();
    public abstract ICRUDProvaDao provaDAO();
    public abstract ICRUDPerguntaDao perguntaDAO();
    public abstract ICRUDRespostaDao respostaDAO();

    public DatabaseApp() {}

    public static synchronized DatabaseApp getInstance(Context context) {
        if(sInstance == null){
            sInstance = getConnection(context);
        }

        return sInstance;
    }

    private static DatabaseApp getConnection(Context contextActivity) {
        return null;

    }


    static RoomDatabase.Callback initDB = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadScheduledExecutor().execute(() -> {
            //Executar métodos e\ou rotinas logo após a criação do banco
                Log.d(TAG, " Banco criado com sucesso! Executar rotinas posteriores");

            });
        }

        public void onOpen(SupportSQLiteDatabase db){

        }
    };


}
