package moraes.lima.anderson.uno.morintegracaocomjava.database_app.dbcallbacks;

import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Aluno;

public interface IAlunoDbCallback {

    public void getAlunoFromDb(List<Aluno> tblAluno);
}
