
public class Main9039 {

	public static void main(String[] args) {
		char ar = 'A';
		for (char i = 'A'; i<='Z'; i++) {
			System.out.print(i);
		}  
		System.out.println();
		for (char i = 0; i<26; i++) {
			//이게 훨씬 빠름
			System.out.print((ar++));
			// System.out.print((char)(ar+i));
		} 

	}

}
