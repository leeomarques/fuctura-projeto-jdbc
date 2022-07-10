package com.fuctura.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fuctura.dao.ContaDAO;
import com.fuctura.dao.EnderecoDAO;
import com.fuctura.dao.PessoaDAO;
import com.fuctura.model.Pessoa;
import com.fuctura.model.util.Conexao;

public class PessoaDAOImpl implements PessoaDAO {// classe prototipo

	Conexao conexao = new Conexao(); // objeto produto em si
	EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
	ContaDAO contaDAO = new ContaDAOImpl();

	@Override
	public void salvar(Pessoa pessoa) {
		Connection conn = conexao.getConnection();
		String sql = "INSERT INTO PESSOA (NOME, IDADE, SEXO, CPF, ID_ENDERECO, NUMERO_CONTA) VALUES(?, ?, ?, ?, ?, ?)";

		try {

			this.enderecoDAO.salvar(pessoa.getEndereco());
			this.contaDAO.salvar(pessoa.getConta());

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setInt(2, pessoa.getIdade());
			ps.setString(3, pessoa.getSexo());
			ps.setString(4, pessoa.getCpf());
			ps.setInt(5, pessoa.getEndereco().getId());
			ps.setInt(6, pessoa.getConta().getNumero());
			ps.execute();
			System.out.println("Pessoa cadastrada com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa no banco: " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}

	}

	@Override
	public void alterar(Pessoa pessoa) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(int numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pessoa pesquisar(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listarTodos() {
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
			System.out.println("Erro ao inserir conta no banco: " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
		return retorno;
	}

}
