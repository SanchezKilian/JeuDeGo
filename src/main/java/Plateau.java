import java.util.ArrayList;

public class Plateau {
	
	public Piece[][] plateau = new Piece[20][20];
	private Piece newP;
	
	public int Pb = 0;
	public int Pn = 0;
	private int bord = -15;
	
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
		
		
		return CaseCheck.size();		
		}
	
	
	
	
	public void score() {
		/*
		for(int a = 1;a <20 ;a++) {
			for(int b = 1 ; b<20;b++) {
				Arround(plateau[a][b],0);
				
			}	
		}
		*/
		System.out.println("\nLe calcul du score est en cours d'implementation,\n Nous nous excusons pour la gêne occasionnée");
	}
		
	private int Arround(Piece P, int arrive) {   // arrive : 4 gauche 8 haut 6 droite 2 bas 
		int X = P.GetPos().getX();
		int Y = P.GetPos().getY();
		int up = -10, down = -11, droite = -12, gauche = -13;
		if(P.getClr() == -1 ) { //&& P.getAppartenance() == -999
			
			if (X > 1  ) { //&& arrive != 8
				switch(plateau[X-1][Y].getClr()) {
				case 0 :
					up = 0;
					break;
				case 1 :
					up =1;
					break;
				default :
					if(plateau[X-1][Y].getAppartenance() == -999 && X !=1) {
						P.setAppartenance(-10);
						up = Arround(plateau[X-1][Y], 2);
					}else {
						up = plateau[X-1][Y].getAppartenance();
					}
					
					break;
				}
			}else {
				up = bord;
			}
			
			if (X <19 ) { //&& arrive != 2
				switch(plateau[X+1][Y].getClr()) {
				case 0 :
					down = 0;
					break;
				case 1 :
					down =1;
					break;
				default :
					if(plateau[X+1][Y].getAppartenance() == -999 && X != 19) {
						P.setAppartenance(-10);
						down = Arround(plateau[X+1][Y],8);
					}
					else {
						down = plateau[X+1][Y].getAppartenance();
					}
					break;
				}
			}else {
				down = bord;
			}
			
			if (Y >1) { // && arrive != 6
				switch(plateau[X][Y-1].getClr()) {
				case 0 :
					gauche = 0;
					break;
				case 1 :
					gauche =1;
					break;
				default :
					if(plateau[X][Y-1].getAppartenance() == -999 && Y!= 1) {
						P.setAppartenance(-10);
						gauche =Arround(plateau[X][Y-1],4);
					}else {
						gauche = plateau[X][Y-1].getAppartenance();
					}
					
					break;
				}
			}else {
				gauche = bord;
			}
			
			if (Y <19 ) { //&& arrive != 4
				switch(plateau[X][Y+1].getClr()) {
				case 0 :
					droite = 0;
					break;
				case 1 :
					droite =1;
					break;
				default :
					if(plateau[X][Y+1].getAppartenance() == -999 && Y!= 1) {
						P.setAppartenance(-10);
						droite = Arround(plateau[X][Y+1],6);
					}else {
						droite = plateau[X][Y+1].getAppartenance();
					}
					
					break;
				}
			}
			else {
				droite = bord;
			}
		}
			//System.out.println("X=" + X +" Y=" +Y + "\n haut : " + up + " bas : " + down + " gauche : " +gauche+" droite : " +droite );
			if(up == down && gauche == droite && up == droite) {
				if(up == 0) {
					//System.out.println("haut : " + up + " bas : " + down + " gauche : " +gauche+" droite : " +droite);
					plateau[X][Y].setAppartenance(up);
					
					return up;
				}
				if(up == 1) {
					//System.out.println("haut : " + up + " bas : " + down + " gauche : " +gauche+" droite : " +droite);
					plateau[X][Y].setAppartenance(up);
					
					return up;
				}
			}
			if( arrive == 8) {
				if((gauche == droite && droite == up)||(gauche == droite &&  up ==-10 && gauche == down)) {
					plateau[X][Y].setAppartenance(up);
					
					return up;
				}
			}
			if( arrive == 2) {
				
				if((gauche == droite && droite == down)||(gauche == down &&  up==droite)) {
					plateau[X][Y].setAppartenance(down);
					
					return up;
				}
			}
			
			if( arrive == 4) {
				if((up == down  && gauche == up)||(up == down  && droite == -10 && up == droite)) {
					plateau[X][Y].setAppartenance(up);
					
					return up;
				}
			}
			if( arrive == 6) {
				if((up == down && droite == up) || ( down == up && gauche == -10 && up == gauche)) {
					plateau[X][Y].setAppartenance(up);
					
					return up;
				}
			}
			if( arrive == 0) {
				if((up == gauche && droite == down) || ( down == up && gauche == -10 && up == gauche)) {
					plateau[X][Y].setAppartenance(up);
					
					return up;
				}
			}
			
			
			
		
		return -789;
	}
	
	
	
}
