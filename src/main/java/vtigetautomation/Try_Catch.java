package vtigetautomation;

import java.io.FileReader;

public class Try_Catch {

	public static void main(String[] args) {
		m3();
		try (FileReader fr = new FileReader("yyy")) {
			System.out.println(10 / 0);
		} catch(Exception e) {
			
		}
	}

	public static void m1() throws InterruptedException {
		Thread.sleep(123);

	}

	public static void m2() {
		try {
			m1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void m3()  {
		String words = "su0mi0t7ni2t3u45ri2so2m7y2a05";
		int total = 0;
		for (int i = 0; i <= words.length() - 1; i++) {
			char ch = words.charAt(i);
			Character c = ch;
			String onechar = c.toString();
			try {
				int a = Integer.parseInt(onechar);
				System.out.println(a);
				total = total + a;
			} catch (Exception s) {
				
			}
			
		}
		System.out.println("total No..= " + total);
	}

}
