import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "FaKtxcRjz1vFFryBHjAyQ2vVi";
    private final static String CONSUMER_KEY_SECRET = "jFzpRFZVKOykPVacwJSGhJSzPs9n696cDfeUjyGPPC2eAww0md";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating my status again from NamexTweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "0s96RXSsru6FoLPBIASS7kBBiQrZIJLCqUZlLpr1CRxHG";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "779644447151697921-nSz2ssZ3uNsHuuzG4VWAJ7BuMkCv6fK";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}