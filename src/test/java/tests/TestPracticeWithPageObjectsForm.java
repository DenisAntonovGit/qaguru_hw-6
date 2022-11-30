package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class TestPracticeWithPageObjectsForm extends TestBase{

    @Test

    void testPracticeForm() {
        Faker faker = new Faker(new Locale("en"));
        String userName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userPhone = faker.phoneNumber().subscriberNumber(10);
        

        registrationPage.openPage()
            .setFirstName(userName)
            .setLastName(lastName)
            .setEmail(userEmail)
            .setGender()
            .setPhone(userPhone)
            .setBirthDate(monthOfBirth, yearOfBirth)
            .setSubject(subject)
            .setHobbie(hobbie)
            .uploadPic(picFilePath)
            .setAdres(adress)
            .setState(state)
            .setCity(city)
            .submitButton();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbie)
                .verifyResult("Picture", picName)
                .verifyResult("Address", adress);
    }
}
