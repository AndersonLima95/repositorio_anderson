package moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Aluno;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Pergunta;

@Dao
public interface ICRUDPerguntaDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)

    public void insertPergunta(Pergunta tblPergunta);

    @Query("SELECT * FROM tbl_pergunta where id = :id")
    public Pergunta getEspecificaPerguntaById(int id);

    @Query("SELECT * FROM tbl_pergunta ORDER BY id DESC")
    public List<Pergunta> getAllPerguntas();

    @Transaction
    @Update(entity = Pergunta.class , onConflict = OnConflictStrategy.REPLACE)
    public  void updatePerguntas(Pergunta tblPergunta);

    @Transaction
    @Delete(entity = Pergunta.class)
    public void deletePergunta(Pergunta tblPergunta);

    @Transaction
    @Query(" DELETE FROM tbl_pergunta where id = :id")
    public void deletePerguntaByID(int id);

    @Transaction
    @Query("DELETE FROM tbl_pergunta where id > 0")
    public void deleteAllPerguntas();
}
