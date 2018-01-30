package hackerrank.Algorithms.Strings;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangram {
public static void main(String[] args)
{
	  Scanner in = new Scanner(System.in);
	    String sentence = in.nextLine();
		        char[] array = new char[100];
	        	String str = sentence.toLowerCase().replace(" ", "");
	        	
		array = str.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for(char c : array)
		{
			set.add(c);
		}
		
		if(set.size()==26)
		{
			System.out.println("pangram");
		}
		else{System.out.println("not pangram");} 
		in.close();
	    }

	    }

