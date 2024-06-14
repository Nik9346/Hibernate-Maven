package it.corso.repository;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import it.corso.configuration.HibernateSessionUtil;
import it.corso.model.Ordine;

public class OrdineRepositoryImpl implements OrdineRepository {

	@Override
	public List<Ordine> getOrdini() {
		try(Session session = HibernateSessionUtil.getSession().openSession())
		{
//			String sql= "SELECT * FROM ordini ...";
			String jpql = "SELECT o FROM Ordine o"; // seleziona tutto l'ordine a cui io passo la classe reference o di default hibernate utilizza jpql
			Query<Ordine> query = session.createQuery(jpql, Ordine.class);
			return query.list();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
