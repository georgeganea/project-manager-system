package usr.speedy.ds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;

public class Util {
	public void printFromFile(PrintWriter out,String fileName) throws FileNotFoundException,IOException {
		URL resource = this.getClass().getResource(fileName);
		try {
			FileReader reader = new FileReader(new File(resource.toURI()));
			BufferedReader input =  new BufferedReader(reader);
			String line;
			while (( line = input.readLine()) != null){
				out.println(line);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void printReplacedText(PrintWriter out,String fileName, String pattern, String replace) throws FileNotFoundException,IOException {
		URL resource = this.getClass().getResource(fileName);
		try {
			FileReader reader = new FileReader(new File(resource.toURI()));
			BufferedReader input =  new BufferedReader(reader);
			String line;
			while (( line = input.readLine()) != null){
				if (line.contains(pattern))
					line = line.replace(pattern, replace);
				out.println(line);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void printFromFile(PrintWriter out, String fileName, String currentPage) throws FileNotFoundException,IOException {
		URL resource = this.getClass().getResource(fileName);
		try {
			FileReader reader = new FileReader(new File(resource.toURI()));
			BufferedReader input =  new BufferedReader(reader);
			String line;
			while (( line = input.readLine()) != null){
				String current = "title=\""+currentPage+"\"";
				if (line.contains(current))
					line = line.replace(current, " class=\"current\" "+current);
				out.println(line);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
