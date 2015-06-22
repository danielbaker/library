package library.web;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class HomeControllerTests {
	
	HomeController controller;
	
	@Before
	public void setUp() {
		controller = new HomeController();
	}

	@Test
	public void indexReturnsTheIndexPage() {
		assertThat(controller.index(), is("index"));
	}
	
}
