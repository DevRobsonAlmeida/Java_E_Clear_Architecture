/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.infra.aluno.inidicacao;

import br.com.alura.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.dominio.aluno.Aluno;

/**
 *
 * @author 99030499
 */
public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao{

    @Override
    public void enviarPara(Aluno indicado) {
        //Logica de envio de email com a lib java Mail
    }
    
    
    
}
