import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Library {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new BookBuilder()
                .setAuthor("James Cook")
                .setYearOfPublication(1770)
                .setTitle("A voyage to the Pacific Ocean")
                .setCategory(Category.adventure)
                .getBook());
        books.add(new BookBuilder()
                .setAuthor("Stanisław Wyspiański")
                .setYearOfPublication(1901)
                .setCategory(Category.history)
                .setTitle("Wesele")
                .getBook());
        books.add(new BookBuilder()
                .setTitle("Sherlock Holmes")
                .setYearOfPublication(1998)
                .setAuthor("Arthura Conana Doyle")
                .getBook());
        books.add(new BookBuilder()
                .setTitle("Potop")
                .setAuthor("Henryk Sienkiewicz")
                .setYearOfPublication(2003)
                .setCategory(Category.history)
                .getBook());
        books.add(new BookBuilder()
                .setCategory(Category.adventure)
                .setYearOfPublication(2001)
                .setTitle("Jakiśtam")
                .setAuthor("Jan Kowalski")
                .getBook());

        System.out.println("books before 2000:");
        books.stream()
                .filter(b -> b.getYearOfPublication() < 2000)
                .forEach(b -> System.out.println(b.presentBook()));
        System.out.println();

        System.out.println("books' titles of authors whose names starts with S:");
        books.stream()
                .filter(b -> b.getAuthor().startsWith("S"))
                .map(b -> b.getTitle())
                .forEach(t -> System.out.println("title: " + t));
        System.out.println();

        System.out.println("The eraliest book:");
        books.stream()
                .reduce((b1, b2) -> b1.getYearOfPublication() < b2.getYearOfPublication() ? b1 : b2)
                .ifPresent(b -> System.out.println(b.presentBook()));

        System.out.println();
        System.out.println("The latest history book:");
        books.stream()
                .filter(b -> b.getCategory().equals(Category.history))
                .reduce((b1, b2) -> b1.getYearOfPublication() < b2.getYearOfPublication() ? b1 : b2)
                .ifPresent(b -> System.out.println(b.presentBook()));
        System.out.println();

        System.out.println("an example adventure book:");
        books.stream()
                .filter(b -> b.getCategory().equals(Category.adventure))
                .findAny()
                .ifPresent(b -> System.out.println(b.presentBook()));

        HashMap<Category, List<Book>> categorizedBooks = new HashMap<>();
        for (Category category : Category.values()) {
            categorizedBooks.put(category, books.stream()
                    .filter(b -> b.getCategory().equals(category))
                    .collect(toList()));
        }
        System.out.println();
        for (Category category : Category.values()) {
            System.out.println(category.toString() + ":");
            categorizedBooks.get(category).forEach(b -> System.out.println(b.presentBook()));
        }
    }
}
