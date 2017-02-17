package com.project.impacta.ibvn.model;

public class EnderecoModel {

    int codEndereco;              // Código do Endereço
    String logradouroEndereco;    // Logradouro do Endereço
    String numeroEndereco;        // Numero do Endereço
    String cepEndereco;           // Cep do Endereço
    String complementoEndereco;   // Complemento do Endereço
    String bairroEndereco;        // Bairro do Endereço
    String cidadeEndereco;        // Cidade do Endereço
    String ufEndereco;            // UF do Endereço

    //TIPO DE ENDERECO
    int codTipoEndereco;          // Codigo Tipo do Endereço
    String tipoEndereco;          // Nome do Tipo de Endereço


    public EnderecoModel(String cepEndereco, String logradouroEndereco, String numeroEndereco, String bairroEndereco, String cidadeEndereco, String ufEndereco) {
        this.cepEndereco = cepEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.ufEndereco = ufEndereco;
    }

    public EnderecoModel(int codEndereco, String logradouroEndereco, String numeroEndereco, String cepEndereco, String complementoEndereco, String bairroEndereco, String cidadeEndereco, String ufEndereco, int codTipoEndereco, String tipoEndereco) {

        this.codEndereco = codEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.cepEndereco = cepEndereco;
        this.complementoEndereco = complementoEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.ufEndereco = ufEndereco;
        this.codTipoEndereco = codTipoEndereco;
        this.tipoEndereco = tipoEndereco;

    }


    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getUfEndereco() {
        return ufEndereco;
    }

    public void setUfEndereco(String ufEndereco) {
        this.ufEndereco = ufEndereco;
    }

    public int getCodTipoEndereco() {
        return codTipoEndereco;
    }

    public void setCodTipoEndereco(int codTipoEndereco) {
        this.codTipoEndereco = codTipoEndereco;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    @Override
    public String toString() {
        return String.format("%s, Nº %s, CEP: %s", this.logradouroEndereco, this.numeroEndereco, this.cepEndereco);
    }
}
