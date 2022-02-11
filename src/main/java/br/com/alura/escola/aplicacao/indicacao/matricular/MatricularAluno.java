/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.aplicacao.indicacao.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

/**
 *
 * @author 99030499
 */
public class MatricularAluno {
    private final RepositorioDeAlunos repositorio;

    public MatricularAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }
    
    //COMMAND
    public void executa(MatricularAlunoDto dados){
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);
    }
    
    
}
