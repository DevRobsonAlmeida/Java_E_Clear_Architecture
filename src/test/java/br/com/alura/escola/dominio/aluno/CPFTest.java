/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.CPF;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 99030499
 */
public class CPFTest {
    

    @Test
    public void cpfInvalido() { 
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF("12345678900"));
    }
    
    @Test
    public void cpfValida(){
        String numero = "123.456.789-00";
        CPF cpf = new CPF(numero);
        assertEquals(numero, cpf.getNumero());
    }
    
}
