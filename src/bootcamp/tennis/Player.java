package bootcamp.tennis;

public class Player {
	
	private char name;
	private int sets;
	private int games;
	private int points;
	private String pointsFormatted;
	
	public char getName() {
		return name;
	}

	public int getSets() {
		return sets;
	}

	public int getGames() {
		return games;
	}

	public int getPoints() {
		return points;
	}
	
	public String getPointsFormatted(){
		return pointsFormatted;
	}
	
	public void setPointsFormatted(String pointsFormatted){
		this.pointsFormatted = pointsFormatted;
	}

	public Player(char name) {
		this.name=name;
		this.sets=0;
		this.games=0;
		this.points=0;
	}
	
	public void incrPoints() {
		this.points++;
	}
	
	public void incrGames() {
		this.games++;
	}
	
	public void incrSets() {
		this.sets++;
	}
	
	public void resetPoints(){
		this.points = 0;
	}
	
	public void resetGames(){
		this.games = 0;
	}

}
