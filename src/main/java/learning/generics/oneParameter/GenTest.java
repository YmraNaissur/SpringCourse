package learning.generics.oneParameter;

/**
 * naissur
 * 23.08.2017
 */
public class GenTest {
    public static void main(String[] args) {
        // Создадим объект параметризованного класса типа Integer
        Gen<Integer> intOb = new Gen<>(100);
        // Выведем его значение и информацию об имени класса
        System.out.println(intOb.getOb());
        System.out.println(intOb.getObClassName());

        // Создадим объект параметризованного класса типа String
        Gen<String> strOb = new Gen<>("Тестовая строка");
        // Выведем его значение и информацию об имени класса
        System.out.println(strOb.getOb());
        System.out.println(strOb.getObClassName());
    }
}