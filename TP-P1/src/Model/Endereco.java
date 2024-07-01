package Model;

import Enum.Sigla;

public class Endereco {
	public Endereco(Sigla sigla, String capital) {
		this.sigla = sigla;
		this.capital = capital;
	}
	
	private Sigla sigla;
	private String capital;
	
	public Sigla getSigla() {
		return sigla;
	}
	public String getCapital() {
		return capital;
	}
}
