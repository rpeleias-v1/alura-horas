package br.com.alura.vo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.alura.model.HoraLancada;

public class RelatorioDeHoras {
	
	private List<HorasPorDia> horasPorDia = new ArrayList<>();
	private double totalHorasNormais;
	private double totalHorasExtras;
	
	public RelatorioDeHoras(List<HoraLancada> horas) {
        calculaHorasPorDia(horas);
    }
    private void calculaHorasPorDia(List<HoraLancada> horas) {
        if (!horas.isEmpty()) {
            double horasDoDia = 0.0;
            Calendar dataAtual = horas.get(0).getData();
            for (HoraLancada hora : horas) {
                if(!hora.getData().equals(dataAtual)){
                    double horasNormais = Math.min(horasDoDia, 8);
                    double horasExtras = Math.max(horasDoDia - 8, 0.0);
                    horasPorDia.add(new HorasPorDia(horasNormais, horasExtras, dataAtual));
                    dataAtual = hora.getData();
                    horasDoDia = 0.0;
                }
                horasDoDia += hora.getDuracao();
            }
            double horasNormais = Math.min(horasDoDia, 8);
            double horasExtras = Math.max(horasDoDia - 8, 0.0);
            horasPorDia.add(new HorasPorDia(horasNormais, horasExtras, dataAtual));
        }
    }
    public List<HorasPorDia> getHorasPorDia() {
        return horasPorDia;
    }
    public double getTotalHorasNormais() {
        return totalHorasNormais;
    }
    public double getTotalHorasExtras() {
		return totalHorasExtras;
    }
}
