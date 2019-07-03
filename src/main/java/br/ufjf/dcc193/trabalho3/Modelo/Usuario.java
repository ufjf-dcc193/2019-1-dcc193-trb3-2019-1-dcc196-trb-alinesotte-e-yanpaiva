package br.ufjf.dcc193.trabalho3.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Usuario
 */

 @Entity
 @Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "Nome é campo obrigatório")
    private String nomeCompleto;

    @NotBlank 
    private String codigoAcesso;

    @NotBlank (message = "Faça a descrição textual")
    private String descricaoTextual;
    
    @Email
    @NotBlank (message = "E-mail é campo obrigatório")
    private String email;

    @OneToOne
    private Anotacao idAnotacao;

    public Usuario(@NotBlank(message = "Nome é campo obrigatório") String nomeCompleto, @NotBlank String codigoAcesso,
            @NotBlank(message = "Faça a descrição textual") String descricaoTextual,
            @Email @NotBlank(message = "E-mail é campo obrigatório") String email) {
        this.nomeCompleto = nomeCompleto;
        this.codigoAcesso = codigoAcesso;
        this.descricaoTextual = descricaoTextual;
        this.email = email;
    }

    public Usuario(){}

    public Usuario(@NotBlank String codigoAcesso,
            @Email @NotBlank(message = "E-mail é campo obrigatório") String email) {
        this.codigoAcesso = codigoAcesso;
        this.email = email;
    }

    
}