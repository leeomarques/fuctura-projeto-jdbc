package com.fuctura.dao;

import java.util.List;

import com.fuctura.model.Pessoa;

//como que um contrato, garante que irá realizar esses metodos abaixo
public interface PessoaDAO {

	public int getSequence();

	public void salvar(Pessoa pessoa);

	public void alterar(Pessoa pessoa);

	public void remover(int numero);

	public Pessoa pesquisar(int numero);

	public List<Pessoa> listarTodos();

}
