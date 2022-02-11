/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.dominio.aluno.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 99030499
 */
public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

    private final Connection connection;
    private PreparedStatement ps;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();
            sql = "INSERT INTO TELEFONE VALUE(?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(0, telefone.getDdd());
                ps.setString(1, telefone.getNumero());
                ps.execute();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Select * from ALUNO a where a.cpf =").append(cpf.getNumero());
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sb.toString());
            
            Boolean encontrou = rs.next();
            if (!encontrou) {   
                throw new AlunoNaoEncontrado(cpf);
            }
            
            Aluno encontrado = new Aluno(rs.getString("nome"),
                    new Email(rs.getString("email")),
                    new CPF(rs.getString("cpf")));

            Long id = rs.getLong("id");
            sb = new StringBuilder("Select ddd, numero FROM TELEFONE WHERE aluno_id =").append(id);
            Statement st = connection.createStatement();
            rs = st.executeQuery(sb.toString());
            
            while (rs.next()) {                
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                encontrado.adicionarTelefone(ddd, numero);
            }
            
            return encontrado;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Aluno> listarTodosMatriculados() {
        try {
            List<Aluno> alunos = new ArrayList<>();
            //
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ALUNO");

            while (rs.next()) {
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                CPF cpf = new CPF(rs.getString("cpf"));
                Aluno aluno = new Aluno(nome, email, cpf);

                Long id = rs.getLong("id");
                String sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ResultSet rsTelefone = ps.executeQuery();
                while (rsTelefone.next()) {
                    String numero = rs.getString("numero");
                    String ddd = rs.getString("ddd");
                    aluno.adicionarTelefone(ddd, numero);
                }
                
                alunos.add(aluno);
            }

            return alunos;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
