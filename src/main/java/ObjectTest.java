import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjectTest {
	private WebDriver driver;
	private String baseURL = "localhost:8080/activiti-app/#/login";
	
	public ObjectTest(WebDriver webdriver) {
		this.driver = webdriver;
		driver.get(baseURL);
	}
	
	public boolean tamanhoSite() {
		driver.get(baseURL);
		int qtd = driver.findElements(By.className("login-container")).size();
		return qtd>0;
	}
	public boolean loginSemCredenciais() {
		driver.get(baseURL);
		driver.findElement(By.id("login")).click();
		return driver.findElement(By.className("login-error")).getText().contains("Invalid credentials");
	}
	public boolean loginComCredenciais() {
		driver.get(baseURL);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("test");
		driver.findElement(By.id("login")).click();
		return driver.findElement(By.className("landing-logo")).isDisplayed();
	}

}
