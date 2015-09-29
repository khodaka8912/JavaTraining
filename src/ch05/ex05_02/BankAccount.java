package ch05.ex05_02;

/**
 * 処理履歴を記録するBankAccount
 * 
 * @author hwatanabe
 *
 */
public class BankAccount {
	private long number;
	private long balance;
	private History history;

	BankAccount(long number) {
		history = new History(10);
		this.number = number;
	}

	public class Action {
		private String act;
		private long amount;

		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}

		public String toString() {
			// identify our enclosing account
			return number + ": " + act + " " + amount;
		}
	}

	public static class History implements Cloneable {
		private Action[] actions;
		private int pointer;

		History(int length) {
			actions = new Action[length];
		}

		void add(Action newAction) {
			for (int i = actions.length - 1; i > 0; i--) {
				actions[i] = actions[i - 1];
			}
			actions[0] = newAction;
		}

		public Action next() {
			if (pointer < actions.length) {
				return actions[pointer++];
			} else {
				return null;
			}
		}

		@Override
		protected History clone() {
			History history = null;
			try {
				history = (History) super.clone();
			} catch (CloneNotSupportedException unreachable) {
			}
			return history;
		}
	}

	public History history() {
		return history.clone();
	}

	public void deposit(long amount) {
		balance += amount;
		history.add(new Action("deposit", amount));
	}

	public void withdraw(long amount) {
		balance -= amount;
		history.add(new Action("withdraw", amount));
	}

	public long getBalance() {
		return balance;
	}
	// ...

}