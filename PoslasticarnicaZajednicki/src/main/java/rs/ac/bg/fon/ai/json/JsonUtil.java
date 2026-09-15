package rs.ac.bg.fon.ai.json;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rs.ac.bg.fon.ai.domen.Racun;

public class JsonUtil {

	
	public static void sacuvajRacunUJSON(Racun racun) throws IOException {

	    Gson gson = new GsonBuilder().setPrettyPrinting().create();

	    String nazivFajla = "racun_" + racun.getIdRacun() + ".json";

	    try (FileWriter out = new FileWriter(nazivFajla)) {
	        gson.toJson(racun, out);
	    }
	}
}
