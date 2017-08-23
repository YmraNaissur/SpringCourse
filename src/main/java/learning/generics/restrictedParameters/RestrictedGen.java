package learning.generics.restrictedParameters;

/**
 * naissur
 * 23.08.2017
 */
class RestrictedGen<T extends Number> {
    private T[] array;

    // Конструктор
    RestrictedGen(T[] array) {
        this.array = array;
    }

    // Метод, возвращающий среднее арифметическое чисел в массиве
    Double getAverage() {
        Double sum = 0.0;
        for (Number n : array) {
            sum += n.doubleValue();
        }
        return sum / array.length;
    }
}