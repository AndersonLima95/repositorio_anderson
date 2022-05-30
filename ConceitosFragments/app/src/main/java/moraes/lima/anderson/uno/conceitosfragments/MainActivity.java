package moraes.lima.anderson.uno.conceitosfragments;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class MainActivity extends FragmentActivity implements ToolbarFragment.ToolbarListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onButtonClick(int position, String texto) {
        TextoFragment tvExibirTexto = (TextoFragment) getSupportFragmentManager().findFragmentById(R.id.frgTexto);
        tvExibirTexto.trocarPropriedadesDoTexto(position, texto);

    }
}