import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temperature {

    public interface TemperatureScale {
        double convert(double temperature);
    }

    // Part A - Already done for you
    public static TemperatureScale createF2C() {
        return new TemperatureScale() {
            public double convert(double temperature) {
                return (temperature - 32) / 1.8;
            }
        };
    }

    // Part B - Fill in lambda expression
    public static TemperatureScale createC2F() {
        TemperatureScale c2F = temperature -> temperature * 1.8 + 32;
        return c2F;
    }

    public static void main(String[] args) {

        TemperatureScale c2F = createC2F();
        TemperatureScale f2C = createF2C();

        List<Double> temps = Arrays.asList(0.0, 32.0, 12.3, 45.6, -12.0);

        List<Double> celsiusTemps = new ArrayList<>();
        List<Double> fahrenheitTemps = new ArrayList<>();

        // Part C - Fill in temperature conversions
        for (double temp : temps) {
            fahrenheitTemps.add(c2F.convert(temp));
            celsiusTemps.add(f2C.convert(temp));
        }

        // Part D - Print all Fahrenheit temps above freezing (32F)
        fahrenheitTemps.stream()
                .filter(temp -> temp > 32)
                .forEach(System.out::println);

        // Part E - Print all Celsius temps below freezing (0C)
        celsiusTemps.stream()
                .filter(temp -> temp < 0)
                .forEach(System.out::println);
    }
}
