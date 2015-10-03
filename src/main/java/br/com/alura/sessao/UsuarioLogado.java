package br.com.alura.sessao;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.alura.model.Usuario;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable{
	
	private Usuario usuario;
	
	public void fazLogin(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isLogado() {
		return this.usuario != null;
	}
	
	public void desloga() {
		this.usuario = null;
	}

}
