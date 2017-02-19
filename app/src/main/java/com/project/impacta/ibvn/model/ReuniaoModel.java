package com.project.impacta.ibvn.model;

import java.util.Calendar;
import java.util.Date;


public class ReuniaoModel {

    private long codReuniao;           // Código da Reunião
    private String dataReuniao;        // Data da Reunião
    private String temaReuniao;        // Tema da Reunião
    private String statusReuniao;      // Status da Reunião
    private String descricaoReuniao;   // Descrição da Reunião

    //CÉLULA
    private CelulaModel celulaReuniao;

    public ReuniaoModel() {
    }

    /*Contrutor full - todos os valores são passados via parametros*/
    public ReuniaoModel(long codReuniao, String dataReuniao, String temaReuniao, String statusReuniao, String descricaoReuniao, int codCelula, String descricaoCelula, int codMenbroCriador, String nomeMembrocriador, int codMembroLider, String nomeMembroLider, String tipoEndereco, String logradouroEndereco, String numeroEndereco, String cepEndereco, String bairroEndereco, String cidadeEndereco, String ufEndereco, String latitudeEndereco, String longitudeEndereco) {

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
        this.celulaReuniao.getMembroCriador().codMembro = codMenbroCriador;
        this.celulaReuniao.getMembroCriador().nomeMembro = nomeMembrocriador;

        //MEMBRO LIDER
        this.celulaReuniao.getMembroLider().codMembro = codMembroLider;
        this.celulaReuniao.getMembroLider().nomeMembro = nomeMembroLider;

        this.celulaReuniao.getEnderecoCelula().setTipoEndereco(tipoEndereco);
        this.celulaReuniao.getEnderecoCelula().setLogradouroEndereco(logradouroEndereco);
        this.celulaReuniao.getEnderecoCelula().setNumeroEndereco(numeroEndereco);
        this.celulaReuniao.getEnderecoCelula().setCepEndereco(cepEndereco);
        this.celulaReuniao.getEnderecoCelula().setBairroEndereco(bairroEndereco);
        this.celulaReuniao.getEnderecoCelula().setCidadeEndereco(cidadeEndereco);
        this.celulaReuniao.getEnderecoCelula().setUfEndereco(ufEndereco);
        this.celulaReuniao.getEnderecoCelula().setLatitudeEndereco(latitudeEndereco);
        this.celulaReuniao.getEnderecoCelula().setLongitudeEndereco(longitudeEndereco);

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


        //CELULA
        this.celulaReuniao.setDescricaoCelula(descricaoCelula);


        //MEMBRO CRIADOR
        this.celulaReuniao.getMembroCriador().nomeMembro = nomeMembrocriador;

        //MEMBRO LIDER
        this.celulaReuniao.getMembroLider().nomeMembro = nomeMembroLider;

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
    public ReuniaoModel(long codReuniao, String dataReuniao, String temaReuniao, String statusReuniao, String descricaoReuniao, CelulaModel celulaReuniao) {
        this.codReuniao = codReuniao;
        this.dataReuniao = dataReuniao;
        this.temaReuniao = temaReuniao;
        this.statusReuniao = statusReuniao;
        this.descricaoReuniao = descricaoReuniao;
        this.celulaReuniao = celulaReuniao;
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

    public CelulaModel getCelulaReuniao() {
        return celulaReuniao;
    }

    public void setCelulaReuniao(CelulaModel celulaReuniao) {
        this.celulaReuniao = celulaReuniao;
    }
}