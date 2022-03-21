package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();
    //locators
    public static SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genderInput = $("#genterWrapper"),
            emailInput = $("#userEmail"),
            mobileInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            resultsTable = $(".table-responsive"),
            hobbyInput = $("#hobbiesWrapper"),
            imageInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submit = $("#submit"),
            modalTitle = $(".modal-header");


    //actions
    public RegistrationPage openPage() {

        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {

        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {

        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {

        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public void setBirthDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

    }

    public RegistrationPage setMobile(String mobile) {

        mobileInput.setValue(mobile);
        return this;
    }
    public RegistrationPage setSubject(String subject) {

        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {

        hobbyInput.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setImage(String image) {

        imageInput.uploadFromClasspath(image);
        return this;
    }

    public RegistrationPage setAddress(String address) {

        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {

        stateInput.click();
        $(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {

        cityInput.click();
        $(byText(city)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {

        submit.click();
        return this;
    }

    public RegistrationPage checkModalForm() {

        modalTitle.shouldBe(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

        return this;
    }
}
