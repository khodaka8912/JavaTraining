package ch04.ex04_05;

/**
 * 具象クラス
 * 
 * @author hwatanabe
 *
 */
class TreeNode {
	private Object element;
	private TreeNode[] childs;
	private int childNum;
	
	public TreeNode(int branchNum, Object element) {
		childs = new TreeNode[branchNum];
		this.element = element;
	}
	
	public void addChild(TreeNode child) {
		childs[childNum++] = child;
	}
	
	public TreeNode getChild(int index) {
		return childs[index];
	}
	public TreeNode[] getChilds() {
		return childs;
	}
	
	public Object getElement() {
		return element;
	}

}
