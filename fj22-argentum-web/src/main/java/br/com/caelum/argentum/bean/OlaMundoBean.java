package br.com.caelum.argentum.bean;
import javax.faces.bean.ManagedBean;

/**
 * 
 */

/**
 * @author Ronaldo Marino
 *
 */
@ManagedBean
public class OlaMundoBean {
	
	private String mensagem="Quem � voc�?";
	private String nome;
	
	public void nomeFoiDigitado() {
		System.out.println("\nChamou o bot�o");
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
