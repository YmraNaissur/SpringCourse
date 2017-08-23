package learning.generics.oneParameter;

/**
 * naissur
 * 23.08.2017
 */
class Gen<T> {
    private T ob;

    // Конструктор
    Gen(T ob) {
        this.ob = ob;
    }

    // Возвращаем значение объекта типа T
    T getOb() {
        return ob;
    }

    // Возвращаем имя класса объекта типа T
    String getObClassName() {
        return "Класс объекта: " + ob.getClass().getName();
    }
}