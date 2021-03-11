package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.BankAccount;
import pojos.Role;
import pojos.Vendor;

import static utils.HibernateUtils.getSf;
public class BankAccountImpl implements IBankAccountDao {

	@Override
	public List<BankAccount> getAllAccountsByVendorId(int vendorId) {
		
		List<BankAccount> accounts = null;
	
		String jpql = "select a from BankAccount a  where a.accountOwner.vendorId=:vid "; 
		
		// session from SF : getCurntSession
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			accounts = session.createQuery(jpql, BankAccount.class)
					.setParameter("vid", vendorId)
					.getResultList();
			
			
			
			
			/* do not use this 
			 * Vendor v = session.get(Vendor.class, vendorId);
			 * 
			 * if(v != null) { accounts = v.getBankAccounts(); accounts.size(); }
			 */
			
			
		
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			// re throw exception to caller
			throw e;
		}
		return accounts;
		

	}

}
