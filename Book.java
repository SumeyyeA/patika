import java.util.*;

public class Book implements Comparable<Book> {
    private String title;
    private int pageCount;
    private String author;
    private String publicationDate;

    public Book(String title, int pageCount, String author, String publicationDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.title.compareTo(otherBook.getTitle()); // İsme göre sıralama
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", pageCount=" + pageCount + ", author=" + author + ", publicationDate="
                + publicationDate + "]";
    }

    public static void main(String[] args) {
        // Kitapların isme göre sıralanması
        Set<Book> bookSetByName = new TreeSet<>();
        bookSetByName.add(new Book("Book D", 250, "Author D", "2021-01-01"));
        bookSetByName.add(new Book("Book A", 150, "Author A", "2021-01-03"));
        bookSetByName.add(new Book("Book C", 300, "Author C", "2021-01-02"));
        bookSetByName.add(new Book("Book B", 200, "Author B", "2021-01-04"));
        bookSetByName.add(new Book("Book E", 350, "Author E", "2021-01-05"));

        System.out.println("Kitaplar isme göre sıralanmıştır:");
        for (Book book : bookSetByName) {
            System.out.println(book);
        }

        // Kitapların sayfa sayısına göre sıralanması
        Set<Book> bookSetByPageCount = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Integer.compare(book1.getPageCount(), book2.getPageCount());
            }
        });

        bookSetByPageCount.addAll(bookSetByName);

        System.out.println("Kitaplar sayfa sayısına göre sıralanmıştır:");
        for (Book book : bookSetByPageCount) {
            System.out.println(book);
        }
    }
}
