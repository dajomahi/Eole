
public class Launch {

	public static void main(String[] args) {
		
		Voilier v1 = new Voilier(1, "Gloria", 1, 572);
		Voilier v2 = new Voilier(2, "Santia", 2, 2000);
		Voilier v3 = new Voilier(3, "Paola", 1, 5720);
		Participants p = new Participants();
		
		p.ajouterVoilier(v1);
		p.ajouterVoilier(v2);
		p.ajouterVoilier(v3);
		
		p.supprimerVoilier(v2);
		
		
		for (int i=0; i < p.lesVoiliers.size(); i++){
			System.out.println(p.lesVoiliers.get(i).getNomVoilier());
		}
		
		static JFrame j = new FenGestion();

	}

}
