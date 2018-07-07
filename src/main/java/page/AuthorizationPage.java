package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizationPage {

    SelenideElement mail = $(By.xpath("//*[@id='loginEmail']"));
    SelenideElement password = $(By.xpath("//*[@id='loginPassword']"));
    SelenideElement enterButton = $(By.xpath("//*[@id='authButton']"));
    SelenideElement errorText = $(By.xpath("//*[@id='authButton']"));
    File file = new File("src/main/resources/qa-test.html");
    String path = file.getAbsolutePath();

    @Step("Open login PORTAL page")
    public  AuthorizationPage openSite(){
        open("https://cellars.azurewebsites.net/");
        return page(AuthorizationPage.class);
    }

    @Step("Input mail")
    public AuthorizationPage inputMail(String mail){
        this.mail.sendKeys(mail);
        return this;
    }

    @Step("Input password")
    public AuthorizationPage inputPassword(String password){
        this.password.sendKeys(password);
        return this;
    }

    @Step("Click button enter")
    public QuestionnairePage enterButtonClick(){
        enterButton.click();
        return page(QuestionnairePage.class);
    }

    @Step("Click button enter from invakid data")
    public AuthorizationPage enterButtonClickFromInvalidData(){
        enterButton.click();
        return this;
    }

    @Step("Messeng invalid mail")
    public AuthorizationPage checkMessengInvalidMail(){
        errorText.text().equals("Неверный формат E-Mail");
        return this;
    }

    @Step("Messeng incorrect data")
    public AuthorizationPage checkMessengIncorrectData(){
        errorText.text().equals("Неверный E-Mail или пароль");
        return this;
    }

}
