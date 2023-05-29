package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	private IO io;
	public FabbricaDiComandiRiflessiva(IO io) {
		this.io = io;
	}

	@Override
	public Comando costruisciComando(String istruzione) throws Exception {
		if(istruzione == null)
			throw new IllegalArgumentException();
		
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();	
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		StringBuilder costruttoreDiStringhe = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		if (nomeComando==null) {
			costruttoreDiStringhe.append("NonValido");
		}else {
			costruttoreDiStringhe.append(Character.toUpperCase(nomeComando.charAt(0)));
			costruttoreDiStringhe.append(nomeComando.substring(1));
		}
		try {
			Class <?> classeComando = Class.forName(costruttoreDiStringhe.toString());
			comando = (Comando) classeComando.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			comando = new ComandoSconosciuto(e);
		}
		
		comando.setParametro(parametro);
		comando.setIO(io);
		return comando;

	}

}
