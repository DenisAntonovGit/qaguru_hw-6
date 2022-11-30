package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    public static String userLastName = "Antonov",
            userEmail = "denis@gmail.com",
            userGender = "Male",
            userPhone = "9505555555",
            dayOfBirth = "21",
            monthOfBirth = "January",
            yearOfBirth = "1989",
            subject = "Computer Science",
            hobbie = "Reading",
            picFilePath = "src/test/resources/cat_pic.webp",
            picName = "cat_pic.webp",
            adress = "My adress",
            state = "Haryana",
            city = "Karnal";

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1460x800";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
