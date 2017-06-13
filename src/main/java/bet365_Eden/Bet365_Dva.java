package bet365_Eden;

 
import org.junit.Before;
import org.junit.Test; 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.mail.PasswordAuthentication;
 


public class Bet365_Dva  {


	public WebDriver driver;
	public String baseUrl,liga,utakmica;
	public String  liga1,utakmica1;
	public String poraka;
	public Boolean dalipostoi=false;
	
	@SuppressWarnings("unused")
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before 
	public void setUp() throws Exception {
		 
		baseUrl="https://www.bet365.com/?&cb=10325414067#/HO/";
		///liga1="Northern Ireland Reserve League";
		//utakmica1="Glentoran Reserves v Coleraine Reserves";
		
	}
	@Test
	public void test() throws InterruptedException { 
	
		File file = new File("C:/temp/bet356_Dva.properties");
		 
    	FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		WebDriver driver = new FirefoxDriver();
   	 driver.manage().window().maximize();
   	 
   	driver.get(baseUrl);
   	
   	Thread.sleep(5000);
   	driver.findElement(By.linkText("English")).click();
   	Thread.sleep(10000);
    	driver.findElement(By.linkText("English")).click();
    	Thread.sleep(10000);
   	driver.findElement(By.xpath("//*[text()='Soccer']")).click();
   	//driver.findElement(By.cssSelector("div.wn-Classification")).click();
   	//(//a[contains(text(),'Save')])[2]")).click();
	Thread.sleep(1000);
  /// 	driver.findElement(By.xpath("//div[15]/div/div")).click();
	while(dalipostoi==false){
   	if (prop.getProperty("ligaprva")!=null)
   		{
   		driver.findElement(By.xpath("//*[text()='"+prop.getProperty("ligaprva")+"']")).click();
   		}
	Thread.sleep(1000);
    	//Biras liga
   	driver.findElement(By.xpath("//*[text()='"+prop.getProperty("liga")+"']")).click();
	Thread.sleep(5000);
   	//Biras utakmica
   	driver.findElement(By.xpath("//*[text()='"+prop.getProperty("utakmica")+"']")).click();
	Thread.sleep(10000);
 
			String imaMain=driver.findElement(By.cssSelector("div.wl-NavBarScroller_HScroll")).getText();
			
	    	if (imaMain.contains("Asian Lines")) 
	    	{
	    		driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div/div[2]")).click();
	    		Thread.sleep(1000);
	    	 
	    		//String AssianHand= driver.findElement(By.cssSelector("span.gl-ParticipantCentered_Handicap")).getText();
	    		///System.out.println(AssianHand);
	    			if (driver.findElements(By.cssSelector("span.gl-ParticipantCentered_Handicap")).size()!=0)
	    				{
	    				 dalipostoi=true;
	    				poraka=("Postoi Asian Handicap za "+prop.getProperty("utakmica"));
	    				System.out.println(poraka);
	    	 
	        final String username = "jenkinss4e@gmail.com";
	        final String password = "Passwords4e";
	        String to ="bo_sale@hotmail.com";// "tomi.pocevski@gmail.com";
	        		
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	          });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("pecakova.bojana@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(to));
	            message.setSubject("Asian Handicap !!!");
	            message.setText(poraka);

	            Transport.send(message);

	            System.out.println("Done");

	        } 

	        catch (MessagingException e) 
	        {
	            // throw new RuntimeException(e);
	            System.out.println("Username or Password are incorrect ... exiting !");
	        }
	    	}
	    	}
	}
	}     
}


