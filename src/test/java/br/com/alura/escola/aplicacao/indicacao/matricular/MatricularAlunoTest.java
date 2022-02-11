/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.aplicacao.indicacao.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunoEmMemoria;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author 99030499
 */
public class MatricularAlunoTest {
    
    public MatricularAlunoTest() {
    }

    @Test
    public void alunoDeveSerMatriculado() {
        //MOCK -> mockito
        RepositorioDeAlunoEmMemoria repositorio = new RepositorioDeAlunoEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);
        
        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "fulano@gmail.com", "123.456.789-00");
        
        useCase.executa(dados);
        
        Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));
        
        Assert.assertEquals("Fulano", encontrado.getNome());
        Assert.assertEquals("123.456.789-00", encontrado.getCpf());
        Assert.assertEquals("fulano@gmail.com", encontrado.getEmail());
    }
    
}
