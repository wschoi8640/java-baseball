
public class Processor {
	static int [] cntBallStrike(int[] mergedArr){
		int strike = 0;
		int ball = 0;
		
		for(int val : mergedArr) {
	    	if(val == 1) {
	    		strike++;
	    	}
	    	else if(val == 2) {
	    		ball++;
	    	}
	    }
		int [] result = {strike, ball};
		return result;
	}

	public static int [] cntResult(int strike, int ball) {
		int gameMode = 0;
		if(strike != 0) {
	    	System.out.print(strike + Msgs.Strike.getMsg());
	    }
	    if(ball != 0) {
	    	System.out.print(ball + Msgs.Ball.getMsg());
	    }
	    System.out.println();
	    
	    if(strike == 3) {
	    	gameMode = GameModeReceiver.receive();
	    }	
	    
	    int [] finalResult = {gameMode, ComNumReceiver.receive()};
	    return finalResult;
	}
}