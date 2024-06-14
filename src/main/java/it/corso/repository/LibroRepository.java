package it.corso.repository;

import it.corso.model.Libro;

public interface LibroRepository 
{
	void registraLibro(Libro libro, String cognomeAutore, String descrizioneCategoria);
}
