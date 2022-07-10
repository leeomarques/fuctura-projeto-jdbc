package com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fuctura.dao.EnderecoDAO;
import com.fuctura.model.Endereco;
import com.fuctura.model.util.Conexao;

public class EnderecoDAOImpl implements EnderecoDAO {

	Conexao conexao = new Conexao();

	@Override
	public void salvar(Endereco endereco) {
		Connection conn = conexao.getConnection();
		String sql = "INSERT INTO ENDERECO (RUA, NUMERO, COMPLEMENTO, ID_ENDERECO) VALUES(?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setInt(2, endereco.getNumero());
			ps.setString(3, endereco.getComplemento());
			ps.setInt(4, endereco.getId());
			ps.execute();
			System.out.println("Endereço inserida com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro ao inserir Endereço no banco: " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}

	}

	@Override
	public void alterar(Endereco endereco) {
		Connection conn = conexao.getConnection();
		String sql = "UPDATE ENDERECO SET RUA= ?, NUMERO=?, COMPLEMENTO=? WHERE ID_ENDERECO=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setInt(2, endereco.getNumero());
			ps.setString(3, endereco.getComplemento());
			ps.setInt(4, endereco.getId());
			ps.executeUpdate();
			System.out.println("Endereço atualizada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Endereço no banco: " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}

	}

	@Override
	public void remover(int numero) {
		Connection conn = conexao.getConnection();
		String sql = "DELETE FROM ENDERECO WHERE NUMERO = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numero);
			ps.execute();
			System.out.println("Endereço deletada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar Endereço no banco: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro ao deletar Endereço no banco: " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}

	}

	@Override
	public Endereco pesquisar(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSequence() {
		Connection conn = conexao.getConnection();
		Integer retorno = null;

		String sql = "SELECT S_ID_ENDERECO.NEXTVAL AS SEQUENCE FROM DUAL";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				retorno = rs.getInt("SEQUENCE");
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir Endereço no banco: " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
		return retorno;
	}

}
