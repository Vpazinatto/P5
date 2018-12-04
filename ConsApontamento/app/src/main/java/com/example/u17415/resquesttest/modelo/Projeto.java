package com.example.u17415.resquesttest.modelo;

import java.io.Serializable;

public class Projeto implements Serializable {
    private Long ID;
    private String nome;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
