package library.beans.book;

import java.sql.Blob;
import java.sql.Date;

/**
 * naissur
 * 25.08.2017
 * Класс, инкапсулирующий информацию о книге.
 */
public class Book {
    private int id; // ИД
    private String name;    // Название книги
    private Blob content;   // Содержимое книги
    private int pageCount;  // Количество страниц
    private String isbn;    // ISBN книги
    private String genre;   // Жанр
    private String author;  // Автор
    private Date publishYear;   // Год выпуска
    private String publisher;   // Издатель
    private Blob image; // Изображение обложки книги

    public Book() {
        // Конструктор по умолчанию
    }

    Book(int id, String name, Blob content, int pageCount, String isbn,
            String genre, String author, Date publishYear, String publisher, Blob image) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publishYear = publishYear;
        this.publisher = publisher;
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

    Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "{(" + id + ") " + name + ", жанр - " + genre + ", автор - " + author + "}";
    }
}