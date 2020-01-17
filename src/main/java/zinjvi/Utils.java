package zinjvi;

public class Utils {
    public static void assertTrue(boolean shouldBeTrue) {
        if (!shouldBeTrue) throw new RuntimeException("It is not 'true'");
    }
}
