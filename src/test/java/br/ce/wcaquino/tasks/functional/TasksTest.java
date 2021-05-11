package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void DeveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		
		try {
			//Clicar em ADD Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Escrever descricao
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
			//Escrever a Data
			driver.findElement(By.id("dueDate")).sendKeys("01/09/2030");
			
			//Clicar em Salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar msg de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);
		} finally {
			//fechar o browser
			driver.quit();
		}
		
		
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		
		try {
			//Clicar em ADD Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Escrever descricao
			//driver.findElement(By.id("task")).sendKeys("Teste via Selenium com erro");
			
			//Escrever a Data
			driver.findElement(By.id("dueDate")).sendKeys("01/01/2010");
			
			//Clicar em Salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar msg de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
		} finally {
			//fechar o browser
			driver.quit();
		}
		
		
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		
		try {
			//Clicar em ADD Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Escrever descricao
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium com erro");
			
			//Escrever a Data
			//driver.findElement(By.id("dueDate")).sendKeys("01/01/2010");
			
			//Clicar em Salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar msg de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", message);
		} finally {
			//fechar o browser
			driver.quit();
		}
		
		
	}
	
	@Test
	public void naoDeveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		
		try {
			//Clicar em ADD Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Escrever descricao
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium com erro");
			
			//Escrever a Data
			driver.findElement(By.id("dueDate")).sendKeys("01/01/2010");
			
			//Clicar em Salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar msg de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);
		} finally {
			//fechar o browser
			driver.quit();
		}
		
		
	}

}
