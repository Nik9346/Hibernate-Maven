package it.corso.repository;

import it.corso.model.Categoria;

public interface CategoriaRepository {
Categoria getCategoriaByDescrizione(String descrizione);
}
