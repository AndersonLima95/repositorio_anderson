package moraes.lima.anderson.uno.calcular;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG              = "MainActivity";
    private static final String DIVISAO          = "Divisão";
    private static final String MULTIPLICACAO    = "Multiplicação";
    private static final String SOMA             = "Soma";
    private static final String SUBTRACAO        = "Subtração";
    private static final String LOGARITMO        = "Logaritmo";
    private static final String POTENCIACAO      = "Potenciação";
    private static final String POTENCIADEBASE10   = "Pontência de Base10";
    private static final String RAIZQUADRADA     = "Raiz Quadrada";
    public int ZERO = 0;
    public int BASE_DEZ = 10;
    private TextView tvOpcao , tvResultado ;
    private Spinner spiOpcoes;
    private EditText edtOperando1 , edtOperando2;
    private ImageView imgvOperacao , imgvIgual;
    private Button btnCalcular,btnLimpar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Calcular");

        }

        tvOpcao         = findViewById(R.id.tvOpcao);
        tvResultado     = findViewById(R.id.tvResultado);

        edtOperando1    = findViewById(R.id.edtOperando1);
        edtOperando2    = findViewById(R.id.edtOperando2);

        imgvOperacao    = findViewById(R.id.imgvOperacao);
        imgvOperacao.setVisibility(View.INVISIBLE);

        imgvIgual       = findViewById(R.id.imgvIgual);
        btnCalcular     = findViewById(R.id.btnCalcular);
        btnLimpar       = findViewById(R.id.btnLimpar);


        spiOpcoes       = findViewById(R.id.spiOpcoes);

        ArrayAdapter<String> adapterOperacoesMatematicas = new ArrayAdapter<>(MainActivity.this
                , android.R.layout.simple_spinner_item
                , getResources().getStringArray(R.array.operacoes_matematica));
        adapterOperacoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapterOperacoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this);



        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(validarOperacao(spiOpcoes.getSelectedItem().toStrign())){

                String operacaoSelecionada = spiOpcoes.getSelectedItem().toString();

                if (operacaoSelecionada.equals(DIVISAO)) {
                    if (validarTermosVazios()) {
                        if (validarDivisor()) {
                            tvResultado.setText(dividir());
                        } else {
                            Toast.makeText(MainActivity.this, "O divisor não pode ser ZERO!!", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();

                    }

                } else if (operacaoSelecionada.equals(MULTIPLICACAO)) {
                    if (validarTermosVazios()) {
                        tvResultado.setText(multiplicar());
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();

                    }

                } else if (operacaoSelecionada.equals(SOMA)) {
                    if (validarTermosVazios()) {
                        tvResultado.setText(somar());
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();

                    }

                } else if (operacaoSelecionada.equals(SUBTRACAO)) {
                    if (validarTermosVazios()) {
                        tvResultado.setText(subtrair());
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();

                    }

                } else if (operacaoSelecionada.equals(RAIZQUADRADA)) {
                    if (validarRaiz()) {
                        tvResultado.setText(radicar());
                    } else {
                        Toast.makeText(MainActivity.this, "Numero inválido!", Toast.LENGTH_SHORT).show();
                    }


                } else if (operacaoSelecionada.equals(POTENCIACAO)) {
                    if(validarTermosVazios()){
                    tvResultado.setText(potenciar());
                } else {
                    Toast.makeText(MainActivity.this, "Preencha com algum valor", Toast.LENGTH_SHORT).show();
                }


                } else if (operacaoSelecionada.equals(POTENCIADEBASE10)) {
                    if ((validaPrimeiroTermo())) {
                        tvResultado.setText(potencia10());
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor", Toast.LENGTH_SHORT).show();
                    }

                } else if(operacaoSelecionada.equals(LOGARITMO)){
                    if(validarTermosVazios()){
                        tvResultado.setText(logaritmo());
                    } else {
                        Toast.makeText(MainActivity.this, "Informe 2 numeros para calcular o logaritmo", Toast.LENGTH_SHORT).show();
                    }



                }else {
                    Toast.makeText(MainActivity.this, "Por favor selecione a operação matemática", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtOperando1.setText("");
                edtOperando2.setText("");
                tvResultado.setText("");
                //imgvIgual.setVisibility(View.INVISIBLE);
                //imgvOperacao.setVisibility(View.INVISIBLE);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        setEdtOperando2Block(false);

        //Toast.makeText(this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
        imgvOperacao.setVisibility(View.VISIBLE);
        // imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_soma , getTheme());


        if(adapterView.getItemAtPosition(i).toString().equals(DIVISAO)){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.divisao , getTheme()));
            edtOperando1.setHint("Dividendo");
            edtOperando2.setHint("Divisor");

        } else if(adapterView.getItemAtPosition(i).toString().equals(MULTIPLICACAO)){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.multiplica , getTheme()));
            edtOperando1.setHint("Multiplicando");
            edtOperando2.setHint("Multiplicador");

        } else if(adapterView.getItemAtPosition(i).toString().equals(SOMA)){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.soma , getTheme()));
            edtOperando1.setHint("Parcela");
            edtOperando2.setHint("Parcela");

        } else if(adapterView.getItemAtPosition(i).toString().equals(SUBTRACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.subtracao, getTheme()));
            edtOperando1.setHint("Minuendo");
            edtOperando2.setHint("Subtraendo");

        }else if(adapterView.getItemAtPosition(i).toString().equals(RAIZQUADRADA)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.raizquadrada, getTheme()));
            imgvOperacao.setVisibility(View.VISIBLE);
            edtOperando1.setHint("Radicando");
            setEdtOperando2Block(true);


        }else if(adapterView.getItemAtPosition(i).toString().equals(POTENCIACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.x_elevado_y, getTheme()));
            edtOperando1.setHint("Base");
            edtOperando2.setHint("Expoente");

        }else if(adapterView.getItemAtPosition(i).toString().equals(POTENCIADEBASE10)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.pot10, getTheme()));
            edtOperando1.setHint("Expoente");
            setEdtOperando2Block(true);




        } else if(adapterView.getItemAtPosition(i).toString().equals(LOGARITMO)){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_log, getTheme()));
            imgvOperacao.setVisibility(View.VISIBLE);
            edtOperando2.setVisibility(View.VISIBLE);



        } else{
            Log.d(TAG , "Nenhuma opção foi selecionada");

        }
        //app:srcCompat="@drawable/soma"


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private String dividir(){
        Double n1 = Double.valueOf(edtOperando1.getText().toString());
        Double n2 = Double.valueOf(edtOperando2.getText().toString());
        Double resultado = n1/n2;

        return " O resultado da divisão é : " + resultado;


    }

    private String multiplicar(){
        Double n1 = Double.valueOf(edtOperando1.getText().toString());
        Double n2 = Double.valueOf(edtOperando2.getText().toString());
        Double resultado = n1 * n2;

        return " O resultado da multiplicação é : " + resultado;

    }

    private String somar(){
        Double n1 = Double.valueOf(edtOperando1.getText().toString());
        Double n2 = Double.valueOf(edtOperando2.getText().toString());
        Double resultado = n1 + n2;

        return " O resultado da soma é : " + resultado;


    }
    private String subtrair(){
        Double n1 = Double.valueOf(edtOperando1.getText().toString());
        Double n2 = Double.valueOf(edtOperando2.getText().toString());
        Double resultado = n1 - n2;

        return " O resultado da subtração é : " + resultado;


    }


    private boolean validarTermosVazios(){
        if(!edtOperando1.getText().toString().isEmpty()){
            if(!edtOperando2.getText().toString().isEmpty()){
                return true;
            }else{
                edtOperando2.requestFocus();
                return false;
            }

        }else {
            edtOperando1.requestFocus();
            return false;
        }
    }


    private boolean validarDivisor(){
        Double n2 = Double.valueOf(edtOperando2.getText().toString());
        if(n2 != ZERO){
            return true;

        }else {
            return false;
        }
    }

    private boolean validarRaiz(){
        double n1 = Double.valueOf(edtOperando1.getText().toString());
        if(n1 != ZERO){
            return  true;
        } else {
            return false;
        }

    }


    private boolean validaPrimeiroTermo(){
        if(!edtOperando1.getText().toString().isEmpty()){
            return true;
        } else {
            edtOperando1.requestFocus();
            return false;
        }
    }


    //Logaritmo ou potenciacao de base2
    private String logaritmo(){
        double n1 = Double.parseDouble(edtOperando1.getText().toString());
        double n2 = Double.parseDouble(edtOperando2.getText().toString());

        double resultado = Math.log(n1/n2);

        return "O logaritmo é "+ resultado;
    }



    // Potenciação de base 10
    private String potencia10(){
        double n1 = Double.parseDouble(edtOperando1.getText().toString());

        double resultado = Math.pow(BASE_DEZ, n1);

        return "O resultado da potencia de 10 é :" + resultado;
    }

    //Raiz Quadrada
    private String radicar(){
        double n1 = Double.parseDouble(edtOperando1.getText().toString());
        double resultado = Math.sqrt(n1) ;

        return "O resultado da radicação é : " + resultado;
    }

    //Potenciação
    private String potenciar(){
        double n1 = Double.parseDouble(edtOperando1.getText().toString());
        double n2 = Double.parseDouble(edtOperando2.getText().toString());
        double resultado = Math.pow(n1,n2);

        return "O resultado da operação é :" + resultado;
    }

    private void setEdtOperando2Block(boolean block ){
        if(block) {
            //edtOperando2.setFocusable(false);
            //edtOperando2.setKeyListener(null);
            edtOperando2.setEnabled(false);
        } else {
            edtOperando2.setFocusable(true);
            //edtOperando2.setKeyListener(null);
            edtOperando2.setEnabled(true);
        }

    }

    /*private boolean validarOperacao(String tipoOperacao) {
        boolean op1 = validarTermoVazio(edtOperando1);
        boolean op2 = validarTermoVazio(edtOperando2);

        if (tipoOperacao.equals(DIVISAO)) {
            if (op1) {
                Toast.makeText(this, "Informe o Dividendo", Toast.LENGTH_SHORT).show();
                edtOperando1.requestFocus();
                return false;
            } else if (op2) {
                Toast.makeText(this, "Informe o Divisor", Toast.LENGTH_SHORT).show();
                edtOperando2.requestFocus();
                return false;
            } else if (validarDivisor()) {
                Toast.makeText(this, "Divisão por zero inválida", Toast.LENGTH_SHORT).show();
                edtOperando2.requestFocus();
                return false;
            }


        } else if (tipoOperacao.equals(MULTIPLICACAO)) {
            if (op1) {
                Toast.makeText(this, "Informe o Multiplicando", Toast.LENGTH_SHORT).show();
                edtOperando1.requestFocus();
                return false;
            } else if (op2) {
                Toast.makeText(this, "Informe o Multiplicador", Toast.LENGTH_SHORT).show();
                edtOperando2.requestFocus();
                return false;
            }

        } else if (tipoOperacao.equals(SOMA)) {
            if (op1) {
                Toast.makeText(this, "Informe a Parcela", Toast.LENGTH_SHORT).show();
                edtOperando1.requestFocus();
                return false;

            } else if (op2) {
                Toast.makeText(this, "Informe a Parcela", Toast.LENGTH_SHORT).show();
                edtOperando2.requestFocus();
                return false;
            }

        } else if (tipoOperacao.equals(SUBTRACAO)) {
            if (op1) {
                Toast.makeText(this, "Informe o Minuendo", Toast.LENGTH_SHORT).show();
                edtOperando1.requestFocus();
                return false;
            } else if (op2) {
                Toast.makeText(this, "Informe o Subtraendo", Toast.LENGTH_SHORT).show();
                edtOperando2.requestFocus();
                return false;
            }

        }
        return true;

    }*/







}