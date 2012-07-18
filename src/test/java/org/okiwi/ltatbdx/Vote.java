package org.okiwi.ltatbdx;

public class Vote {

	public String voter;

	public Vote(String voter){
		this.voter = voter;
	}
	
	@Override
	public boolean equals(Object object) {
		try {
			String aCandidate = ((Vote) object).voter;
			return aCandidate != null ? aCandidate.equals(this.voter) : false;
		} catch (ClassCastException cce) {
			return false;
		}
	}
}
