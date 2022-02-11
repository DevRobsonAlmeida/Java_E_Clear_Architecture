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
public class AlunoNaoEncontrado extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getNumero());
    }
    
    
}
