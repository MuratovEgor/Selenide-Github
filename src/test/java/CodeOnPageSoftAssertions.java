import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CodeOnPageSoftAssertions {
    @Test
    void findPageSoftAssertionsInDirectoryWiki() {
        // Откройте страниц Selenide в Github
        open("https://github.com/selenide/selenide");

        // Перейдите в раздел Wiki проекта
        $("[data-content=\"Wiki\"]").click();
        $("#wiki-content h1").shouldHave(text("Welcome to the selenide wiki!"));

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$(".markdown-body ul li a").findBy(text("Soft assertions")).click();

        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("#wiki-wrapper h1").shouldHave(text("SoftAssertions"));
        $$(".markdown-body ol li").shouldHave(itemWithText("Using JUnit5 extend test class:"));
        $x("//li[text()='Using JUnit5 extend test class:']/ancestor::ol/following-sibling::div[1]").shouldBe(visible);

    }
}
