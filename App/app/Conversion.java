package app;

import java.util.regex.Pattern;

public class Conversion {
	
	public static int HHMMSSToseconds(String duree) {
			if(Pattern.matches("\\d\\d:\\d\\d:\\d\\d", duree)){
				int hours= Integer.parseInt(duree.substring(0,2)) * 3600;
				int minutes= Integer.parseInt(duree.substring(3,5)) * 60;
				int seconds= Integer.parseInt(duree.substring(6,8)) + minutes + hours;
				return seconds;
			}else{
				return 0;
			}
		}
	
	public static String secondsToHHMMSS(int secondes) {
		String duree = "";
		
		if(secondes / 3600 <= 0){
			duree += "00:";
		} else {
			duree += secondes / 3600 + ":";
		}
		secondes %= 3600;
		if(secondes / 60 <= 0){
			duree += "00:";
		} else {
			duree += secondes / 60 + ":";
		}
		if(secondes <= 0){
			duree += "00";
		} else {
			secondes %= 60;
			duree += secondes + "";
		}
		return duree;
	}
	
	public static int TempsCompense(String duree, int rating, double distance){
		int tempsCompense;
		System.out.println(duree);
		int hours= Integer.parseInt(duree.substring(0,2)) * 3600;
		int minutes= Integer.parseInt(duree.substring(3,5)) * 60;
		int seconds= Integer.parseInt(duree.substring(6,8)) + minutes + hours;
		int handicap = (int) ((5143 / (Math.sqrt(rating) + 3.5)) * distance);
		if (seconds==0){
			tempsCompense=0;
		}else{
			tempsCompense= seconds + handicap;
		}
		
	return tempsCompense;	
	}
}