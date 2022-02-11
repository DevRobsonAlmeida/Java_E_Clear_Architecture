/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.dominio.indicacao;

import br.com.alura.escola.dominio.aluno.Aluno;

/**
 *
 * @author 99030499
 */
public class Indicacao {
    
    private Aluno indicado;
    private Aluno indicante;

    public Indicacao(Aluno indicado, Aluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
    }
    
}
