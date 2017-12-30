import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Plateau P = new Plateau();
		ArrayList<Chaines> allCh = new ArrayList<Chaines>();
		ArrayList<Chaines> AConcate = new ArrayList<Chaines>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Chaines finalle;
		Piece Piec;
		int nbPasse = 0;
		int NJoueur = 0;
		int choix = 0;
		int posX;
		int posY;
		/*
		while (nbPasse !=2) {
			System.out.println("joueur " + NJoueur + " : " );
			System.out.println("\tPour jouer : 1 \n\tPour passer : 2 ");
				choix = scan.nextInt();
			
			if (choix == 2) {
				nbPasse ++;
			}else {
				nbPasse = 0;
				
					System.out.println("X : ");
					posX = scan.nextInt();
					System.out.println("Y : ");
					posY = scan.nextInt();
					// test si dej une piece à cet endroit,
					if (P.freeCase(posX, posY)) {
						Piec = new Piece(posX,posY,NJoueur);
						P.PlacerPiece(posX, posY, NJoueur);	
						Chaines NCh = new Chaines(Piec);
						AConcate.add(NCh);
						for (Chaines C : allCh) {
							if(C.ChaineProche(Piec)) {
								AConcate.add(C);
								System.out.println("coucou /////////////////////////////////////////////" + C);
							}
						}
						if (AConcate.size()==1) {
							allCh.add(NCh);
							
						}
						if(AConcate.size()>1) {
							finalle = new Chaines(AConcate.get(0));
							AConcate.remove(0);
							for (Chaines C : AConcate) {
								finalle.AjouterC(C);
								System.out.println("ajout à la chaine de concaténation");
								allCh.remove(C);
							}
							
							allCh.add(finalle);	
							System.out.println("AConcate : " + AConcate.size());
							
						}
						AConcate.clear();
						
						
					}else {
						System.out.println("emplacement non valide, veuillez selectionner un autre emplacement ou passer votre tour.");
						break;
					}
					
					
					
					
					
			}
			if(NJoueur == 0) {
				NJoueur = 1;
			}else {
				NJoueur =0;
			}
			for (Chaines C : allCh) {
				System.out.println("\n chaine : nombre libertée : " + P.calcFree(C)  );
				C.afficherChaine();
			}
			P.afficherP();
			
		}	
		*/
		P.PlacerPiece(1, 1, 1);	
		P.PlacerPiece(1, 2, 1);	
		P.PlacerPiece(1, 3, 1);	
		P.PlacerPiece(2, 1, 1);	
		P.PlacerPiece(3, 1, 1);	
		P.PlacerPiece(4, 1, 1);	
		P.PlacerPiece(3, 4, 1);	
		P.PlacerPiece(1, 4, 1);	
		P.PlacerPiece(2, 4, 1);	
		P.PlacerPiece(4, 3, 1);	
		P.PlacerPiece(4, 2, 1);	
		//P.PlacerPiece(2, 3, 1);
		P.PlacerPiece(5, 6, 1);	
		P.PlacerPiece(5, 4, 1);	
		P.PlacerPiece(4, 5, 0);	
		P.PlacerPiece(6, 5, 0);	
		
		P.PlacerPiece(7, 5, 0);	
		P.PlacerPiece(8, 5, 0);	
		P.PlacerPiece(9, 5, 0);	
		P.PlacerPiece(10, 5, 0);	
		P.PlacerPiece(11, 5, 0);	
		P.PlacerPiece(12, 5, 0);	
		P.PlacerPiece(13, 5, 0);	
		P.PlacerPiece(14, 5, 0);	
		
		P.PlacerPiece(15, 5, 0);	
		P.PlacerPiece(16, 5, 0);	
		P.PlacerPiece(17, 5, 0);	
		P.PlacerPiece(18, 5, 0);	
		P.PlacerPiece(19, 5, 0);	
		P.PlacerPiece(6, 6, 0);	
		P.PlacerPiece(6, 7, 0);	
		P.PlacerPiece(6, 8, 0);	
		
		P.afficherP();
		System.out.println(allCh.size());
				
		P.score();
		
		System.out.println("appart : " + P.plateau[3][2].getAppartenance());
	}
}
