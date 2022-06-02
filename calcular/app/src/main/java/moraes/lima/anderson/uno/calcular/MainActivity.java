package moraes.lima.anderson.uno.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvOpcao , tvResultado , tvOperacao;
    private Spinner spiOpcoes;
    private EditText edtOperando1 , edtOperando2;
    private ImageView imgvOperacao , imgIgual;
    private Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOpcao         = findViewById(R.id.tvOpcao);
        spiOpcoes       = findViewById(R.id.spiOpcoes);
        tvOperacao      = findViewById(R.id.tvOperacao);
        edtOperando1    = findViewById(R.id.edtOperando1);
        imgvOperacao    = findViewById(R.id.imgvOperacao);
        edtOperando2    = findViewById(R.id.edtOperando2);
        imgIgual        = findViewById(R.id.imgIgual);
        btnCalcular     = findViewById(R.id.btnCalcular);
        tvResultado     = findViewById(R.id.tvResultado);
    }
}