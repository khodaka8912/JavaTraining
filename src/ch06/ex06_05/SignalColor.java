package ch06.ex06_05;

import java.awt.Color;

/**
 * 信号機の色
 * getColorは単にColorを返すだけなため、
 * ｋ
 * 
 * @author hwatanabe
 * 
 */
public enum SignalColor {
	GREEN {
		public Color getColor() {
			return Color.GREEN;
		}
	},
	YELLOW {
		public Color getColor() {
			return Color.YELLOW;
		}
	},
	RED {
		public Color getColor() {
			return Color.RED;
		}
	},
	;

	public abstract Color getColor();
}
