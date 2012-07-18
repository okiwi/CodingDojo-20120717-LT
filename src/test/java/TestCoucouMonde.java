import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

public class TestCoucouMonde extends WebTester {
	@Before
	public void avant() {
		new Server().start();
	}

	@Test
	public void peutDireCoucou() {
		beginAt("http://localhost:8080");

		assertTextPresent("Hello world Okiwi!");
	}
}
