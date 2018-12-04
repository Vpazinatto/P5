package com.example.u17415.resquesttest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.u17415.resquesttest.adapter.ApontamentosAdapter;
import com.example.u17415.resquesttest.adapter.ProjetosAdapter;
import com.example.u17415.resquesttest.modelo.Apontamento;
import com.example.u17415.resquesttest.modelo.Projeto;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog load;

    private ListView listaApontamentos;
    private FloatingActionButton btnFiltro;
    private Utils util = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaApontamentos = (ListView) findViewById(R.id.lista_apontamentos);

        btnFiltro = findViewById(R.id.fab);
        btnFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FiltroFragment ff = new FiltroFragment();
                ff.show(getSupportFragmentManager(), "dialog");
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