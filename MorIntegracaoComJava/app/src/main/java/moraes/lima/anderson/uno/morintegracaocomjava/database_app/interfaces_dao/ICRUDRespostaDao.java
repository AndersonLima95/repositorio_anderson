package moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Prova;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Resposta;

@Dao
public interface ICRUDRespostaDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)

    public void insertResposta(Resposta tblResposta);

    @Query("SELECT * FROM tbl_prova where id = :id")
    public Resposta getEspecificaRespostaById(int id);

    @Query("SELECT * FROM tbl_resposta ORDER BY id DESC")
    public List<Resposta> getAllResposta();

    @Transaction
    @Update(entity = Resposta.class , onConflict = OnConflictStrategy.REPLACE)
    public  void updateRespostas(Resposta tblResposta);

    @Transaction
    @Delete(entity = Resposta.class)
    public void deleteResposta(Resposta tblResposta);

    @Transaction
    @Query(" DELETE FROM tbl_resposta where id = :id")
    public void deleteRespostaByID(int id);

    @Transaction
    @Query("DELETE FROM tbl_resposta where id > 0")
    public void deleteAllRespostas();
}


