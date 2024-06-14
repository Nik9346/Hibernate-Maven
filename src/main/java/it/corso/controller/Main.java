package it.corso.controller;

import java.util.List;

import it.corso.model.Libro;
import it.corso.model.Ordine;
import it.corso.model.Profilo;
import it.corso.model.Utente;
import it.corso.repository.LibroRepository;
import it.corso.repository.LibroRepositoryImpl;
import it.corso.repository.OrdineRepository;
import it.corso.repository.OrdineRepositoryImpl;
import it.corso.repository.UtenteRepository;
import it.corso.repository.UtenteRepositoryImpl;

public class Main {

	private static OrdineRepository ordineRepository = new OrdineRepositoryImpl();
	private static LibroRepository libroRepository = new LibroRepositoryImpl();
	private static UtenteRepository utenteRepository = new UtenteRepositoryImpl();

	
	
	public static void main(String[] args) {
	//lista ordini
//		List<Ordine> ordini = ordineRepository.getOrdini();
//		ordini.forEach(o -> {
//			System.out.println(o);
//			o.getLibri().forEach(l -> {
//				System.out.println(l);
//			});
//		});
		
	//registrazione del libro
//		Libro libro = new Libro();
//		libro.setTitolo("Libro sei");
//		libro.setPrezzo(18.54);
//		libroRepository.registraLibro(libro, "Uno", "Thriller");
		
	//registrazione di un nuovo utente
//		Profilo profilo = new Profilo(); //assemblo il profilo con i dati ricevuti
//		profilo.setUsername("laura.gialli");
//		profilo.setPassword("123");
//		
//		Utente utente = new Utente(); //assemblo l'utente con i dati ricevuti e setto il profilo
//		utente.setNome("Laura");
//		utente.setCognome("Gialli");
//		utente.setProfilo(profilo);
//		
//		utenteRepository.RegistraUtente(utente); //registro il nuovo utente
		
	//lista Utenti
	utenteRepository.getUtenti().forEach(u -> System.out.println(u));
		
	//Singolo utente
//		System.out.println(utenteRepository.getUtenteById(3));
		
	//modifica utente
//		Utente utenteMod = utenteRepository.getUtenteById(1); //invoco la funzione per trovare l'utente by id
//		utenteMod.getProfilo().setPassword("5678");
//		utenteMod.setNome("Mariuccio");
//		utenteRepository.modificaDatiUtente(utenteMod);
		
	//eliminazione utente
//		utenteRepository.eliminaUtente(2);
		
	}

}
