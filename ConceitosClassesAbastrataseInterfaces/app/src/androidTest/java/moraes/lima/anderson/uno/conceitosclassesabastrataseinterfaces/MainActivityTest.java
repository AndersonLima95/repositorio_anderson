package moraes.lima.anderson.uno.conceitosclassesabastrataseinterfaces;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;




@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Test
    public void deveriaMainActivityEstarVisivel(){
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.idActivityMain)).check(matches(isDisplayed()));




    }
}