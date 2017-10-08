public class Book {
    private String title;
    private int yearOfPublication;
    private String author;
    private Category category;

    public Book(String title, int yearOfPublication, String author, Category category) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public String presentBook() {
        return String.format("Category: %s, title: %s, author: %s, publication year: %d", category, title, author, yearOfPublication);
    }
}
