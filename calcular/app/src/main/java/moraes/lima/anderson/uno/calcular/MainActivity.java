package moraes.lima.anderson.uno.calcular;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView tvOpcao , tvResultado , tvOperacao;
    private Spinner spiOpcoes;
    private EditText edtOperando1 , edtOperando2;
    private ImageView imgvOperacao , imgvIgual;
    private Button btnCalcular;
    private static final String DIVISAO = "Divisão";
    private static final String MULTIPLICACAO = "Multiplicão";
    private static final String SOMA = "Soma";
    private static final String SUBTRACAO = "Subtração";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Calcular");

        }

        tvOpcao         = findViewById(R.id.tvOpcao);
        tvOperacao      = findViewById(R.id.tvOperacao);
        tvResultado     = findViewById(R.id.tvResultado);

        edtOperando1    = findViewById(R.id.edtOperando1);
        edtOperando2    = findViewById(R.id.edtOperando2);

        imgvOperacao    = findViewById(R.id.imgvOperacao);
        imgvOperacao.setVisibility(View.INVISIBLE);

        imgvIgual       = findViewById(R.id.imgvIgual);
        btnCalcular     = findViewById(R.id.btnCalcular);


        spiOpcoes       = findViewById(R.id.spiOpcoes);


            ArrayAdapter<String> adapteroperacoesMatematicas = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item , getResources().getStringArray(R.array.operacoes_matematica));
            adapteroperacoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spiOpcoes.setAdapter(adapteroperacoesMatematicas);
            spiOpcoes.setOnItemSelectedListener(this);

        String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (opcaoSelecionada == DIVISAO ) {

                }
                if(opcaoSelecionada == MULTIPLICACAO){

                }
                if(opcaoSelecionada == SOMA){

                }
                if(opcaoSelecionada == SUBTRACAO){

                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, adapterView.getItemIdAtPosition(i), Toast.LENGTH_SHORT).show();
        if(adapterView.getItemIdAtPosition(i).toString() == DIVISAO){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_soma , getTheme());

        }
        if(edtOperando1.getText().toString() == MULTIPLICACAO){

        }
        if(edtOperando1.getText().toString() == SOMA){

        }
        if(edtOperando1.getText().toString() == SUBTRACAO){

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}