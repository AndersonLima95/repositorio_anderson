package moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.AlunoProva;


@Dao
public interface ICRUDAlunoProvaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAlunoProva(AlunoProva alunoProvaTable);

    @Query("SELECT * FROM tblaluno_prova where aluno_id = :aluno_id AND prova_id = :prova_id")
    public AlunoProva getEspecificAlunoProvaByID(int aluno_id, int prova_id);

    @Query("SELECT * FROM tblaluno_prova ORDER BY aluno_id, prova_id DESC")
    public List<AlunoProva> getAllAlunosProvas();

    @Transaction
    @Update(entity = AlunoProva.class, onConflict = OnConflictStrategy.REPLACE)
    public void updateAlunoProva(AlunoProva alunoProvaTable);

    //CASCADE definido nas tabelas base
    @Transaction
    @Delete(entity = AlunoProva.class)
    public void deleteAlunoProva(AlunoProva alunoProvaTable);

    @Transaction
    @Query("DELETE FROM tblaluno_prova WHERE aluno_id = :aluno_id")
    public void deleteAlunoProvaByID(int aluno_id);

    @Transaction
    @Query("DELETE FROM tblaluno_prova WHERE aluno_id > 0")
    public void deleteAllAlunosProvas();
}
