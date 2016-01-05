package ch14.ex14_08;

/*
 * hugback()呼び出し前にyield呼び出しを行うことで、デッドロックの発生確率が上昇する
 *
 */
public class YieldFriendly {

	private YieldFriendly partner;
	private String name;

	public YieldFriendly(String name) {
		this.name = name;
	}

	public synchronized void hug() {
		System.out.println(Thread.currentThread().getName() + " in " + name + ".hug() try to invoke " + partner.name
				+ ".hugBack()");
		Thread.yield();
		partner.hugBack();
	}

	public synchronized void hugBack() {
		System.out.println(Thread.currentThread().getName() + " in " + name + ".hugBack()");

	}

	public void becomeFriend(YieldFriendly partner) {
		this.partner = partner;
	}
	
	public static void main(String[] args) {
		final YieldFriendly jareth = new YieldFriendly("jareth");
		final YieldFriendly cory = new YieldFriendly("cory");
		
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
