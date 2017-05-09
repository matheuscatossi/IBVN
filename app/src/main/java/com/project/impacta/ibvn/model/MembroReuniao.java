package com.project.impacta.ibvn.model;

/**
 * Created by matheuscatossi on 5/8/17.
 */

public class MembroReuniao {

    int fk_reuniao;
    int fk_membro;
    int presente;
    String created_at;
    String update_at;
    Membro membro;

    public MembroReuniao(){

    }

    public MembroReuniao(int fk_reuniao, int fk_membro, int presente, String created_at, String update_at, Membro membro){
        this.fk_reuniao = fk_reuniao;
        this.fk_membro = fk_membro;
        this.presente = presente;
        this.created_at = created_at;
        this.update_at = update_at;
        this.membro = membro;
    }

    public int getFk_reuniao() {
        return fk_reuniao;
    }

    public void setFk_reuniao(int fk_reuniao) {
        this.fk_reuniao = fk_reuniao;
    }

    public int getFk_membro() {
        return fk_membro;
    }

    public void setFk_membro(int fk_membro) {
        this.fk_membro = fk_membro;
    }

    public int getPresente() {
        return presente;
    }

    public void setPresente(int presente) {
        this.presente = presente;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }
}
