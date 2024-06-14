package it.corso.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.corso.configuration.HibernateSessionUtil;
import it.corso.model.Autore;
import it.corso.model.Categoria;
import it.corso.model.Libro;



public class LibroRepositoryImpl implements LibroRepository {

	private AutoreRepository autoreRepository = new AutoreRepositoryImpl();
	private CategoriaRepository categoriaRepository = new CategoriaRepositoryImpl();
	
	@Override
	public void registraLibro(Libro libro, String cognomeAutore, String descrizioneCategoria) 
	{
		//recupero dell'autore e della categoria
		Autore autore = autoreRepository.getAutoreByCognome(cognomeAutore);
		Categoria categoria = categoriaRepository.getCategoriaByDescrizione(descrizioneCategoria);
		
		if(autore != null && categoria != null) 
		{
			Transaction transaction = null;
			try(Session session = HibernateSessionUtil.getSession().openSession())
			{
				libro.setAutore(autore);
				libro.setCategoria(categoria);
				transaction = session.beginTransaction(); // apriamo la sessione
				session.persist(libro);
				transaction.commit(); // facciamo il commit della transaction
			}catch (Exception e) {
				System.out.println(e.getMessage());
				if(transaction != null)
					transaction.rollback(); // il metodo rollback annulla ciò che non ci fa andare avanti
			}
		}
		

	}

}
