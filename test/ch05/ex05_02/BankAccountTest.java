package ch05.ex05_02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch05.ex05_02.BankAccount.History;

public class BankAccountTest {

	BankAccount target;

	@Before
	public void setUp() throws Exception {
		target = new BankAccount(123);
	}

	@Test
	public void testBankAccount() {
		assertThat(target, is(notNullValue()));
	}

	@Test
	public void testDeposit() {
		target.deposit(100);
		assertThat(target.getBalance(), is(100L));
		assertThat(target.history().next().toString(), is("123: deposit 100"));
	}

	@Test
	public void testWithdraw() {
		target.withdraw(200);
		assertThat(target.getBalance(), is(-200L));
		assertThat(target.history().next().toString(), is("123: withdraw 200"));
	}

	@Test
	public void testHistory() {
		History blank = new History(10);
		assertThat(blank.next(), is(nullValue()));
	}

	@Test
	public void testHistory2() {
		History history = new History(10);
		history.add(target.new Action("depoist", 10));
		assertThat(history.next(), is(notNullValue()));
	}

	@Test
	public void testHistoryNex() {
		History history = new History(10);
		history.add(target.new Action("depoist", 1));
		history.add(target.new Action("depoist", 2));
		history.add(target.new Action("depoist", 3));
		history.add(target.new Action("depoist", 4));
		history.add(target.new Action("depoist", 5));
		history.add(target.new Action("depoist", 6));
		history.add(target.new Action("depoist", 7));
		history.add(target.new Action("depoist", 8));
		history.add(target.new Action("depoist", 9));
		history.add(target.new Action("depoist", 10));
		history.add(target.new Action("depoist", 11));
		for (int i = 0; i < 10; i++) {
			assertThat(history.next(), is(notNullValue()));
		}
		assertThat(history.next(), is(nullValue()));
	}
}
