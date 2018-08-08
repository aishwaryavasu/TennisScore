package bootcamp.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bootcamp.tennis.Player;
import bootcamp.tennis.TennisScoreBoard;

public class Main {
	
	public static void main(String a[]) throws IOException{
		
		TennisScoreBoard tsb;
		Player p1 = new Player('A');
		Player p2 = new Player('B');
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String inp="AABAABBABBAABAABBABBAABAABBABBAABAABBABBAABAABBABBAABAABBABBAABAABBABBAABAABBABBAABAAAABAA";
	//	while(true) {
			tsb=new TennisScoreBoard(p1, p2);
	//		inp=br.readLine();
			for(int i=0;i<inp.length();i++) {
				char c=inp.charAt(i);
				if(c == 'A')
					tsb.update(p1);
				else
					tsb.update(p2);
				//System.out.println(tsb);
			}
			System.out.println(tsb);
	//	}
		
	}

}
