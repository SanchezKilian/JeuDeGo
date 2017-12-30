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
		
	
		
		P.afficherP();
		System.out.println(allCh.size());
				
		P.score();
		
		System.out.println("appart : " + P.plateau[3][2].getAppartenance());
	}
}
