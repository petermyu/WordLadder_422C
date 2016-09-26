package assignment3;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		Main.initialize();
		Scanner keyboard = new Scanner(System.in);
		System.out.println(Main.parse(keyboard).get(0).toString());
	}

}
