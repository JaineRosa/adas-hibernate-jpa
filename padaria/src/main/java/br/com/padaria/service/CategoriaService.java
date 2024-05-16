package br.com.padaria.service;

import java.util.List;

import br.com.padaria.DAO.GenericDAO;
import br.com.padaria.model.Categoria;

public class CategoriaService {

	private GenericDAO<Categoria> dao = new GenericDAO<Categoria>();
	 
	public void salvar(Categoria categoria) {
		dao.salvar(categoria);
	}
		public void alterar(Categoria categoria) {
		dao.alterar(categoria);
	}
	public void deletar(Categoria categoria) {
		dao.deletar(Categoria.class, categoria.getId() );
	}
	public Categoria buscarPorId(int id) {
		return dao.buscarPorId(Categoria.class, id);
		}
	
	public List<Categoria> buscarTodos(){
		String jpql = "SELECT c FROM Categoria c ORDER BY c.descricao";
		return dao.buscarTodos(jpql);
	}
}
