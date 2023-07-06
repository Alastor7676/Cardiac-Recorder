package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

import static java.lang.Thread.sleep;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class signup_loginTest {
    @Rule
    public ActivityScenarioRule<signup_login> activityRule =
            new ActivityScenarioRule<>(signup_login.class);

    @Test
    public void test_signup_login_switch(){
        onView(withId(R.id.signupButton)).perform(click());
        onView(withId(R.id.sign)).check(matches(isDisplayed()));

        Espresso.pressBack();
        onView(withId(R.id.signlog)).check(matches(isDisplayed()));

        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.log)).check(matches(isDisplayed()));
    }

    @Test
    public void test_signup() throws InterruptedException {
        onView(withId(R.id.signupButton)).perform(click());
        onView(withId(R.id.sign)).check(matches(isDisplayed()));

        onView(withId(R.id.name)).perform(ViewActions.typeText("test"));
        onView(withId(R.id.username)).perform(ViewActions.typeText("test"));
        onView(withId(R.id.password)).perform(ViewActions.typeText("1234"));
        onView(withId(R.id.confirmpassword)).perform(ViewActions.typeText("1234"));
        Espresso.pressBack();
        onView(withId(R.id.email)).perform(ViewActions.typeText("+8801976111988"));
        Espresso.pressBack();

        onView(withId(R.id.signupButton)).perform(click());
        sleep(1000);
        onView(withId(R.id.otp)).check(matches(isDisplayed()));
    }

    @Test
    public void test_login() throws InterruptedException {
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.log)).check(matches(isDisplayed()));

        onView(withId(R.id.username)).perform(ViewActions.typeText("asif"));
        onView(withId(R.id.password)).perform(ViewActions.typeText("asif"));

        onView(withId(R.id.loginButton)).perform(click());
        sleep(1000);
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_add_delete() throws InterruptedException {
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.log)).check(matches(isDisplayed()));

        onView(withId(R.id.username)).perform(ViewActions.typeText("asif"));
        onView(withId(R.id.password)).perform(ViewActions.typeText("asif"));

        onView(withId(R.id.loginButton)).perform(click());
        sleep(1000);
        onView(withId(R.id.main)).check(matches(isDisplayed()));

        onView(withId(R.id.imgadd)).perform(click());
        sleep(1000);
        onView(withId(R.id.add)).check(matches(isDisplayed()));

        sleep(1000);
        onView(withId(R.id.datetext)).perform(ViewActions.typeText("17/06/2023"));
        onView(withId(R.id.timetext)).perform(ViewActions.typeText("7:25 PM"));
        onView(withId(R.id.systext)).perform(ViewActions.typeText("123"));
        onView(withId(R.id.distext)).perform(ViewActions.typeText("83"));
        Espresso.pressBack();
        onView(withId(R.id.bpmtext)).perform(ViewActions.typeText("65"));
        Espresso.pressBack();
        onView(withId(R.id.cmnttext)).perform(ViewActions.typeText("test record"));
        Espresso.pressBack();

        onView(withId(R.id.addbutton)).perform(click());
        sleep(1000);
        onView(withId(R.id.main)).check(matches(isDisplayed()));

        sleep(1000);
        onView(withText("123")).check(matches(isDisplayed()));
        onView(withText("83")).check(matches(isDisplayed()));
        onView(withText("65")).check(matches(isDisplayed()));
        onView(withText("test record")).check(matches(isDisplayed()));

        sleep(1000);
        onView(withId(R.id.image)).perform(click());
        onView(withText("123")).check(doesNotExist());
        onView(withText("83")).check(doesNotExist());
        onView(withText("65")).check(doesNotExist());
        onView(withText("test record")).check(doesNotExist());
    }

    @Test
    public void test_details() throws InterruptedException {
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.log)).check(matches(isDisplayed()));

        onView(withId(R.id.username)).perform(ViewActions.typeText("asif"));
        onView(withId(R.id.password)).perform(ViewActions.typeText("asif"));

        onView(withId(R.id.loginButton)).perform(click());
        sleep(1000);
        onView(withId(R.id.main)).check(matches(isDisplayed()));

        onView(withId(R.id.imgadd)).perform(click());
        sleep(1000);
        onView(withId(R.id.add)).check(matches(isDisplayed()));

        sleep(1000);
        onView(withId(R.id.datetext)).perform(ViewActions.typeText("17/06/2023"));
        onView(withId(R.id.timetext)).perform(ViewActions.typeText("8:00 PM"));
        onView(withId(R.id.systext)).perform(ViewActions.typeText("127"));
        onView(withId(R.id.distext)).perform(ViewActions.typeText("89"));
        Espresso.pressBack();
        onView(withId(R.id.bpmtext)).perform(ViewActions.typeText("70"));
        Espresso.pressBack();
        onView(withId(R.id.cmnttext)).perform(ViewActions.typeText("test record2"));
        Espresso.pressBack();

        onView(withId(R.id.addbutton)).perform(click());
        sleep(1000);
        onView(withId(R.id.main)).check(matches(isDisplayed()));

        sleep(1000);
        onView(withText("70")).perform(click());
        sleep(1000);
        onView(withId(R.id.det)).check(matches(isDisplayed()));

        sleep(1000);
        onView(withText("127 (High sys pressure)")).check(matches(isDisplayed()));
        onView(withText("89 (High dias pressure)")).check(matches(isDisplayed()));
        onView(withText("70 (Normal heart rate)")).check(matches(isDisplayed()));
        onView(withText("test record2")).check(matches(isDisplayed()));
        onView(withText("8:00 PM")).check(matches(isDisplayed()));
        onView(withText("17/06/2023")).check(matches(isDisplayed()));

        sleep(1200);
        Espresso.pressBack();
        sleep(500);
        onView(withId(R.id.main)).check(matches(isDisplayed()));

        sleep(1000);
        onView(withId(R.id.image)).perform(click());
    }


}