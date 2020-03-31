/**
 * 
 */
package cn.tjuscs.st2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author m^_^m
 *
 */
public class Exct {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.setProperty("webdriver.gecko.driver","/usr/local/Cellar/geckodriver/0.26.0/bin/geckodriver");
		WebDriver driver = new FirefoxDriver();
	    driver.get("http://103.120.226.190/selenium-demo/git-repo");
	    
	    File excelFile = new File("/Users/yvonne/Documents/sofetest/resource/Selenium+Lab2020.xlsx");
	    InputStream inp = new FileInputStream(excelFile);  
        XSSFWorkbook workbook = new XSSFWorkbook(inp);  
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        for(int i=0;i<20;i++) {
        	Row row = sheet.getRow(i);
        	WebElement userName = driver.findElement(By.name("user_number"));
     		userName.sendKeys(row.getCell(1).getStringCellValue());
     		
     		WebElement passName = driver.findElement(By.name("password"));
     		passName.sendKeys(row.getCell(2).getStringCellValue());
     		
     		WebElement submitName = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
     		submitName.click();
     		
     		WebElement textShow = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
     		if(textShow.getText().equals(row.getCell(2).getStringCellValue())) {
     			System.out.println((i+1)+" Succeed!􏱨􏱩􏱪􏱫􏱑􏱬􏱭􏱌􏱮");
     		}else {
     			System.out.println((i+1)+" Failed!");
     		}
        	
        }
        driver.close();
	    
	}
}
