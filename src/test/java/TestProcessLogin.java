import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProcessLogin {
	private static WebDriver driver;
	private ObjectTest objectTest;
	
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.objectTest = new ObjectTest(driver);
	}
	
	@Test
	public void testTamanho() {
		assertTrue(this.objectTest.tamanhoSite());
	}
	
	@Test
	public void testLoginSem() {
		assertTrue(this.objectTest.loginSemCredenciais());
	}
	
	@Test
	public void testLoginCom() {
		assertTrue(this.objectTest.loginComCredenciais());
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

}
