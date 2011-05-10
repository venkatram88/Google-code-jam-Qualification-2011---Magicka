import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Magicka {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = null;
		try {
			File f = new File("B-large.in");
			
			bf = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		int numberOfCases = Integer.parseInt(bf.readLine());
		
		String[] output = new String[numberOfCases];
		String finalOutput="";
		for (int i = 0; i < output.length; i++) {
			Elements elem = new Elements(bf.readLine());
			String out = elem.invoke();
			String[] outSplit = out.split("");
			finalOutput="";
			if(!out.equals("")){
				for (int j = 0; j < out.length(); j++) {
					finalOutput+=outSplit[j+1]+", ";
					
				}
				
				finalOutput=finalOutput.substring(0, finalOutput.length()-2);
			}
			output[i] = "Case #"+(i+1)+": ["+finalOutput+"]";
			}
		bf.close();
		File fw = new File("B-output.in");
		BufferedWriter bfw = new BufferedWriter(new FileWriter(fw));
		
		for (int i = 0; i < output.length; i++) {
			
			if(i!=output.length-1)
				bfw.write(output[i]+"\n");
			else
				bfw.write(output[i]);
		}
		bfw.close();
			
		}
		
		
		
		
	}

