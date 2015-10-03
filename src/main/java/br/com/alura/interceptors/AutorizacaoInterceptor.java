package br.com.alura.interceptors;

import javax.inject.Inject;

import br.com.alura.annotations.Open;
import br.com.alura.controller.LoginController;
import br.com.alura.sessao.UsuarioLogado;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutorizacaoInterceptor {

	private UsuarioLogado usuarioLogado;
	private Result result;
	private ControllerMethod controllerMethod;
	
	@Deprecated
	AutorizacaoInterceptor() {
	}

	@Inject
	public AutorizacaoInterceptor(UsuarioLogado usuarioLogado, Result result, ControllerMethod controllerMethod) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.controllerMethod = controllerMethod;
	}
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		if (usuarioLogado.isLogado()) {
			stack.next();
		} else {
			result.redirectTo(LoginController.class).form();
		}
	}
	
	@Accepts
	public boolean accepts() {
		return !controllerMethod.containsAnnotation(Open.class);
	}
}
