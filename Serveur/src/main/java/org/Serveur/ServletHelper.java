package org.Serveur;
import java.util.Map;

public class ServletHelper {

	public static String getValue(String p, Map<String, String[]> params){
		return params.get(p) != null ? params.get(p)[0] + "" : "";
	}

}