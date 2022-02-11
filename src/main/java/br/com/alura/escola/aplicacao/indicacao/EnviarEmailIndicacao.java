/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.dominio.aluno.Aluno;

/**
 *
 * @author 99030499
 */
public interface EnviarEmailIndicacao {
    void enviarPara(Aluno indicado);
}
