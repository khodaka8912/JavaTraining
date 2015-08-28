package ch01.ex01_11;

class StringsDemo {
	public static void main(String[] args) {
		String myName = "Hodaka";
		String company = "Ricoh Co, Ltd.";
		myName += " Watanabe";
		myName += " ";
		myName += "(" + company + ")";
		System.out.println("Name = " + myName);
	}
}
