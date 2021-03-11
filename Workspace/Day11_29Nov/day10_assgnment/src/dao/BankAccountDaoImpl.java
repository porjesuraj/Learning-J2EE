package dao;

import static utils.HibernateUtils.getSf;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.BankAccount;
import pojos.Vendor;

public class BankAccountDaoImpl implements IBankAccountDao {

	@Override
	public List<BankAccount> getAllAccountsByVendorId(int vendorId) {
		List<BankAccount> accts = null;
		String jpql = "select a from BankAccount a where a.accountOwner.vendorId = :vid";
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			accts = session.createQuery(jpql, BankAccount.class).setParameter("vid", vendorId).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return accts;
	}

	@Override
	public String createAccount(Vendor v,BankAccount a) {
		String mesg="A/C Creation Failed...";
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.update(v);//re attach detached POJO to L1 cache
			v.addAccount(a);
			tx.commit();
			mesg="A/C created successfully..";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String closeAccount(Vendor v, int acctNo) {
		String mesg="A/C closing Failed...";
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.update(v);//re attach detached POJO to L1 cache
			BankAccount a=session.get(BankAccount.class, acctNo);
			v.removeAccount(a);
			tx.commit();
			mesg="A/C closed successfully..";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	

}
