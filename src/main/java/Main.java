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
		
		System.out.println("Bienvenue dans ce jeu de Go");
		System.out.println("\nà chaque tour, le joueur peut choisir de jouer ou passer.");
		System.out.println("pour jouer indiquer les coordonnées de l'intersection sur laquelle vous souhaitez placer votre pion,");
		System.out.println("(de 1.1 à 19.19)");
		System.out.println("\n \t Bonne Partie ! \n\n\n");
		
		
		while (nbPasse !=2) {
			System.out.println("\n\njoueur " + NJoueur + " : " );
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
								
								allCh.remove(C);
							}
							
							allCh.add(finalle);	
							
							
						}
						AConcate.clear();
						if(NJoueur == 0) {
							NJoueur = 1;
						}else {
							NJoueur =0;
						}
						
					}else {
						System.out.println("emplacement non valide, veuillez selectionner un autre emplacement ou passer votre tour.");
						
					}
							
			}
			
			P.afficherP();
		}		
	
		
		P.afficherP();
		
		P.score();
		
		
	}
}
