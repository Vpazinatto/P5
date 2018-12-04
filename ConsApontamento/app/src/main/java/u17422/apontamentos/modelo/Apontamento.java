package u17422.apontamentos.modelo;

import java.io.Serializable;

public class Apontamento implements Serializable {
    private Long ID;
    private Long IDprojeto;
    private Long IDprofissional;
    private String data;
    private int qtdHoras;
    private String descricao;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getIDprojeto() {
        return IDprojeto;
    }

    public void setIDprojeto(Long IDprojeto) {
        this.IDprojeto = IDprojeto;
    }

    public Long getIDprofissional() {
        return IDprofissional;
    }

    public void setIDprofissional(Long IDprofissional) {
        this.IDprofissional = IDprofissional;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(int qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
