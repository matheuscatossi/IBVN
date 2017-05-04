package com.project.impacta.ibvn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Celula implements Serializable {

    //CÉLULA
    @SerializedName("id")
    @Expose
    private int Id;


    @SerializedName("nome")
    @Expose
    private String descricao;

    @SerializedName("cep")
    @Expose
    private String cep;

    @SerializedName("created_at ")
    @Expose
    private String criado;

    @SerializedName("updated_at")
    @Expose
    private String atualizado;

    @SerializedName("logradouro")
    @Expose
    private String logradouro;

    @SerializedName("numero")
    @Expose
    private String numero;

    @SerializedName("complemento")
    @Expose
    private String complemento;

    @SerializedName("bairro")
    @Expose
    private String bairro;

    @SerializedName("cidade")
    @Expose
    private String cidade;

    @SerializedName("estado")
    @Expose
    private String estado;

    @SerializedName("latitude")
    @Expose
    private double latitude;

    @SerializedName("logitude")
    @Expose
    private double longitude;

    //CRIADOR
    private Membro membroCriador;


    @SerializedName("lider")
    @Expose
    private int lider_id;

    //LIDER
    private Membro membroLider;


    public Celula() {
    }

    public Celula(
            int codCelula,
            String descricaoCelula,
            String criadoPor,
            String liderNome,
            String logradouroEndereco,
            String numeroEndereco,
            String cepEndereco,
            String bairroEndereco,
            String cidadeEndereco,
            String estadoEndereco,
            String complementoEndereco,
            String latitudeEndereco,
            String longitudeEndereco

    ) {

        this.membroCriador = new Membro();
        this.membroLider = new Membro();

        this.Id = codCelula;
        this.descricao= descricaoCelula;

        this.cep = cepEndereco;
        this.logradouro = logradouroEndereco;
        this.numero = numeroEndereco;
        this.complemento = complementoEndereco;
        this.bairro = bairroEndereco;
        this.cidade = cidadeEndereco;
        this.estado = estadoEndereco;
        this.latitude = Double.parseDouble(latitudeEndereco);
        this.longitude = Double.parseDouble(longitudeEndereco);

        //MEMBRO CRIADOR
        this.membroCriador.nome = criadoPor;

        //MEMBRO LIDER
        this.membroLider.nome = liderNome;

    }


    public Celula(
            int codCelula,
            String descricaoCelula,
            String criado,
            String atualizado,
            int codCriadoPor,
            String criadoPor,
            int codLider,
            String liderNome,
            String tipoEndereco,
            String logradouroEndereco,
            String numeroEndereco,
            String cepEndereco,
            String bairroEndereco,
            String cidadeEndereco,
            String ufEndereco,
            String latitudeEndereco,
            String longitudeEndereco) {
        this.membroCriador = new Membro();
        this.membroLider = new Membro();


        this.Id = codCelula;
        this.descricao= descricaoCelula;
        this.criado = criado;
        this.atualizado = atualizado;

        //MEMBRO CRIADOR
        this.membroCriador.id = codCriadoPor;
        this.membroCriador.nome = criadoPor;

        //MEMBRO LIDER
        this.membroLider.id = codLider;
        this.membroLider.nome = liderNome;

        this.setLogradouro(logradouroEndereco);
        this.setNumero(numeroEndereco);
        this.setCep(cepEndereco);
        this.setBairro(bairroEndereco);
        this.setCidade(cidadeEndereco);
        this.setEstado(ufEndereco);
        this.setLatitude(Double.parseDouble(latitudeEndereco));
        this.setLogitude(Double.parseDouble(longitudeEndereco));
    }

    /*
    * CONSTRUTOR padrão utiliza instancia para preencher dados*/
    public Celula(
            int codCelula
            , String descricaoCelula
            , String criado
            , String atualizado
            , Membro membroCriador
            , Membro membroLider
    ) {
        this.Id = codCelula;
        this.descricao= descricaoCelula;
        this.criado = criado;
        this.atualizado = atualizado;
        this.membroCriador = membroCriador;
        this.membroLider = membroLider;

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCriado() {
        return criado;
    }

    public void setCriado(String criado) {
        this.criado = criado;
    }

    public String getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(String atualizado) {
        this.atualizado = atualizado;
    }

    public Membro getMembroCriador() {
        return membroCriador;
    }

    public void setMembroCriador(Membro membroCriador) {
        this.membroCriador = membroCriador;
    }

    public int getCodCriadoPor() {
        return membroCriador.id;
    }

    public void setCodCriadoPor(int codCriadoPor) {
        this.membroCriador.id = codCriadoPor;
    }

    public String getCriadoPor() {
        return membroCriador.nome;
    }

    public void setCriadoPor(String criadoPor) {
        this.membroCriador.nome = criadoPor;
    }

    public Membro getMembroLider() {
        return membroLider;
    }

    public void setMembroLider(Membro membroLider) {
        this.membroLider = membroLider;
    }

    public int getCodLider() {
        return membroLider.id;
    }

    public void setCodLider(int codLider) {
        this.membroLider.id = codLider;
    }

    public String getLiderNome() {
        return membroLider.nome;
    }

    public void setLiderNome(String liderNome) {
        membroLider.nome = liderNome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLogitude() {
        return longitude;
    }

    public void setLogitude(double logitude) {
        this.longitude = logitude;
    }


    public int getLider_id() {
        return lider_id;
    }

    public void setLider_id(int lider_id) {
        this.lider_id = lider_id;
    }

}
