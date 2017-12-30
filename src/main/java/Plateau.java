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
	
	public int calcFree(Chaines C) {   // libert�
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
		if(X > 1 ) {
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
	
	public void score() {
		/*
		for(int a = 1;a <20 ;a++) {
			for(int b = 1 ; b<20;b++) {
				Arround(plateau[a][b],0);
				System.out.println("a"+a + "\n b"+b);
			}	
		}
		*/	
		Arround(plateau[10][2],0);
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
					System.out.println("un point pour l'�quipe " + up);
					return up;
				}
				if(up == 1) {
					//System.out.println("haut : " + up + " bas : " + down + " gauche : " +gauche+" droite : " +droite);
					plateau[X][Y].setAppartenance(up);
					System.out.println("un point pour l'�quipe " + up);
					return up;
				}
			}
			if( arrive == 8) {
				if((gauche == droite && droite == up)||(gauche == droite &&  up ==-10 && gauche == down)) {
					plateau[X][Y].setAppartenance(up);
					System.out.println("un point pour l'�quipe8 " + up);
					return up;
				}
			}
			if( arrive == 2) {
				
				if((gauche == droite && droite == down)||(gauche == down &&  up==droite)) {
					plateau[X][Y].setAppartenance(down);
					System.out.println("un point pour l'�quipe2 " + up +"aaa" + X +"zzz"+Y);
					return up;
				}
			}
			
			if( arrive == 4) {
				if((up == down  && gauche == up)||(up == down  && droite == -10 && up == droite)) {
					plateau[X][Y].setAppartenance(up);
					System.out.println("un point pour l'�quipe 4" + up);
					return up;
				}
			}
			if( arrive == 6) {
				if((up == down && droite == up) || ( down == up && gauche == -10 && up == gauche)) {
					plateau[X][Y].setAppartenance(up);
					System.out.println("un point pour l'�quipe 6" + up);
					return up;
				}
			}
			if( arrive == 0) {
				if((up == gauche && droite == down) || ( down == up && gauche == -10 && up == gauche)) {
					plateau[X][Y].setAppartenance(up);
					System.out.println("un point pour l'�quipe 0" + up);
					return up;
				}
			}
			
			
			
			
		
		
		System.out.println("X : " + X);
		System.out.println("Y : " + Y);
		System.out.println("haut : " + up + " bas : " + down + " gauche : " +gauche+" droite : " +droite);
		System.out.println("arrive : " + arrive +"\n\n");
		
		return -789;
	}
	
	
	
}
