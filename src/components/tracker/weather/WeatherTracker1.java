package components.tracker.weather;

import java.util.Iterator;

import components.map.Map;
import components.map.Map.Pair;
import components.map.Map2;

/**
 * Weather tracker component represented with map.
 *
 * @convention $this.rep is a map and $this.rep is {(location,{(key,value)})}
 *             where key is (temperature,humidity,windspeed, precipitation
 *             ,condition) and value is the number or string associated with the
 *             key
 *
 * @correspondence this = {(location,{(key,value)})}
 *
 * @author Timothy Jimoh
 */
public final class WeatherTracker1 extends WeatherTrackerSecondary {

    /**
     * Representation of {@code this}.
     */
    private Map<String, Map<String, String>> rep;

    /*
     * Helper Methods-----------------------------------------------------------
     */

    /**
     * Retrieves Weather information based on location.
     *
     * @param location
     *            the name or ID of the location
     * @return Map with Weather information on location
     * @requires location exist
     * @ensures Map with Weather information on location
     */
    private Map<String, String> retrieveWeatherData(String location) {

        /*
         * This method can be used with an API to get weather information but I
         * put random weather details in here
         */

        Map<String, String> weatherDetails = new Map2<>();
        weatherDetails.add("temperature", "50°F");
        weatherDetails.add("humidity", "40%");
        weatherDetails.add("windSpeed", "10mph");
        weatherDetails.add("precipitation", "5 inches");
        weatherDetails.add("condition", "Partly Cloudy");

        return weatherDetails;
    }

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Map2<String, Map<String, String>>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No argument constructor.
     */
    public WeatherTracker1() {
        this.createNewRep();
    }

    /**
     * Constructor for creating weather tracker object with location.
     *
     * @param location
     *            the name or ID of the location
     * @requires location is not in this
     * @ensures this = {(location,{(key,value)})} where Key,Value are weather
     *          details.
     */
    public WeatherTracker1(String location) {
        this.createNewRep();
        Map<String, String> weatherData = this.retrieveWeatherData(location);
        this.rep.add(location, weatherData);
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public void clear() {
        this.createNewRep();

    }

    @Override
    public WeatherTracker newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public void transferFrom(WeatherTracker source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof WeatherTracker1 : ""
                + "Violation of: source is of dynamic type WeatherTracker1";

        WeatherTracker1 localSource = (WeatherTracker1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();

    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public Map<String, String> fetchWeatherData(String location) {

        return this.rep.value(location);
    }

    @Override
    public void addLocation(String newLocation) {
        Map<String, String> weatherData = this.retrieveWeatherData(newLocation);
        this.rep.add(newLocation, weatherData);

    }

    @Override
    public WeatherTracker removeLocation(String location) {

        WeatherTracker temp = this.newInstance();
        Pair<String, Map<String, String>> weatherData = this.rep
                .remove(location);

        WeatherTracker1 localSource = (WeatherTracker1) temp;
        localSource.rep.add(weatherData.key(), weatherData.value());
        return temp;
    }

    @Override
    public WeatherTracker removeAnyLocation() {

        /*
         * Create iterator object.
         */
        Iterator<Pair<String, Map<String, String>>> it = this.rep.iterator();
        Pair<String, Map<String, String>> entry = it.next();
        WeatherTracker temp = this.removeLocation(entry.key());
        return temp;
    }

    @Override
    public int numberOfTrackedLocation() {

        return this.rep.size();
    }

    @Override
    public boolean isTracked(String location) {

        return this.rep.hasKey(location);
    }

    @Override
    public String location() {
        Pair<String, Map<String, String>> temp = this.rep.removeAny();
        String location = temp.key();
        this.rep.add(location, temp.value());
        return location;
    }

    @Override
    public Iterator<Pair<String, Map<String, String>>> iterator() {
        return this.rep.iterator();
    }

}
