package Tutorial;

import java.util.LinkedHashSet;

public class Demo2 {

	

			public static void main(String[] args) {
				String a =" haaaarrrriiiaaaaaa";
				//convert into array//
		char[] c =a.toCharArray();

		LinkedHashSet hs = new LinkedHashSet();

		for(int i=0;i<c.length;i++) {
			

		hs.add(c[i]);

			}
		System.out.println(hs);
		}
		

	}


