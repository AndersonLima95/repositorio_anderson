package moraes.lima.anderson.uno.morintegracaocomjava.database_app.dbcallbacks;

import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.AlunoProva;

public interface IAlunoProvaDbCallback {
    void getAlunoProvaFromDB(List<AlunoProva> tblAlunoProva);
}
