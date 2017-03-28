import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hover {
	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Loading Ecoles");
		List<Ecole> ecoles = CSVScanner.getList();

		System.out.println("Setting property");
		System.setProperty("webdriver.firefox.marionette", "./resources/geckodriver.exe");

		WebDriver driver;

		System.out.println("Opening Firefox");
		driver = new FirefoxDriver();

		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES); //10 minutes Timeout

		BufferedWriter writer = new BufferedWriter(new FileWriter("./resources/result.txt"));

		for(Ecole ecole : ecoles){

			driver.get("http://www.google.fr");
			Thread.sleep(1000);

			WebElement searchBar = driver.findElement(By.className("gsfi"));
			searchBar.sendKeys(ecole.getName() + " " + ecole.getType());
			searchBar.sendKeys(Keys.RETURN);
			Thread.sleep(2000);

			try{
				driver.findElement(By.cssSelector("a[href*='www.education.gouv.fr']")).click();
	
				Thread.sleep(3000);
	
				ecole.setPhone(driver.findElement(By.className("annuaire-etablissement-infos-part3")).getText());
	
				System.out.println(ecole.toString());
				writer.write(ecole.toString());
			}
			catch(Exception e){
				System.out.println("Not found : "+ecole.toString());
			}
			
			System.out.println("---------");
		}

		writer.close();
		driver.close();

	}
}
