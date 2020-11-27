package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable, Task {
	ConcurrentLinkedQueue<Task> taskQueue;
	Worker(ConcurrentLinkedQueue<Task> taskQueue) {
	this.taskQueue = taskQueue;
	}
	public void run() {
		while (!taskQueue.isEmpty()) {
			taskQueue.remove().perform();
			
		}
		
	}
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}


}
