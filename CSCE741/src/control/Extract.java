package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Extract {

	public void extractData() throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\MarcosFelipe\\Desktop\\Fall2017firstMonday.txt"));
		String outputFolder = "C:\\Users\\MarcosFelipe\\Desktop\\out.txt";
		ArrayList<String> a = new ArrayList<>();
		//2
		PrintWriter writer = new PrintWriter(outputFolder);
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			String[] previous = null;
			boolean first = true;
			String out = "";
			
			String tab = "	";
			
			int c = 0;
			while (line != null) {
				c++;
				if (first) {
					writer.println(line);
					first = false;
					line = br.readLine();
					continue;
				}

				String[] l = line.split(tab);
				if (!l[0].trim().equals("")) {
					a.add(out);
					writer.println(line);
					previous = l;
				} else {
					for (int i = 0; i <= 17; i++) {
						if (l[i].trim().equals("")) {
							l[i] = previous[i];
						}
					}
					for (String string : l) {
						out += string + tab;
					}
					a.add(out);
					writer.println(out);

					out = "";
					previous = l;
				}

				line = br.readLine();
			}

			System.out.println("Done - " + c);

		} finally {
			br.close();
			writer.close();
		}

	}

}
