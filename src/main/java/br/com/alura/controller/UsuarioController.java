package br.com.alura.controller;

import javax.inject.Inject;

import br.com.alura.dao.UsuarioDAO;
import br.com.alura.model.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {

	private Result result;
	private UsuarioDAO usuarioDAO;
	private Validator validator;

	@Deprecated
	UsuarioController() {
	}

	@Inject
	public UsuarioController(Result result, UsuarioDAO usuarioDAO, Validator validator) {
		this.result = result;
		this.usuarioDAO = usuarioDAO;
		this.validator = validator;
	}
	
	public void form() {		
	}
	
	@IncludeParameters
	@Post
	public void adiciona(Usuario usuario) {
		validator.onErrorRedirectTo(this).form();
		usuarioDAO.adiciona(usuario);
		result.redirectTo(this).lista();
	}

	@Get
	public void lista() {
		result.include("usuarios", usuarioDAO.lista());
		
	}
	
}
