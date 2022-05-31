package formacao.desenvolvedores.tecnologia.uno.porjetodesoftwareorientadoaobjetos.conceitosintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnPerguntar;
    private TextView tvExibirResposta;
    private TextView tvTitulo;
    private EditText edtPergunta;
    private ImageButton btnDelete;
    private static final int REQUEST_CODE = 5;
    private ActivityResultLauncher<Intent> activityResultLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnPerguntar        = findViewById(R.id.btnPerguntar);
        tvExibirResposta    = findViewById(R.id.tvExibirResposta);
        edtPergunta         = findViewById(R.id.edtPergunta);
        btnDelete           = findViewById(R.id.btnDelete);
        tvTitulo            = findViewById(R.id.tvTitulo);

        tvTitulo.setVisibility(View.INVISIBLE);


        btnPerguntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtPergunta.getText().toString().isEmpty()){
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                        Intent irParaOutraActivity = new Intent(MainActivity.this, RespostaActivity.class);

                        String conteudo = edtPergunta.getText().toString();
                        irParaOutraActivity.putExtra("Pergunta", conteudo);

                        if (!tvExibirResposta.getText().toString().isEmpty()) {
                            //MÉTODO 1 DE COLOCAR A RESPOSTA DENTRO DA INTENT.
                            String myResposta = tvExibirResposta.getText().toString();
                            irParaOutraActivity.putExtra("Resposta", myResposta);
                        }
                            startActivityForResult(irParaOutraActivity, REQUEST_CODE);

                    }else {
                        openActivityForResult();
                    }


                }else{

                        Toast.makeText(MainActivity.this, "Insira uma pergunta", Toast.LENGTH_LONG).show();

                }


            }

        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPergunta.setText("");
                tvExibirResposta.setText("");
            }
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    tvTitulo.setVisibility(View.VISIBLE);
                    tvExibirResposta.setText(data.getExtras().getString("returnData"));
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)){

            String returnString = data.getExtras().getString("returnData");



            if(returnString != null){
                if(!returnString.isEmpty()){
                    tvTitulo.setVisibility(View.VISIBLE);
                    //edtPergunta.setText(returnString);

                }
            }

            tvExibirResposta.setText(returnString);
        }
    }

    private void openActivityForResult(){
        Intent outraActivity  = new Intent(this , RespostaActivity.class);
        //MÉTODO 2 DE COLOCAR A PERGUNTA DENTRO DA INTENT.
        outraActivity.putExtra("Pergunta" , edtPergunta.getText().toString());

        activityResultLauncher.launch(outraActivity);

    }
}

