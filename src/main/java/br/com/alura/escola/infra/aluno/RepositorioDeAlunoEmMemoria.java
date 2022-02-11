/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 99030499
 */
public class RepositorioDeAlunoEmMemoria implements RepositorioDeAlunos{
    
    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
       return this.matriculados.stream().filter(a -> a.getCpf().equals(cpf.getNumero())).findFirst().orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosMatriculados() {
        return this.matriculados;
    }
    
}
