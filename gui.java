//Author: Brandon Batton

import java.awt.EventQueue;
import java.util.concurrent.Semaphore;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class gui {
	static JLabel stat1;
	static JLabel stat2;
	static JLabel stat3;
	static JLabel stat4;
	static JLabel stat5;
	static JLabel fork1;
	static JLabel fork2;
	static JLabel fork3;
	static JLabel fork4;
	static JLabel fork5;

	private JFrame frmDiningProblem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frmDiningProblem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gui() {
	
		frmDiningProblem = new JFrame();
		frmDiningProblem.setForeground(new Color(255, 255, 255));
		frmDiningProblem.setTitle("Dining Problem");
		frmDiningProblem.setBounds(100, 100, 450, 300);
		frmDiningProblem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDiningProblem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(0, 0, 434, 262);
		frmDiningProblem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Lphil1 = new JLabel("Philosopher1");
		Lphil1.setBounds(188, 0, 74, 14);
		Lphil1.setFont(new Font("Georgia", Font.PLAIN, 12));
		panel.add(Lphil1);
		
		JLabel Lphil2 = new JLabel("Philosopher 2");
		Lphil2.setBounds(310, 71, 85, 14);
		Lphil2.setFont(new Font("Georgia", Font.PLAIN, 12));
		panel.add(Lphil2);
		
		JLabel Lphil3 = new JLabel("Philosopher 3");
		Lphil3.setBounds(276, 170, 79, 14);
		Lphil3.setFont(new Font("Georgia", Font.PLAIN, 12));
		panel.add(Lphil3);
		
		JLabel Lphil4 = new JLabel("Philosopher 4");
		Lphil4.setBounds(90, 170, 91, 14);
		Lphil4.setFont(new Font("Georgia", Font.PLAIN, 12));
		panel.add(Lphil4);
		
		JLabel Lphil5 = new JLabel("Philosopher 5");
		Lphil5.setBounds(62, 71, 85, 14);
		Lphil5.setFont(new Font("Georgia", Font.PLAIN, 12));
		panel.add(Lphil5);
		
		stat1 = new JLabel("");
		stat1.setBounds(198, 11, 46, 14);
		panel.add(stat1);
		
		stat2 = new JLabel("");
		stat2.setBounds(320, 84, 46, 14);
		panel.add(stat2);
		
		stat3 = new JLabel("");
		stat3.setBounds(286, 181, 46, 14);
		panel.add(stat3);
		
		stat4 = new JLabel("");
		stat4.setBounds(100, 181, 46, 14);
		panel.add(stat4);
		
		stat5 = new JLabel("");
		stat5.setBounds(72, 84, 46, 14);
		panel.add(stat5);
		
		fork1 = new JLabel("");
		fork1.setBounds(122, 28, 46, 14);
		panel.add(fork1);
		
		fork2 = new JLabel("");
		fork2.setBounds(296, 28, 46, 14);
		panel.add(fork2);
		
		fork3 = new JLabel("");
		fork3.setBounds(296, 122, 46, 14);
		panel.add(fork3);
		
		fork4 = new JLabel("");
		fork4.setBounds(208, 209, 46, 14);
		panel.add(fork4);
		
		fork5 = new JLabel("");
		fork5.setBounds(110, 122, 46, 14);
		panel.add(fork5);
		
		Button Start = new Button("Start");
		Start.setBounds(10, 230, 70, 22);
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//One Semaphore for each fork acting as fair locks
				Semaphore sem1 = new Semaphore(1,true);
				Semaphore sem2 = new Semaphore(1,true);
				Semaphore sem3 = new Semaphore(1,true);
				Semaphore sem4 = new Semaphore(1,true);
				Semaphore sem5 = new Semaphore(1,true);
				
				//Creating 5 threads each acting as an instance of Philosopher
				Thread phil1 = new Thread(new Philosopher(1, sem1, sem2));
				Thread phil2 = new Thread(new Philosopher(2, sem2, sem3));
				Thread phil3 = new Thread(new Philosopher(3, sem3, sem4));
				Thread phil4 = new Thread(new Philosopher(4, sem4, sem5));
				Thread phil5 = new Thread(new Philosopher(5, sem5, sem1));
				
				//Start all 5 threads
				phil1.start();
				phil2.start();
				phil3.start();
				phil4.start();
				phil5.start();
				
			}
		});
		panel.add(Start);
		
	}

}
