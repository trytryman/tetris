package tetris;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyTetris extends JFrame {
	private JPanel contentPane;
	public static TetrisCanvas tetrisCanvas = new TetrisCanvas();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { try {
				MyTetris frame = new MyTetris();	
				frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); 
				} 
			} 
			}); 
		}
	public MyTetris() { 
		setTitle("Tetris");
		TetrisView tetrisView = new TetrisView();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 629);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("\uAC8C\uC784");
		menuBar.add(menu);
		JMenuItem mntmNewMenuItem = new JMenuItem("\uC2DC\uC791");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { tetrisCanvas.start();
			} 
		});	
		menu.add(mntmNewMenuItem);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uC885\uB8CC");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				System.exit(0); 
				} 
			});
		menu.add(mntmNewMenuItem_1);
		contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		contentPane.setLayout(new BorderLayout(0,0)); 
		setContentPane(contentPane); contentPane.add(tetrisView, BorderLayout.CENTER); 
		} 
	}
