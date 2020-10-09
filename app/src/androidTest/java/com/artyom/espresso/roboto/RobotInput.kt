package com.artyom.espresso.roboto

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withId

class RobotInput {

    fun inputFirstName(firstName: String): RobotInput {
        onView(FIRST_NAME_INPUT_MATCHER).perform(clearText(), typeText(firstName), closeSoftKeyboard())
        return this
    }

    fun inputLastName(lastName: String): RobotInput {
        onView(LAST_NAME_INPUT_MATCHER).perform(clearText(), typeText(lastName), closeSoftKeyboard())
        return this
    }

    fun inputEmailAddress(email: String): RobotInput {
        onView(EMAIL_INPUT_MATCHER).perform(clearText(), typeText(email), closeSoftKeyboard())
        return this
    }

    fun inputPhoneNumber(number: String): RobotInput {
        onView(PHONE_NUMBER_INPUT_MATCHER).perform(clearText(), typeText(number), closeSoftKeyboard())
        return this
    }

    fun enableEmailOptIn(): RobotInput {
        onView(OPT_IN_ENABLE).perform(click()).also { closeSoftKeyboard() }
        return this
    }

    fun register(): RobotInput {
        onView(REGISTER_CLICK_MATCHER).perform(click())
        return this
    }

    fun checkEmailError(error: String): RobotInput {
        onView(EMAIL_INPUT_MATCHER).check(matches(hasErrorText(error)))
        return this
    }

    companion object {
        val FIRST_NAME_INPUT_MATCHER = withId(R.id.etFirstName)
        val LAST_NAME_INPUT_MATCHER = withId(R.id.etLastName)
        val EMAIL_INPUT_MATCHER = withId(R.id.etEmail)
        val PHONE_NUMBER_INPUT_MATCHER = withId(R.id.etPhone)
        val OPT_IN_ENABLE = withId(R.id.rbEmailOptIn)
        val REGISTER_CLICK_MATCHER = withId(R.id.registerButton)
    }
}