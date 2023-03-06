import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Date;


public class mainProg {
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
	  String motive = "";
		int open = 0;
		try {
			 motive = getSomeMotivation();	
			open += 1;
		}catch(IOException e) {
			motive = "Sorry, can't access Daily Affirmations";
		}
		if(open == 0) {
			System.out.println(motive);
		}else {
			//display
			displayMotivation(motive);
		}
		
		
	} public static String getSomeMotivation() throws IOException {
		
		String motivation = "";
		URL oracle = new URL("https://www.affirmations.dev/");
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
        	motivation = (inputLine.substring(15,inputLine.length()-1));
        }
        //close
        in.close();
        return motivation;
        
	}
  	public static void displayMotivation(String str) {
		//display 
		Date dateRead = new Date();
		System.out.println("--------- Daily Affirmations ---------");
		System.out.println( "Your Chosen Quote for today " + dateRead);
		System.out.println(str);
		System.out.println("-----------Until Tomorrow!---------");

	}


}
