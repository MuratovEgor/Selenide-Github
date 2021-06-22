import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @Test
    void dragAndDrop() {
        //открыть сайт
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //переместить А на место Б
        $("#column-a").dragAndDropTo("#column-b");
        //Проверить что А теперь второй
        $("div.column header", 1).shouldHave(text("A"));
    }
}
