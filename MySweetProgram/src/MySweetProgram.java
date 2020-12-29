import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySweetProgram {

	public static void main(String[] args) throws FileNotFoundException {

		//System.out.println("What's your name ?");

		
		/* Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		
		if(s.equals("kalidas")) {
			System.out.println("Hey Kali!");
			
		} else if (s.equals("Pradeep")) {
			System.out.println("Hey paddy!");
		} else {
			System.out.println("You are not welcome here!");
		}

		in.close();
		//System.out.println(s);
		 	int i=0;
		while (i < 10) {
			System.out.println("My i value is :"+i);
			i++;
		}
		*/
		
		Scanner in = new Scanner(new File("students.txt"));
		
		List<String> students = new ArrayList<String>();
		
				while(in.hasNextLine()) {
					students.add(in.nextLine());
					
				}
				
				for (int i =0; i < students.size(); i++) {
					
					System.out.println("name is "+ students.get(i));
				}
				
				
		
		in.close();
		
	
	}

}
