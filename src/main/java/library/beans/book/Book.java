package library.beans.book;

import java.sql.Blob;

/**
 * naissur
 * 25.08.2017
 * Класс, инкапсулирующий информацию о книге. Пока только id и название.
 * Позже добавлю остальную информацию.
 */
public class Book {
    private int id; // ИД
    private String name;    // Название книги
    private int pageCount;  // Количество страниц
    private String isbn;    // ISBN книги
    private Blob image; // Изображение обложки книги

    public Book() {
        // Конструктор по умолчанию
    }

    Book(int id, String name, int pageCount, String isbn, Blob image) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.image = image;
    }

    // Геттеры и сеттеры для полей

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

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}