package databaseClass;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import businessClass.store;

public class StoreDB {

	public static List<store> listAllStores() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT s FROM store s";
		TypedQuery<store> q = em.createQuery(qString, store.class);
		List<store> stores;
		try {
			stores = q.getResultList();
			if (stores == null || stores.isEmpty())
				stores = null;
		} finally {
			em.close();
		}
		return stores;

	}

	public static List<store> listAllStores(int divisionID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT s FROM store s  WHERE s.divisionID = :divisionID";

		TypedQuery<store> q = em.createQuery(qString, store.class);
		q.setParameter("divisionID", divisionID);
		List<store> stores;
		try {
			stores = q.getResultList();
			if (stores == null || stores.isEmpty())
				stores = null;
		} finally {
			em.close();
		}
		return stores;

	}

	public static void UpdatetStore(store Store, String storeNumber) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		String qString = "SELECT s FROM store s WHERE s.storeNumber = :storeNumber";
		TypedQuery<store> q = em.createQuery(qString, store.class);
		q.setParameter("storeNumber", storeNumber);
		store s;
		try {
			s = q.getSingleResult();
			s.setStoreNumber(Store.getStoreNumber());
			s.setSales(Store.getSales());
			s.setName(Store.getName());
			s.setAddress(Store.getAddress());
			s.setCity(Store.getCity());
			s.setState(Store.getState());
			s.setZip(Store.getZip());
			em.merge(s);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (trans != null & trans.isActive())
				trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void addStore(store Store) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(Store);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (trans != null & trans.isActive())
				trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void deleteStore(String storeNumber) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		String qString = "SELECT s FROM store s  WHERE s.storeNumber = :storeNumber";
		TypedQuery<store> q = em.createQuery(qString, store.class);
		q.setParameter("storeNumber", storeNumber);
		store s;
		try {
			s = q.getSingleResult();
			em.remove(em.merge(s));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (trans != null & trans.isActive())
				trans.rollback();
		} finally {
			em.close();
		}
	}

	public static store selectStore(String storeNumber) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT s FROM stores s" + "WHERE s.storeNumber = :storeNumber";
		TypedQuery<store> q = em.createQuery(qString, store.class);
		q.setParameter("storeNumber", storeNumber);
		try {
			store store = q.getSingleResult();
			return store;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	public static boolean StoreNumberExists(String storeNumber) {
		store s = selectStore(storeNumber);
		return s != null;
	}

	public static double getSalesSummary() {
		double sum = 0.0;
		List<store> stores = listAllStores();
		for (store s : stores) {
			sum += s.getSales();
		}
		return sum;
	}

	public static double getSalesSummary(int divisionNumber) {
		double sum = 0.0;
		List<store> divStores = listAllStores(divisionNumber);
		for (store s : divStores) {
			sum += s.getSales();
		}
		return sum;
	}
}