package org.okiwi.ltatbdx;

public class VotedTwiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private String participant;
	
	public VotedTwiceException(String aParticipant) {
		this.participant = aParticipant;
	}

}
