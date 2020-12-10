package com.jadeappstudio.pembukuantk

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.jadeappstudio.pembukuantk.ui.AddUserActivity
import com.jadeappstudio.pembukuantk.ui.BottomNavActivity
import com.jadeappstudio.pembukuantk.ui.LoginActivity
import com.jadeappstudio.pembukuantk.ui.UsersManagementActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class UnitTest {
    @Test
    fun loginTest() {
        ActivityScenario.launch(LoginActivity::class.java)
        Espresso.onView(withId(R.id.etUsername))
            .perform(ViewActions.typeText("har"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.etPassword))
            .perform(ViewActions.typeText("har"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btnLogin)).perform(ViewActions.click())
    }

    @Test
    fun addUserTest() {
        ActivityScenario.launch(BottomNavActivity::class.java)
        Espresso.onView(withId(R.id.navigation_dashboard)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_transactions)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_customer)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_inventory)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_profile)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.btnUserManagement)).perform(ViewActions.click())
        loadUserManagement()
    }

    fun loadUserManagement() {
        ActivityScenario.launch(UsersManagementActivity::class.java)
        Espresso.onView(withId(R.id.btnAddUser)).perform(ViewActions.click())
        insertUser()
    }

    fun insertUser() {
        ActivityScenario.launch(AddUserActivity::class.java)
        Espresso.onView(withId(R.id.etUsername))
            .perform(ViewActions.typeText("revino"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.etPassword))
            .perform(ViewActions.typeText("revino"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btnAddNewUser)).perform(ViewActions.click())
    }

    @Test
    fun addCustomerTest() {
        ActivityScenario.launch(BottomNavActivity::class.java)
        Espresso.onView(withId(R.id.navigation_dashboard)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_transactions)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_customer)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.btnAddCustomer)).perform(ViewActions.click())
        insertCustomer()
    }

    fun insertCustomer() {
        Espresso.onView(withId(R.id.etCustomerName))
            .perform(ViewActions.typeText("Randi"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.etCustomerPhone))
            .perform(ViewActions.typeText("081234567890"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.etCustomerEmail))
            .perform(ViewActions.typeText("randi@gmail.com"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.etCustomerAddress))
            .perform(ViewActions.typeText("jl. galunggung 18"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btnAddCustomer)).perform(ViewActions.click())
    }

    @Test
    fun addProductTest() {
        ActivityScenario.launch(BottomNavActivity::class.java)
        Espresso.onView(withId(R.id.navigation_dashboard)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_transactions)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_customer)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_inventory)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.btnAddProduct)).perform(ViewActions.click())
        insertProduct()
    }

    fun insertProduct() {
        Espresso.onView(withId(R.id.etProductName))
            .perform(ViewActions.typeText("Aqua"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.etProductPrice))
            .perform(ViewActions.typeText("20000"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btnAddProduct)).perform(ViewActions.click())
    }

    @Test
    fun logout() {
        ActivityScenario.launch(BottomNavActivity::class.java)
        Espresso.onView(withId(R.id.navigation_dashboard)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_transactions)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_customer)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_inventory)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.navigation_profile)).perform(ViewActions.swipeRight())
        Espresso.onView(withId(R.id.btnLogout)).perform(ViewActions.click())
    }
}