package ch20.ex20_01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class TranslateByte {
	public static void main(String[] args) throws IOException {
		byte[] buf = "abracadabra!".getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		translateByte((byte) 'b', (byte) 'B', in, out);
		System.out.println(out.toString());
	}

	public static void translateByte(byte from, byte to, InputStream in, OutputStream out)
			throws IOException {
		int b;
		while ((b = in.read()) != -1) {
			out.write(b == from ? to : b);
		}
	}
}