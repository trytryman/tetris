package tetris;

public class TetrisData {
	public static final int ROW = 20;
	public static final int COL = 10;
	public int now_score=0;
	private int data[][];
	private int line; //지운 줄 수

	public TetrisData() { 
	data = new int[ROW][COL]; 
	}
	public int getAt(int x, int y) {
		if(x < 0 || x >= ROW || y < 0 || y >= COL) 
			return 0; dsfdsnfdkljdfsjkdsfjksdfjdsfjkldfs
		return data[x][y]; 
	}
	public void setAt(int x, int y, int v) {
		data[x][y] = v; 
	}
	public int getLine() { return line; }
	public synchronized void removeLines() { 
		NEXT:
			for(int i = ROW-1; i >= 0; i--) {
				boolean done = true;
				for(int k = 0; k < COL; k++) {
					if(data[i][k] == 0) { 
						done = false; 
						continue NEXT; 
					} 	
				}
				if(done) {
					line++; 
					for(int x = i; x > 0; x--) {
						for(int y = 0; y < COL; y++) {
							data[x][y] = data[x-1][y]; 
						} 
					}
					if(i != 0) {
						for(int y = 0; y < COL; y++) {
							data[0][y] = 0;
							now_score=getLine() * 175 * TetrisCanvas.level;
							TetrisView.refresh_now_score(now_score);
							TetrisView.refresh_delete_line(getLine());
							
						} 
					}
					
				}
				
			} 
	}
	public void clear() {
		for(int i = 0; i < ROW; i++) {
			for(int k = 0; k < COL; k++) {
				data[i][k] = 0; 
			} 
		} 
	}
	public void scroe_x() {
			now_score=0;
			line=0;
			TetrisView.refresh_now_score(now_score); 
			TetrisView.refresh_delete_line(getLine());
	}
	
	public void dump() {
		for(int i = 0; i < ROW; i++) {
			for(int k = 0; k < COL; k++) {
				System.out.print(data[i][k] + " "); 
			}
			System.out.println(); 
		} 
	} 
}
