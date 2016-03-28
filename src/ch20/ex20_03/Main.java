package ch20.ex20_03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		byte[] source = "abracadabra!".getBytes();
		System.out.println("source = " + Arrays.toString(source));
		byte key = (byte) 0xab;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		EncryptOutputStream eout = new EncryptOutputStream(bout, key);
		try {
			eout.write(source);
		} finally {
			eout.close();
		}
		byte[] encrypted = bout.toByteArray();
		System.out.println("encrypted = " + Arrays.toString(encrypted));
		ByteArrayInputStream bin = new ByteArrayInputStream(encrypted);
		DecryptInputStream din = new DecryptInputStream(bin, key);
		byte[] decrypted = new byte[source.length];
		DataInputStream datain = new DataInputStream(din);
		try {
			datain.readFully(decrypted);
		} finally {
			datain.close();
		}
		System.out.println("decrypted = " + Arrays.toString(decrypted));
	}

}
