package it.corso.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

import it.corso.configuration.HibernateSessionUtil;
import it.corso.model.Autore;

public class AutoreRepositoryImpl implements AutoreRepository {

	@Override
	public Autore getAutoreByCognome(String cognome) {
		try(Session session = HibernateSessionUtil.getSession().openSession())
		{
//			String sql = "SELECT * FROM autori WHERE cognome=?";
			String jpql = "SELECT a FROM Autore a WHERE a.cognome=:c"; // si utilizza :c al posto del marker posizionale ? si chiama marker nominale :c
			Query<Autore> query = session
					.createQuery(jpql, Autore.class)
					.setParameter("c", cognome)
					.setMaxResults(1);
			return query.getSingleResult();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
