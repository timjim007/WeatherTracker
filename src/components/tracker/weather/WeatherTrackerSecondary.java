package components.tracker.weather;

import java.util.Iterator;

import components.map.Map;
import components.map.Map.Pair;
import components.set.Set;
import components.set.Set2;

public abstract class WeatherTrackerSecondary implements WeatherTracker {

    @Override
    public final Set<String> trackedLocations() {

        Set<String> setOfLocations = new Set2<>();

        /*
         * Create iterator object.
         */
        Iterator<Pair<String, Map<String, String>>> it = this.iterator();

        while (it.hasNext()) {
            Pair<String, Map<String, String>> entry = it.next();
            setOfLocations.add(entry.key());
        }

        return setOfLocations;

    }

    @Override
    public final void updateWeatherData() {
        WeatherTracker temp = this.newInstance();

        while (this.numberOfTrackedLocation() > 0) {
            WeatherTracker removed = this.removeAnyLocation();
            temp.addLocation(removed.location());
        }
        this.transferFrom(temp);

    }

    @Override
    public final String getWeatherInfo(String location,
            String whatInformation) {
        assert this.isTracked(location) == true;

        Map<String, String> weatherData = this.fetchWeatherData(location);

        return weatherData.value(whatInformation);

    }

    @Override
    public final String toString() {
        String result = "";
        Iterator<Pair<String, Map<String, String>>> it = this.iterator();
        while (it.hasNext()) {
            Pair<String, Map<String, String>> entry = it.next();
            result = result + "\n" + entry.toString();
        }
        return result;
    }

}
