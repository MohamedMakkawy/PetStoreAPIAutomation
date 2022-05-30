package PetStoreAPIAutomation.PetStoreAPIAutomation;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
	  public static String readFileAsString(String file)throws Exception
	  {
	      return new String(Files.readAllBytes(Paths.get(file)));
	  }
}
