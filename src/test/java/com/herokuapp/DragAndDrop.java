package com.herokuapp;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @Test
            void dragAndDrop () {
        // открыть страницу https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
        // проверить, что прямоугольники поменялись местами
        $("#column-b").shouldHave(Condition.text("A"));
        $("#column-a").shouldHave(Condition.text("B"));

    }

}
