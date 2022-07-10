package com.fuctura.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.fuctura.dao.ContaDAO;
import com.fuctura.dao.EnderecoDAO;
import com.fuctura.dao.PessoaDAO;
import com.fuctura.dao.impl.ContaDAOImpl;
import com.fuctura.dao.impl.EnderecoDAOImpl;
import com.fuctura.dao.impl.PessoaDAOImpl;
import com.fuctura.model.Conta;
import com.fuctura.model.Endereco;
import com.fuctura.model.Pessoa;

public class Principal {

	public static void main(String[] args) {

//		Conexao conexao = new Conexao();
//		Connection conn = conexao.getConnection();

		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();

//		conta.setNumero(1001);
//		conta.setSaldo(6000);
//		conta.setLimite(50000);
//
//		endereco.setRua("Estrada do Caiara");
//		endereco.setNumero(218);
//		endereco.setComplemento("Casa");
//		endereco.setId(enderecoDAO.getSequence());

		ContaDAO contaDAO = new ContaDAOImpl();

//		contaDAO.salvar(conta);
//		contaDAO.alterar(conta);
//		contaDAO.remover(1001);

//		enderecoDAO.salvar(endereco);
//		enderecoDAO.alterar(endereco);
//		enderecoDAO.remover(0);

		Conta conta1 = contaDAO.pesquisar(1002);
		System.out.println("Número da Conta: " + conta1.getNumero());
		System.out.println("Saldo Disponível: " + conta1.getSaldo());
		System.out.println("Limite Disponível: " + conta1.getLimite());

		contaDAO.listarTodos();

		List<Conta> listasConta = contaDAO.listarTodos();
		for (Conta c : listasConta) {
			System.out.println(c.toString());
		}

		contaDAO.listarTodos().forEach(System.out::println); // função lambda
//		contaDAO.listarTodos().forEach(c -> System.out.println(c));

		Pessoa p = new Pessoa();
		p.setNome(JOptionPane.showInputDialog("a"));
		p.setSexo("M");
		p.setCpf("1234");
		p.setIdade(300);

		Conta conta = new Conta();
		conta.setNumero(100100);
		conta.setSaldo(6000);
		conta.setLimite(50000);

		Endereco endereco = new Endereco();
		endereco.setRua("Estrada do Caiara");
		endereco.setNumero(218);
		endereco.setComplemento("Casa");
		endereco.setId(enderecoDAO.getSequence());

		p.setConta(conta);
		p.setEndereco(endereco);

		PessoaDAO pDAO = new PessoaDAOImpl();
		pDAO.salvar(p);

	}

}
