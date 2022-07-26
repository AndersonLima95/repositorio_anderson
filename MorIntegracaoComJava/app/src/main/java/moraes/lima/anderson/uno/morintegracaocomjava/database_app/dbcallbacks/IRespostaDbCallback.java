package moraes.lima.anderson.uno.morintegracaocomjava.database_app.dbcallbacks;

import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Resposta;

public interface IRespostaDbCallback {
    void getRespostaFromDB(List<Resposta> tblResposta);
}
