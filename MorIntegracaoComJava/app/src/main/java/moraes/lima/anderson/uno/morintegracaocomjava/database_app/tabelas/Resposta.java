package moraes.lima.anderson.uno.morintegracaocomjava.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl resposta"
        , indices = {@Index(value = {"pergunta_id"}) , @Index(value = {"id"})}
        , foreignKeys = {@ForeignKey(entity = Pergunta.class , parentColumns = "id" ,
            childColumns = "pergunta_id" , onUpdate = CASCADE , onDelete = CASCADE)})

/*@Entity(tableName = "tbl aluno_prova"
        ,primaryKeys = {"idAluno" , "idProva"}
        , indices = {@Index(value = {"aluno_id"}) , @Index(value = {"prova_id"})}
        , foreignKeys = {@ForeignKey(entity = Aluno.class , parentColumns = "id" ,
            childColumns = "aluno_id" , onUpdate = CASCADE , onDelete = CASCADE)
            , @ForeignKey(entity = Prova.class , parentColumns = "id" ,
                    childColumns = "prova_id" , onUpdate = CASCADE , onDelete = CASCADE)})*/

public class Resposta {
    @PrimaryKey(autoGenerate = true)
    private int id, pergunta_id;

    private String resposta;

    public Resposta(){}

    // CONSTRUTOR DE CÓPIA
    public Resposta(Resposta tblResposta) {
        this.id             = tblResposta.getId();
        this.pergunta_id    = tblResposta.getPergunta_id();
        this.resposta       = tblResposta.getResposta();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPergunta_id() {
        return pergunta_id;
    }

    public void setPergunta_id(int pergunta_id) {
        this.pergunta_id = pergunta_id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
