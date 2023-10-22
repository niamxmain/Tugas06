package saucedemo.cucumber.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user already open login page")
    public void userAlreadyOpenLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("user input username")
    public void userInputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input password")
    public void userInputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user redirect to dashboard")
    public void userRedirectToDashboard() {
        String dashboardLogo = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(dashboardLogo, "Swag Labs");
        driver.close();
    }

    @When("user input invalid username")
    public void userInputInvalidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
    }

    @Then("error message invalid username")
    public void errorMessageInvalidUsername() {
        String errorMessage = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    //ADD PRODUCT
    @Given("user login with standard user")
    public void userLoginWithStandardUser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user in product page")
    public void userInProductPage() {
        String dashboardLogo = driver.findElement(By.className("app_logo")).getText();
        String titleProduct = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(dashboardLogo, "Swag Labs");
        Assert.assertEquals(titleProduct, "Products");

    }

    @And("user click button add to cart")
    public void userClickButtonAddToCart() {
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("user click icon cart")
    public void userClickIconCart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("displays product descriptions")
    public void displaysProductDescriptions() {
        String productDescription = driver.findElement(By.xpath("//div[@class='inventory_item_desc']")).getText();
        Assert.assertEquals(productDescription, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        driver.close();
    }

    @Given("user login with error user")
    public void userLoginWithErrorUser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("error_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @And("user click remove button in product page")
    public void userClickRemoveButtonInProductPage() {
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
    }

    @Then("the remove button cant click")
    public void theRemoveButtonCantClick() {
        String textButton = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).getText();
        Assert.assertEquals(textButton, "Remove");
        driver.close();
    }


    //CHECKOUT
    @And("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//button[@name='checkout']")).click();

    }

    @Then("user completes information data")
    public void userCompletesInformationData() {
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Asep");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Jayadi");
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("58111");
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.xpath("//input[@name='continue']")).click();
    }

    @Then("display checkout information")
    public void displayCheckoutInformation() {
        String title = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(title, "Checkout: Overview");
    }

    @Then("click finish button")
    public void clickFinishButton() {
        driver.findElement(By.xpath("//button[@name='finish']")).click();
    }

    @Then("display popup success")
    public void displayPopupSuccess() {
        String popup = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        Assert.assertEquals(popup, "Thank you for your order!");
        driver.close();
    }

    @And("user click image product")
    public void userClickImageProduct() {
        driver.findElement(By.xpath("//img[@class='inventory_item_img']")).click();
    }

    @Then("display product information")
    public void displayProductInformation() {
        String detailName = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        Assert.assertEquals(detailName, "Sauce Labs Backpack");
        driver.close();
    }
}
