package ch10.ex10_04;

public class BitChecker {

	/**
	 * 作成したビットカウントアルゴリズム。1bitずつ調べる。
	 * 
	 * @param i
	 * @return
	 */
	public static int bitCount(int i) {
		long start = System.nanoTime();
		int count = 0;
		int mask = 0x01;
		while (mask != 0) {
			if ((i & mask) != 0) {
				count++;
			}
			mask <<= 1;
		}
		System.out.println("bitCount:calc time = " + (System.nanoTime() - start));
		return count;
	}

	/**
	 * 公開されているビットカウントアルゴリズム。 Non-zero LSBの消しこみ。
	 * 
	 * @param i
	 * @return
	 */
	public static int bitCount2(int i) {
		long start = System.nanoTime();
		int count = 0;
		while (i != 0) {
			i &= i - 1;
			count++;
		}
		System.out.println("bitCount2:calc time = " + (System.nanoTime() - start));
		return count;
	}

	/**
	 * 公開されているビットカウントアルゴリズム。ビットを半分ずつ右に寄せる。
	 * 
	 * @param i
	 * @return
	 */
	public static int bitCount3(int i) {
		long start = System.nanoTime();
		int count = (i & 0x55555555) + (i >> 1 & 0x55555555);
		count = (count & 0x33333333) + (count >> 2 & 0x33333333);
		count = (count & 0x0f0f0f0f) + (count >> 4 & 0x0f0f0f0f);
		count = (count & 0x00ff00ff) + (count >> 8 & 0x00ff00ff);
		count = (count & 0x0000ffff) + (count >> 16 & 0x0000ffff);
		System.out.println("bitCount3:calc time = " + (System.nanoTime() - start));
		return count;
	}

	public static void main(String[] args) {
		System.out.println(bitCount(0x0f0ff00f));
		System.out.println(bitCount2(0x0f0ff00f));
		System.out.println(bitCount3(0x0f0ff00f));
	}

}
