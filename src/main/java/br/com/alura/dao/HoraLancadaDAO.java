package br.com.alura.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.model.HoraLancada;

public class HoraLancadaDAO {
	
	private EntityManager em;

	@Inject
	public HoraLancadaDAO(EntityManager em) {
		this.em = em;
	}
	
	@Deprecated
	HoraLancadaDAO() {
	}
	
	public void adiciona(HoraLancada horaLancada ) {
		this.em.getTransaction().begin();
		this.em.persist(horaLancada);
		this.em.getTransaction().commit();
	}
	
	public List<HoraLancada> lista() {
		TypedQuery<HoraLancada> query = this.em.createQuery("select hl from HoraLancada hl", HoraLancada.class);
		return query.getResultList();
	}
	

}
