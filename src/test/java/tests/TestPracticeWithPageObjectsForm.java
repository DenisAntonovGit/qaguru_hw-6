package tests;

import org.junit.jupiter.api.Test;
public class TestPracticeWithPageObjectsForm extends TestBase{

    @Test
    void testPracticeForm() {
        String userName = "Denis";
        String userLastName = "Antonov";
        String userEmail = "denis@gmail.com";
        String userGender = "Male";
        String userPhone = "9505555555";
        String dayOfBirth = "21";
        String monthOfBirth = "January";
        String yearOfBirth = "1989";
        String subject = "Computer Science";
        String hobbie = "Reading";
        String picFilePath = "src/test/resources/cat_pic.webp";
        String picName = "cat_pic.webp";
        String adress = "My adress";
        String state = "Haryana";
        String city = "Karnal";

        registrationPage.openPage()
            .setFirstName(userName)
            .setLastName(userLastName)
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
                .verifyResult("Student Name", userName + " " + userLastName)
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
