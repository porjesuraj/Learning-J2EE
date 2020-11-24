package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {
	//add a method to ret list of all candidates 
	List<Candidate> getAllCandidates() throws SQLException;
	//add a method to inc vote count
	String incrementVotes(int candidateId)throws SQLException;
}
