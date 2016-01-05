package ch14.ex14_08;

public class NonDeadlockFriendly {
	private static final Object LOCK = new Object();

	private NonDeadlockFriendly partner;
	private String name;	

	public NonDeadlockFriendly(String name) {
		this.name = name;
	}

	public void hug() {
		synchronized(LOCK) {
			System.out.println(Thread.currentThread().getName() + " in " + name + ".hug() try to invoke " + partner.name
					+ ".hugBack()");
			partner.hugBack();
		}
	}

	public void hugBack() {
		synchronized (LOCK) {
			System.out.println(Thread.currentThread().getName() + " in " + name + ".hugBack()");			
		}
	}

	public void becomeFriend(NonDeadlockFriendly partner) {
		this.partner = partner;
	}

	public static void main(String[] args) {
		final NonDeadlockFriendly jareth = new NonDeadlockFriendly("jareth");
		final NonDeadlockFriendly cory = new NonDeadlockFriendly("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		new Thread(new Runnable() {
			public void run() {
				jareth.hug();
			}
		}, "Thread1").start();
		new Thread(new Runnable() {
			public void run() {
				cory.hug();
			}
		}, "Thread2").start();
	}

}
