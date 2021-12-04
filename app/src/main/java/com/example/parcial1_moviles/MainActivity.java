package com.example.parcial1_moviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import db.MyDatabaseActions;
import model.Transporte;

public class MainActivity extends AppCompatActivity {

    private TextView textTitle;
    private EditText modelo;
    private RadioButton auto;
    private RadioButton moto;
    private Button guardarDatos;
    private Button mostrarDatos;
    private String tipoElegido;
    private ListView myListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTitle = (TextView) findViewById(R.id.titulo);
        modelo = (EditText) findViewById(R.id.editTextInput);
        auto = (RadioButton) findViewById(R.id.radioAuto);
        moto = (RadioButton) findViewById(R.id.radioMoto);
        guardarDatos = (Button) findViewById(R.id.buttonGuardar);
        mostrarDatos = (Button) findViewById(R.id.buttonMostrar);
        myListView = (ListView) findViewById(R.id.myListView);

        MyDatabaseActions actions = new MyDatabaseActions(this);
        guardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  actions.insertarDatos(modelo.toString(), tipoElegido);
            }
        });

        mostrarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   ArrayList<Transporte> listaTransportes = new ArrayList<Transporte>();
                   listaTransportes = actions.mostrarDatos();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioAuto:
                if (isChecked)
                    tipoElegido = "Auto";
            case R.id.radioMoto:
                if (isChecked)
                    tipoElegido = "Moto";
        }
    }
}