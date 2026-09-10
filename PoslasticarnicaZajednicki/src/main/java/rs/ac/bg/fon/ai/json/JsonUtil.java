package rs.ac.bg.fon.ai.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import rs.ac.bg.fon.ai.domen.Kolac;

public class JsonUtil {

	
    public static void main(String[] args) {
    	
    	 Kolac k1 = new Kolac(
                 1L,
                 "Cheesecake",
                 450.0,
                 "Kolac sa plazmom, sirom i malinama."
         );

         Kolac k2 = new Kolac(
                 2L,
                 "Tiramisu",
                 500.0,
                 "Kolac sa kafom i maskarpone sirom."
         );

         Kolac k3 = new Kolac(
                 3L,
                 "Cokoladna torta",
                 550.0,
                 "Cokoladna torta sa cokoladnim filom."
         );

         List<Kolac> kolaci = new ArrayList<Kolac>();

         kolaci.add(k1);
         kolaci.add(k2);
         kolaci.add(k3);
         
         Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
         
         //Serijalizacija
         try(FileWriter out = new FileWriter("kolaci.json")){
         	
         	gson.toJson(kolaci, out);
         
         }catch(Exception e) {
         	e.printStackTrace();
         }
         
         //Deserijalizacija
         try (FileReader in = new FileReader("kolaci.json")) {
        	 Gson gson2 = new Gson();
             Type collectionType = new TypeToken<LinkedList<Kolac>>(){}.getType();

             List<Kolac> ucitaniKolaci = gson2.fromJson(in, collectionType);

             System.out.println("Ucitani kolaci:");

             for (Kolac k : ucitaniKolaci) {
                 System.out.println(k);
             }

         } catch (Exception e) {
             e.printStackTrace();
         }
         
         ////Rucna serijalizacija bez mapiranja na domensku klasu
         JsonObject k = new JsonObject();

         k.addProperty("id kolaca", 1L);
         k.addProperty("naziv kolaca", "Tiramisu");
         k.addProperty("cena kolaca", 500.0);
         k.addProperty("opis kolaca", "Kolac sa kafom i maskarpone sirom.");

         try (FileWriter out = new FileWriter("kolaci_manual.json")) {
        	 Gson gson3 = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
             gson3.toJson(k, out);

         } catch (Exception e) {
             e.printStackTrace();
         }
         
         ////Rucna deserijalizacija bez mapiranja na domensku klasu
         try (FileReader in = new FileReader("kolaci_manual.json")) {
        	 Gson gson4 = new Gson();
             JsonObject ucitaniKolac = gson4.fromJson(in, JsonObject.class);

             String naziv = ucitaniKolac.get("naziv kolaca").getAsString();
             
             System.out.println("//////////////////////");
             System.out.println("Naziv kolaca: " + naziv);
             System.out.println("Cena kolaca: " + ucitaniKolac.get("cena kolaca").getAsDouble());

         } catch (Exception e) {
             e.printStackTrace();
         }
         
    /*
        Kolac kolac = new Kolac(
                1L,
                "Cheesecake",
                450.0,
                "Kolac sa plazmom, sirom i malinama."
        );

        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        		
        try(FileWriter out = new FileWriter("kolac.json")){
        	
        	gson.toJson(kolac, out);
        
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        //String json = gson.toJson(kolac);
        //System.out.println(json);
        
		try(FileReader in = new FileReader("kolac.json")){
        	
			Gson gson2 = new Gson();
			Kolac kolac2 = gson2.fromJson(in, Kolac.class);
			System.out.println(kolac2);
			
        }catch(Exception e) {
        	e.printStackTrace();
        }
		
	*/	
    	
    }
}
