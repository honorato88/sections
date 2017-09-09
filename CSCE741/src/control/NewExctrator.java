package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import entities.Course;
import entities.Section;

public class NewExctrator {

	public void extractData() throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\MarcosFelipe\\Desktop\\Fall2017firstMonday.txt"));
		String outputFolder = "C:\\Users\\MarcosFelipe\\Desktop\\out.txt";

		// PrintWriter writer = new PrintWriter(outputFolder);

		ArrayList<Course> courses = new ArrayList<>();
		ArrayList<Section> sections = new ArrayList<>();

		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			String[] previous = null;
			boolean first = true;
			String out = "";

			String tab = "	";

			int x = 0;
			while (line != null) {
				x++;
				System.out.println(x);
				if (first) {
					// writer.println(line);
					first = false;
					line = br.readLine();
					continue;
				}

				String[] l = line.split(tab);
				if (!l[0].trim().equals("")) {
					Course c = new Course();
					c.setCourse(l[3].trim());
					c.setDate(l[15].trim());
					c.setSubject(l[2].trim());
					c.setTerm(l[7].trim());
					c.setTitle(l[8].trim());

					if (courses.size() == 0) {
						courses.add(c);
					} else {
						boolean t = false;
						for (Course cc : courses) {
							if (c.getCourse().equals(cc.getCourse()) && c != null)
								t = true;
						}
						if (!t) {
							courses.add(c);
						}
					}

					Section s = new Section();
					s.setActual(new Integer(l[12].trim()));
					s.setCapacity(new Integer(l[11].trim()));
					s.setCourse(c);
					s.setDays(l[9].trim());
					s.setLocation(l[16].trim());
					s.setTeacher(l[14].trim());
					s.setTime(l[10].trim());
					sections.add(s);

					// writer.println(line);
					previous = l;
				} else {
					for (int i = 0; i <= 17; i++) {
						if (l[i].trim().equals("")) {
							l[i] = previous[i];
						}
					}

					Course c = new Course();
					c.setCourse(l[3].trim());
					c.setDate(l[15].trim());
					c.setSubject(l[2].trim());
					c.setTerm(l[7].trim());
					c.setTitle(l[8].trim());

					if (courses.size() == 0) {
						courses.add(c);
					} else {
						boolean t = false;
						for (Course cc : courses) {
							if (c.getCourse().equals(cc.getCourse()) && c != null)
								t = true;
						}
						if (!t) {
							courses.add(c);
						}
					}

					Section s = new Section();
					if (!l[12].trim().equals("")) {
						s.setActual(new Integer(l[12].trim()));
						s.setCapacity(new Integer(l[11].trim()));
					}

					s.setCourse(c);
					s.setDays(l[9].trim());
					s.setLocation(l[16].trim());
					s.setTeacher(l[14].trim());
					s.setTime(l[10].trim());
					sections.add(s);

					previous = l;
				}

				line = br.readLine();
			}

			System.out.println("Done - ");

		} finally {
			br.close();
			// writer.close();
		}

		System.out.println(sections.size());
		System.out.println(courses.size());

		for (Course ccc : courses) {
			System.out.println(ccc.getCourse());
		}
		
	}

}
