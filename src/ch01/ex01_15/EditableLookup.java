package ch01.ex01_15;

/**
 * 編集可能な検索テーブル
 * @author hwatanabe
 *
 */
public interface EditableLookup extends Lookup {
	
	/**
	 * オブジェクトを追加する
	 * @param name オブジェクトに関連付ける名前
	 * @param element 追加するオブジェクト
	 */
	void add(String name, Object element);
	
	/**
	 * nameと関連付けされたオブジェクトを削除する。
	 * 該当するオブジェクトがない場合は失敗する。
	 * @param element 削除するオブジェクト
	 * @return true 成功　false 失敗
	 */
	boolean remove(String name);
}
