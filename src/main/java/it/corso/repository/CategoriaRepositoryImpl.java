package it.corso.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

import it.corso.configuration.HibernateSessionUtil;

import it.corso.model.Categoria;

public class CategoriaRepositoryImpl implements CategoriaRepository {

	@Override
	public Categoria getCategoriaByDescrizione(String descrizione) {
		try(Session session = HibernateSessionUtil.getSession().openSession())
		{
//			String sql = "SELECT * FROM categorie WHERE descrizione=?";
			String jpql = "SELECT c FROM Categoria c WHERE c.descrizione=:d"; // si utilizza :d al posto del marker posizionale ? si chiama marker nominale :d
			Query<Categoria> query = session
					.createQuery(jpql, Categoria.class)
					.setParameter("d", descrizione)
					.setMaxResults(1);
			return query.getSingleResult();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
