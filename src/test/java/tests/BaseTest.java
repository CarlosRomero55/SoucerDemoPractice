package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configurar WebDriver para Chrome
        WebDriverManager.chromedriver().setup();

        // Inicializar WebDriver
        driver = new ChromeDriver();

        // Maximizar ventana del navegador
        driver.manage().window().maximize();

        // Abrir la URL base definida en config.properties
        driver.get(ConfigReader.getProperty("baseURL"));
    }

    @AfterClass
    public void tearDown() {
        // Cerrar el navegador después de las pruebas
        if (driver != null) {
            driver.quit();
        }
    }
}