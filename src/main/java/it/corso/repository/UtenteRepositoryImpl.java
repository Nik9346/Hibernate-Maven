package it.corso.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.corso.configuration.HibernateSessionUtil;
import it.corso.model.Utente;

public class UtenteRepositoryImpl implements UtenteRepository {

	@Override
	public void RegistraUtente(Utente utente) {
		Transaction transaction = null; // va dichiarata fuori dal try catch
		try (Session session = HibernateSessionUtil.getSession().openSession()) {
			transaction = session.beginTransaction(); // apro la transazione
			session.persist(utente);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (transaction != null)
				transaction.rollback(); //annulla tutto quello che è stato scritto nel database in caso di errori.
		}
	}

	@Override
	public List<Utente> getUtenti() {
		try (Session session = HibernateSessionUtil.getSession().openSession()) {
			String jpql = "SELECT u FROM Utente u";
			Query<Utente> query = session.createQuery(jpql, Utente.class);
			return query.list();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("resource")
	@Override
	public Utente getUtenteById(int id) {
		try (
		Session session = HibernateSessionUtil.getSession().openSession()) {
			return session.get(Utente.class, id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public void modificaDatiUtente(Utente utente) { // dobbiamo passargli il getUtenteById per poter avere la corrispondenza esatta
		Transaction transaction = null; // va dichiarata fuori dal try catch
		try (Session session = HibernateSessionUtil.getSession().openSession()) {
			transaction = session.beginTransaction(); // apro la transazione
			session.merge(utente); // in questo modo facciamo la modifica dei dati
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (transaction != null)
				transaction.rollback(); //annulla tutto quello che è stato scritto nel database in caso di errori.
		}

	}

	@Override
	public void eliminaUtente(int id) {
		Transaction transaction = null; // va dichiarata fuori dal try catch
		try (Session session = HibernateSessionUtil.getSession().openSession()) {
			transaction = session.beginTransaction(); // apro la transazione
			Utente utente = getUtenteById(id); // in questo modo recupero l'oggetto utente in base all'id
			session.remove(utente); // in questo modo eliminiamo i dati in base all'id passato AL REMOVE VA PASSATO L'INTERO OGGETTO UTENTE
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (transaction != null)
				transaction.rollback(); //annulla tutto quello che è stato scritto nel database in caso di errori.
		}

	}

}
