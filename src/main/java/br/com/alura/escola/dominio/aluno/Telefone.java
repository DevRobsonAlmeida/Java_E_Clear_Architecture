/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.dominio.aluno;

/**
 *
 * @author 99030499
 */
public class Telefone {
    
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if (ddd == null || !ddd.matches("\\d{3}")) {
            throw new IllegalArgumentException("DDD invalido!");
        }
        
        if (numero == null || !numero.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Numero de Telefone invalido!");
        }
        
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
    
    
    
    
    
    
}
