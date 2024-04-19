package components.tracker.weather;

import java.util.Iterator;

import components.map.Map;
import components.map.Map.Pair;
import components.standard.Standard;

public interface WeatherTrackerKernel extends Standard<WeatherTracker> {

    /**
     * Retrieves Weather data and returns it as a map.
     *
     * @param location
     *            the name or ID of the location to be removed
     * @return weather location details
     * @requires location is in this
     * @ensures map with weather location details.
     */
    Map<String, String> fetchWeatherData(String location);

    /**
     * Adds a new location to be tracked.
     *
     * @param newLocation
     *            location to be tracked
     * @updates this
     * @requires newLocation is not in this
     * @ensures newLocation weather details is added to this
     */
    void addLocation(String newLocation);

    /**
     * Removes an existing location from the tracked list and returns it.
     *
     * @param location
     *            the name or ID of the location to be removed
     * @return Removed WeatherTracker object of location
     * @updates this
     * @requires location is in this
     * @ensures location is removed from this
     */
    WeatherTracker removeLocation(String location);

    /**
     * Removes any location from the tracked list and returns it.
     *
     * @return Removed WeatherTracker object of location
     * @updates this
     * @requires |this| > 0
     * @ensures WeatherTracker object for arbitrary location is removed from
     *          this
     */
    WeatherTracker removeAnyLocation();

    /**
     * Reports the number of tracked location.
     *
     * @return number of tracked location.
     * @ensures numberOfTrackedLocation = |this|
     */
    int numberOfTrackedLocation();

    /**
     * Reports whether weather location is tracked.
     *
     * @param location
     *            the name or ID of the location to be checked
     * @return true iff location is in this
     * @ensures isTracked = (location is in this)
     */
    boolean isTracked(String location);

    /**
     * Reports weather location.
     *
     * @return the location being tracked
     * @requires this contains only one location. |this| = 1
     * @ensures location of tracked weather.
     */
    String location();

    /**
     * Returns an iterator over elements.
     *
     * @return iterator over elements
     */
    Iterator<Pair<String, Map<String, String>>> iterator();

}
