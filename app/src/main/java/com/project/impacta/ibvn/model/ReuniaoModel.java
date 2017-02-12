package com.project.impacta.ibvn.model;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sebastiao Martins on 12/02/2017.
 */

public class ReuniaoModel {

    private long  codigo;
    private Calendar data;
    private String tema;
    private CelulaModel Celula;
    private int celula_cod;
    private String status;

    public ReuniaoModel(){};

    public ReuniaoModel(long codigo, Calendar data, String tema, CelulaModel celula, String status) {
        this.codigo = codigo;
        this.data = data;
        this.tema = tema;
        this.Celula = celula;
        this.status = status;
    }

    public long getCodigo() {return codigo;}

    public void setCodigo(long codigo) {this.codigo = codigo;}

    public Calendar getData() {return data;}

    public void setData(Calendar data) {this.data = data;}

    public String getTema() {return tema;}

    public void setTema(String tema) {this.tema = tema;}

    public CelulaModel getCelula() {return Celula;}

    public void setCelula(CelulaModel celula) {
        Celula = celula;
        celula_cod =  celula.codigo;
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}
}
