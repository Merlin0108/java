package lab4;


class Book {
    private String title;
    private String author;

    public Book() {
        this.title = "";
        this.author = "";
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}