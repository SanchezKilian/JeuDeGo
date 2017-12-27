import java.util.ArrayList;

	public class Chaines {
	public ArrayList<Piece> tabChaine = new ArrayList<Piece>();
	private int liberte;
	
	public Chaines(Piece P) {
		tabChaine.add(P);
	}
	public Chaines(Chaines Azer) {
		for (Piece P : Azer.tabChaine) {
			tabChaine.add(P);
		}
	}
	
	public void AjouterP(Piece P) {
		tabChaine.add(P);
	}
	public void AjouterC(Chaines C) {
		for(Piece P : C.tabChaine) {
			this.tabChaine.add(P);
		}
	}
	
	public boolean ChaineProche(Piece P) { //on test si une piece est à coté d'une chaine
		
		for(Piece p : tabChaine) {
			if(p.Acote(P)) {
				return true;
			}
		}
		return false;
	}
	
	public void afficherChaine() {
		for (Piece P : tabChaine) {
			System.out.println( P.GetPos().getX() + "..." + P.GetPos().getY());
		}
	}
	
	public void suppr() {
		
	}
	
	public int getLib() {
		
		
		return liberte;
	}
	
	
	
}
