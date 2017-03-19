package com.project.impacta.ibvn.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


public class ReuniaoModel implements Serializable {

    private long codReuniao;
    private String dataReuniao;
    private String temaReuniao;
    private String statusReuniao;
    private String descricaoReuniao;

    //CÉLULA Model
    private CelulaModel celulaReuniao;

    //Endereco Model
    private EnderecoModel enderecoReuniao;

    public ReuniaoModel() {
    }

    /*Contrutor full - todos os valores são passados via parametros*/
    public ReuniaoModel(
            long codReuniao
            , String dataReuniao
            , String temaReuniao
            , String statusReuniao
            , String descricaoReuniao

            , int codCelula
            , String descricaoCelula
            , int codMenbroCriador
            , String nomeMembrocriador
            , int codMembroLider
            , String nomeMembroLider

            , String tipoEndereco
            , String logradouroEndereco
            , String numeroEndereco
            , String cepEndereco
            , String bairroEndereco
            , String cidadeEndereco
            , String ufEndereco
            , String latitudeEndereco
            , String longitudeEndereco

            , String tipoEnderecoReuniao
            , String logradouroEnderecoReuniao
            , String numeroEnderecoReuniao
            , String cepEnderecoReuniao
            , String bairroEnderecoReuniao
            , String cidadeEnderecoReuniao
            , String ufEnderecoReuniao
            , String latitudeEnderecoReuniao
            , String longitudeEnderecoReuniao

    ) {

        this.celulaReuniao = new CelulaModel();
        this.celulaReuniao.setMembroCriador(new MembroModel());
        this.celulaReuniao.setMembroLider(new MembroModel());
        this.celulaReuniao.setEnderecoCelula(new EnderecoModel());

        ///REUNIAO
        this.codReuniao = codReuniao;
        this.dataReuniao = dataReuniao;
        this.temaReuniao = temaReuniao;
        this.statusReuniao = statusReuniao;
        this.descricaoReuniao = descricaoReuniao;

        //CELULA
        this.celulaReuniao.setCodCelula(codCelula);
        this.celulaReuniao.setDescricaoCelula(descricaoCelula);

        //MEMBRO CRIADOR
        this.celulaReuniao.getMembroCriador().id = codMenbroCriador;
        this.celulaReuniao.getMembroCriador().nome = nomeMembrocriador;

        //MEMBRO LIDER
        this.celulaReuniao.getMembroLider().id = codMembroLider;
        this.celulaReuniao.getMembroLider().nome = nomeMembroLider;

        this.celulaReuniao.getEnderecoCelula().setTipoEndereco(tipoEndereco);
        this.celulaReuniao.getEnderecoCelula().setLogradouroEndereco(logradouroEndereco);
        this.celulaReuniao.getEnderecoCelula().setNumeroEndereco(numeroEndereco);
        this.celulaReuniao.getEnderecoCelula().setCepEndereco(cepEndereco);
        this.celulaReuniao.getEnderecoCelula().setBairroEndereco(bairroEndereco);
        this.celulaReuniao.getEnderecoCelula().setCidadeEndereco(cidadeEndereco);
        this.celulaReuniao.getEnderecoCelula().setUfEndereco(ufEndereco);
        this.celulaReuniao.getEnderecoCelula().setLatitudeEndereco(latitudeEndereco);
        this.celulaReuniao.getEnderecoCelula().setLongitudeEndereco(longitudeEndereco);


        //ENDERECO REUNIÃO
        this.enderecoReuniao.setTipoEndereco(tipoEnderecoReuniao);
        this.enderecoReuniao.setLogradouroEndereco(logradouroEnderecoReuniao);
        this.enderecoReuniao.setNumeroEndereco(numeroEnderecoReuniao);
        this.enderecoReuniao.setCepEndereco(cepEnderecoReuniao);
        this.enderecoReuniao.setBairroEndereco(bairroEnderecoReuniao);
        this.enderecoReuniao.setCidadeEndereco(cidadeEnderecoReuniao);
        this.enderecoReuniao.setUfEndereco(ufEnderecoReuniao);
        this.enderecoReuniao.setLatitudeEndereco(latitudeEnderecoReuniao);
        this.enderecoReuniao.setLongitudeEndereco(longitudeEnderecoReuniao);

    }


