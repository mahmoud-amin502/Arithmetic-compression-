package ass5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class main {

	public static void main(String args[]) throws FileNotFoundException {

		String s1 = new Scanner(new File("input.txt")).useDelimiter("\\A").next();

		double low = 0;
		double high = 1;
		double code_range = 0;

		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		HashMap<Character, Double> high_1 = new HashMap<Character, Double>();
		HashMap<Character, Double> low_1 = new HashMap<Character, Double>();
		HashMap<Character, Double> prop = new HashMap<Character, Double>();

		double x = 0;
		double y = 0;
		int z = s1.length();

		for (int i = 0; i < s1.length(); i++) {

			char a = s1.charAt(i);
			if (dict.containsKey(a))
				dict.put(a, dict.get(a) + 1);
			else
				dict.put(a, 1);
		}
		// System.out.println(dict);

		for (int i = 0; i < s1.length(); i++) {
			char a1 = s1.charAt(i);
			if (dict.containsKey(a1)) {
				x = dict.get(a1);
				y = (float) (x / z);
				prop.put(a1, y);
			}
		}
		// System.out.println(prop);
		Set<Character> keys = prop.keySet();

		double r1 = 0;
		for (char s : keys) {

			if (prop.containsKey(s)) {
				r1 = r1 + prop.get(s);
				high_1.put(s, r1);
			}
			// System.out.println(s);
		}
		// System.out.println(high_1);
		double r2 = 0;
		for (char c1 : keys) {

			if (prop.containsKey(c1)) {
				low_1.put(c1, r2);
				r2 = r2 + prop.get(c1);
			}
			// System.out.println(c1);
		}
		
		
		

		// compression

		for (int i = 0; i < s1.length(); i++) {
			char x1 = s1.charAt(i);

			code_range = high - low;
			// System.out.println(high_1.get(x2));
			if (high_1.containsKey(x1) && low_1.containsKey(x1)) {

				high = low + (code_range * high_1.get(x1));
				low = low + (code_range) * low_1.get(x1);
			}

		}

		System.out.println(low);
		

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		
		
		
		
		//decompression
		
		double[] high_2 = new double[high_1.size()];
		double[] low_2 = new double[low_1.size()];
		char[] k = new char[high_1.size()];

		int i = 0;
		for (char key : keys) {
			high_2[i] = high_1.get(key);
			low_2[i] = low_1.get(key);
			k[i] = key;
			i++;
		}

		// for(int j=0;j<high_2.length;j++){
		// System.out.println(high_2[j]);
		// System.out.println(low_2[j]);
		// System.out.println(k[j]);
		// }

		double data = low;
		char g = 'k';
		double current_range2 = 0;
		double value = 0;
		double value2 = 0;
		String s2="";

		boolean f1 = true;
		int l = 0;

		while (l < s1.length()) {
			int j = 0;
			while (j < high_2.length) {
				if (data >= low_2[j] && data < high_2[j]) {
					g = k[j];
					current_range2 = high_2[j] - low_2[j];
					value = data - low_2[j];
					value2 = value / current_range2;
					data = value2;
					s2+=g;
	
//					System.out.println(current_range2);
//					System.out.println(value);
//					System.out.println(value2);
				}
				j++;
			}
			//if(s2==s1)break;
			l++;
		}
		System.out.println(s1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
