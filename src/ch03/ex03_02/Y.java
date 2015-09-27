package ch03.ex03_02;

class Y extends X {
	
	private int showMasks = showMasks("--Before Y initialize--");
	protected int yMask = 0xff00;
	
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
