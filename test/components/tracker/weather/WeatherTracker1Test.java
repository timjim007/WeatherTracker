package components.tracker.weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;

public class WeatherTracker1Test {
        
      /*
     * Constructor tests. ------------------------------------------------------
     */
    @Test
    public void testNoArgumentConstructor() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1();
        WeatherTracker wObjectExpected = new WeatherTracker1();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(wObjectExpected.numberOfTrackedLocation(),
                wObject.numberOfTrackedLocation());
    }

    @Test
    public void testArgumentConstructor() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        WeatherTracker wObjectExpected = new WeatherTracker1("Columbus");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(wObjectExpected.isTracked("Columbus"),
                wObject.isTracked("Columbus"));
    }

    /*
     * Standard tests. ------------------------------------------------------
     */

    /*
     * Test clear
     */
    @Test
    public void testClear() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        WeatherTracker wObjectExpected = new WeatherTracker1();

        /*
         * Call method under test
         */
        wObject.clear();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(wObjectExpected.numberOfTrackedLocation(),
                wObject.numberOfTrackedLocation());
    }

    /*
     * Test transferFrom
     */
    @Test
    public void testTransferFrom() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker oldWObject = new WeatherTracker1("Columbus");
        WeatherTracker wObjectExpected = new WeatherTracker1("Columbus");
        WeatherTracker newWObject = new WeatherTracker1();

        /*
         * Call method under test
         */
        newWObject.transferFrom(oldWObject);
        ;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(wObjectExpected.isTracked("Columbus"),
                newWObject.isTracked("Columbus"));
    }

    /*
     * Kernel Method tests.
     * ------------------------------------------------------
     */

    /*
     * Test fetchWeatherData one location
     */
    @Test
    public void testfetchWeatherData1() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        WeatherTracker wObjectExpected = new WeatherTracker1("Columbus");
        Map<String, String> dataExpected = wObjectExpected
                .fetchWeatherData("Columbus");

        /*
         * Call method under test
         */
        Map<String, String> data = wObject.fetchWeatherData("Columbus");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(dataExpected, data);
    }

    /*
     * Test fetchWeatherData two location
     */
    @Test
    public void testfetchWeatherData2() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        wObject.addLocation("Chicago");
        WeatherTracker wObjectExpected = new WeatherTracker1("Columbus");
        wObjectExpected.addLocation("Chicago");

        Map<String, String> dataExpected = wObjectExpected
                .fetchWeatherData("Chicago");

        /*
         * Call method under test
         */
        Map<String, String> data = wObject.fetchWeatherData("Chicago");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(dataExpected, data);
        assertEquals(wObjectExpected.isTracked("Chicago"),
                wObject.isTracked("Chicago"));
    }

    /*
     * Test addlocation
     */
    @Test
    public void addLocation() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1();
        WeatherTracker wObjectExpected = new WeatherTracker1("Chicago");

        /*
         * Call method under test
         */
        wObject.addLocation("Chicago");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(wObjectExpected.isTracked("Chicago"),
                wObject.isTracked("Chicago"));
    }

    /*
     * Test removeLocation
     */
    @Test
    public void removeLocation() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        wObject.addLocation("Chicago");
        WeatherTracker wObjectExpected = new WeatherTracker1("Chicago");

        WeatherTracker expectedRemoved = new WeatherTracker1("Columbus");
        /*
         * Call method under test
         */
        WeatherTracker removed = wObject.removeLocation("Columbus");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(wObjectExpected.isTracked("Chicago"),
                wObject.isTracked("Chicago"));
        assertEquals(expectedRemoved.isTracked("Columbus"),
                removed.isTracked("Columbus"));
        assertEquals(expectedRemoved.isTracked("Chicago"),
                removed.isTracked("Chicago"));
    }

    /*
     * Test removeAnyLocation
     */
    @Test
    public void removeAnyLocation() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        WeatherTracker wObjectExpected = new WeatherTracker1();

        WeatherTracker expectedRemoved = new WeatherTracker1("Columbus");

        /*
         * Call method under test
         */
        WeatherTracker removed = wObject.removeAnyLocation();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(wObjectExpected.numberOfTrackedLocation(),
                wObject.numberOfTrackedLocation());
        assertEquals(expectedRemoved.isTracked("Columbus"),
                removed.isTracked("Columbus"));
    }

    /*
     * Test numberOfTrackedLocation
     */
    @Test
    public void testNumberOfTrackedLocation() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        wObject.addLocation("Chicago");
        wObject.addLocation("London");

        WeatherTracker wObjectExpected = new WeatherTracker1("Columbus");
        wObjectExpected.addLocation("Chicago");
        wObjectExpected.addLocation("London");

        /*
         * Assert that values of variables match expectations
         */

        assertEquals(wObjectExpected.numberOfTrackedLocation(),
                wObject.numberOfTrackedLocation());
    }

    /*
     * Test isTracked
     */
    @Test
    public void testIsTracked() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");
        WeatherTracker wObjectExpected = new WeatherTracker1("Columbus");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(wObjectExpected.isTracked("Columbus"),
                wObject.isTracked("Columbus"));
    }

    /*
     * Test location
     */
    @Test
    public void location() {
        /*
         * Set up variables and call method under test
         */
        WeatherTracker wObject = new WeatherTracker1("Columbus");

        WeatherTracker wObjectExpected = new WeatherTracker1("Columbus");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(wObjectExpected.location(), wObject.location());
    }
}
