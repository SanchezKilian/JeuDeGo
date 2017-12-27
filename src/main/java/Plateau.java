import java.util.ArrayList;

public class Plateau {
	
	private Piece[][] plateau = new Piece[19][19];
	private Piece newP;
	private ArrayList<Chaines> Chaines = new ArrayList<Chaines>();
	
	public Plateau() {
		for (int a = 0; a < 19 ; a++) {
			for (int z = 0; z < 19 ; z++) {
				plateau[a][z] = new Piece(a,z,-1);
			}
		}
	}
	
	public void PlacerPiece(int x, int y , int clr) {
		
		newP = new Piece(x,y,clr);
		plateau[x-1][y-1] = newP;
	}
	
	public void afficherP() {
		for (int q = 0; q < 19; q++) {
			System.out.print("\n");
			for (int s = 0; s <19; s++) {
				
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
		if (plateau[x-1][y-1].getClr() == -1 || plateau[x-1][y-1].getClr() == 9) {
			return true;
		}else
			return false;
	}
	
	public int calcFree(Chaines C) {
		ArrayList<Piece> CaseCheck = new ArrayList<Piece>();
		for (Piece P : C.tabChaine) {
			if(plateau[P.GetPos().getX()][P.GetPos().getY()-1].getClr() == -1 ) {
				if(CaseCheck.contains(plateau[P.GetPos().getX()+1][P.GetPos().getY()])==false){
					CaseCheck.add(plateau[P.GetPos().getX()+1][P.GetPos().getY()]);
					
				}	
			}
			if( plateau[P.GetPos().getX()-2][P.GetPos().getY()-1].getClr() == -1) {
				if(CaseCheck.contains(plateau[P.GetPos().getX()-1][P.GetPos().getY()])==false) {
					CaseCheck.add(plateau[P.GetPos().getX()-1][P.GetPos().getY()]);
					
				}
			}
			if( plateau[P.GetPos().getX()-1][P.GetPos().getY()].getClr() == -1 ) {
				if(CaseCheck.contains(plateau[P.GetPos().getX()][P.GetPos().getY()+1])==false) {
					CaseCheck.add(plateau[P.GetPos().getX()][P.GetPos().getY()+1]);
					
				}
			}
			if(plateau[P.GetPos().getX()-1][P.GetPos().getY()-2].getClr() == -1) {
				if(CaseCheck.contains(plateau[P.GetPos().getX()][P.GetPos().getY()-1])==false) {
					CaseCheck.add(plateau[P.GetPos().getX()][P.GetPos().getY()-1]);		
				}
			}
			}
		return CaseCheck.size();		
		}
		
	
	
	
	
}
