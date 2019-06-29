package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Cadastro;

public class CadastroImpl implements CadastroDao {

	private EntityManager em;

	public CadastroImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Cadastro cadastro) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(cadastro);
		tx.commit();
	}

	@Override
	public void alterar(Cadastro cadastro) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(cadastro);
		tx.commit();
	}

	@Override
	public void remover(Cadastro cadastro) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(cadastro);
		tx.commit();
	}

	@Override
	public Cadastro pesquisar(String nome) {
		Cadastro cadastro = em.find(Cadastro.class, nome);
        return cadastro;
	}

	@Override
	public List<Cadastro> recuperarTodos() {
        Query query = em.createQuery("from Cadastro c");
        List<Cadastro> cadastro = query.getResultList();
        return cadastro;
	}



}
