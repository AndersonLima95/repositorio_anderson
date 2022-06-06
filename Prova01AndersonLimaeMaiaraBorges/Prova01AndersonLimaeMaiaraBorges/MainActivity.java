package com.example.prova01andersonlimaemaiara;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ImageButton imgLimparPergunta , imgResponder;
    private EditText edtDigitarPergunta;
    private TextView tvPergunta , tvResposta;

    private static int QUESTAO02 = 2;
    private static int QUESTAO03 = 3;
    private static int QUESTAO04 = 4;
    private static int QUESTAO05 = 5;
    private static int QUESTAO06 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLimparPergunta        = findViewById(R.id.imgLimparPergunta);
        imgResponder        = findViewById(R.id.imgResponder);
        tvPergunta       = findViewById(R.id.tvPergunta);
        tvResposta       = findViewById(R.id.tvResposta);
        edtDigitarPergunta = findViewById(R.id.edtDigitarPergunta);

        PerguntaseRespostas perguntaseRespostas = new PerguntaseRespostas();


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Desenvolvedores em TI");

        }

        imgLimparPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPergunta.setText("");
                tvResposta.setText("");
                edtDigitarPergunta.setText("");
            }
        });

        imgResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!edtDigitarPergunta.getText().toString().isEmpty()){
                    if (Integer.valueOf(edtDigitarPergunta.getText().toString()) >= QUESTAO02 && Integer.valueOf(edtDigitarPergunta.getText().toString()) <= QUESTAO06){

                        int numeroQuestao = Integer.valueOf(edtDigitarPergunta.getText().toString());

                        if(numeroQuestao == QUESTAO02){
                            tvPergunta.setText(perguntaseRespostas.getPerguntas(2));
                            tvResposta.setText(perguntaseRespostas.getRespostas(2));
                            //tvPergunta.setText(String.valueOf(numeroQuestao));
                        }

                        if(numeroQuestao == QUESTAO03){
                            tvPergunta.setText(perguntaseRespostas.getPerguntas(3));
                            tvResposta.setText(perguntaseRespostas.getRespostas(3));
                        }

                        if(numeroQuestao == QUESTAO04){
                            tvPergunta.setText(perguntaseRespostas.getPerguntas(4));
                            tvResposta.setText(perguntaseRespostas.getRespostas(4));
                        }

                        if(numeroQuestao == QUESTAO05){
                            tvPergunta.setText(perguntaseRespostas.getPerguntas(5));
                            tvResposta.setText(perguntaseRespostas.getRespostas(5));
                        }

                        if(numeroQuestao == QUESTAO06){
                            tvPergunta.setText(perguntaseRespostas.getPerguntas(6));
                            tvResposta.setText(perguntaseRespostas.getRespostas(6));
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Digite um número válido de 2 a 6!!!", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Por favor informe o número da questão desejada !!!", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

}