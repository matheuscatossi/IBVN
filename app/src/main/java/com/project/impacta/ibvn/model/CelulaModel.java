package com.project.impacta.ibvn.model;

/**
 * Created by Sebastiao Martins on 12/02/2017.
 */

public class CelulaModel {

    //CÉLULA
    int codCelula;                               // Código da Célula
    int descricaoCelula;                         // Descrição da Célula
    String criado;                               // Criado em da Célula
    String atualizado;                           // Atualizado em da Célula

    //CRIADOR
    int codCriadoPor;                            // Código do membro criador
    String criadoPor;                            // Nome do membro criador

    //LIDER
    int codLider;                                // Código do membro Lider
    String LiderNome;                            // Nome do membro Lider

    //ENDEREÇO
    String tipoEndereco;                         // Tipo do endereço
    String logradouroEndereco;                   // Logradouro do endereço
    String numeroEndereco;                       // Número do endereço
    String cepEndereco;                          // CEP do endereço
    String bairroEndereco;                       // Bairro do endereço
    String cidadeEndereco;                       // Cidade do endereço
    String ufEndereco;                           // UF do endereço
    Double latitudeEndereco;                     // Latitude do endereço
    Double longitudeEndereco;                    // Longitude do endereço
    String criadoEmEndereco;                     // Data de criação do endereço


    public CelulaModel() {
    }
}
