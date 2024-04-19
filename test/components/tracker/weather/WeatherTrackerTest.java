package components.tracker.weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map2;
import components.set.Set;
import components.set.Set2;


public class WeatherTrackerTest {
    /*
     * Test trackedLocations
     */
    @Test
    public void testTrackedLocations() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        wObject.addLocation("Chicago");
        wObject.addLocation("London");

        Set<String> wExpected = new Set2<>();
        wExpected.add("Columbus");
        wExpected.add("Chicago");
        wExpected.add("London");

        /*
         * Call method under test
         */
        Set<String> tracked = wObject.trackedLocations();

        /*
         * Assert that values of variables match expectations
         */

        assertEquals(wExpected, tracked);
    }

    /*
     * Test getWeatherInfo
     */
    @Test
    public void testGetWeatherInfo() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        wObject.addLocation("Chicago");
        wObject.addLocation("London");

        Map<String, String> wExpected = new Map2<>();
        wExpected.add("Temperature", "50°F");

        /*
         * Call method under test
         */
        String weatherInfo = wObject.getWeatherInfo("Chicago", "temperature");

        /*
         * Assert that values of variables match expectations
         */

        assertEquals(wExpected.value("Temperature"), weatherInfo);
    }


}
