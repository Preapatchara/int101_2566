package work01Utilitor;

import work02Person.Person;

public class Utilitor {
    public static String testString(String value) {
        if(value == null) throw new NullPointerException();
        if(value.isBlank()) throw new IllegalArgumentException();
        return value.trim();
    }

    public static Person testPerson(Person owner) {
        if(owner == null) throw new NullPointerException();
        return owner;
    }

    public static double testPositive(double value) {
        if(value < 0) throw new IllegalArgumentException();
        return value;
    }

    public static int computeIsbn10(long value) {
        int sum = 0;
        for(int i=2; i<=10; i++) {
            int digit = (int)value % 10;
            sum += digit*i;
            value /= 10;
        }
        return (11 - (sum%11)) %11;
    }
}
