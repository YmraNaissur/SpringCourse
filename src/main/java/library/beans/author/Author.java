package library.beans.author;

/**
 * naissur
 * 25.08.2017
 * Класс, инкапсулирующий информацию об авторе. Пока только id и имя.
 * Позже добавлю день рождения.
 */
public class Author {
    private int id;
    private String name;

    public Author() {
        // Конструктор по умолчанию
    }

    Author(int id, String name) {
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

    @Override
    public String toString() {
        return "{(" + id + ") " + name + "}";
    }
}