package br.com.alura.escola.dominio.aluno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 99030499
 */
public class Email {
    
    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email invalido!");
        }
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
    
}
