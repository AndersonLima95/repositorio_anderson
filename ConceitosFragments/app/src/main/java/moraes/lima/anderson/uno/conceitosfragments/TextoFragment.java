package moraes.lima.anderson.uno.conceitosfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;


public class TextoFragment extends Fragment {
    private TextView tvExibirTexto;


    public TextoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_textofragment, container , false);

        tvExibirTexto = view.findViewById(R.id.tvExibirTexto);

        return view ;
    }

    public void trocarPropriedadesDoTexto(int tamanhoDaFonte, String texto) {
        tvExibirTexto.setTextSize(tamanhoDaFonte);
        tvExibirTexto.setText(texto);

    }
}
