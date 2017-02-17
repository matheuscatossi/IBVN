package com.project.impacta.ibvn.model;

import java.util.Calendar;
import java.util.Date;


public class ReuniaoModel {

    private long codReuniao;           // Código da Reunião
    private String dataReuniao;        // Data da Reunião
    private String temaReuniao;        // Tema da Reunião
    private String statusReuniao;      // Status da Reunião
    private String descricaoReuniao;   // Descrição da Reunião

    private int celula_cod;

    public ReuniaoModel(long codReuniao, String dataReuniao, String temaReuniao, String statusReuniao, String descricaoReuniao, int celula_cod, CelulaModel celula) {
        this.codReuniao = codReuniao;
        this.dataReuniao = dataReuniao;
        this.temaReuniao = temaReuniao;
        this.statusReuniao = statusReuniao;
        this.descricaoReuniao = descricaoReuniao;
        this.celula_cod = celula_cod;

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

    public int getCelula_cod() {
        return celula_cod;
    }

    public void setCelula_cod(int celula_cod) {
        this.celula_cod = celula_cod;
    }

    public ReuniaoModel() {};


}