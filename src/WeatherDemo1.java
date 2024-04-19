import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.tracker.weather.WeatherTracker;
import components.tracker.weather.WeatherTracker1;

/**
 * Use case of Weather component.
 *
 * @author Timothy Jimoh
 */
public final class WeatherDemo1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private WeatherDemo1() {
    }

    /**
     * Get command from user.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return the command entered by the user
     * @updates in.content
     * @updates out.content
     * @requires in.is_open and out.is_open
     * @ensures <pre>
     * [displays a menu of available commands, prompts the user to
     *   enter a command, inputs and returns the command]
     * </pre>
     */
    private static String getCommand(SimpleReader in, SimpleWriter out) {

        out.println();
        out.println("Command: a [Add location]");
        out.println("         r [Remove location]");
        out.println("         t [Tracked locations]");
        out.println("         w [Weather information for tracked location]");
        out.println("         u [Update weather for tracked locations]");
        out.print("         q [quit]: ");
        return in.nextLine();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Create Weather tracker object
         */
        WeatherTracker tracker = new WeatherTracker1();

        String command = getCommand(in, out);
        while (!command.equals("q")) {
            out.println();
            if (command.equals("a")) {
                out.print("Enter Location to track its weather: ");
                tracker.addLocation(in.nextLine());

            } else if (command.equals("r")) {
                out.print("Enter Location to remove: ");
                tracker.removeLocation(in.nextLine());

            } else if (command.equals("t")) {
                out.println(tracker.trackedLocations());

            } else if (command.equals("w")) {
                out.print("Enter a location: ");
                String location = in.nextLine().toLowerCase();
                out.print("Enter information you need: ");
                String whatInformation = in.nextLine().toLowerCase();

                out.println();
                out.println(tracker.getWeatherInfo(location, whatInformation));

            } else if (command.equals("u")) {
                tracker.updateWeatherData();

            } else {
                out.println(command);
            }
            command = getCommand(in, out);
        }

        in.close();
        out.close();
    }

}
