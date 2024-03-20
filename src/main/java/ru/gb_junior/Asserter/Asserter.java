package ru.gb_junior.Asserter;

import ru.gb_junior.Colors;

public class Asserter {

    public static void assertEquals(int expected, int actual) throws AssertionMessage {
        if (expected == actual) {
            throw new AssertionMessage(Colors.GREEN + "ОК" + Colors.RESET);
        } else {
            throw new AssertionMessage(
                    String.format(Colors.RED + "Ожидается %d, фактический %d" + Colors.RESET, expected, actual));
        }
    }
}
