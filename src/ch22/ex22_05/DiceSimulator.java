package ch22.ex22_05;

import java.util.HashMap;
import java.util.Map;

public class DiceSimulator {
	
	private static final int FACE_NUM = 6;
	
	private final int diceNum;
	private final int max;
	private final int min;
	
	public DiceSimulator(int diceNum) {
		this.diceNum = diceNum;
		min = diceNum;
		max = diceNum * FACE_NUM;
	}
	
	public Map<Integer, Double> getProbDistribution() {
		Map<Integer, Double> probMap = new HashMap<>();
		
		return probMap;
	}

}
