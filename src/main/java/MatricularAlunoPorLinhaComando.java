
import br.com.alura.escola.aplicacao.indicacao.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.indicacao.matricular.MatricularAlunoDto;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunoEmMemoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 99030499
 */
public class MatricularAlunoPorLinhaComando {
    
    public static void main(String[] args) {
        String nome =  "Fulano da Silva";
        String cpf =   "123.456.789-00";
        String email = "fulano@email.com";
        
        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunoEmMemoria());
        matricular.executa(new MatricularAlunoDto(nome, email, cpf));
    }
    
}
