package app;

public class Conversion {
	
	public static int ConversionSec(String H, String M, String S) {
		int hours= Integer.parseInt(H.substring(0,1)) * 3600;
		int minutes= Integer.parseInt(M.substring(0,1)) * 60;
		int seconds= Integer.parseInt(S.substring(0,1)) + minutes + hours;
		return seconds;
		}
	
	public static int TempsCompense(String H, String M, String S, int Rating, int Distance){
		int tempsCompense;
		int distance= Distance;
		int r= Rating;
		int hours= Integer.parseInt(H.substring(0,1)) * 3600;
		int minutes= Integer.parseInt(M.substring(0,1)) * 60;
		int seconds= Integer.parseInt(S.substring(0,1)) + minutes + hours;
		int handicap = (int) ((5143 / (Math.sqrt(r) + 3.5)) * distance);
		if (seconds==0){
			tempsCompense=0;
		}else{
			tempsCompense= seconds + handicap;
		}
		
	return tempsCompense;	
	}
}