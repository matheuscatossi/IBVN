package com.project.impacta.ibvn.model;

/**
 * Created by Sebastiao Martins on 12/02/2017.
 */

public class EnderecoModel {
    int codigo;
    String tipo;
    String logradouro;
    String numero;
    String cep;
    String bairro;
    String cidade;
    String uf;
    String complemento;

    public EnderecoModel(){};

    public EnderecoModel(int codigo, String tipo, String logradouro, String numero, String cep, String bairro, String cidade, String uf, String complemento) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
    }

    public int getCodigo() {return codigo;}

    public void setCodigo(int codigo) {this.codigo = codigo;}

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getLogradouro() {return logradouro;}

    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}

    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public String getCep() {return cep;}

    public void setCep(String cep) {this.cep = cep;}

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getUf() {return uf;}

    public void setUf(String uf) {this.uf = uf;}

    public String getComplemento() {return complemento;}

    public void setComplemento(String complemento) {this.complemento = complemento;}

    @Override
    public String toString() {
        return String.format("%s, Nº %s, CEP: %s",this.logradouro,this.numero,this.cep);
    }
}
