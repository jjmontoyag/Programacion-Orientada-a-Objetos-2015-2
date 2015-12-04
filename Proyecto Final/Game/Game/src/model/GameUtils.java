package model;

import java.util.Date;

public final class GameUtils {
	
	public static boolean isTimeUp(double creationTime, double span){
		if(new Date().getTime() - creationTime >= span)
			return true;
	   	    return false;
	}

}
