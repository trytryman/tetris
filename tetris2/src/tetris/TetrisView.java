package tetris;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TetrisView extends JPanel {
	public static TetrisPreview tetrisPre = new TetrisPreview();
	static JTextPane nowScore = new JTextPane();
	static JTextPane nowlevel = new JTextPane();
	static JTextPane deleteline = new JTextPane();
	public TetrisView() {
		setLayout(new BorderLayout(0, 0));
		JPanel tetrisBlock = new JPanel();
		add(tetrisBlock, BorderLayout.CENTER);
		tetrisBlock.add(MyTetris.tetrisCanvas, BorderLayout.CENTER);
		JPanel tetrisImf = new JPanel();
		add(tetrisImf, BorderLayout.EAST);
		tetrisImf.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		tetrisImf.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		Box verticalBox = Box.createVerticalBox(); 
		panel.add(verticalBox, BorderLayout.NORTH);
		
		JTextPane txtpnTesxt = new JTextPane();
		txtpnTesxt.setEnabled(false); txtpnTesxt.setEditable(false); txtpnTesxt.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		verticalBox.add(txtpnTesxt); txtpnTesxt.setText("NEXT"); txtpnTesxt.setDisabledTextColor(SystemColor.desktop); txtpnTesxt.setBackground(new Color(240, 240, 240));
		
		JPanel preview = new JPanel(); 
		verticalBox.add(preview);
		preview.add(tetrisPre);
		tetrisPre.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
		
		verticalBox.add(nowScore);
		nowScore.setText("현재 점수:0"); 
		nowScore.setDisabledTextColor(SystemColor.desktop); 
		nowScore.setBackground(new Color(240, 240,240)); 
		nowScore.setEnabled(false); 
		nowScore.setEditable(false); 
		
		verticalBox.add(nowlevel); 
		nowlevel.setEditable(true); 
		nowlevel.setBackground(new Color(240, 240, 240));
		nowlevel.setText("현재 레벨: " + TetrisCanvas.level); nowlevel.setEnabled(false);
		verticalBox.add(deleteline); 
		deleteline.setText("삭제한 줄 수: 0");
		deleteline.setEnabled(false); 
		deleteline.setEditable(false); 
		deleteline.setDisabledTextColor(Color.BLACK); 
		deleteline.setBackground(SystemColor.menu);
	}
	public static void refresh_now_score(int score) { nowScore.setText("현재 점수: " + score); }
	public static void refresh_now_level(int level) { nowlevel.setText("현재 레벨: " + level); }
	public static void refresh_delete_line(int line) { deleteline.setText("삭제한 줄 수: " + line); } }