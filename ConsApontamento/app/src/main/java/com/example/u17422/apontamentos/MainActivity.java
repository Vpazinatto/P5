package com.example.u17422.apontamentos;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.u17415.resquesttest.R;
import com.example.u17422.apontamentos.adapter.ApontamentosAdapter;
import com.example.u17422.apontamentos.modelo.Apontamento;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog load;
    private ListView listaApontamentos;
    private FloatingActionButton btnFiltro;
    private AlertDialog.Builder builder;
    private AlertDialog alert;
    private String choice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaApontamentos = (ListView) findViewById(R.id.lista_apontamentos);

        builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = MainActivity.this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.filtro_dialog, null))
                .setTitle(R.string.filtro)
                .setPositiveButton(R.string.apply, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        onResume();
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
        });
        alert = builder.create();

        btnFiltro = findViewById(R.id.fab);
        btnFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = "";
                alert.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        GetJson load = new GetJson();
        load.execute();
    }

    public class GetJson extends AsyncTask<Void, Void,  List<Apontamento>> {
        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MainActivity.this,
                "Por favor Aguarde ...", "Conectando com o servidor...");
        }

        @Override
        protected List<Apontamento> doInBackground(Void... params) {
            Utils util = new Utils();

            if (choice != "")
                return util.getApontamentos("http://10.0.2.2:3000/apontamentos/projeto/" + choice);

            //se estiver rodando no emulador usar o IP 10.0.2.2 Se for no celular 127.0.0.1
            return util.getApontamentos("http://10.0.2.2:3000/apontamentos");
        }

        @Override
        protected void onPostExecute(List<Apontamento> apontamentos)
        {
            ApontamentosAdapter adapter = new ApontamentosAdapter(MainActivity.this, apontamentos);
            listaApontamentos.setAdapter(adapter);
            load.dismiss();
        }
    }
}