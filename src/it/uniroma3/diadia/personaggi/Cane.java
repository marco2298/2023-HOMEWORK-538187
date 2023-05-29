package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	private static final String MESSAGGIO_MORSO = 
			"UOF UOF -1CFU UOF UOF";
	
	private static final String MESSAGGIO_REGALO = 
			"Ti ringrazio per questo regalo UOF UOF";
	
	private static String CIBO_PREFERITO= "osso";
	private Attrezzo regaloDelCane;
	private boolean regaloPosato = false;
	
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}


	@Override
	public String agisci(Partita partita) {
		String msg;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		msg = MESSAGGIO_MORSO;
		return msg;
	}

	@Override
	public String riceviRegalo( Attrezzo attrezzo,Partita partita) {
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			if(!this.regaloPosato){
				partita.getStanzaCorrente().addAttrezzo(this.regaloDelCane);
				this.regaloPosato = true;
			}		return MESSAGGIO_REGALO;
		} else {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() -1);
			return "Il cane non accetta il tuo regalo e ti morde";
		}
	}

}