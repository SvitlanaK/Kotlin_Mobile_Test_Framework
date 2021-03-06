package core.utils

import com.codeborne.selenide.Condition.hidden
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import core.constants.Constants
import core.constants.Constants.Companion.IS_ANDROID
import org.openqa.selenium.By

class WaitingUtils {
    var progressBar: SelenideElement? = Selenide.`$`(By.id("progress"))
    var splashBackground: SelenideElement? = Selenide.`$`(By.id("splash_background"))


    fun waitingUntilLoadingIsGone() {
        if (IS_ANDROID)
            progressBar!!.waitUntil(hidden, Constants.ONE_MINUTE.toLong())
    }

    fun waitingUntilSplashScreenDisappear() {
        if (IS_ANDROID)
            splashBackground!!.waitUntil(hidden, Constants.ONE_MINUTE.toLong())
    }

}