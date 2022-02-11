/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.Telefone;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author 99030499
 */
public class TelefoneTest {
    

    @Test
    public void numerosComDDDInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "123456789"));   
    }
    
    @Test
    public void numeroTelefoneInvalidas(){
        assertThrows(IllegalArgumentException.class, () -> new Telefone("011", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("011", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("011", "123"));
    }
    
    
    @Test
    public void numeroDddValidos(){
        String ddd = "111";
        String numero = "123456789";
        Telefone tf = new Telefone(ddd, numero);
        assertEquals(ddd, tf.getDdd());
        assertEquals(numero, tf.getNumero());
    }
}
