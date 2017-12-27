
public class Position {
		
	private int X;
	private int Y;
	
	public Position(int x, int y) {
		if (x < 20 && y < 20) {
			X=x;
			Y=y;
		}	
	}
	
	public void remove() {
		X = -1;
		Y = -1;
	}
	
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	
	
}
