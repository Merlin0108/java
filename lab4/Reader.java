package lab4;

class Reader {
    private String name;
    private Book book;
    private int returnDay;
    private int returnMonth;

    public Reader() {
        this.name = "";
        this.book = new Book();
        this.returnDay = 0;
        this.returnMonth = 0;
    }

    public Reader(String name, Book book, int returnDay, int returnMonth) {
        this.name = name;
        this.book = book;
        this.returnDay = returnDay;
        this.returnMonth = returnMonth;
    }

    public Reader(Reader other) {
        this.name = other.name;
        this.book = new Book(other.book);
        this.returnDay = other.returnDay;
        this.returnMonth = other.returnMonth;
    }

    public String getName() {
        return name;
    }

    public Book getBook() {
        return book;
    }

    public int getReturnDay() {
        return returnDay;
    }

    public int getReturnMonth() {
        return returnMonth;
    }

    public boolean isBookReturnedOnTime(int dueDay, int dueMonth) {
        if (this.returnMonth < dueMonth) {
            return true;
        } else if (this.returnMonth > dueMonth) {
            return false;
        } else {
            return this.returnDay <= dueDay;
        }
    }
}