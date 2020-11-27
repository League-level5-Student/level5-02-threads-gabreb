package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
Thread[] threads;
ConcurrentLinkedQueue<Task>taskQueue; 

ThreadPool(int totalThreads) {
	threads = new Thread[totalThreads];
	for (int i = 0; i < threads.length; i++) {
		taskQueue = new ConcurrentLinkedQueue<Task>();
		threads[i] = new Thread(new Worker(taskQueue));
	}
}

public void addTask(Task task) {
	taskQueue.add(task);
}
public void start() {
	for (Thread t: threads) {
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
