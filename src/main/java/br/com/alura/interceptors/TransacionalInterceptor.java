package br.com.alura.interceptors;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.alura.annotations.Transacional;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@AcceptsWithAnnotations(Transacional.class)
@Intercepts
public class TransacionalInterceptor {

	private EntityManager manager;

	@Inject
	public TransacionalInterceptor(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated
	TransacionalInterceptor() {
	}
	
	@AroundCall
	public void intercepts(SimpleInterceptorStack stack) {
		this.manager.getTransaction().begin();
		stack.next();
		this.manager.getTransaction().commit();
	}	
}
