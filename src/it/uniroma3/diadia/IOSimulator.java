package it.uniroma3.diadia;

import java.util.LinkedList;
import java.util.List;

public class IOSimulator implements IO{


	private List<String> righeDaLeggere ;
	private List <String> messaggiProdotti ;

	public IOSimulator (List <String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.messaggiProdotti = new LinkedList<String>();
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		if (!this.righeDaLeggere.isEmpty())
			return this.righeDaLeggere.remove(0);
		else
			return null;
	}

	public String nextMessaggio() {
		if(hasNextMessaggio ())
			return this.messaggiProdotti.remove(0);
		else
			return null;
	}

	public boolean hasNextMessaggio() {
		return !this.messaggiProdotti.isEmpty();
	}
}
