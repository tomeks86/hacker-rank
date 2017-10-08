public class BookBuilder {
    private String title = "unknown";
    private int yearOfPublication = 0;
    private String author = "unknown";
    private Category category = Category.none;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Book getBook() {
        return new Book(title, yearOfPublication, author, category);
    }
}
