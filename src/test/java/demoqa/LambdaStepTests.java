package demoqa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;


public class LambdaStepTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";
    String lastName = " Alexeev";
    String email = "emain@email.com";
    String gender = "Male";
    String mobile = "8002000500";
    String day = "25";
    String month = "June";
    String year = "1992";
    String subject = "Chemistry";
    String hobby = "Sports";
    String image = "photo.jpg";
    String address = "Current Address";
    String state = "NCR";
    String city = "Delhi";

    @DisplayName("Лямбда шаги через step")
    @Test
    void lambdaStepTests() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем основную страницу", () -> {
            registrationPage.openPage();
        });
        step("Заполнение основных полей", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setMobile(mobile)
                    .setSubject(subject)
                    .setHobby(hobby)
//                    .setImage(image)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .setBirthDate(day, month, year);
        });
        step("Нажатие кнопки submit", () -> {
            registrationPage.clickSubmit();
        });
        step("Проверка открытия окна", () -> {
            registrationPage.checkModalForm();
        });
        step("Проверка заполнения полей", () -> {
            registrationPage.checkForm("Student Name", firstName + " " + lastName)
                    .checkForm("Student Email", email)
                    .checkForm("Gender", gender)
                    .checkForm("Mobile", mobile)
                    .checkForm("Date of Birth", day + " " + month + "," + year)
                    .checkForm("Subjects", subject)
                    .checkForm("Hobbies", hobby)
//                    .checkForm("Picture", image)
                    .checkForm("Address", address)
                    .checkForm("State and City", state + " " + city);
        });

    }

}

