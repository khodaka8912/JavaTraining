package ch20.ex20_02;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class ByteTranslater extends FilterInputStream {

	private final byte from;
	private final byte to;

	public ByteTranslater(InputStream in, byte from, byte to) {
		super(in);
		this.from = from;
		this.to = to;
	}

	@Override
	public int read() throws IOException {
		int b = super.read();
		if (b == -1) {
			return b;
		}
		return b == from ? to : b;
	}

	public static void main(String[] args) throws IOException {
		byte[] buf = "abracadabra!".getBytes();
		InputStream in = new ByteTranslater(new ByteArrayInputStream(buf), (byte) 'b', (byte) 'B');
		int b;
		while ((b = in.read()) != -1) {
			System.out.print((char) b);
		}
	}

}