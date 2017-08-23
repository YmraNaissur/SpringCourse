package learning.generics.twoParameters;

/**
 * naissur
 * 23.08.2017
 */
class TwoGen<T, V> {
    private T ob1;
    private V ob2;

    // Конструктор
    TwoGen(T ob1, V ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }

    // Возвращаем строку со значениями объектов
    String getValues() {
        return "ob1 = " + ob1 + "; ob2 = " + ob2;
    }

    // Возвращаем строку с типами объектов
    String getTypes() {
        return "Тип ob1: " + ob1.getClass().getName() + "; тип ob2: " + ob2.getClass().getName();
    }
}