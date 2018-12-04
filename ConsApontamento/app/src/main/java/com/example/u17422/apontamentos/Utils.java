package com.example.u17422.apontamentos;

import com.example.u17422.apontamentos.modelo.Apontamento;
import com.example.u17422.apontamentos.modelo.Projeto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Utils
{
    List<Apontamento> apontamentos = new ArrayList<Apontamento>();
    String[] projetos;

    public List<Apontamento> getApontamentos(String end)
    {
        String json;
        List<Apontamento> retorno;

        json = ConnectionApi.getApontamentoFromApi(end);
        retorno = parseJsonApontamentos(json);

        return retorno;
    }

    public String[] getProjetos() {
        String json;
        String[] retorno;

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

    private String[] parseJsonProjetos(String json)
    {
        try
        {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray array = jsonObj.getJSONArray("recordset");

            for (int i =0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                projetos[i] = obj.getString("nome");
            }

            return projetos;
        }catch (JSONException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}