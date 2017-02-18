package com.project.impacta.ibvn.model;

public class CelulaModel {

    //CÉLULA
    private int codCelula;                               // Código da Célula
    private String descricaoCelula;                         // Descrição da Célula
    private String criado;                               // Criado em da Célula
    private String atualizado;                           // Atualizado em da Célula

    //CRIADOR
    private MembroModel membroCriador;
//    int codCriadoPor;                            // Código do membro criador
//    String criadoPor;                            // Nome do membro criador

    //LIDER
    private MembroModel membroLider;
//    int codLider;                                // Código do membro Lider
//    String LiderNome;                            // Nome do membro Lider

    //ENDEREÇO
    private EnderecoModel enderecoCelula;

//    String tipoEndereco;                         // Tipo do endereço
//    String logradouroEndereco;                   // Logradouro do endereço
//    String numeroEndereco;                       // Número do endereço
//    String cepEndereco;                          // CEP do endereço
//    String bairroEndereco;                       // Bairro do endereço
//    String cidadeEndereco;                       // Cidade do endereço
//    String ufEndereco;                           // UF do endereço
//    Double latitudeEndereco;                     // Latitude do endereço
//    Double longitudeEndereco;                    // Longitude do endereço
//    String criadoEmEndereco;                     // Data de criação do endereço


    public CelulaModel() {
    }

    public CelulaModel(int codCelula, String descricaoCelula, String criadoPor, String liderNome, String logradouroEndereco, String numeroEndereco, String cepEndereco, String bairroEndereco, String cidadeEndereco) {
        this.membroCriador = new MembroModel();
        this.membroLider = new MembroModel();
        this.enderecoCelula = new EnderecoModel();

        this.codCelula = codCelula;
        this.descricaoCelula = descricaoCelula;
//        this.criado = criado;
//        this.atualizado = atualizado;

        //MEMBRO CRIADOR
        //this.membroCriador.codMembro = codCriadoPor;
        this.membroCriador.nomeMembro = criadoPor;

        //MEMBRO LIDER
        //this.membroLider.codMembro = codLider;
        this.membroLider.nomeMembro = liderNome;

        //this.enderecoCelula.tipoEndereco = tipoEndereco;
        this.enderecoCelula.setLogradouroEndereco(logradouroEndereco);
        this.enderecoCelula.setNumeroEndereco(numeroEndereco);
        this.enderecoCelula.setCepEndereco(cepEndereco);
        this.enderecoCelula.setBairroEndereco(bairroEndereco);
        this.enderecoCelula.setCidadeEndereco(cidadeEndereco);
        //this.enderecoCelula.ufEndereco = ufEndereco;
        //this.enderecoCelula.latitudeEndereco = latitudeEndereco;
        //this.enderecoCelula.longitudeEndereco = longitudeEndereco;
    }


    public CelulaModel(int codCelula, String descricaoCelula, String criado, String atualizado, int codCriadoPor, String criadoPor, int codLider, String liderNome, String tipoEndereco, String logradouroEndereco, String numeroEndereco, String cepEndereco, String bairroEndereco, String cidadeEndereco, String ufEndereco, String latitudeEndereco, String longitudeEndereco) {
        this.membroCriador = new MembroModel();
        this.membroLider = new MembroModel();
        this.enderecoCelula = new EnderecoModel();

        this.codCelula = codCelula;
        this.descricaoCelula = descricaoCelula;
        this.criado = criado;
        this.atualizado = atualizado;

        //MEMBRO CRIADOR
        this.membroCriador.codMembro = codCriadoPor;
        this.membroCriador.nomeMembro = criadoPor;

        //MEMBRO LIDER
        this.membroLider.codMembro = codLider;
        this.membroLider.nomeMembro = liderNome;

        this.enderecoCelula.setTipoEndereco(tipoEndereco);
        this.enderecoCelula.setLogradouroEndereco(logradouroEndereco);
        this.enderecoCelula.setNumeroEndereco(numeroEndereco);
        this.enderecoCelula.setCepEndereco(cepEndereco);
        this.enderecoCelula.setBairroEndereco(bairroEndereco);
        this.enderecoCelula.setCidadeEndereco(cidadeEndereco);
        this.enderecoCelula.setUfEndereco(ufEndereco);
        this.enderecoCelula.setLatitudeEndereco(latitudeEndereco);
        this.enderecoCelula.setLongitudeEndereco(longitudeEndereco);
    }

