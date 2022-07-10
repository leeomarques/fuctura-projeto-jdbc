package com.fuctura.dao;

import java.util.List;

import com.fuctura.model.Endereco;

//como que um contrato, garante que irá realizar esses metodos abaixo
public interface EnderecoDAO {

	public int getSequence();

	public void salvar(Endereco endereco);

	public void alterar(Endereco endereco);

	public void remover(int numero);

	public Endereco pesquisar(int numero);

	public List<Endereco> listarTodos();

}
