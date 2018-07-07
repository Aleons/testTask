import org.testng.annotations.Test;
import page.AuthorizationPage;
import page.QuestionnairePage;

public class Tests {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    QuestionnairePage questionnairePage = new QuestionnairePage();
    void authorization(){
        authorizationPage.openSite().inputMail("test@protei.ru").inputPassword("test").enterButtonClick();
    }

    @Test(description = "test valid Authorization")
    void checkAuthorization(){
        authorization();
    }

    @Test(description = "invalid mail")
    void checkInvalidMail(){
        authorizationPage.openSite()
                .inputMail("bag").inputPassword("test").enterButtonClickFromInvalidData()
                .checkMessengInvalidMail();
    }

    @Test(description = "incorrect data")
    void checkIncorrectData(){
        authorizationPage.openSite()
                .inputMail("test@protei.ru").inputPassword("bag").enterButtonClickFromInvalidData()
                .checkMessengIncorrectData();
    }

    @Test(description = "valid Questionnaire")
    void checkValidQuestionnaire(){
        authorization();
        questionnairePage.inputMail("test@test.ru").inputName("test")
                .clickVar1_1().clickVar2_1().clickAddButton()
                .checkModalDialog().checkAllDataInTable();
    }

    @Test(description = "invalid mail")
    void checkErrorInvalidMail(){
        authorization();
        questionnairePage.inputMail("www").clickAddButtonInvalidData().errorMessInvalidMail();
    }

    @Test(description = "null name")
    void checkErrorNullName(){
        authorization();
        questionnairePage.inputMail("www@ww.ru").clickAddButtonInvalidData().errorMessNullName();
    }

    @Test(description = "Null v1 and v2 in table")
    void nullV1andV2InTabel(){
        authorization();
        questionnairePage.inputMail("test@test.ru").inputName("test")
                .clickAddButton().checkModalDialog().checkDataInTableWhereNullVar();
    }


}
