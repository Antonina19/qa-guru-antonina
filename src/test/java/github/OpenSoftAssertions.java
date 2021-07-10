package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class OpenSoftAssertions {
    @Test
        void openSoftAssertions(){
        // открыть страницу https://github.com/selenide/selenide
        open("https://github.com/selenide/selenide");
        // перейти в раздел Wiki
        $$(".js-repo-nav li").findBy(text("Wiki")).click();
        // убедиться что есть страница SoftAssertions
        $("[id=wiki-pages-filter]").setValue("SoftAssertions").pressEnter();
        // открыть страницу SoftAssertions(
        $$(".wiki-rightbar li").findBy(text("SoftAssertions")).click();
        // проверить, что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));




    }


}
