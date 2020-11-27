package _01_Olympic_Rings;

import java.awt.Color;
import java.util.ArrayList;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
		Robot blue = new Robot(100, 100);
		Robot y = new Robot(180,145);
		Robot black = new Robot(260,100);
		Robot green = new Robot(320,145);
		Robot r = new Robot(400,100);
		ArrayList<Robot> robots = new ArrayList<Robot>();
		
		public static void main(String[] args) {
			OlympicRings_Threaded t = new OlympicRings_Threaded(); 
			t.run();
			
		}
		
		void run() {
		robots.add(blue);
		robots.add(y);
		robots.add(black);
		robots.add(green);
		robots.add(r);
		
		for (int i = 0; i < robots.size(); i++) {
			robots.get(i).penDown();
			robots.get(i).setSpeed(10);
			robots.get(i).hide();
			}
		
		blue.setPenColor(Color.BLUE);
		black.setPenColor(Color.BLACK);
		r.setPenColor(Color.RED);
		green.setPenColor(Color.green);
		y.setPenColor(Color.YELLOW);
		
		Thread r1 = new Thread(()->drawCircle(blue));
		Thread r2 = new Thread(()->drawCircle(y));
		Thread r3 = new Thread(()->drawCircle(black));
		Thread r4 = new Thread(()->drawCircle(r));
		Thread r5 = new Thread(()->drawCircle(green));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
		
		
		}
		
		public void drawCircle(Robot b) {
			for (int i = 0; i < 360; i++) {
				b.turn(1);
				b.move(1);
			}
		}
		
}

