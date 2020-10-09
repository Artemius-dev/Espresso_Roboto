package com.artyom.espresso.roboto

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun SuccessfulRegistration() {
        RobotInput()
            .inputFirstName(FIRST_NAME)
            .inputLastName(LAST_NAME)
            .inputPhoneNumber("1234567890")
            .inputEmailAddress(EMAIL)
            .enableEmailOptIn()
            .register()

        RobotCheck()
            .checkFullName("$FIRST_NAME $LAST_NAME")
            .checkEmail(EMAIL)
            .checkPhoneNumber("(123)-456-7890")
            .isEmailOptInEnable()
    }

    @Test
    fun EmptyEmailError() {
        RobotInput()
            .inputFirstName(FIRST_NAME)
            .inputLastName(LAST_NAME)
            .inputPhoneNumber("1234567890")
            .enableEmailOptIn()
            .register()
            .checkEmailError("Must enter an email address.")

    }

    @Test
    fun InvalidEmailError() {
        RobotInput()
            .inputFirstName(FIRST_NAME)
            .inputLastName(LAST_NAME)
            .inputPhoneNumber("1234567890")
            .inputEmailAddress("sdasdas")
            .enableEmailOptIn()
            .register()
            .checkEmailError("Must enter a valid email address.")

    }

    companion object {
        val FIRST_NAME = "Artyom"
        val LAST_NAME = "Zhuravliov"
        val EMAIL = "artiom25454@gmail.com"
    }
}