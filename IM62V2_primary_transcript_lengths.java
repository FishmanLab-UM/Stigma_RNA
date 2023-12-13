import java.nio.file.Files;
import java.io.IOException; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.FileWriter;

public class Nucleo {
	public static void main(String[] args) throws IOException {
		String s = new String(Files.readAllBytes(Paths.get("genodes.txt")));

		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(); 

		String temp = "ATGGGAGAGCGGGTCAACTATCTTGCGAAAAAATCGAGCGTGTGTTCGGTTATTAGGGTTCTTGAATCGGGGAGTTTTAAGGCGAAGGAGAAGTGTATTTGGATTTTGGAGAGAGTGTTTAGAGTTGAGGCTCATAGAGAAGAGTATGGTGAATCTGCACAAATGGTGCTTATTGATATTGCACAGAATGGTGATACTTTGTTGGCTTCTGGTGTGGCTAAGTTGTTAGCACAACTTGATCTTTTGCAATATCAGTCTACTTATTTTTGAATATTTTCTACATTCAAAGAAATGAtttttcttttcttt";
		System.out.println(temp.length());


		String name = "";
		int count = 0;
		name = s.substring(1, s.indexOf(" "));

		for(int i =s.indexOf("\n") + 1; i < s.length(); i++) {
			// System.out.println(s.charAt(i))
			if(s.charAt(i) == '>') {
				map.put(name,count);
				name = s.substring(i+1, s.indexOf(" ", i));
				count = 0;
				i = s.indexOf("\n", i) +1;
				
			}
			else {
				if(s.charAt(i) != '\n')
					count++;
			}			
		}
		map.put(name, count);
		FileWriter writer = new FileWriter("output.txt");

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            writer.write("Name : " + key + " || Count : " + value + "\n");
        }
        writer.close();
	}
}