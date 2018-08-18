/**
 * 
 */
package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Marino
 *
 */
public final class Candlestick {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;
	
	public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		
		if (minimo > maximo) {
			throw new IllegalArgumentException("Valor minimo não pode ser maior que o máximo");
		}
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}
	
	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}
	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		
		sb.append("[Abertura ");
		sb.append(abertura);
		sb.append(", Fechamento ");
		sb.append(fechamento);
		sb.append(", Mínima ");
		sb.append(minimo);
		sb.append(", Máxima ");
		sb.append(maximo);
		sb.append(", Volume ");
		sb.append(volume);
		sb.append(", Data ");
		sb.append(sd.format(data.getTime()));
		sb.append("]");
		
		return sb.toString();
	}

}
