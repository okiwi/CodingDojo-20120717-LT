package org.okiwi.ltatbdx;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class LightningTalk {
	private String subject;
	private String description;
	private String speaker;
	private ArrayList<Vote> votes;
	
	public LightningTalk() {
		this.votes = new ArrayList<Vote>();
	}

	public void addSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}

	public void addDescription(String description) {
		this.description = description;
		
	}

	public String getDescription() {
		return this.description;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
		
	public String getSpeaker() {
		return this.speaker;
	}

	public ArrayList<Vote> getVotes() {
		return this.votes;
	}

	public void receivedAVoteFrom(String participant) {
		Vote vote = new Vote(participant);
		if (!this.votes.contains(vote)) {
			this.votes.add(vote);
		} else {
			throw new VotedTwiceException(participant);
		}
	}
}
