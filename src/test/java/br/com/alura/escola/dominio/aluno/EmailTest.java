/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.Email;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

/**
 *
 * @author 99030499
 */
public class EmailTest {
    
    @Test
    public void verificarEmailsInvalidos() {
        assertThrows(IllegalArgumentException.class, 
                () -> new Email(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));
        assertThrows(IllegalArgumentException.class, 
                () -> new Email("emailInvalidos"));
    }
    
}
