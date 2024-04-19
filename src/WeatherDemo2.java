import components.set.Set;
import components.simplewriter.SimpleWriter;
import components.tracker.weather.WeatherTracker;

/**
 *
 * Use case of Weather component.
 *
 * @author Timothy Jimoh
 */
public final class WeatherDemo2 {

    private WeatherTracker tracker;

    /**
     * No argument constructor--private to prevent instantiation.
     */
    @SuppressWarnings("unused")
    private WeatherDemo2() {

    }

    public WeatherDemo2(WeatherTracker trackedWeather) {
        this.tracker = trackedWeather;
    }

    public String getTemp(String location) {
        return this.tracker.getWeatherInfo(location, "temperature");
    }

    public String getCondition(String location) {
        return this.tracker.getWeatherInfo(location, "Condition");
    }

    public void printWeatherInfo(SimpleWriter out) {
        Set<String> locations = this.tracker.trackedLocations();
        while (locations.size() > 0) {
            String location = locations.removeAny();
            out.print(
                    location + ": " + this.tracker.fetchWeatherData(location));
        }

    }

}
