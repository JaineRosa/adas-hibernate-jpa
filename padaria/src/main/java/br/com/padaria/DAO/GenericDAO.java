package br.com.padaria.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.padaria.util.ConnectionFactory;

public class GenericDAO<E> {

	private static EntityManager mannager = ConnectionFactory.getEntityManager();
	
	
	public E buscarPorId(Class<E> entidade, int id) {
	return mannager.find(entidade, id);	
	}
	
	@SuppressWarnings("unchecked")
	public List<E> buscarTodos(String jpql){
		Query query = mannager.createQuery(jpql);
		return query.getResultList();
	}
	
	public void salvar(E e) {
		try {
			mannager.getTransaction().begin();
			mannager.persist(e);
			mannager.getTransaction().commit();
		} catch (Exception ex){
			ex.printStackTrace();
			mannager.getTransaction().rollback();
		}
	}
	
	
	public void alterar(E e) {
		try {
			mannager.getTransaction().begin();
			mannager.merge(e);
			mannager.getTransaction().commit();
		} catch (Exception ex){
			ex.printStackTrace();
			mannager.getTransaction().rollback();
		}
	}
	
	public void deletar(Class<E> entidade, int id) {
		E e = buscarPorId(entidade, id);
		 try {
				mannager.getTransaction().begin();
				mannager.remove(e);
				mannager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			mannager.getTransaction().rollback();

		}
	}
}
