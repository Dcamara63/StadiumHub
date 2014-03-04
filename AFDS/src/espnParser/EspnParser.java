package espnParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class EspnParser {

	private static final String APIKEY = "m9ug5cb4yufg88xv3su9k8sz";
	private static final String APIURL = "http://api.espn.com/v1/now/sports/";
	private static final String FOOTBALL_PARAM = "football/nba/?content='gamescore'apikey=";
	private static final String BASKETBALL_PARAM = "basketball/nba/?content='gamescore'apikey=";
	private static final String BASEBALL_PARAM = "baseball/mlb/?content='gamescore'apikey=";
	private static final String HOCKEY_PARAM = "hockey/nhl/?content='gamescore'apikey=";
	protected String getUrl(Sport sport) 
	{	
		switch(sport)
		{
			case BASKETBALL:
				return "http://api.espn.com/v1/sports/baseball/mlb/news/headlines";
						//APIURL + BASKETBALL_PARAM + APIKEY;
			case BASEBALL:
				return APIURL + BASEBALL_PARAM + APIKEY;
			case FOOTBALL:
				return APIURL + FOOTBALL_PARAM + APIKEY;
			case HOCKEY:
				return APIURL + HOCKEY_PARAM + APIKEY;
			default:
				return null;
		}
	}
}
