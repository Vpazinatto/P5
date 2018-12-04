package com.example.u17415.resquesttest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ListView;

import com.example.u17415.resquesttest.adapter.ApontamentosAdapter;
import com.example.u17415.resquesttest.modelo.Apontamento;
import com.example.u17415.resquesttest.modelo.Projeto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils
{
    List<Apontamento> apontamentos = new ArrayList<Apontamento>();
    List<Projeto> projetos = new ArrayList<Projeto>();

    public List<Apontamento> getApontamentos(String end)
    {
        String json;
        List<Apontamento> retorno;

        json = ConnectionApi.getApontamentoFromApi(end);
        retorno = parseJsonApontamentos(json);

        return retorno;
    }

    public List<Projeto> getProjetos() {
        String json;
        List<Projeto> retorno;

        json = ConnectionApi.getProjetosFromApi();
        retorno = parseJsonProjetos(json);

        return retorno;
    }

    private List<Apontamento> parseJsonApontamentos(String json)
    {
        try
        {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray array = jsonObj.getJSONArray("recordset");

            for (int i =0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Apontamento apontamento = new Apontamento();
                apontamento.setID(obj.getLong("id"));
                apontamento.setIDprojeto(obj.getLong("idProjeto"));
                apontamento.setIDprofissional(obj.getLong("idProfissional"));
                apontamento.setData(obj.getString("data"));
                apontamento.setQtdHoras(obj.getInt("qtdeHoras"));
                apontamento.setDescricao(obj.getString("descricao"));
                apontamentos.add(apontamento);
            }

            return apontamentos;
        }catch (JSONException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private List<Projeto> parseJsonProjetos(String json)
    {
        try
        {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray array = jsonObj.getJSONArray("recordset");

            for (int i =0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Projeto projeto = new Projeto();
                projeto.setID(obj.getLong("id"));
                projeto.setNome(obj.getString("nome"));
                projetos.add(projeto);
            }

            return projetos;
        }catch (JSONException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}