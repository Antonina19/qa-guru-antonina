package guru.qa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void setup() {
        baseUrl = "https://demoqa.com";
        startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Julia"); // имя
        $("#lastName").setValue("Fox"); // фамилия
        $("#userEmail").setValue("julia@qaguru.com"); // почта
        $(byText("Female")).click(); // выбор пола
        $("#userNumber").setValue("0123456789"); // номер телефона
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption("March"); // месяц
        $(".react-datepicker__year-select").selectOption("1990"); // год
        $(".react-datepicker__day--004").click(); // день
        $("#subjectsInput").setValue("Biology").pressEnter(); // предметы
        $(byText("Music")).click(); // хобби
        $("#uploadPicture").uploadFile(new File("src/test/resources/fox.jpeg")); // картинка
        $("#currentAddress").setValue("Street1"); // адрес
        $("#react-select-3-input").setValue("NCR").pressEnter(); // штат
        $("#react-select-4-input").setValue("Noida").pressEnter(); // город


        $("#submit").click(); // клик по кнопке

        // сравнение введенных данных

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //$(".table-responsive").shouldHave(text("Julia"));
        //$(".table-responsive").shouldHave(text("Fox"));
        $("tbody").$(byText("Student Name")).parent().shouldHave(text("Julia Fox"));

        //$(".table-responsive").shouldHave(text("julia@qaguru.com"));
        $("tbody").$(byText("Student Email")).parent().shouldHave(text("julia@qaguru.com"));

        //$(".table-responsive").shouldHave(text("Female"));
        $("tbody").$(byText("Gender")).parent().shouldHave(text("Female"));

        //$(".table-responsive").shouldHave(text("0123456789"));
        $("tbody").$(byText("Mobile")).parent().shouldHave(text("0123456789"));

        //$(".table-responsive").shouldHave(text("04"));
        //$(".table-responsive").shouldHave(text("March,"));
        //$(".table-responsive").shouldHave(text("1990"));
        $("tbody").$(byText("Date of Birth")).parent().shouldHave(text("04 March,1990"));

        //$(".table-responsive").shouldHave(text("Biology"));
        $("tbody").$(byText("Subjects")).parent().shouldHave(text("Biology"));

        //$(".table-responsive").shouldHave(text("Music"));
        $("tbody").$(byText("Hobbies")).parent().shouldHave(text("Music"));

        //$(".table-responsive").shouldHave(text("fox.jpeg"));
        $("tbody").$(byText("Picture")).parent().shouldHave(text("fox.jpeg"));

        //$(".table-responsive").shouldHave(text("Street1"));
        $("tbody").$(byText("Address")).parent().shouldHave(text("Street1"));

        //$(".table-responsive").shouldHave(text("NCR"));
        //$(".table-responsive").shouldHave(text("Noida"));
        $("tbody").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));

    }
}