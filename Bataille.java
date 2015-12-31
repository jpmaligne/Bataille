import java.util.ArrayList;
import java.util.Collections;

public class Bataille {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Joueur Joueur1 = new Joueur("Joueur1");
		Joueur Joueur2 = new Joueur("Joueur2");
		
		ArrayList<Carte> paquet = new ArrayList<Carte>();
		
		int i=0;
		for(int j = 0; j<Carte.couleurs.length; j++){
			for (int k = 0; k < Carte.valeurs.length; k++) {
				Carte carte = new Carte(Carte.valeurs[k], Carte.couleurs[j]);
				paquet.add(carte);
				i++;
			}
		}
		
		Collections.shuffle(paquet);
		
		for(i=0; i<paquet.size(); i=i+2){
			Joueur1.tireCarte(paquet.get(i));
			Joueur2.tireCarte(paquet.get(i+1));
		}
		System.out.println("Début du Partie :");
		int gain = 1;
		for(i=Joueur1.getSet().size(); i>0; i--){
	
			if(Joueur1.getSet().get(i-1).isBetterThan(Joueur2.getSet().get(i-1)) == 1){
				Joueur1.setPoints(gain);
				System.out.println("Joueur1 : "+Joueur1.getPoints()+" : "+Joueur1.getSet().get(i-1)+ " Meilleur que "+Joueur2.getSet().get(i-1));
				gain = 1;
			}
			else if(Joueur1.getSet().get(i-1).isBetterThan(Joueur2.getSet().get(i-1)) == 0){
				Joueur2.setPoints(gain);
				System.out.println("Joueur2 : "+Joueur2.getPoints()+" : "+Joueur2.getSet().get(i-1)+ " Meilleur que "+Joueur1.getSet().get(i-1));
				gain = 1;
			}
			else{
				System.out.println("Egalité: "+Joueur2.getSet().get(i-1)+ " contre "+Joueur1.getSet().get(i-1));
				gain = 0;
			}
		}
		
		if(Joueur1.getPoints() > Joueur2.getPoints())
			System.out.println("Le vainqueur est Joueur1 !");
		else if(Joueur1.getPoints() < Joueur2.getPoints())
			System.out.println("Le vainqueur est Joueur2 !");
		else
			System.out.println("Égalité !");
	}

}
