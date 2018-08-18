/**
 * 
 */
package br.com.caelum.argentum.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author Ronaldo Marino
 *
 */
public class GeradorAleatorioDeXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar data = Calendar.getInstance();
		Random random = new Random(123);
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		
		double valor = 40;
		int quantidade = 1000;
		
		for (int dias = 0; dias < 30; dias++) {
			int quantidadeNegociacoesDia = random.nextInt(20);
			
			for (int negociacaoi = 0; negociacaoi < quantidadeNegociacoesDia; negociacaoi++) {
				//Variação entre -1 a +5
				valor += (random.nextInt(200)-100)/100.0;
				if (valor < 5) {
					valor=5.0;
				}
				
				//Quantidade entre 500 e 1500
				quantidade += random.nextInt(500);
				
				Negociacao n = new Negociacao(valor, quantidade, data);
				negociacoes.add(n);
				
			}
			
			data = (Calendar) data.clone();
			data.add(Calendar.DAY_OF_YEAR, 1);
			
		}
		
		XStream stream = new XStream(new DomDriver());
		stream.setMode(XStream.NO_REFERENCES);
		stream.alias("negociacao", Negociacao.class);
		
		PrintStream out = null;
		try {
			out = new PrintStream(new File("negociacao.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println(stream.toXML(negociacoes));
		
		
	}

}
