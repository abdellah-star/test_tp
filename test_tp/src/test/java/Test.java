package test.java;

import static org.junit.jupiter.api.Assertions.*;
  
import main.java.Sum;

public class Test {

	@org.junit.jupiter.api.Test
	public void test() {
		Sum cs = new Sum();
		int s = cs.somme(40, 2);
		assertEquals(s, 42);
	}
}
