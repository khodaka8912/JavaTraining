package ch20.ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream {

	private final byte key;

	public EncryptOutputStream(OutputStream out, byte key) {
		super(out);
		this.key = key;
	}

	@Override
	public void write(int b) throws IOException {
		super.write(encrypt(b));
	}
	
	private int encrypt(int b) {
		return b ^ key;
	}

}
