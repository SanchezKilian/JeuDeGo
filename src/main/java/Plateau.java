import java.util.ArrayList;

public class Plateau {
	
	private Piece[][] plateau = new Piece[20][20];
	private Piece newP;
	
	
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
		for (int q = 0; q < 20; q++) {
			System.out.print("\n");
			for (int s = 0; s <20; s++) {
				
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
		
	
	
	
	
}
