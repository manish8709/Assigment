
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PetstoreApiTest {

    public static void main(String[] args) {
        
    	WebDriver driver = new ChromeDriver();
    	System.setProperty("webdriver,chrome,driver","C:\\selenium webdriver\\chrome driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		

        // Test Endpoint 1: Get pet by ID
       int petId = 1;
        String apiUrl = "https://petstore.swagger.io/v2/pet/" + petId;

        driver.get(apiUrl);
        Response response = RestAssured.get(apiUrl);

        
        System.out.println("Test 1: Get pet by ID");
        System.out.println(response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());

        // Test Endpoint 2: Get available pets
        apiUrl = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
        driver.get(apiUrl);
        response = RestAssured.get(apiUrl);

        System.out.println("Test 2: Get available pets");
        System.out.println(response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());

        // Test Endpoint 3: Get store inventory
        apiUrl = "https://petstore.swagger.io/v2/store/inventory";
        driver.get(apiUrl);
        response = RestAssured.get(apiUrl);

        System.out.println("Test 3: Get store inventory");
        System.out.println(response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());

       
        driver.quit();
    }
}
