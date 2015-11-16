package app;

import java.util.regex.Pattern;


public class Voilier {
	private static String HEUREDEPART = "00:00:00";
	private String heureArrivee = "00:00:00";
	
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

	public static String getHeureDepart() {
		return HEUREDEPART;
	}
	
	/**
	 * 
	 * @param heureDepart
	 * @return true si le format de heureDepart est le suivant : "hh:mm:ss". Sinon, return false.
	 */
	public static boolean setHeureDepart(String heureDepart) {
		if(Pattern.matches("\\d\\d:\\d\\d:\\d\\d", heureDepart)){
			Voilier.HEUREDEPART = heureDepart;
			return true;
		}else{
			return false;
		}
	}

	public String getHeureArrivee() {
		return heureArrivee;
	}

	/**
	 * 
	 * @param heureArrivee
	 * @return true si le format de heureArrivee est le suivant : "hh:mm:ss". Sinon, return false.
	 */
	public boolean setHeureArrivee(String heureArrivee) {
		if(Pattern.matches("\\d\\d:\\d\\d:\\d\\d", heureArrivee)){
			this.heureArrivee = heureArrivee;
			return true;
		}else{
			return false;
		}
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
