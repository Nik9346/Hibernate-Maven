package it.corso.repository;

import java.util.List;

import it.corso.model.Utente;

public interface UtenteRepository {
	void RegistraUtente(Utente utente);
	List<Utente> getUtenti();
	Utente getUtenteById(int id);
	void modificaDatiUtente(Utente utente);
	void eliminaUtente(int id);

}
