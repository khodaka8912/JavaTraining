package ch03.ex03_06;

/**
 * 動力源
 * @author hwatanabe
 *
 */
abstract class EnergySource {
	/**
	 * 動力源が空かどうかを調べる
	 * @return true 空 false 空ではない
	 */
	public abstract boolean empty();
}
