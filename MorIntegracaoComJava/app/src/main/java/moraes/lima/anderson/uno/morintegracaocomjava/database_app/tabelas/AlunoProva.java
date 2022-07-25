package moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

/*DEFINIÇÃO DE CHAVES ENSTRANGEIRAS*/
@Entity(tableName = "tbl aluno_prova"
        ,primaryKeys = {"idAluno" , "idProva"}
        , indices = {@Index(value = {"aluno_id"}) , @Index(value = {"prova_id"}) , @Index(value = {"id"})}
        , foreignKeys = {@ForeignKey(entity = Aluno.class , parentColumns = "id" ,
            childColumns = "aluno_id" , onUpdate = CASCADE , onDelete = CASCADE)
            , @ForeignKey(entity = Prova.class , parentColumns = "id" ,
                    childColumns = "prova_id" , onUpdate = CASCADE , onDelete = CASCADE)})

public class AlunoProva {

    private int aluno_id , prova_id;

    public AlunoProva(){}

    // CONSTRUTOR DE CÓPIA
    public AlunoProva(AlunoProva tblAlunoProva) {
        this.aluno_id = tblAlunoProva.getAluno_id();
        this.prova_id = tblAlunoProva.getProva_id();
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    public int getProva_id() {
        return prova_id;
    }

    public void setProva_id(int prova_id) {
        this.prova_id = prova_id;
    }
}
