package com.project.impacta.ibvn.model;

/**
 * Created by Sebastiao Martins on 12/02/2017.
 */

public class CelulaModel {

    int codigo;
    MembroModel Lider;
    EnderecoModel Endereco;
    int endereco_cod;
    MembroModel criado_por;
    int criado_po_cod;

    public CelulaModel( ) {}

    public CelulaModel(int codigo, MembroModel lider, EnderecoModel endereco, MembroModel criado_por) {
        this.codigo = codigo;
        Lider = lider;
        Endereco = endereco;
        this.criado_por = criado_por;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public MembroModel getLider() {
        return Lider;
    }

    public void setLider(MembroModel lider) {
        Lider = lider;
    }

    public EnderecoModel getEndereco() {
        return Endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        Endereco = endereco; this.endereco_cod = endereco.codigo;
    }

    public int getEndereco_id() {
        return endereco_cod;
    }

    public void setEndereco_id(int endereco_cod) {this.endereco_cod = endereco_cod;}

    public MembroModel getCriado_por() {
        return criado_por;
    }

    public void setCriado_por(MembroModel criado_por) {
        this.criado_por = criado_por;
        this.criado_po_cod = criado_por.codigo;
    }

    public int getId_criado_por() {
        return criado_po_cod;
    }

    public void setId_criado_por(int criado_po_cod) {
        this.criado_po_cod = criado_po_cod;
    }
}
