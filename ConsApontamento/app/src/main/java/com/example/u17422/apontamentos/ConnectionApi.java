package com.example.u17422.apontamentos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionApi
{
    private static HttpURLConnection conexao;
    private static InputStream is;
    private static String retorno;

    //Responsavel por carregar o Objeto JSON
    public static String getApontamentoFromApi(String url) {
        try {
            URL apiEnd = new URL(url);

            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setRequestMethod("GET");
            conexao.connect();

            if(conexao.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST)
                is = conexao.getInputStream();
            else
                is = conexao.getErrorStream();

            retorno = converterInputStreamToString(is);
            is.close();
            conexao.disconnect();
        } catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return retorno;
    }

    public static String getProjetosFromApi() {
        try {
            URL apiEnd = new URL("http://10.0.2.2:3000/projetos");

            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setRequestMethod("GET");
            conexao.connect();

            if(conexao.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST)
                is = conexao.getInputStream();
            else
                is = conexao.getErrorStream();

            retorno = converterInputStreamToString(is);
            is.close();
            conexao.disconnect();
        } catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return retorno;
    }

    private static String converterInputStreamToString(InputStream is) {
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));

            while((linha = br.readLine()) != null)
                buffer.append(linha);

            br.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        return buffer.toString();
    }
}