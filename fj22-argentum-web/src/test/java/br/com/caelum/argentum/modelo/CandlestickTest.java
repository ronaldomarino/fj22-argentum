/**
 * 
 */
package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import org.junit.Test;

/**
 * @author Ronaldo Marino
 *
 */
public class CandlestickTest {

	@Test (expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		
		Calendar c = Calendar.getInstance();
		Candlestick candle = new Candlestick(10, 20, 20, 10, 1000, c);
		
		//Assert.assertEquals(candle.getMinimo() <= candle.getMaximo(), candle.getMinimo() > candle.getMaximo());
		
		
	}

}
