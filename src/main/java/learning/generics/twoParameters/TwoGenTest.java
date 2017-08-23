package learning.generics.twoParameters;

/**
 * naissur
 * 23.08.2017
 */
public class TwoGenTest {
    public static void main(String[] args) {
        TwoGen<Double, String> twoGenObj = new TwoGen<>(25.5, "Тестовая строка");

        // Выводим значения объектов из TwoGenObj
        System.out.println(twoGenObj.getValues());
        // Выводим типы объектов из TwoGenObj
        System.out.println(twoGenObj.getTypes());
    }
}