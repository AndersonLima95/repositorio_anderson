package moraes.lima.anderson.uno.morintegracaocomjava.database_app.dbcallbacks;

import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Prova;

public interface IProvaDbCallback {
    void getProvaFromDB(List<Prova> tblProva);
}
