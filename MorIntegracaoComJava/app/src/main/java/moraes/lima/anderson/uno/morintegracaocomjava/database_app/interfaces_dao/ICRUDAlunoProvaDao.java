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
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.AlunoProva;

@Dao
public interface ICRUDAlunoProvaDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAlunoProva(AlunoProva tblAlunoProva);

    @Query("SELECT * FROM tblaluno_prova where aluno_id || prova_id = :id ")
    public AlunoProva getEspecificaAlunoById(int id);

    @Query("SELECT * FROM tblaluno_prova ORDER BY aluno_id || prova_id DESC")
    public List<AlunoProva> getAllAlunoProvas();

    @Transaction
    @Update(entity = AlunoProva.class , onConflict = OnConflictStrategy.REPLACE)
    public  void updateAlunoProvas(AlunoProva tblAlunoProva);

    @Transaction
    @Delete(entity = AlunoProva.class)
    public void deleteAlunoProva(AlunoProva tblAlunoProva);

    @Transaction
    @Query(" DELETE FROM tblaluno_prova where aluno_id || prova_id = :id")
    public void deleteAlunoProvaByID(int id);

    @Transaction
    @Query("DELETE FROM tblaluno_prova where aluno_id || prova_id > 0")
    public void deleteAllAlunoProvas();
}

