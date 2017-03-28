import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVScanner {

	public static List<Ecole> getList() throws IOException {
		// open file input stream
		BufferedReader reader = new BufferedReader(new FileReader("./resources/texte.txt"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		List<Ecole> ecoleList = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			Ecole ecole = new Ecole();
			scanner = new Scanner(line);
			scanner.useDelimiter("\t");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					ecole.setId(data);
				else if (index == 1)
					ecole.setName(data);
				else if (index == 2)
					ecole.setRole(data);
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			index = 0;
			ecoleList.add(ecole);
		}
		
		//close reader
		reader.close();
		
		return ecoleList;
	}
	
	/*
	public static void writeList(List<Ecole> ecoles) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter("./resources/result.txt"));
		
		for(Ecole ecole : ecoles){
			writer.write(arg0);
		}
	}
	*/

}