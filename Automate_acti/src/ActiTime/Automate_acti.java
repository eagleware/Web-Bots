package ActiTime;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automate_acti {

	public static void main(String[] args) throws InterruptedException {
		String baseURL="https://demo.actitime.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","F:\\Selenium JAR\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.findElement(By.xpath("//input[@type='text'][@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password'][@name='pwd']")).sendKeys("manager");
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		driver.findElement(By.xpath("/html/body/div[19]/form/table/tbody/tr/td/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[7]/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div[1]/div[1]")).click();
		List<WebElement> list =driver.findElements(By.xpath("//div[@class='scrollableDropdownView']//div/descendant::div[@class='itemRow ']"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			Thread.sleep(4000);
			System.out.println(list.get(i).getText());
			Thread.sleep(4000);
			if(list.get(i).getText().contains("- New Customer -")) {
				Thread.sleep(4000);
				list.get(i).click();
				Thread.sleep(4000);
				break;
			}		
		}
		driver.findElement(By.xpath("//input[contains(@class,'newCustomer ')and contains(@class,'newCustomerProjectField')]")).sendKeys("Milan");
		driver.findElement(By.xpath("//*[contains(@class,'newProject')][contains(@placeholder,'Enter')]")).sendKeys("ActiTime");
		driver.findElement(By.xpath("//td[contains(@class,'nameCell')]/input[@type='text'][@class='inputFieldWithPlaceholder']")).sendKeys("Hjgh");
		driver.findElement(By.xpath("//td[@class='estimateCell']/input[@type='text']")).sendKeys("12:00");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em[@unselectable='on']/button[contains(@class,'x-btn-text') and contains(@id,'ext-gen34')]")).click();
		Thread.sleep(2000);
		String Expected_month = "March 2019";
		String Current_month = driver.findElement(By.xpath("//tr[@id='ext-gen97']/td[@class='x-btn-center']/em[@unselectable='on']/button[@class='x-btn-text']")).getText();
		System.out.println(Expected_month);
		System.out.println(Current_month);
		for(int i=1;i<12;i++) {
			Thread.sleep(50);
			driver.findElement(By.xpath("//td[@class='x-date-right']/a[@id='ext-gen79']")).click();
			Thread.sleep(1000);
			if(Expected_month.equals(Current_month)) {
				System.out.println("Month Selected");
				break;
			}
			
		}
		Thread.sleep(4000);
		
		WebElement datepicker = driver.findElement(By.xpath("//td[@colspan='3']/table[@class='x-date-inner']/tbody/tr[5]"));
		List<WebElement> dates=datepicker.findElements(By.xpath("//td[@colspan='3']/table[@class='x-date-inner']/tbody/tr[5]//span"));
		System.out.println(dates);
		for(WebElement date : dates ) {
			String calDate=date.getText().toString();
			Thread.sleep(2000);
			if(calDate.equals("22")) {
				date.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[@class='commitButtonPlaceHolder']/div[contains(@class,'components_button withPlusIcon')]/div[@class='components_button_label']")).click();

	}

}
