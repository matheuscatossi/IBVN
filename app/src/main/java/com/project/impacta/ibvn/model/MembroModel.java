package com.project.impacta.ibvn.model;

/**
 * Created by Matheus on 12/02/2017.
 */

public class MembroModel {

    /*  /
       //Informação Pessoal
     */
    int codMembro;                       // Código do membro
    String nomeMembro;                   // Nome do membro
    String sexoMembro;                   // Sexo do membro
    String cpfMembro;                    // Cpf do membro
    String emailMembro;                  // Email do membro
    int codCriadoPor;                    // Código do membro criador
    String criadoPor;                    // Nome do membro criador
    String statusMembro;                 // Status do membro
    String telefoneMembro;               // Telefone do membro
    String celularMembro;                // Celular do membro
    /*Talvez Date */ String criado;      // Data de criação do membro
    /*Talvez Date */ String atualizado;  // Data de atualização do membro

    /*  /
       //Endereço
     */
    String tipoEndereco;                         // Tipo do endereço
    String logradouroEndereco;                   // Logradouro do endereço
    String numeroEndereco;                       // Número do endereço
    String cepEndereco;                             // CEP do endereço
    String bairroEndereco;                       // Bairro do endereço
    String cidadeEndereco;                       // Cidade do endereço
    String ufEndereco;                           // UF do endereço
    Double latitudeEndereco;                     // Latitude do endereço
    Double longitudeEndereco;                    // Longitude do endereço
    /*Talvez date */ String criadoEmEndereco;  // Data de criação do endereço

    /*  /
       //Célula
     */
    int codCelula;                           // Código da célula
    int codLider;                            // Código do líder criador
    String nomeLider;                        // Nome do líder criador
    /*Talvez Date */ String criadoEmCelula;  // Data da criação da célula

    public MembroModel() {

    }

    public MembroModel(int codMembro, String nomeMembro, String sexoMembro, String cpfMembro, String emailMembro, int codCriadoPor, String criadoPor, String statusMembro, String telefoneMembro, String celularMembro, String criado, String atualizado, String tipoEndereco, String logradouroEndereco, String numeroEndereco, String cepEndereco, String bairroEndereco, String cidadeEndereco, String ufEndereco, Double latitudeEndereco, Double longitudeEndereco, String criadoEmEndereco, int codCelula, int codLider, String nomeLider, String criadoEmCelula) {
        this.codMembro           = codMembro;
        this.nomeMembro          = nomeMembro;
        this.sexoMembro          = sexoMembro;
        this.cpfMembro           = cpfMembro;
        this.emailMembro         = emailMembro;
        this.codCriadoPor        = codCriadoPor;
        this.criadoPor           = criadoPor;
        this.statusMembro        = statusMembro;
        this.telefoneMembro      = telefoneMembro;
        this.celularMembro       = celularMembro;
        this.criado              = criado;
        this.atualizado          = atualizado;
        this.tipoEndereco        = tipoEndereco;
        this.logradouroEndereco  = logradouroEndereco;
        this.numeroEndereco      = numeroEndereco;
        this.cepEndereco         = cepEndereco;
        this.bairroEndereco      = bairroEndereco;
        this.cidadeEndereco      = cidadeEndereco;
        this.ufEndereco          = ufEndereco;
        this.latitudeEndereco    = latitudeEndereco;
        this.longitudeEndereco   = longitudeEndereco;
        this.criadoEmEndereco    = criadoEmEndereco;
        this.codCelula           = codCelula;
        this.codLider            = codLider;
        this.nomeLider           = nomeLider;
        this.criadoEmCelula      = criadoEmCelula;
    }

    public MembroModel(int codMembro, String nomeMembro, String emailMembro, String sexoMembro){
        this.codMembro           = codMembro;
        this.nomeMembro          = nomeMembro;
        this.emailMembro         = emailMembro;
        this.sexoMembro          = sexoMembro;
    }


    public int getCodMembro() {
        return codMembro;
    }

    public void setCodMembro(int codMembro) {
        this.codMembro = codMembro;
    }

    public String getNomeMembro() {
        return nomeMembro;
    }

    public void setNomeMembro(String nomeMembro) {
        this.nomeMembro = nomeMembro;
    }

    public String getSexoMembro() {
        return sexoMembro;
    }

    public void setSexoMembro(String sexoMembro) {
        this.sexoMembro = sexoMembro;
    }

    public String getCpfMembro() {
        return cpfMembro;
    }

    public void setCpfMembro(String cpfMembro) {
        this.cpfMembro = cpfMembro;
    }

    public String getEmailMembro() {
        return emailMembro;
    }

    public void setEmailMembro(String emailMembro) {
        this.emailMembro = emailMembro;
    }

    public int getCodCriadoPor() {
        return codCriadoPor;
    }

    public void setCodCriadoPor(int codCriadoPor) {
        this.codCriadoPor = codCriadoPor;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public String getStatusMembro() {
        return statusMembro;
    }

    public void setStatusMembro(String statusMembro) {
        this.statusMembro = statusMembro;
    }

    public String getTelefoneMembro() {
        return telefoneMembro;
    }

    public void setTelefoneMembro(String telefoneMembro) {
        this.telefoneMembro = telefoneMembro;
    }

    public String getCelularMembro() {
        return celularMembro;
    }

    public void setCelularMembro(String celularMembro) {
        this.celularMembro = celularMembro;
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

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
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

    public Double getLatitudeEndereco() {
        return latitudeEndereco;
    }

    public void setLatitudeEndereco(Double latitudeEndereco) {
        this.latitudeEndereco = latitudeEndereco;
    }

    public Double getLongitudeEndereco() {
        return longitudeEndereco;
    }

    public void setLongitudeEndereco(Double longitudeEndereco) {
        this.longitudeEndereco = longitudeEndereco;
    }

    public String getCriado_em_endereco() {
        return criadoEmEndereco;
    }

    public void setCriadoEmEndereco(String criadoEmEndereco) {
        this.criadoEmEndereco = criadoEmEndereco;
    }

    public int getCodCelula() {
        return codCelula;
    }

    public void setCodCelula(int codCelula) {
        this.codCelula = codCelula;
    }

    public int getCodLider() {
        return codLider;
    }

    public void setCodLider(int codLider) {
        this.codLider = codLider;
    }

    public String getNomeLider() {
        return nomeLider;
    }

    public void setNomeLider(String nomeLider) {
        this.nomeLider = nomeLider;
    }

    public String getCriadoEmCelula() {
        return criadoEmCelula;
    }

    public void setCriadoEmCelula(String criadoEmCelula) {
        this.criadoEmCelula = criadoEmCelula;
    }

}
