package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto {

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private List<Stanza> listaStanze;

	public LabirintoBuilder() {
		this.stanzaIniziale=null;
		this.stanzaVincente=null;
		this.listaStanze = new ArrayList<>();
	}

	/**
	 * Creo stanza iniziale, ovvero la prima stanza del labirinto
	 * */

	public LabirintoBuilder addStanzaIniziale(String nome) {
		this.setStanzaIniziale(nome);
		this.getListaStanze().add(this.stanzaIniziale);
		return this;
	}

	/**
	 * Creo una stanz vicente, ovvero una stanza che farà vincere la partita
	 * */

	public LabirintoBuilder addStanzaVincente (String nome) {
		this.setStanzaVincente(nome);
		this.listaStanze.add(this.stanzaVincente);
		return this;
	}

	public Labirinto getLabirinto() {
		return (Labirinto)this;
	}
	
	/**
	 * aggiungo attrezzo all ultima stanza aggiunta
	 * */
	
	public LabirintoBuilder addAttrezzo(String nome,int peso) {
		Stanza ultima =this.listaStanze.get(listaStanze.size()-1);
		ultima.addAttrezzo(new Attrezzo(nome,peso));
		return this;
	}
	
	/**
	 * Creo adiacenze tra le stanze presenti nella lista di stanze
	 * */
	
	public LabirintoBuilder addAdiacenza(String stanzaPartenza, String stanzaAdiacente, String direzione) {
		Iterator<Stanza> it = this.listaStanze.iterator();
		Stanza partenza = null;
		Stanza adiacente = null;
		while (it.hasNext()) {
			Stanza s = it.next();
			if (s.getNome().equals(stanzaPartenza))
				partenza = s;
			if (s.getNome().equals(stanzaAdiacente))
				adiacente = s;
		}
		partenza.impostaStanzaAdiacente(direzione, adiacente);
		return this;
	}
	
	/**
	 * Aggiungo una stanza alla liste di stanze presenti nel labirinto
	 * */
	
	public LabirintoBuilder addStanza(String nome) {
		this.listaStanze.add(new Stanza(nome));
		return this;
	}
	
	/**
	 * Aggiungo una stanza buia alla liste di stanze presenti nel labirinto
	 * */
	
	public LabirintoBuilder addStanzaBuia(String nome, String nomeAttrezzo) {
		this.listaStanze.add(new StanzaBuia(nome,nomeAttrezzo));
		return this;
	}
	
	/**
	 * Aggiungo una stanza bloccata alla liste di stanze presenti nel labirinto
	 * */
	
	public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		this.listaStanze.add(new StanzaBloccata(nome,attrezzoSbloccante, direzioneBloccata));
		return this;
	}
	
	/**
	 * Aggiungo una stanza magica alla liste di stanze presenti nel labirinto
	 * */
	
	public LabirintoBuilder addStanzaMagica(String nome) {
		this.listaStanze.add(new StanzaMagica(nome));
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome, int sogliaMagica) {
		this.listaStanze.add(new StanzaMagica(nome,sogliaMagica));
		return this;
	}
	
	@Override
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	@Override
	public void setStanzaIniziale(String nome) {
		this.stanzaIniziale = new Stanza(nome);
	}

	@Override
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	@Override
	public void setStanzaVincente(String nome) {
		this.stanzaVincente = new Stanza(nome);
	}

	public List<Stanza> getListaStanze() {
		return this.listaStanze;
	}


}
