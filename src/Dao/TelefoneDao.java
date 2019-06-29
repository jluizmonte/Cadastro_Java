package dao;

import java.util.List;

import entidade.Telefone;

public interface TelefoneDao {
	public void salvar(Telefone telefone);
	public void alterar(Telefone telefone);
	public void remover(Telefone telefone);
	public Telefone pesquisar(String numero);
	public List<Telefone> recuperarTodos();
}
