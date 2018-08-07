package bootcamp.tennis;

public class TennisScoreBoard { 
	
	private Player p1, p2;
	
	public TennisScoreBoard(Player p1, Player p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	
	private void updatePoints(Player p){
		p.incrPoints();
	}
	
	private void updateGames(){
		Player larger = p2, smaller = p1;
		if(p1.getPoints() >= p2.getPoints()){
			larger = p1;
			smaller = p2;
		}
		if(larger.getPoints() >= 4 && (larger.getPoints() - smaller.getPoints()) >= 2){
			larger.incrGames();
			p1.resetPoints();
			p2.resetPoints();
		}
	}
	
	private void updateSets(){
		Player larger = p2, smaller = p1;
		if(p1.getGames() >= p2.getGames()){
			larger = p1;
			smaller = p2;
		}
		if(larger.getGames() >= 6 && (larger.getGames() - smaller.getGames()) >= 2){
			larger.incrSets();
			p1.resetGames();
			p2.resetGames();
		}
	}
	
	public void update(Player p){
		updatePoints(p);
		updateGames();
		updateSets();
	}
	
	private void computePoints(){
		Player larger = p2, smaller = p1;
		if(p1.getPoints() >= p2.getPoints()){
			larger = p1;
			smaller = p2;
		}
		if(p1.getPoints() < 3 || p2.getPoints() < 3){
			smaller.setPointsFormatted(new String("" + (15 * smaller.getPoints())));
			if(larger.getPoints() < 3)
				larger.setPointsFormatted(new String("" + (15 * larger.getPoints())));
			else if(larger.getPoints() == 3)
				larger.setPointsFormatted(new String("" + 40));
			else larger.setPointsFormatted(new String("Adv"));
		}
		else{
			smaller.setPointsFormatted(new String(""+40));
			if((larger.getPoints() - smaller.getPoints()) == 0)
				larger.setPointsFormatted(new String(""+ 40));
			else
				larger.setPointsFormatted(new String("Adv"));
		}
	}
	
	@Override
	public String toString(){
		computePoints();
		StringBuilder sb=new StringBuilder();
		sb.append("player:\t"+p1.getName()+"\t"+p2.getName()+"\n")
		.append("sets:\t"+p1.getSets()+"\t"+p2.getSets()+"\n")
		.append("games:\t"+p1.getGames()+"\t"+p2.getGames()+"\n")
		.append("points:\t"+p1.getPointsFormatted()+"\t"+p2.getPointsFormatted()+"\n");
		return sb.toString();
	}
}