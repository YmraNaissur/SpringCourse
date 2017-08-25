package library.beans.Genre;

/**
 * naissur
 * 25.08.2017
 * Класс инкапсулирует информацию о жанрах
 */
public class Genre {
    private int id;
    private String name;

    public Genre() {
        // Конструктор по умолчанию
    }

    Genre(int id, String name) {
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