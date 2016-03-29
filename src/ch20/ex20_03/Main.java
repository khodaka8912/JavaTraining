package ch20.ex20_03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		byte[] source = "abracadabra!".getBytes();
		System.out.println("source = \"" + new String(source) + "\" " + Arrays.toString(source));
		byte key = (byte) 0xab;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try (EncryptOutputStream eout = new EncryptOutputStream(bout, key)) {
			eout.write(source);
		}
		byte[] encrypted = bout.toByteArray();
		System.out.println("encrypted = \"" + new String(encrypted) + "\" " + Arrays.toString(encrypted));
		ByteArrayInputStream bin = new ByteArrayInputStream(encrypted);
		byte[] decrypted = new byte[source.length];
		try(DecryptInputStream din = new DecryptInputStream(bin, key)) {
			din.read(decrypted);
		}
		System.out.println("decrypted = \"" + new String(decrypted) + "\" " + Arrays.toString(decrypted));
	}

}
