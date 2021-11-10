package org.springframework.samples.petclinic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOwnerStepDefiniton {
	
	WebDriver driver;
	WebElement searchbox;
	
	@Given("Launch the web site")
	public void launch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:8088/");
	}
	
	@And("Click find owners button")
	public void click_find_owners_button() {
		driver.findElement(By.xpath("//*[@id=\'main-navbar\']/ul/li[2]/a/span[2]")).click();
	}
	@And("Hit the search box")
	public void hit_the_search_box() {
		searchbox = driver.findElement(By.xpath("//div/input[@class ='form-control']"));
		searchbox.click();
	}
	@When("Type {string} in the search box")
	public void type_in_the_search_box(String string) {
		searchbox.sendKeys(string);
	}
	@And("Click find owner button")
	public void click_find_owner_button() {
		driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button")).submit();
	}
	@Then("We should see {string} text")
	public void we_should_see_text(String string) {
		String error = driver.findElement(By.xpath("//*[@id=\"lastNameGroup\"]/div/span/div/p")).getText();
		System.out.println(error);
		Assert.assertEquals(error, string);
	}
	
	@When("Hit the {string} button")
	public void hit_the_button(String string) {
	    driver.findElement(By.linkText(string)).click();
	}
	@When("user enter valid data on the page")
	public void user_enter_valid_data_on_the_page(DataTable dataTable) {
	    String nameData = dataTable.cell(1, 1);
	    WebElement name = driver.findElement(By.id("firstName"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
		wait1.until(ExpectedConditions.elementToBeClickable(name));
		name.sendKeys(nameData);
		String nameText = name.getText();
		Assert.assertNotNull(nameText);
		
		String lastNameData = dataTable.cell(2, 1);
	    WebElement lastName = driver.findElement(By.id("lastName"));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
		wait2.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lastNameData);
		String lastNameText = lastName.getText();
		Assert.assertNotNull(lastNameText);
		
		String addressData = dataTable.cell(3, 1);
	    WebElement address = driver.findElement(By.id("address"));
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
		wait3.until(ExpectedConditions.elementToBeClickable(address));
		address.sendKeys(addressData);
		String addressText = address.getText();
		Assert.assertNotNull(addressText);
		
		String cityData = dataTable.cell(4, 1);
	    WebElement city = driver.findElement(By.id("city"));
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
		wait4.until(ExpectedConditions.elementToBeClickable(city));
		city.sendKeys(cityData);
		String cityText = city.getText();
		Assert.assertNotNull(cityText);
		
		String telData = dataTable.cell(5, 1);
	    WebElement tel = driver.findElement(By.id("telephone"));
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
		wait5.until(ExpectedConditions.elementToBeClickable(tel));
		tel.sendKeys(telData);
		String telText = tel.getText();
		Assert.assertNotNull(telText);
	}
	
	@When("Click Add Owner button")
    public void click_Add_Owner_button() {
        driver.findElement(By.className("btn-default")).click();
    }

    @Then("Owner table should be visible")
    public void owner_table_should_be_visible() {
        WebElement box1 = driver.findElement(By.cssSelector("table.table-striped"));
        Assert.assertNotNull(box1);
    } 

}
