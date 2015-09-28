package ch06.ex06_04;

import java.awt.Color;

/**
 * 信号機の色
 * 
 * @author hwatanabe
 * 
 */
public enum SignalColor {
	GREEN(Color.GREEN), YELLOW(Color.YELLOW), RED(Color.RED), ;
	
	private final Color color;
	
	SignalColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
}
