package org.threads;

public class CounterCommand extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Counter: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
