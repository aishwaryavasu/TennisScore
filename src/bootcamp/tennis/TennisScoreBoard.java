package bootcamp.tennis;

public class TennisScoreBoard { 
	
	private Player p1, p2;
	private boolean tie;
	public static int MAX_POINTS = 4;
	public static int MAX_TIE_POINTS = 7;
	public static int MAX_GAMES = 6;
	public static int MIN_DIFF = 2;


	public TennisScoreBoard(Player p1, Player p2){
		this.p1 = p1;
		this.p2 = p2;
		tie = false;
	}
    public void update(Player p){
        updatePoints(p);
        updateGames();
        updateSets();
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
		if(tie){
			if(larger.getPoints() >= MAX_TIE_POINTS && (larger.getPoints() - smaller.getPoints()) >= MIN_DIFF){
				larger.incrSets();
				tie=false;
				p1.resetPoints();
				p2.resetPoints();
				p1.resetGames();
				p2.resetGames();
			}
		}
		else if(larger.getPoints() >= MAX_POINTS && (larger.getPoints() - smaller.getPoints()) >= MIN_DIFF){
			larger.incrGames();
			p1.resetPoints();
			p2.resetPoints();
		}

	}
	
	private void updateSets() {
		Player larger = p2, smaller = p1;
		if (p1.getGames() >= p2.getGames()) {
			larger = p1;
			smaller = p2;
		}
		if (larger.getGames() >= MAX_GAMES && (larger.getGames() - smaller.getGames()) >= 2) {
			larger.incrSets();
			p1.resetGames();
			p2.resetGames();
		}
		if (larger.getGames() == MAX_GAMES && smaller.getGames() == MAX_GAMES) {
			tie = true;
		}
	}

	private void computeDisplayPoints(){
		Player larger = p2, smaller = p1;
		if(p1.getPoints() >= p2.getPoints()){
			larger = p1;
			smaller = p2;
		}
		if(tie){
			p1.setPointsFormatted(p1.getPoints()+"");
			p2.setPointsFormatted(p2.getPoints()+"");
		}
		else if(p1.getPoints() < 3 || p2.getPoints() < 3){
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
		computeDisplayPoints();
		StringBuilder sb=new StringBuilder();
		sb.append("player:\t"+p1.getName()+"\t"+p2.getName()+"\n")
		.append("sets:\t"+p1.getSets()+"\t"+p2.getSets()+"\n")
		.append("games:\t"+p1.getGames()+"\t"+p2.getGames()+"\n")
		.append("points:\t"+p1.getPointsFormatted()+"\t"+p2.getPointsFormatted()+"\n");
		return sb.toString();
	}
}