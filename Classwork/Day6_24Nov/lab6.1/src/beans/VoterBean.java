package beans;

import java.sql.SQLException;

import dao.VoterDaoImpl;
import pojos.Voter;

public class VoterBean {
	//properties of Java Bean (JB) : private , non static , non transient
	//clnt's conversational state
	private String email,password;
	//DAO layer ref : dependency of JB
	private VoterDaoImpl voterDao;
	//store validated user details : Voter POJO
	private Voter validatedUser;
	//def constr
	public VoterBean() throws Exception
	{
		System.out.println("voter bean constr");
		//instantiate DAO
		voterDao=new VoterDaoImpl();
	}
	//all setters n getters for properties
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public VoterDaoImpl getVoterDao() {
		return voterDao;
	}
	public void setVoterDao(VoterDaoImpl voterDao) {
		this.voterDao = voterDao;
	}
	public Voter getValidatedUser() {
		return validatedUser;
	}
	public void setValidatedUser(Voter validatedUser) {
		this.validatedUser = validatedUser;
	}
	//add B.L method for user validation to return navigational outcome 
	public String validateUser() throws SQLException
	{
		System.out.println("in JB : validateUser "+email+" "+password);
		//invoke dao's method for validation
		validatedUser=voterDao.authenticateVoter(email, password);
		if(validatedUser == null)
		{
			//invalid user
			return "login";
		}
		//valid user : chk role
		if(validatedUser.getRole().equals("admin"))
			return "admin_status";
		//voter : user : chk voting status
		if(validatedUser.isStatus())
			return "voter_status";
		//voter : not yet voted
		return "candidate_list";
	}
	
	// add B.L method to update voting status 
	
	public String updateStatus() throws Exception {
		
		System.out.println("in B.L update status ");
		return voterDao.updateVotingStatus(validatedUser.getVoterId()); 
	}
	// B.L : add to  clean up voter dao 
	
		public void daoCleanUp() throws SQLException {
			
			voterDao.cleanUp();
		}
	

}

            