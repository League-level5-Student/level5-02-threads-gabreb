package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	static Random ran = new Random();
	static int randy;
 	static boolean race2 = true;
	static boolean winner = true;
	
	public static void main(String[] args) {
		Robot[] robots = new Robot[5];
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot();
			robots[i].penDown();
		}
		for (int i = 0; i < robots.length; i++) {
			robots[i].setX(70 + (100*i));
			robots[i].setY(550);
			robots[i].setSpeed(100);
		}
		
		Thread r1 = new Thread(()->moving(robots[0]));
		Thread r2 = new Thread(()->moving(robots[1]));
		Thread r3 = new Thread(()->moving(robots[2]));
		Thread r4 = new Thread(()->moving(robots[3]));
		Thread r5 = new Thread(()->moving(robots[4]));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
	}
	public static void moving(Robot l) {
		while(winner) {
   		 randy = ran.nextInt(50);
   		 l.move(randy);
   		 if (l.getY() <= 0) {
   			 winner = false;
   			 break;
   		 }
   	}
	}
	
    	}

