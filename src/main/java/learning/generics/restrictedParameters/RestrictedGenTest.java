package learning.generics.restrictedParameters;

/**
 * naissur
 * 23.08.2017
 * Демонстрация работы параметризованного класса с ограниченным типом
 */
public class RestrictedGenTest {
    public static void main(String[] args) {
        // Объявляем массивы с числами типа Integer и Double
        Integer[] iArray = {1, 2, 3, 4, 5};
        Double[] dArray = {1.1, 2.2, 3.3, 4.4, 5.5};

        // Создаем объекты параметризованного класса
        RestrictedGen<Integer> integerRestrictedGen = new RestrictedGen<>(iArray);
        RestrictedGen<Double> doubleRestrictedGen = new RestrictedGen<>(dArray);

        // Выводим средние арифметические
        System.out.println("Среднее арифметическое массива Integer: " + integerRestrictedGen.getAverage());
        System.out.println("Среднее арифметическое массива Double: " + doubleRestrictedGen.getAverage());
    }
}