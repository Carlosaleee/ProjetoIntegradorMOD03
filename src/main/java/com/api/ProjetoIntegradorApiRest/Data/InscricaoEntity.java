package com.api.ProjetoIntegradorApiRest.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "atletas")
public class InscricaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Size(min=2, message="Informe ao menos 2 caracteres para o campo Nome.")
    @NotBlank(message="Nome obrigatório")
    private String nome;
    
    @Email(message="Email obrigatório.")
    private String email;
    
    @Size(min=14, message="Informe ao menos 14 caracteres para o campo Telefone.")
    @NotBlank(message="Telefone obrigatório")
    private String telefone;
    
    @NotBlank(message="Data Nascimento obrigatório")
    private String dataNascimento;

    @Size(min=1, message="Informe ao menos 1 caracter para o campo Sexo.")
    @NotBlank(message="Sexo obrigatório")
    private String sexo;

    @Size(min=2, message="Informe ao menos 2 caracteres para o campo Cidade.")
    @NotBlank(message="Cidade obrigatório")
    private String cidade;

    @Size(min=2, message="Informe ao menos 2 caracteres para o campo Categoria.")
    @NotBlank(message="Categoria obrigatório")
    private String categoria;

}