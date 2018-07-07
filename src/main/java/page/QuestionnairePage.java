package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import page.forms.ModalDialog;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class QuestionnairePage {

    SelenideElement mail = $(By.xpath("//*[@id='dataEmail']"));
    SelenideElement name = $(By.xpath("//*[@id='dataName']"));
    SelenideElement gender = $(By.xpath("//*[@id='dataGender']"));
    SelenideElement var1_1 = $(By.xpath("//*[@id='dataCheck11']"));
    SelenideElement var1_2 = $(By.xpath("//*[@id='dataCheck12']"));
    SelenideElement var2_1 = $(By.xpath("//*[@id='dataSelect21']"));
    SelenideElement var2_2 = $(By.xpath("//*[@id='dataSelect22']"));
    SelenideElement var2_3 = $(By.xpath("//*[@id='dataSelect23']"));
    SelenideElement buttonAdd = $(By.xpath("//*[@id='dataSend']"));
    SelenideElement table = $(By.xpath("//*[@id='dataTable']"));
    SelenideElement blankNameError = $(By.xpath("//*[@id='blankNameError']"));
    SelenideElement emailFormatError = $(By.xpath("//*[@id='emailFormatError']"));

    @Step("Input mail Questionnaire")
    public QuestionnairePage inputMail(String mail){
        this.mail.sendKeys(mail);
        return this;
    }

    @Step("Input name")
    public QuestionnairePage inputName(String name){
        this.name.sendKeys(name);
        return this;
    }

    @Step("Select gender")
    public QuestionnairePage checkSelectGender(){
        gender.click();
        gender.$(By.xpath("/option[2]")).click();
        return this;
    }

    @Step("click var1.1")
    public QuestionnairePage clickVar1_1(){
        var1_1.click();
        return this;
    }

    @Step("click var1.2")
    public QuestionnairePage clickVar1_2(){
        var1_2.click();
        return this;
    }

    @Step("click var2.1")
    public QuestionnairePage clickVar2_1(){
        var2_1.click();
        return this;
    }

    @Step("click var2.2")
    public QuestionnairePage clickVar2_2(){
        var2_2.click();
        return this;
    }

    @Step("click var2.3")
    public QuestionnairePage clickVar2_3(){
        var2_3.click();
        return this;
    }

    @Step("Click addButton")
    public ModalDialog clickAddButton(){
        buttonAdd.click();
        return page(ModalDialog.class);
    }

    @Step("Click addButton invalid data")
    public QuestionnairePage clickAddButtonInvalidData(){
        buttonAdd.click();
        return this;
    }



    @Step("Check all data in table")
    public QuestionnairePage checkAllDataInTable(){
        table.$(By.xpath("./tbody/tr/td[1]")).text().equals(mail.text());
        table.$(By.xpath("./tbody/tr/td[2]")).text().equals(name.text());
        table.$(By.xpath("./tbody/tr/td[3]")).text().equals(gender.text());
        table.$(By.xpath("./tbody/tr/td[4]")).text().equals("1.1");
        table.$(By.xpath("./tbody/tr/td[4]")).text().equals("2.1");
        return this;
    }

    @Step("Check data in table where null var")
    public QuestionnairePage checkDataInTableWhereNullVar(){
        table.$(By.xpath("./tbody/tr/td[1]")).text().equals(mail.text());
        table.$(By.xpath("./tbody/tr/td[2]")).text().equals(name.text());
        table.$(By.xpath("./tbody/tr/td[3]")).text().equals(gender.text());
        table.$(By.xpath("./tbody/tr/td[4]")).text().equals("Нет");
        table.$(By.xpath("./tbody/tr/td[5]")).text().equals("");
        return this;
    }

    @Step("check error messadge invalid mail")
    public QuestionnairePage errorMessInvalidMail(){
        emailFormatError.text().equals("Неверный формат E-Mail");
        return this;
    }

    @Step("check error messadge null name")
    public QuestionnairePage errorMessNullName(){
        blankNameError.text().equals("Поле имя не может быть пустым");
        return this;
    }
}
