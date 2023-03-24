package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private static final String ATTREZZO = "AttrezzoDiTest";
	private static final String STANZA = "StanzaDiTest";
	private static final String STANZA_ADIACENTE = "StanzaAdiacente";
	private static final String NORD = "nord";
	
	
	protected Stanza stanza;
	
	 @Before
	 public void setUp() {
		 this.stanza = new Stanza(STANZA);
	 }
	 
	 @Test
	 public void testImpostaStanzaAdiacenteSingola() {
		 Stanza adiacente = creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		 assertEquals(adiacente, this.stanza.getStanzaAdiacente(NORD));
	 }
	 
	 @Test
	 public void testCambiaStanzaAdiacenteSingola() {
		 creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		 Stanza nuova = creaStanzaEImpostaAdiacente(this.stanza, "Nuova Adiacente", NORD);
		 assertEquals(nuova, this.stanza.getStanzaAdiacente(NORD));

	 }
	 
	 @Test
	 public void testImpostaMassimo4Stanza() {
		 Stanza adiacente = new Stanza(STANZA_ADIACENTE);
		 String[] direzioni = new String [] {"nord","sud","ovest", "est"};
		 for (String direzione: direzioni)
			 this.stanza.impostaStanzaAdiacente(direzione, adiacente);
		 
		 String direzioneNuova = "sud-ovest";
		 creaStanzaEImpostaAdiacente(this.stanza, "Da non inserire", direzioneNuova);
		 
		 assertNotContains(this.stanza.getDirezioni(), direzioneNuova);
	 }
	 
	 private void assertNotContains(String[] direzioni, String direzioneNuova) {
		boolean contiene = false;
		for (String direzione: direzioni)
			if (direzione !=null && direzione.equals(direzioneNuova))
				contiene = true;
		
		assertFalse(contiene);
		
	}

	 
	 @Test
	 public void testGetStanzaAdiacenteNonEsistente() {
		 assertNull(this.stanza.getStanzaAdiacente(NORD));
	 }
	 
	 @Test
	 public void testGetStanzaAdiacenteEsistente() {
		 creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		 assertNotNull(this.stanza.getStanzaAdiacente(NORD));
	 }
	 
	 @Test
	 public void testGetStanzaAdiacenteDirezioneNonValida() {
		 creaStanzaEImpostaAdiacente(this.stanza,STANZA_ADIACENTE,NORD);
		 assertNull (this.stanza.getStanzaAdiacente("nonValida"));
	 }
	 
	 @Test
	 public void testGetDirezioniVuoto() {
		 assertArrayEquals(new String[0], this.stanza.getDirezioni());
	 }
	 
	 @Test
	 public void testGetDirezioniSingleton() {				//instanzio array direzioni con una sola direzione
		 creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		 String[] direzioni = new String [1];
		 direzioni[0]= NORD;
		 assertArrayEquals(direzioni, this.stanza.getDirezioni());		//verifica che l'array delle direzioni è lo stesso che ho impostato io 
	 }
	 
	 @Test
	 public void testAddAttrezzoSingolo() {
		 Attrezzo attrezzoSemplice = new Attrezzo(ATTREZZO, 1);
		 this.stanza.addAttrezzo(attrezzoSemplice);
		 assertEquals(attrezzoSemplice, this.stanza.getAttrezzo(ATTREZZO));	 
	 }
	 
	 @Test
	 public void testAddAttrezziOltreMassimo() {
		 for (int i = 0; i < Stanza.NUMERO_MASSIMO_ATTREZZI;i++) {
			 Attrezzo attrezzoSemplice = new Attrezzo (ATTREZZO+i,1);
			 assertTrue(this.stanza.addAttrezzo(attrezzoSemplice));
		 }
		 Attrezzo attrezzoDiTroppo = new Attrezzo (ATTREZZO+Stanza.NUMERO_MASSIMO_ATTREZZI,1);
		 assertFalse(this.stanza.addAttrezzo(attrezzoDiTroppo));
	 }
	 
	 @Test
	 public void testGetHasAttrezzoSingolo() {
		 Attrezzo attrezzo = new Attrezzo(ATTREZZO, 1);
		 this.stanza.addAttrezzo(attrezzo);
		 assertTrue(this.stanza.hasAttrezzo(ATTREZZO));	 
	 }
	 
	 @Test
	 public void testHasAttrezzoStanzaVuota() {
		 assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	 }
	 
	 @Test
	 public void testHasAttrezzoInesistente() {
		assertFalse(this.stanza.hasAttrezzo("inesistente")); 
	 }
	 
	private Stanza creaStanzaEImpostaAdiacente (Stanza stanzaDiPartenza, String nomeStanzaAdiacente, String direzione) {
		 Stanza stanzaAdiacente = new Stanza (nomeStanzaAdiacente);
		 stanzaDiPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		 return stanzaAdiacente;
	 }
}	
	