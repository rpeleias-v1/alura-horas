package br.com.alura.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.model.Usuario;

public class UsuarioDAO {
	
	private EntityManager em;
	
	@Deprecated
	UsuarioDAO() {	
	}
	
	@Inject
	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}

	public void adiciona(Usuario usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public List<Usuario> lista() {
		TypedQuery<Usuario> query = em.createQuery("select * from Usuario l", Usuario.class);
		return query.getResultList();
	}
}