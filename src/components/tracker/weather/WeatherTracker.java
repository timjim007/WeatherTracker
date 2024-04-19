package components.tracker.weather;

import components.set.Set;

public interface WeatherTracker extends WeatherTrackerKernel {

    /**
     * Returns a set of names of weather location being tracked.
     *
     * @return names of location being tracked.
     * @ensures names of location being tracked.
     */
    Set<String> trackedLocations();

    /**
     * Updates the weather data for weather locations been tracked.
     *
     * @updates all weather location tracked with latest information
     * @ensures weather data for weather locations are updated
     */
    void updateWeatherData();

    /**
     * Returns information of weather location.
     *
     * @param location
     *            the name or ID of the location to be removed
     * @param whatInformation
     *            the name of the information you are looking for
     * @return Information of weather location.
     *
     * @requires location is in this and whatInformation is any of this
     *           words(temperature,humidity,windSpeed, precipitation ,condition)
     * @ensures details of weather information
     */
    String getWeatherInfo(String location, String whatInformation);

}
