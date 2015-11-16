package app;

import java.util.ArrayList;
import java.util.List;

public class Participants {
	List<Voilier> lesVoiliers;
	
	/**
	 * @author mmoser
	 * 
	 * Constructeur contenant la liste des voilier.
	 */
	public Participants(){
		lesVoiliers = new ArrayList<>();
	}
	
	public void ajouterVoilier(Voilier v){
		lesVoiliers.add(v);
	}
	
	public void  supprimerVoilier(Voilier v){
		lesVoiliers.remove(v);
	}
}
