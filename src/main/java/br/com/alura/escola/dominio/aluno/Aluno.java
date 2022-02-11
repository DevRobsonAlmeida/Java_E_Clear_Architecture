/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 99030499
 */
public class Aluno {
    
    private String nome;
    //
    private Email email;
    private CPF cpf;
    //
    private List<Telefone> telefones = new ArrayList<>();
    
    private String senha;

    public Aluno(String nome, Email email, CPF cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
    
    
    public void adicionarTelefone(String ddd, String numero){
        this.telefones.add(new Telefone(ddd, numero)); 
    }
    
    public static void main(String[] args){
        Aluno a = new Aluno("Fulano da Silva", new Email("email"), new CPF("123"));
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }
    public String getCpf() {
        return cpf.getNumero();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
    
}
 