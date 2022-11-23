package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            dateOfBirthInput = $("#dateOfBirthInput");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender() {
        $(".custom-control-label").click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(value);
        $("#subjectsInput").pressEnter();
        return this;
    }

    public RegistrationPage setHobbie(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPic(String value) {
        $("#uploadPicture").uploadFile(new File(value));
        return this;
    }

    public RegistrationPage setAdres(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText(value)).click();
        return this;
    }

    public RegistrationPage submitButton() {
        $("#submit").click();
        return this;
    }
}
