package ch03.ex03_05;

class LoopBenchmark extends Benchmark {

	private final int loopCount;
	
	public LoopBenchmark(int loopCount) {
		this.loopCount = loopCount;
	}
	
	/**
	 * 0からloopCountまでのループを実行する
	 */
	@Override
	protected void benchmark() {
		for (int i = 0; i < loopCount; i++);
	}

	/**
	 * 
	 * @param args args[0]:ベンチマークのリピート回数 args[1]:１回のベンチマークで行うループ回数
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			throw new IllegalArgumentException("Length of argments must be 2");
		}
		int count = Integer.parseInt(args[0]);
		int loopCount = Integer.parseInt(args[1]);
		long time = new LoopBenchmark(loopCount).repeat(count);
		System.out.println(count + " methods of " + loopCount + " loops in " +
				time + " nanoseconds");		
	}
}
