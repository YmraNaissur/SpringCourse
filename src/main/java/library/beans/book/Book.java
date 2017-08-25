package library.beans.book;

/**
 * naissur
 * 25.08.2017
 * Класс, инкапсулирующий информацию о книге. Пока только id и название.
 * Позже добавлю остальную информацию.
 */
public class Book {
    private int id;
    private String name;

    public Book() {
        // Конструктор по умолчанию
    }

    Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}