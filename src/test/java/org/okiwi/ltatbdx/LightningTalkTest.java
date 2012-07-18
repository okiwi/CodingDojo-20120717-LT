package org.okiwi.ltatbdx;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class LightningTalkTest {
	
	LightningTalk lightTalk = new LightningTalk();
	
	@Test
	public void canCreateALightningTalk(){
		assertThat(lightTalk)
			.isNotNull()
			.isInstanceOf(LightningTalk.class);
	}

	@Test
	public void shouldLightningTalkHaveASubjet(){
		String subject = "My subject";
		lightTalk.addSubject(subject);
		assertThat(lightTalk.getSubject()).isEqualTo(subject);
	}
	
	@Test
	public void shouldLightningTalkHaveDescription(){
		String description = "My Description";
		lightTalk.addDescription(description);
		assertThat(lightTalk.getDescription()).isEqualTo(description);
	}
	
	@Test
	public void doesLightningTalkHaveASpeaker(){
		lightTalk.setSpeaker("My Speaker");
		assertThat(lightTalk.getSpeaker()).isNotNull();
	}
	
	@Test
	public void doesLightningTalkNotHaveASpeaker(){
		assertThat(lightTalk.getSpeaker()).isNull();
	}
	
	@Test
	public void aNewLightningTalkShouldHaveNoVotes(){
		assertThat(lightTalk.getVotes().size()).isEqualTo(0);
	}
	
	@Test
	public void aPersonCanVoteForALightningTalk(){
		lightTalk.receivedAVoteFrom("Jef");
		assertThat(lightTalk.getVotes().size()).isEqualTo(1);
	}
	
	@Test
	public void returnVotesFromALightningTalkIsAVote(){
		lightTalk.receivedAVoteFrom("Jef");
		assertThat(lightTalk.getVotes().get(0))
			.isInstanceOf(Vote.class);
	}
	
	@Test
	public void jefVoted(){
		lightTalk.receivedAVoteFrom("Jef");
		assertThat(lightTalk.getVotes().get(0).voter)
			.isEqualTo("Jef");
	}
	
	@Test(expected = VotedTwiceException.class)
	public void JefCantVoteTwiceForALT(){
		lightTalk.receivedAVoteFrom("Jef");
		lightTalk.receivedAVoteFrom("Jef");
	}

	@Test
	public void JeffAndFloCanVote(){
		lightTalk.receivedAVoteFrom("Jef");
		lightTalk.receivedAVoteFrom("Flo");
	}
}
