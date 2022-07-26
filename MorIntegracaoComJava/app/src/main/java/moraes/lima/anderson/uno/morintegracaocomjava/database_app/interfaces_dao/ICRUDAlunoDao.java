package moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;


import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Aluno;

@Dao
public interface ICRUDAlunoDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAluno(Aluno tblAluno);

    @Query("SELECT * FROM tbl_aluno where id = :id") // ID É A CHAVE PRIMÁRIA DA TABELA.
    Aluno getEspecificaAlunoById(int id);

    @Query("SELECT * FROM tbl_aluno ORDER BY id DESC")
    List<Aluno> getAllAlunos();

    @Transaction
    @Update(entity = Aluno.class , onConflict = OnConflictStrategy.REPLACE)
    void updateAlunos(Aluno tblAluno);

    @Transaction
    @Delete(entity = Aluno.class)
    void deleteAluno(Aluno tblAluno);

    @Transaction
    @Query(" DELETE FROM tbl_aluno where id = :id")
    void deleteAlunoByID(int id);

    @Transaction
    @Query("DELETE FROM tbl_aluno where id > 0")
    void deleteAllAlunos();

}
