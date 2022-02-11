/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.dominio.aluno;

import java.util.List;

/**
 *
 * @author 99030499
 */
public interface RepositorioDeAlunos {
    
    void matricular(Aluno aluno);
    
    Aluno buscarPorCPF(CPF cpf);
    
    List<Aluno> listarTodosMatriculados();
    
    //...
    
}
