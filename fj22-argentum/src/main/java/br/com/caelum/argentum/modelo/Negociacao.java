/**
 * 
 */
package br.com.caelum.argentum.modelo;

import java.util.Calendar;

/**
 * @author Marino
 *
 */
public final class Negociacao implements Comparable<Negociacao>{
	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("data nao pode ser nula");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}
	
	public double getVolume() {
		return preco * quantidade;
	}
	
	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		Calendar copia = Calendar.getInstance();
		copia.setTimeInMillis(data.getTimeInMillis());
		return copia;
		//return data;
	}

	public boolean isMesmoDia(Calendar outraData) {
		return
				data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH) &&
				data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH) &&
				data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
	}

	@Override
	public int compareTo(Negociacao outraNegociacao) {
		if (this.data.before(outraNegociacao.getData())) {
			return -1;
		}
		if (this.data.after(outraNegociacao.getData())) {
			return 1;
		}
		
		return 0;
	}

}
