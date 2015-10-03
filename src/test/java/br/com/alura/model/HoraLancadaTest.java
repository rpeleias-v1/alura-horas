package br.com.alura.model;

import org.junit.Assert;
import org.junit.Test;

public class HoraLancadaTest {

	@Test	
	public void calculaDuracaoQuandoInicioMenorDoQueFim() {
		HoraLancada hora = new HoraLancada();
		
		hora.setHoraInicial("09:00");
		hora.setHoraFinal("19:00");
		
		Assert.assertEquals(10.0,  hora.getDuracao(), 0.01);
	}

}
