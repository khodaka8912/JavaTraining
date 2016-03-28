package ch20.ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {

	private final byte key;

	protected DecryptInputStream(InputStream in, byte key) {
		super(in);
		this.key = key;
	}

	@Override
	public int read() throws IOException {
		int b = super.read();
		return b == -1 ? b : ((b ^ key) & 0xff);
	}

}
