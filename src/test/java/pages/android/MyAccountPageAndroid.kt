package pages.android

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import core.utils.WaitingUtils
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.BasePage
import pages.MyAccountPage
import java.lang.String.format
import java.util.logging.Logger

class MyAccountPageAndroid : BasePage(), MyAccountPage {
    private val log: Logger = Logger.getLogger(MyAccountPageAndroid::class.java.name)

    private val pageTitle: SelenideElement = `$`(By.id("toolbar_title"))

    private val emailField: SelenideElement = `$`(By.id("login_email_edittext"))

    private val passwordField: SelenideElement = `$`(By.id("password_edittext"))

    private val signInButton: SelenideElement = `$`(By.id("login_button"))

    private val greetingText: SelenideElement = `$`(By.xpath(".//*[contains(@text, 'Hello')]"))

    private val txtErrorMsg: SelenideElement = `$`(By.xpath("//android.widget.TextView[@text='Incorrect e-mail or password']"))

    private val logOutButton: SelenideElement = `$`(By.id("myaccount_logout_button"))

    private val yesButton: SelenideElement = `$`(By.id("dialog_layout_button_positive"))

    @Step("Getting heading text")
    override fun isMyAccountPageOpen(): Boolean {
        log.info("Getting heading text")
        WaitingUtils().waitingUntilLoadingIsGone()
        return pageTitle.shouldBe(visible).`is`(visible)
    }

    @Step("Set {0} text to the 'Email' field")
    override fun setEmailField(text: String): MyAccountPageAndroid {
        log.info(format("Set '[%s]' text to the 'Email' field", text))
        ElementHelpers().typeText(emailField, text)
        return this
    }

    @Step("Set {0} text to the 'Password' field")
    override fun setPasswordField(text: String): MyAccountPageAndroid {
        log.info(format("Set [%s] text to the 'Password' field", text))
        ElementHelpers().typeText(passwordField, text)
        return this
    }

    @Step("Click on the 'Sign In' button")
    override fun clickSignInButton(): MyAccountPageAndroid {
        log.info("Click on the 'Sign In' button")
        ElementHelpers().tap(signInButton)
        return this
    }

    @Step("Authorization with {0} email, {1} password")
    override fun authorization(email: String, password: String): MyAccountPageAndroid {
        log.info(format("Authorization with '%s' email, '%s' password", email, password))
        setEmailField(email)
        setPasswordField(password)
        return clickSignInButton()
    }

    @Step("Click on the 'Log Out' Button")
    override fun clickLogOutButton(): MyAccountPageAndroid {
        log.info("Click on the 'Log Out' Button")
        logOutButton.shouldBe(visible).click()
        return this
    }

    @Step("Accept log out")
    override fun clickYesButton(): MyAccountPageAndroid {
        log.info("Accept log out")
        yesButton.shouldBe(visible).click()
        return this
    }

    @Step("Verify if Greeting message is present")
    override fun isGreetingPresent(): Boolean {
        log.info("Verify if Greeting message is present")
        return greetingText.waitUntil(visible, 60000).exists()
    }

    @Step("Verify if Error message is present")
    override fun isErrorMsgPresent(): Boolean {
        log.info("Verify if Error message is present")
        return txtErrorMsg.waitUntil(visible, 30000).exists()
    }

    @Step("Verify if 'Sign in' button enabled")
    override fun isSignInButtonEnabled(): Boolean {
        log.info("Verify if 'Sign in' button enabled")
        return signInButton.shouldBe(visible).exists()
    }

    @Step("Getting greeting text")
    override fun getGreetingText(): String {
        log.info("Getting greeting text")
        return greetingText.text()
    }
}