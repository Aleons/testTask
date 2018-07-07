package page.forms;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import page.QuestionnairePage;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ModalDialog {

    SelenideElement buttonOk = $(By.xpath("//*[@class='uk-margin uk-modal-content']"));
    SelenideElement modalContent = $(By.xpath("//*[@class='uk-button uk-button-primary uk-modal-close']"));

    @Step("Check modal dialog")
    public QuestionnairePage checkModalDialog(){
        modalContent.sendKeys("Данные добавлены.");
        buttonOk.pressEnter();
        return page(QuestionnairePage.class);
    }
}
