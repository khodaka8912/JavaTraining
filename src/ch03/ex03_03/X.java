package ch03.ex03_03;

class X {
	/** フィールド初期化前の値表示用 */
	private int showMasks = showMasks("--Before X initialize--");
	protected int xMask = 0x00ff;
	protected int fullMask;

	protected static final String FORMAT = "%1$s   \t= 0x%2$04x\n";

	{
		showMasks("--Before X constractor--");
	}

	public X() {
		fullMask = xMask;
		showMasks("--After X constractor--");
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}
	
	/**
	 * 各マスク値を表示する
	 * @param message 表示用メッセージ
	 * @return 0
	 */
	protected int showMasks(String message) {
		System.out.println(message);
		System.out.printf(FORMAT, "fullMask", fullMask);
		System.out.printf(FORMAT, "xMask", xMask);
		return 0x00;
	}
}
