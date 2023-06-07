package tetris;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TetrisPreview extends JPanel {
	protected TetrisData data;
	protected Piece current;
	protected Color colors[];
	static int block[] = {8,8};	
	protected int w = 25;
	protected int margin = 20;
	public Dimension getPreferredSize(){
		int tw = 110;
		int th = 100;
		return new Dimension(110, 150); 
		}
	public TetrisPreview() {
		colors = new Color[8];
		colors[0] = new Color(80, 80, 80);
		colors[1] = new Color(255, 0, 0);
		colors[2] = new Color(0, 255, 0);
		colors[3] = new Color(0, 200, 255);
		colors[4] = new Color(255, 255, 0);
		colors[5] = new Color(255, 150, 0);
		colors[6] = new Color(210, 0, 240);
		colors[7] = new Color(40, 0, 240);
		repaint();
		}

@Override
	public void paint(Graphics g) {
	super.paint(g);
	switch(block[0]){
	case 0: current = new Bar(data); break;
	case 1: current = new Tee(data); break;
	case 2: current = new El(data); break;
	case 3: current = new Z(data); break;
	case 4: current = new O(data); break;
	case 5: current = new S(data); break;
	case 6: current = new J(data); break;
	default:
		if(block[0] % 2 == 0)
			current = new Tee(data);
		else current = new El(data); 
		}
	if(block[0] != 8) {
		for(int i = 0; i < 4; i++) {
			g.setColor(colors[current.getType()]);
			g.fill3DRect(margin/2 + w * (1+current.c[i]), margin/2 + w * (current.getY()+current.r[i]), w, w, true);
			repaint(); 
			} 
		}
	switch(block[1]){
	case 0: current = new Bar(data); break;
	case 1: current = new Tee(data); break;
	case 2: current = new El(data); break;
	case 3: current = new Z(data); break;
	case 4: current = new O(data); break;
	case 5: current = new S(data); break;
	case 6: current = new J(data); break;
	default: if(block[1] % 2 == 0)
		current = new Tee(data);
	else current = new El(data); }
	if(block[1] != 8) {
		for(int i = 0; i < 4; i++) {
			g.setColor(colors[current.getType()]); g.fill3DRect(margin/2 + w * (1+current.c[i]), margin/2 + w *(3+current.r[i]), w, w, true);
			repaint(); 
			} 
		} 
	}
	public static void input_next_blocks(int next1, int next2) {
		block[0] = next1; block[1] = next2; } }

