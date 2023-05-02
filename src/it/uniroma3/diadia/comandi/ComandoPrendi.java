package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	public static final String NOME = "prendi";
	private String nomeAttrezzo;

	/**
	 * Cerca di prende un attrezzo dalla stanza corrente, se non è presente stampa un messaggio di errore 
	 * altrimente aggiunge l'attrezzo alla borsa del giocatore eliminandolo dalla stanza
	 */

	@Override
	public void esegui(Partita partita) {
			if (nomeAttrezzo==null) {
				io.mostraMessaggio("Non ho capito, Quale attrezzo devo prendere ?");
				return;
			}
			if (!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
				io.mostraMessaggio("L'attrezzo: " +nomeAttrezzo+ " non è presente nella stanza corrente");
				return;
			}
			
			Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
			boolean attrezzoPreso = partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			
			if (!attrezzoPreso) {
				io.mostraMessaggio("Non c'e' abbastanza spazio nella borsa per prendere "+nomeAttrezzo);
				return;
			}
			Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("Attrezzo " +nomeAttrezzo+ " aggiunto in borsa!");

		}

		@Override
		public void setParametro(String parametro) {
			this.nomeAttrezzo= parametro;
		}

		@Override
		public void setIO(IO io) {
			this.io = io;
		}

		@Override
		public String getParametro() {
			return this.nomeAttrezzo;
		}

		@Override
		public String getNome() {
			return NOME;
		}

	}
