package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String attrezzoperVedere;
	public static final String DESCRIZIONE_STANZA_BUIA = "qui c'è buio pesto";
	
	public StanzaBuia(String nome, String attrezzoPerVedere) {
		super(nome);
		this.attrezzoperVedere = attrezzoPerVedere;
	}
	
	@Override
	public String getDescrizione () {
		if(!super.hasAttrezzo(attrezzoperVedere))
			return DESCRIZIONE_STANZA_BUIA;
		return super.getDescrizione();
	}
	

}
