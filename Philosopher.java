import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
		
	//Sets all Philosopher Object class variables
	volatile int id, think;
	volatile boolean running = true;
	Semaphore leftFork, rightFork;
	private static String status;
	Random random = new Random();
	
	//Sets a semaphore as a lock for each fork for each thread based on position
	public Philosopher(final int ID, Semaphore s, Semaphore  s2){
		this.id = ID;
		this.leftFork = s2;
		this.rightFork = s;
	}

	//this simulates the philosophers problem
	public void run() {
		
		while(this.running){
			this.think = random.nextInt(10000);
			System.out.println(this.id+": Started Thinking");
			this.status = "thinking";
			if (id == 1) {
				gui.stat1.setText("Thinking");
			} else if (id == 2) {
				gui.stat2.setText("Thinking");
			} else if (id == 3) {
				gui.stat3.setText("Thinking");
			} else if (id == 4) {
				gui.stat4.setText("Thinking");
			} else if (id == 5) {
				gui.stat5.setText("Thinking");
			}
			
			//Randomly sleep thread by random time to simulate work
			try{
				Thread.sleep(this.think);
			}catch(InterruptedException e){
				System.out.println("I thought too hard!");
			}
			System.out.println(this.id+": Is Now Hungry");
			if (id == 1) {
				gui.stat1.setText("Hungry");
			} else if (id == 2) {
				gui.stat2.setText("Hungry");
			} else if (id == 3) {
				gui.stat3.setText("Hungry");
			} else if (id == 4) {
				gui.stat4.setText("Hungry");
			} else if (id == 5) {
				gui.stat5.setText("Hungry");
			}
			//If left acquire is interrupted release left fork just in case
			try {
				this.leftFork.acquire();
				System.out.println(this.id+": Left Fork Acquired");
				if (id == 1) {
					gui.fork2.setText("" + id);
				} else if (id == 2) {
					gui.fork3.setText("" + id);
				} else if (id == 3) {
					gui.fork4.setText("" + id);
				} else if (id == 4) {
					gui.fork5.setText("" + id);
				} else if (id == 5) {
					gui.fork1.setText("" + id);
				}
			} catch (InterruptedException e) {
				System.out.println("Oops I dropped my left fork");
				this.leftFork.release();
			}
			
			//If right acquire is interrupted release right fork just in case
			try{
				this.rightFork.acquire();
				System.out.println(this.id+": Right Fork Acquired");
				if (id == 1) {
					gui.fork1.setText("" + id);
				} else if (id == 2) {
					gui.fork2.setText("" + id);
				} else if (id == 3) {
					gui.fork3.setText("" + id);
				} else if (id == 4) {
					gui.fork4.setText("" + id);
				} else if (id == 5) {
					gui.fork5.setText("" + id);
				}
			}catch(InterruptedException e) {
				System.out.println("Oops I dropped my right fork");
				this.rightFork.release();
			}
			
			//Simulated eating for 5 seconds && if interrupted release all forks
			try{
				if (id == 1) {
					gui.stat1.setText("Eating");
				} else if (id == 2) {
					gui.stat2.setText("Eating");
				} else if (id == 3) {
					gui.stat3.setText("Eating");
				} else if (id == 4) {
					gui.stat4.setText("Eating");
				} else if (id == 5) {
					gui.stat5.setText("Eating");
				}
				Thread.sleep(5000);
				this.status = "Eating";
			}catch (InterruptedException e) {
				System.out.println("I ate too much");
				this.leftFork.release();
				this.rightFork.release();
			}
			
			//Releases forks then return to simulated work unless terminate
			if (id == 1) {
				gui.fork1.setText("");
				gui.fork2.setText("");
			} else if (id == 2) {
				gui.fork2.setText("");
				gui.fork3.setText("");
			} else if (id == 3) {
				gui.fork3.setText("");
				gui.fork4.setText("");
			} else if (id == 4) {
				gui.fork4.setText("");
				gui.fork5.setText("");
			} else if (id == 5) {
				gui.fork5.setText("");
				gui.fork1.setText("");
			}
			this.leftFork.release();
			this.rightFork.release();
			System.out.println(this.id+": Forks Released");
		}			
	}
}