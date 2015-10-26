package ch07.ex07_02;

public class LiteralChecker {
	boolean bo;
	char c;
	byte by;
	short s;
	int i;
	long l;
	float f;
	double d;

	public static void main(String[] args) {
		new LiteralChecker().check();
	}
	
	public void check() {
		bo = true; System.out.println("bo = " + bo);
//		bo = 1; bo = 1L; bo = 1.0f; bo = 1.0d // NG
		c = 1; System.out.println("c = " + (int)c);
//		c = 0xffffff; c = 1L; c = 1.0f; c = 1.0d; c = true; // NG
		by = 1; System.out.println("by = " + by);
//		by = 0xffff; by = 1L; by = 1.0f; by = 1.0d; by = true // NG
		s = 1; System.out.println("s = " + s);
//		s = 0xffffff; s = 1L; s = 1.0f; s = 1.0d; s = true; // NG
		i = 1; System.out.println("i = " + i);
//		i = 1L; i = 1.0f; i = 1.0d; i = true; // NG
		l = 1; System.out.println("f = " + l);
		l = 10L; System.out.println("f = " + l);
//		l = 1.0f; l = 1.0d; l = true; // NG
		f = 1; System.out.println("f = " + f);
		f = 10L; System.out.println("f = " + f);
		f = 123456789012345L; System.out.println("f = " + f);
//		f = 1.0d; f = true // NG
		d = 1; System.out.println("d = " + d);
		d = 10L; System.out.println("d = " + d);
		d = 123456789012345L; System.out.println("d = " + d);
		d = 1234567890123456789L; System.out.println("d = " + d);
		d = 1.0f; System.out.println(d);
//		d = true; // NG
	}
}