    /*
    * CONSTRUTOR padrão utiliza instancia para preencher dados*/
    public CelulaModel(int codCelula, String descricaoCelula, String criado, String atualizado, MembroModel membroCriador, MembroModel membroLider, EnderecoModel enderecoCelula) {
        this.codCelula = codCelula;
        this.descricaoCelula = descricaoCelula;
        this.criado = criado;
        this.atualizado = atualizado;
        this.membroCriador = membroCriador;
        this.membroLider = membroLider;
        this.enderecoCelula = enderecoCelula;
    }

    public int getCodCelula() {
        return codCelula;
    }

    public void setCodCelula(int codCelula) {
        this.codCelula = codCelula;
    }

    public String getDescricaoCelula() {
        return descricaoCelula;
    }

    public void setDescricaoCelula(String descricaoCelula) {
        this.descricaoCelula = descricaoCelula;
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

    public MembroModel getMembroCriador() {
        return membroCriador;
    }

    public void setMembroCriador(MembroModel membroCriador) {
        this.membroCriador = membroCriador;
    }

    public int getCodCriadoPor() {
        return membroCriador.codMembro;
    }

    public void setCodCriadoPor(int codCriadoPor) {
        this.membroCriador.codMembro = codCriadoPor;
    }

    public String getCriadoPor() {
        return membroCriador.nomeMembro;
    }

    public void setCriadoPor(String criadoPor) {
        this.membroCriador.nomeMembro = criadoPor;
    }

    public MembroModel getMembroLider() {
        return membroLider;
    }

    public void setMembroLider(MembroModel membroLider) {
        this.membroLider = membroLider;
    }

    public int getCodLider() {
        return membroLider.codMembro;
    }

    public void setCodLider(int codLider) {
        this.membroLider.codMembro = codLider;
    }

    public String getLiderNome() {
        return membroLider.nomeMembro;
    }

    public void setLiderNome(String liderNome) {
        membroLider.nomeMembro = liderNome;
    }

    public EnderecoModel getEnderecoCelula() {
        return enderecoCelula;
    }

    public void setEnderecoCelula(EnderecoModel enderecoCelula) {
        this.enderecoCelula = enderecoCelula;
    }

    public String getTipoEndereco() {
        return enderecoCelula.getTipoEndereco();
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.enderecoCelula.setTipoEndereco(tipoEndereco);
    }

    public String getLogradouroEndereco() {
        return enderecoCelula.getLogradouroEndereco();
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.enderecoCelula.setLogradouroEndereco(logradouroEndereco);
    }

    public String getNumeroEndereco() {
        return enderecoCelula.getNumeroEndereco();
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.enderecoCelula.setNumeroEndereco(numeroEndereco);
    }

    public String getCepEndereco() {
        return enderecoCelula.getCepEndereco();
    }

    public void setCepEndereco(String cepEndereco) {
        this.enderecoCelula.setCepEndereco(cepEndereco);
    }

    public String getBairroEndereco() {
        return enderecoCelula.getBairroEndereco();
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.enderecoCelula.setBairroEndereco(bairroEndereco);
    }

    public String getCidadeEndereco() {
        return enderecoCelula.getCidadeEndereco();
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.enderecoCelula.setCidadeEndereco(cidadeEndereco);
    }

    public String getUfEndereco() {
        return enderecoCelula.getUfEndereco();
    }

    public void setUfEndereco(String ufEndereco) {
        this.enderecoCelula.setUfEndereco(ufEndereco);
    }

    public String getLatitudeEndereco() {
        return enderecoCelula.getLatitudeEndereco();
    }

    public void setLatitudeEndereco(String latitudeEndereco) {
        this.enderecoCelula.setLatitudeEndereco(latitudeEndereco);
    }

    public String getLongitudeEndereco() {
        return enderecoCelula.getLongitudeEndereco();
    }

    public void setLongitudeEndereco(String longitudeEndereco) {
        this.enderecoCelula.setLongitudeEndereco(longitudeEndereco);
    }

}
