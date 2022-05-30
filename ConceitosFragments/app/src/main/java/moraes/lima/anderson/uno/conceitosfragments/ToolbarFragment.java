package moraes.lima.anderson.uno.conceitosfragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private EditText         edtInformarTexto;
    private SeekBar          skbFormatarTexto;
    private Button           btnTexto;
    private ToolbarListener  toolbarListener;
    private static  int textSize = 10;

    //Modo de declaração de interface , sempre segue esta assinatura.
    public interface ToolbarListener{
        void onButtonClick(int position , String texto);


    }

    public ToolbarFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public static ToolbarFragment newInstance(String param1, String param2) {

        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View toolBarLayoutInflater = inflater.inflate(R.layout.fragment_toolbar, container, false);

        edtInformarTexto = toolBarLayoutInflater.findViewById(R.id.edtInformarTexto);
        skbFormatarTexto = toolBarLayoutInflater.findViewById(R.id.skbFormatarTexto);
        btnTexto         = toolBarLayoutInflater.findViewById(R.id.btnTexto);

        btnTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });



        return toolBarLayoutInflater;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            toolbarListener = (ToolbarListener) context;

        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
            + "Obrigatório implementar a interface ToolbarListener");

        }
    }

    public void buttonClicked(View view){
        toolbarListener.onButtonClick(textSize, edtInformarTexto.getText().toString());

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        textSize = i;

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}