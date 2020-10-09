package com.artyom.espresso.roboto

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.allOf

class RobotCheck {

    fun checkFullName(name: String): RobotCheck {
        onView(FULL_NAME_CHECK).check(matches(allOf(isDisplayed(), withText(name))))
        return this
    }

    fun checkEmail(email: String): RobotCheck {
        onView(EMAIL_CHECK).check(matches(allOf(isDisplayed(), withText(email))))
        return this
    }

    fun checkPhoneNumber(phone: String): RobotCheck {
        onView(PHONE_NUMBER_CHECK).check(matches(withText(phone)))
        return this
    }

    fun isEmailOptInEnable(): RobotCheck {
        onView(OPT_IN_ENABLE_CHECK).check(matches(isChecked()))
        return this
    }

    fun isEmailOptInDisable(): RobotCheck {
        onView(OPT_IN_ENABLE_CHECK).check(matches(isNotChecked()))
        return this
    }

    companion object {
        val FULL_NAME_CHECK = withId(R.id.tvFullName)
        val EMAIL_CHECK = withId(R.id.tvEmailAddress)
        val PHONE_NUMBER_CHECK = withId(R.id.tvPhoneNumber)
        val OPT_IN_ENABLE_CHECK = withId(R.id.cbOptedIn)
    }
}