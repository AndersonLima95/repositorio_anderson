package moraes.lima.anderson.uno.morintegracaocomjava.database_app.interfaces_dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Pergunta;
import moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas.Prova;


@Dao
public interface ICRUDProvaDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)

    public void insertProva(Prova tblProva);

    @Query("SELECT * FROM tbl_prova where id = :id")
    public Prova getEspecificaProvaById(int id);

    @Query("SELECT * FROM tbl_prova ORDER BY id DESC")
    public List<Prova> getAllProva();

    @Transaction
    @Update(entity = Prova.class , onConflict = OnConflictStrategy.REPLACE)
    public  void updateProvas(Prova tblProva);

    @Transaction
    @Delete(entity = Prova.class)
    public void deleteProva(Prova tblProva);

    @Transaction
    @Query(" DELETE FROM tbl_prova where id = :id")
    public void deleteProvaByID(int id);

    @Transaction
    @Query("DELETE FROM tbl_prova where id > 0")
    public void deleteAllProvas();
}
