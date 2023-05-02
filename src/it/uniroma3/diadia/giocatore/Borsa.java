package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAtt;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new TreeMap<>();
		this.numeroAttrezzi = 0;
	}
	
	
	/**
	 * aggiunge un attrezzo alla borsa
	 * @param attrezzo
	 * @return true se è stato aggiunto false altrimenti
	 * */
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null)
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(),attrezzo);
		this.numeroAttrezzi++;
		this.pesoAtt += attrezzo.getPeso();
		return true;
	}
	
	
	/**
	 * 
	 * @return restituisce il peso massimo che può portare la borsa
	 * */
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	/**
	 * Controlla se il nome dell'attrezzo nel parametro corrisponde ad un attrezzo nella borsa
	 * @param	nomeAttrezzo
	 * @return restituisce l'attrezzo richiesto altrimenti null
	 * */
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo != null && this.attrezzi.containsKey(nomeAttrezzo))
			a = this.attrezzi.get(nomeAttrezzo);
		return a;
	}

	
	/**
	 * Calcola il peso corrente della borsa ad ogni sua invocazione
	 * @return peso della borsa aggiornato
	 */
	
	public int getPeso() {
		return this.pesoAtt;
	}
	
	public int getPesoBorsaAttuale() {
		int sommaPesoBorsa = 0;
        for (Attrezzo attrezzo: attrezzi.values()) {
        	sommaPesoBorsa += attrezzo.getPeso();
        }
        return sommaPesoBorsa;
	}

	public boolean getPesoRimanente(Attrezzo a) {
		if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
			return true;
		return false; 
	}
	
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo!=null){
			a = attrezzi.remove(nomeAttrezzo);
		}
		return a;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (getPesoBorsaAttuale()!=0) {					
			s.append("Contenuto borsa ("+getPesoBorsaAttuale()+"/"+this.getPesoMax()+"kg): ");
				if (attrezzi !=null)
				s.append(this.attrezzi.values() .toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi.values());
		Collections.sort(l, new ComparatorePerPeso());
		return l;
		
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<Attrezzo>(this.attrezzi.values());

		
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Set<Attrezzo> tmp;
		ComparatorePerNome comp = new ComparatorePerNome();
		Map<Integer,Set<Attrezzo>> contenuto;
		contenuto = new HashMap<Integer,Set<Attrezzo>>();
		for (Attrezzo attrezzo: this.attrezzi.values()) {
			if (contenuto.containsKey(attrezzo.getPeso())) {
				tmp=contenuto.get(attrezzo.getPeso());
				tmp.add(attrezzo);
			}
			else {
				tmp = new TreeSet<Attrezzo>(comp);
				tmp.add(attrezzo);
				contenuto.put(attrezzo.getPeso(), tmp);
			}
		}
		return contenuto;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatorePerPeso());
		s.addAll(this.attrezzi.values());
		return s;
	}
}