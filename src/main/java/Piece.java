
public class Piece {
	
	private Position position;
	private int couleur = -1; // true = b , false = w
	private int appartenance = -999;
	
	public Piece(int X, int Y, int clr) { // clr = couleur, 0 = b , 1 = w , -1 = invisible;
		position = new Position(X,Y);
		couleur = clr;
	}
	
	public int getAppartenance() {
		return appartenance;
	}

	public void setAppartenance(int appartenance) {
		this.appartenance = appartenance;
	}

	public Position GetPos() {
		return position;
	}
	public int getClr() {
		return couleur;
	}
	public void setClr(int a) {
		 couleur = a;
	}
	
	public boolean Acote(Piece P) {
		
		if(couleur == P.getClr() ) {
			if (position.getX() + 1 == P.GetPos().getX() || position.getX()-1 == P.GetPos().getX()) {
				return true;
			}
				if (position.getY() + 1 == P.GetPos().getY() || position.getY()-1 == P.GetPos().getY()) {
					return true;
				}
		}
		
		
		
		return false;
	}
}
