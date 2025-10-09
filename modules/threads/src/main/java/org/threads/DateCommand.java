package org.threads;

import java.time.ZonedDateTime;

public class DateCommand implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Date: " + ZonedDateTime.now());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
