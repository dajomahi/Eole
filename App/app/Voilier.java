package app;

import java.util.regex.Pattern;


public class Voilier {
	private static double distanceEnMiles = 0.0;
	private static String heureDepart = "00:00:00";
	private String heureArrivee = "00:00:00";
	
	private int numVoilier;
	private String nomVoilier;
	private int classeVoilier;
	private int rating;
	private boolean handicap = false;
	
	public Voilier(int numVoilier, String nomVoilier, int classeVoilier, int rating) {
		this.numVoilier = numVoilier;
		this.nomVoilier = nomVoilier;
		this.classeVoilier = classeVoilier;
		this.rating = rating;
	}

	public static String getHeureDepart() {
		return heureDepart;
	}
	
	/**
	 * 
	 * @param heureDepart
	 * @return true si le format de heureDepart est le suivant : "hh:mm:ss". Sinon, return false.
	 */
	public static boolean setHeureDepart(String heureDepart) {
		if(Pattern.matches("\\d\\d:\\d\\d:\\d\\d", heureDepart)){
			Voilier.heureDepart = heureDepart;
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
	
	public static double getDistanceEnMiles() {
		return distanceEnMiles;
	}

	public static void setDistanceEnMiles(double distanceEnMiles) {
		Voilier.distanceEnMiles = distanceEnMiles;
	}
	
	public String tempsReel(){
		int hDuree = Integer.parseInt(heureArrivee.substring(0, 2)) - Integer.parseInt(heureDepart.substring(0, 2));
		int minDuree = Integer.parseInt(heureArrivee.substring(3, 5)) - Integer.parseInt(heureDepart.substring(3, 5));
		int secDuree = Integer.parseInt(heureArrivee.substring(6, 8)) - Integer.parseInt(heureDepart.substring(6, 8));
		int dureeFinale = Conversion.HHMMSSToseconds(hDuree + ":" + minDuree + ":" + secDuree);
		
		String duree = "";
		if(dureeFinale / 3600 <= 0){
			duree += "00:";
		} else {
			duree += dureeFinale / 3600 + ":";
		}
		dureeFinale %= 3600;
		if(dureeFinale / 60 <= 0){
			duree += "00:";
		} else {
			duree += dureeFinale / 60 + ":";
		}
		dureeFinale %= 60;
		duree += dureeFinale + "";
		
		if(this.handicap){
			return Conversion.secondsToHHMMSS(Conversion.TempsCompense(duree, rating, distanceEnMiles));
		}else{
			return Conversion.secondsToHHMMSS(dureeFinale);
		}
	}
	
}
