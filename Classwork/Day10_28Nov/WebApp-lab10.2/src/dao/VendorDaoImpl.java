package dao;

import pojos.Role;
import pojos.Vendor;
import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.*;

public class VendorDaoImpl implements IVendorDao {

	@Override
	public String registerVendor(Vendor v) {
		String mesg = "registration failed....";
		// v : transient
		// session from SF : getCurntSession
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// transient -----> persistent : save
			session.save(v); // v : persistent
			tx.commit();
			mesg = "Vendor registered with ID " + v.getVendorId();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// re throw exception to caller
			throw e;
		}
		// v : detached
		return mesg;
	}

//List all vendors , registered after specific reg date & reg amount < specified amt.
	@Override
	public List<Vendor> listSpecificVendors(LocalDate regDate, double amount) {
		List<Vendor> vendors = null;
		String jpql = "select v from Vendor v where v.regDate > :dt and v.regAmount < :amt and v.userRole=:rl";
		// session from SF : getCurntSession
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// create query obj , set IN params , exec query
			vendors = session.createQuery(jpql, Vendor.class).setParameter("dt", regDate).setParameter("amt", amount)
					.setParameter("rl", Role.VENDOR).getResultList();// vendors : list of PERSISTENT pojos
			tx.commit();// session closed
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// re throw exception to caller
			throw e;
		}
		return vendors;// vendors : list of DETACHED pojos
	}

	@Override
	public List<Vendor> applyDiscount(double discount, LocalDate date) {
		List<Vendor> vendors = null;
		String jpql = "select v from Vendor v where v.regDate < :dt and v.userRole=:rl";// select jpql
		// session from SF : getCurntSession
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get list of selected vendors : create query --set IN params --exec
			vendors = session.createQuery(jpql, Vendor.class).setParameter("dt", date).
					setParameter("rl", Role.VENDOR)
					.getResultList();//vendors : list of persistent pojos.
			vendors.forEach(v->v.setRegAmount(v.getRegAmount()-discount));//internal iteration
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// re throw exception to caller
			throw e;
		}
		return vendors;
	}

	@Override
	public Vendor authenticateUser(String email, String password) {
		
		Vendor v = null;
		
		String jpql = "select v from Vendor  v join fetch v.bankAccounts where v.email=:em and v.password=:pass"; 
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			v = session.createQuery(jpql, Vendor.class)
					.setParameter("em", email)
					.setParameter("pass", password)
					.getSingleResult(); 
			
 			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// re throw exception to caller
			throw e;
		}
		// v : detached
		return v;
	}

}
