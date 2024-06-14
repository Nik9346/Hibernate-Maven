
package it.corso.repository;

import it.corso.model.Autore;

public interface AutoreRepository {
	Autore getAutoreByCognome(String cognome);

}
