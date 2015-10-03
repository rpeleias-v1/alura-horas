package br.com.alura.vo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.model.HoraLancada;

public class RelatorioDeHorasTest {

	@Test
	public void test() {
		 Calendar data = new GregorianCalendar(2014, 11, 11);
        HoraLancada hora1 = novaHoraLancada("10:00", "18:00", data);
        HoraLancada hora2 = novaHoraLancada("18:00", "20:00", data);
        RelatorioDeHoras relatorio = new RelatorioDeHoras(Arrays.asList(hora1, hora2));
        HorasPorDia horasPorDia = relatorio.getHorasPorDia().get(0);
        Assert.assertEquals(1, relatorio.getHorasPorDia().size());
        Assert.assertEquals(8.0, horasPorDia.getHorasNormais(), 0.001);
        Assert.assertEquals(2.0, horasPorDia.getHorasExtras(), 0.001);
        Assert.assertEquals(data, horasPorDia.getData());

	}
	
	private HoraLancada novaHoraLancada(String inicio, String fim, Calendar data) {
		HoraLancada hora = new HoraLancada();
		hora.setData(data);;
		hora.setHoraInicial(inicio);
		hora.setHoraFinal(fim);
		return hora;
	}

}
