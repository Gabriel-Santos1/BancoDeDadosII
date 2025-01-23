/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auladb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 0077530
 */
public class FuncionarioDao {

    public void inserir(Funcionario f) throws Exception {
        Conexao con = new Conexao();
        String sql = "INSERT INTO FUNCIONARIO (NOME, CPF, SEXO, IDADE) " + "VALUES (?,?,?,?)";

        try (PreparedStatement pstm = con.getConexao().prepareStatement(sql)) {
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getCpf());
            pstm.setString(3, f.getSexo());
            pstm.setInt(4, f.getIdade());
            pstm.execute();

        } catch (Exception e) {
            throw e;
        }
    }

    public void remover(Funcionario f) throws Exception {
        Conexao con = new Conexao();
        String sql = "DELETE FROM FUNCIONARIO WHERE ID = ?";

        try (PreparedStatement pstm = con.getConexao().prepareStatement(sql)) {
            pstm.setInt(5, f.getId());
            pstm.execute();

        } catch (Exception e) {
            throw e;
        }
    }

    public void atualiziar(Funcionario f) throws Exception {
        Conexao con = new Conexao();
        String sql = "UPDATE FUNCIONARIO SET NOME = ?, CPF = ?, SEXO = ?, IDADE = ? WHERE ID = ?";

        try (PreparedStatement pstm = con.getConexao().prepareStatement(sql)) {
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getCpf());
            pstm.setString(3, f.getSexo());
            pstm.setInt(4, f.getIdade());
            pstm.setInt(5, f.getId());
            pstm.execute();

        } catch (Exception e) {
            throw e;
        }
    }

    public List<Funcionario> getTodos() throws Exception {

        Conexao con = new Conexao();
        String sql = "SELECT * FROM FUNCIONARIO";
        PreparedStatement pstm = con.getConexao().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Funcionario> lista = new ArrayList<>();

        while (rs.next()) {
            Funcionario f1 = new Funcionario();
            f1.setId(rs.getInt("id"));
            f1.setNome(rs.getString("nome"));
            f1.setCpf(rs.getString("cpf"));
            f1.setIdade(rs.getInt("idade"));
            f1.setSexo(rs.getString("sexo"));

            lista.add(f1);

        }
        return null;
        
    }

    

    public Funcionario getById(int id) throws Exception {
        Conexao con = new Conexao();
        String sql = "SELECT * FROM FUNCIONARIO";
        PreparedStatement pstm = con.getConexao().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        Funcionario f1 = null;

        while (rs.next()) {
            f1.setId(rs.getInt("id"));
            f1.setNome(rs.getString("nome"));
            f1.setCpf(rs.getString("cpf"));
            f1.setIdade(rs.getInt("idade"));
            f1.setSexo(rs.getString("sexo"));

        }
        return f1;
    }
}
