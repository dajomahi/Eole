import java.util.ArrayList;
import java.util.List;

public class Participants {
	List<Voilier> lesVoiliers;
	
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
