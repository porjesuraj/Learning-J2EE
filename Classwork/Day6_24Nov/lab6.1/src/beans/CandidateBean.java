package beans;

import java.sql.SQLException;
import java.util.List;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateBean {


	// properties 
	private CandidateDaoImpl candidateDao;
	// constr : arg less constr 
	// clients request parameter : choosen candidate id : int (WC setter : parsing fro string)  

	private int cid; 
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public CandidateBean() throws Exception {
	
		
		candidateDao = new CandidateDaoImpl(); 
		// TODO Auto-generated constructor stub
	}
	
	// no getter and setter are reuired for dao as it an internal property : meant only for bean 
	
	// B.L fetch all candidates
	
	public List<Candidate> getCandidates() throws SQLException{
		
		System.out.println("in B.L of candidate bean ");
		
		
		return candidateDao.getAllCandidates(); 
	}
	
	// B.L to increment selected voted count 
	
	public String updateVotes() throws SQLException {
		System.out.println("in BL cid = " + cid);
		
		 return candidateDao.incrementVotes(cid); 
	}
	
	// B.L : add to  clean up voter dao 
	
			public void daoCleanUp() throws SQLException {
				
				candidateDao.cleanUp();
			}
}


















