package databaseClass;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import businessClass.division;

public class DivisionDB {

	public static List<division> listAllDivision() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT d FROM division d";
		TypedQuery<division> q = em.createQuery(qString, division.class);
		List<division> division;
		try {
			division = q.getResultList();
			if (division == null || division.isEmpty())
				division = null;
		} finally {
			em.close();
		}
		return division;
	}

	public static void addDivision(division division) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(division);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (trans != null & trans.isActive())
				trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void updateDivision(division division) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(division);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (trans != null & trans.isActive())
				trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void deleteDivision(String divisionNumber) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		String qString = "SELECT d FROM division d WHERE d.divisionNumber = :divisionNumber";
		TypedQuery<division> q = em.createQuery(qString, division.class);
		q.setParameter("divisionNumber", divisionNumber);
		division d;
		try {
			d = q.getSingleResult();
			em.remove(em.merge(d));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (trans != null & trans.isActive())
				trans.rollback();
		} finally {
			em.close();
		}
	}

	public static division selectDivision(String divisionNumber) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT d FROM division d" + "WHERE d.divisionNumber = :divisionNumber";
		TypedQuery<division> q = em.createQuery(qString, division.class);
		try {
			division division = q.getSingleResult();
			return division;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	public boolean DivisionNumberExists(String divisionNumber) {
		division d = selectDivision(divisionNumber);
		return d != null;
	}

}
