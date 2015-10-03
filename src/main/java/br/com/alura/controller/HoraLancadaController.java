package br.com.alura.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.dao.HoraLancadaDAO;
import br.com.alura.model.HoraLancada;
import br.com.alura.sessao.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class HoraLancadaController {
	
	private HoraLancadaDAO horaLancadaDAO;
	private Validator validator;
	private Result result;
	private UsuarioLogado usuarioLogado;
	
	@Inject
	public HoraLancadaController(HoraLancadaDAO horaLancadaDAO, Validator validator, Result result,
			UsuarioLogado usuarioLogado) {
		this.horaLancadaDAO = horaLancadaDAO;
		this.validator = validator;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}
	
	@Deprecated
	HoraLancadaController() {
	}

	@Get
	public void form() {		
	}
	
	@IncludeParameters
	public void adiciona(@Valid HoraLancada horaLancada) {
		validator.onErrorRedirectTo(this).form();
		horaLancada.setUsuario(usuarioLogado.getUsuario());
		horaLancadaDAO.adiciona(horaLancada);
		result.redirectTo(this).lista();
	}

	public void lista() {
		result.include("horas", horaLancadaDAO.lista());
		
	}
	
}
