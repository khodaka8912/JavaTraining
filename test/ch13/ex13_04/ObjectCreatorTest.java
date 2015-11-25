package ch13.ex13_04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ObjectCreatorTest {

	@Test
	public void testCreate() {
		ObjectCreator creator = new ObjectCreator("res/testValues");
		creator.create();
		List<Object> createdList = creator.getList();
		assertThat((Boolean)createdList.get(0), is(Boolean.valueOf(true)));
		assertThat((Integer)createdList.get(1), is(Integer.valueOf(123)));
		assertThat((Character)createdList.get(2), is(Character.valueOf('c')));
		assertThat((Long)createdList.get(3), is(Long.valueOf(987654321)));
		assertThat((Short)createdList.get(4), is(Short.valueOf((short)255)));
		assertThat((Byte)createdList.get(5), is(Byte.valueOf((byte)-128)));
		assertThat((Double)createdList.get(6), is(Double.valueOf(123.456)));
		assertThat((Float)createdList.get(7), is(Float.valueOf((float)-987.654)));
	}

}
