package gui;

import java.io.IOException;

import control.Extract;
import control.NewExctrator;

public class Init {

	public static void main(String[] args) {
		Extract extract =new Extract();
		NewExctrator ne = new NewExctrator();
		
		try {
			ne.extractData();
		} catch (IOException e) {			
			e.printStackTrace();
		}

	}

}
