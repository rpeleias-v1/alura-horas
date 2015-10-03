package br.com.alura.controller;

import javax.inject.Inject;

import br.com.alura.annotations.Open;
import br.com.alura.dao.UsuarioDAO;
import br.com.alura.model.Usuario;
import br.com.alura.sessao.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {

	private UsuarioLogado usuarioLogado;
	private UsuarioDAO usuarioDAO;
	private Validator validator;
	private Result result;

	@Deprecated
	LoginController() {
	}

	@Inject
	public LoginController(UsuarioLogado usuarioLogado, UsuarioDAO usuarioDAO, Validator validator, Result result) {
		this.usuarioLogado = usuarioLogado;
		this.usuarioDAO = usuarioDAO;
		this.validator = validator;
		this.result = result;
	}

	@Open
	@Get
	public void form() {
	}
	
	@Open
	@Post
	public void login(String login, String senha) {
		Usuario usuario = usuarioDAO.busca(login, senha);
		if (usuario != null) {
			usuarioLogado.fazLogin(usuario);
			result.redirectTo(IndexController.class).index();
		} else {
			validator.add(new SimpleMessage("login_invalid", "Login ou senha incorretos"));
			validator.onErrorRedirectTo(this).form();
		}
	}
	
	@Open
	@Get
	public void desloga() {
		usuarioLogado.desloga();
		result.redirectTo(this).form();
	}

}
