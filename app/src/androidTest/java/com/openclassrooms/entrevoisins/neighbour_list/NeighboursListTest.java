
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourDetailActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion;
import com.openclassrooms.entrevoisins.utils.SharedPreferencesUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed)
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;
    private NeighbourApiService apiService;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
        Intents.init();
        apiService = DI.getNewInstanceApiService();
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT-1));
    }

    @Test
    public void checkNeighbourDetailActivityLaunch() {
        // Click on the first item of the list
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        //We check that the elements of this new activity exist
        intended(hasComponent(NeighbourDetailActivity.class.getName()));
    }

    @Test
    public void checkNeighbourDetailName() {
        // position du neighbour
        int position = 0;
        // neighbour avec sa position
        Neighbour neighbour = apiService.getNeighbours().get(position);
        // click sur l'item de la liste avec la position
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));
        // vérifie que le nom est bien affiche
        onView(withId(R.id.activity_neighbour_detail_name)).check(matches(withText(neighbour.getName())));
    }

    @Test
    public void checkNeighbourFavorite() {
        // 1 - on verifie qe l'on clique sur le Neighbour
        // 2 - Clique bien sur l'étoile
        // 3 - verifie que l'on ajoute bien le neighbour à la liste de Favoris

        int position = 0;
        Neighbour neighbour = apiService.getNeighbours().get(position);

        String key = neighbour.getId().toString();
        SharedPreferencesUtils.setBooleanPreference(mActivity, key, false);
        int favoriteListSize = apiService.getFavoriteNeighbours(mActivity).size();

        // vue detail
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));
        onView(withId(R.id.activity_neighbour_detail_favorites)).perform(click());

        onView(withId(R.id.activity_neighbour_detail_return)).perform(click());
        onView(withId(R.id.list_neighbours_favorite)).check(RecyclerViewItemCountAssertion.withItemCount(favoriteListSize+1));

    }




}