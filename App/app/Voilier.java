package app;


public class Voilier {
	private int numVoilier;
	private String nomVoilier;
	private int classeVoilier;
	private int rating;
	
	public Voilier(int numVoilier, String nomVoilier, int classeVoilier, int rating) {
		this.numVoilier = numVoilier;
		this.nomVoilier = nomVoilier;
		this.classeVoilier = classeVoilier;
		this.rating = rating;
	}

	public int getNumVoilier() {
		return numVoilier;
	}

	public String getNomVoilier() {
		return nomVoilier;
	}

	public int getClasseVoilier() {
		return classeVoilier;
	}

	public int getRating() {
		return rating;
	}
	
	
}
