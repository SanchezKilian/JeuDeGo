import java.util.ArrayList;

public class Plateau {
	
	private Piece[][] plateau = new Piece[20][20];
	private Piece newP;
	
	private int Pb = 0;
	private int Pn = 0;
	
	public Plateau() {
		for (int a = 0; a < 20 ; a++) {
			for (int z = 0; z < 20 ; z++) {
				plateau[a][z] = new Piece(a,z,-1);
			}
		}
	}
	
	public void PlacerPiece(int x, int y , int clr) {
		
		newP = new Piece(x,y,clr);
		plateau[x][y] = newP;
	}
	
	public void afficherP() {
		for (int q = 1; q < 20; q++) {
			System.out.print("\n");
			for (int s = 1; s <20; s++) {
				
				if (plateau[q][s].getClr() == 0) {
					System.out.print("B");
				}
				if (plateau[q][s].getClr() == 1) {
					System.out.print("W");
				}
				if(plateau[q][s].getClr() == -1) {
					System.out.print("X");
				}
				if(plateau[q][s].getClr() == 9) {
					System.out.print("F");
				}
			}
		}
	}
	
	public boolean freeCase(int x, int y) {
		if (plateau[x][y].getClr() == -1 || plateau[x-1][y-1].getClr() == 9) {
			return true;
		}else
			return false;
	}
	
	public int calcFree(Chaines C) {   // liberté
		ArrayList<Piece> CaseCheck = new ArrayList<Piece>();
		for (Piece P : C.tabChaine) {
			
			
			if(P.GetPos().getY() != 1) {
				if(plateau[P.GetPos().getX()][P.GetPos().getY()-1].getClr() == -1 ) {
					if(CaseCheck.contains(plateau[P.GetPos().getX()][P.GetPos().getY()-1])==false){
						CaseCheck.add(plateau[P.GetPos().getX()][P.GetPos().getY()-1]);
					}					
				}
			}
			
			if(P.GetPos().getY() != 19) {
				if( plateau[P.GetPos().getX()][P.GetPos().getY()+1].getClr() == -1) {
					if(CaseCheck.contains(plateau[P.GetPos().getX()][P.GetPos().getY()+1])==false){
						CaseCheck.add(plateau[P.GetPos().getX()][P.GetPos().getY()+1]);
					}				
				}
			}
			
			if(P.GetPos().getX() != 1) {
				if( plateau[P.GetPos().getX()-1][P.GetPos().getY()].getClr() == -1 ) {
					if(CaseCheck.contains(plateau[P.GetPos().getX()-1][P.GetPos().getY()])==false){
						CaseCheck.add(plateau[P.GetPos().getX()-1][P.GetPos().getY()]);
					}				
				}
			}
			
			if(P.GetPos().getX() != 19) {
				if(plateau[P.GetPos().getX()+1][P.GetPos().getY()].getClr() == -1) {
					if(CaseCheck.contains(plateau[P.GetPos().getX()+1][P.GetPos().getY()])==false){
						CaseCheck.add(plateau[P.GetPos().getX()+1][P.GetPos().getY()]);		
					}
				}
			}
			
			
			}
		
		for (Piece P : CaseCheck) {
			System.out.println("place libre : " + P.GetPos().getX() +"__" + P.GetPos().getY()  + " clr " + P.getClr()); 
			
		}
		
		return CaseCheck.size();		
		}
	
	
	public int CalcScore() {  // i = pt pour les blancs  l = pt pour les noires.
		boolean fin = false;
		for(int a = 0; a < 20 ; a++) {
			for (int b = 0; b <20; b++) {
				if (plateau[a][b].getClr() == -1) {
					while (!fin) {
						
					
					}
				}
			}
		}
		return 0;
	}
	
	public int Calcul(int X, int Y) {
		int dessus =-15, dessous = -20,droite = -25 , gauche = -30;
		if(X != 1) {
			if (plateau[X-1][Y].getClr() != -1) {
				return plateau[X-1][Y].getClr();
			}else {
				dessus = Calcul(X-1,Y);
			}
		}else {
			return -9;
		}
		if(X != 19) {
			if (plateau[X+1][Y].getClr() != -1) {
				return plateau[X+1][Y].getClr();
			}else {
				dessous = Calcul(X+1,Y);
			}
		}else {
			return -9;
		}
		if(Y != 1) {
			if (plateau[X][Y-1].getClr() != -1) {
				return plateau[X][Y-1].getClr();
			}else {
				gauche = Calcul(X,Y-1);
			}
		}else {
			return -9;
		}
		if(Y != 19) {
			if (plateau[X][Y+1].getClr() != -1) {
				return plateau[X][Y+1].getClr();
			}else {
				droite = Calcul(X,Y+1);
			}
		}else {
			return -9;
		}
		
		if(dessus == dessous && gauche == droite && dessus == droite) {
			if(dessus == 0) {
				Pb ++;
				System.out.println("pB++");
			}
			if(dessus == 1) {
				Pn ++;
				System.out.println("pN++");
			}
		}
		
		
		return -10;
		
	}
		
	
	
	
	
}
