package com.jadeappstudio.pembukuantk

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.jadeappstudio.pembukuantk.ui.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class AuthTest {
    @get:Rule
    var mActivityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun LoginTest() {
        Espresso.onView(withId(R.id.etUsername))
            .perform(ViewActions.typeText("joseph88888"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.etPassword))
            .perform(ViewActions.typeText("dummy"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btnLogin)).perform(ViewActions.click())
    }
}