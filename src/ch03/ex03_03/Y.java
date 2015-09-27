package ch03.ex03_03;

class Y extends X {
	/** フィールド初期化前の値表示用 */
	private int showMasks = showMasks("--Before Y initialize--");
	/** スーパークラスの生成中に使用できるようfinalにする */
	protected final int yMask = 0xff00;
	
	{
		showMasks("--Before Y constractor--");
	}
	
	public Y() {
		fullMask |= yMask;
		showMasks("--After Y constractor--");	
	}
	
	@Override
	protected int showMasks(String message) {
		super.showMasks(message);
		System.out.printf(FORMAT, "yMask", yMask);
		return 0X00;
	}

	public static void main(String[] args) {
		new Y();
	}
}
