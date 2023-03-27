
/**
 * 
 * @author venkateswarlu
 *
 *Sports Team class to addplayers and getplayers
 */
public class Team {

	
	private String teamName;

	private String[] players;
	
	private int playerCount;
	
	
	public Team() {
		this.players = new String[20];
		this.playerCount =0;
	}
	
	
	public Team(String teamName) {
		this.players = new String[20];
		this.playerCount =0;
		this.teamName = teamName;
	}
	
	
	public void addPlayer(String player) {
		players[playerCount] = player;
		playerCount++;
	}
	
	
	public String[] getPlayers() {
		return players;
	}
	
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	
	public String getTeamName() {
		return teamName;
	}
}