    /*
    * Construtor utilizado para carregadar dados para a lista
    * */
    public ReuniaoModel(long codReuniao, String dataReuniao, String temaReuniao, String descricaoCelula, String nomeMembrocriador, String nomeMembroLider, String logradouroEndereco, String numeroEndereco, String cepEndereco, String bairroEndereco, String cidadeEndereco, String ufEndereco) {

        this.celulaReuniao = new CelulaModel();
        this.celulaReuniao.setMembroCriador(new MembroModel());
        this.celulaReuniao.setMembroLider(new MembroModel());
        this.celulaReuniao.setEnderecoCelula(new EnderecoModel());

        //REUNIAO
        this.codReuniao = codReuniao;
        this.dataReuniao = dataReuniao;
        this.temaReuniao = temaReuniao;


        //CÉLULA
        this.celulaReuniao.setDescricaoCelula(descricaoCelula);


        //MEMBRO CRIADOR
        this.celulaReuniao.getMembroCriador().nome = nomeMembrocriador;

        //MEMBRO LIDER
        this.celulaReuniao.getMembroLider().nome = nomeMembroLider;

        //ENDECEREO CELULA
        this.celulaReuniao.getEnderecoCelula().setLogradouroEndereco(logradouroEndereco);
        this.celulaReuniao.getEnderecoCelula().setNumeroEndereco(numeroEndereco);
        this.celulaReuniao.getEnderecoCelula().setCepEndereco(cepEndereco);
        this.celulaReuniao.getEnderecoCelula().setBairroEndereco(bairroEndereco);
        this.celulaReuniao.getEnderecoCelula().setCidadeEndereco(cidadeEndereco);
        this.celulaReuniao.getEnderecoCelula().setUfEndereco(ufEndereco);
    }

    /*
    * Contrutor padrão utilizando model para relacionamento.
    * */
    public ReuniaoModel(long codReuniao, String dataReuniao, String temaReuniao, String statusReuniao, String descricaoReuniao, CelulaModel celulaReuniao, EnderecoModel enderecoReuniao) {
        this.codReuniao = codReuniao;
        this.dataReuniao = dataReuniao;
        this.temaReuniao = temaReuniao;
        this.statusReuniao = statusReuniao;
        this.descricaoReuniao = descricaoReuniao;
        this.celulaReuniao = celulaReuniao;
        this.enderecoReuniao = enderecoReuniao;
    }


    public long getCodReuniao() {
        return codReuniao;
    }

    public void setCodReuniao(long codReuniao) {
        this.codReuniao = codReuniao;
    }

    public String getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(String dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public String getTemaReuniao() {
        return temaReuniao;
    }

    public void setTemaReuniao(String temaReuniao) {
        this.temaReuniao = temaReuniao;
    }

    public String getStatusReuniao() {
        return statusReuniao;
    }

    public void setStatusReuniao(String statusReuniao) {
        this.statusReuniao = statusReuniao;
    }

    public String getDescricaoReuniao() {
        return descricaoReuniao;
    }

    public void setDescricaoReuniao(String descricaoReuniao) {
        this.descricaoReuniao = descricaoReuniao;
    }

    public EnderecoModel getEnderecoReuniao() {
        return enderecoReuniao;
    }

    public void setEnderecoReuniao(EnderecoModel enderecoReuniao) {
        this.enderecoReuniao = enderecoReuniao;
    }


    public CelulaModel getCelulaReuniao() {
        return celulaReuniao;
    }

    public void setCelulaReuniao(CelulaModel celulaReuniao) {
        this.celulaReuniao = celulaReuniao;
    }
}