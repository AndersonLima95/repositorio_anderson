package formacao.desenvolvedores.tecnologia.uno.porjetodesoftwareorientadoaobjetos.conceitosintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
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

import formacao.desenvolvedores.tecnologia.uno.porjetodesoftwareorientadoaobjetos.conceitosintent.utils.app.UtilsApp;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
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

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Activity de Perguntas");
        }


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
                            //M??TODO 1 DE COLOCAR A RESPOSTA DENTRO DA INTENT.
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

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    tvTitulo.setVisibility(View.VISIBLE);
                    tvExibirResposta.setText(data.getExtras().getString("returnData"));
                }
            }
        });

        //CONVERS??O DE TIPOS PRIMITIVOS.
        UtilsApp utilsApp = new UtilsApp();
        Log.d(TAG , "Valor convertido de tipos primitivos double p/ int: "  + utilsApp.convertToInt(5.1987));

        byte b = -27;
        Log.d(TAG , "Valor convertido de tipos primitivos byte p/ int: "  + utilsApp.convertToInt(b));

        char valorChar = 'A';
        Log.d(TAG , "Valor convertido de tipos primitivos char p/ int: "  + utilsApp.convertToInt(valorChar));

        short valorShort = 1000;
        Log.d(TAG , "Valor convertido de tipos primitivos short p/ int: "  + utilsApp.convertToInt(valorShort));

        long valorLong = 9253531313189L;
        Log.d(TAG , "Valor convertido de tipos primitivos long p/ int: "  + utilsApp.convertToInt(valorLong));


        //Log.d(TAG , "Valor convertido de tipos primitivos String p/ int: "  + utilsApp.convertToInt("32"));

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
        //M??TODO 2 DE COLOCAR A PERGUNTA DENTRO DA INTENT.
        outraActivity.putExtra("Pergunta" , edtPergunta.getText().toString());

        activityResultLauncher.launch(outraActivity);

    }
}

