import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book {
    private String title;
    private int pageCount;
    private String author;
    private LocalDate publicationDate;

    public Book(String title, int pageCount, String author, LocalDate publicationDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }
    
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}

public class Main {
    public static void main(String[] args) {
        // 10 tane Book nesnesi oluşturulması
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Kitap 1", 150, "Yazar 1", LocalDate.of(2021, 1, 1)));
        bookList.add(new Book("Kitap 2", 200, "Yazar 2", LocalDate.of(2021, 2, 2)));
        bookList.add(new Book("Kitap 3", 100, "Yazar 3", LocalDate.of(2021, 3, 3)));
        bookList.add(new Book("Kitap 4", 250, "Yazar 4", LocalDate.of(2021, 4, 4)));
        bookList.add(new Book("Kitap 5", 180, "Yazar 5", LocalDate.of(2021, 5, 5)));
        bookList.add(new Book("Kitap 6", 120, "Yazar 6", LocalDate.of(2021, 6, 6)));
        bookList.add(new Book("Kitap 7", 300, "Yazar 7", LocalDate.of(2021, 7, 7)));
        bookList.add(new Book("Kitap 8", 220, "Yazar 8", LocalDate.of(2021, 8, 8)));
        bookList.add(new Book("Kitap 9", 130, "Yazar 9", LocalDate.of(2021, 9, 9)));
        bookList.add(new Book("Kitap 10", 180, "Yazar 10", LocalDate.of(2021, 10, 10)));

        // Kitap ismi karşısında yazar ismi olan Map oluşturulması
        Map<String, String> titleAuthorMap = bookList.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getAuthor));

        System.out.println("Kitaplar ve Yazarlar:");
        titleAuthorMap.forEach((title, author) -> System.out.println(title + " - " + author));

        // Sayfa sayısı 100'den fazla olan kitapların filtrelenip yeni bir liste olarak alınması
        List<Book> filteredBooks = bookList.stream()
                .filter(book -> book.getPageCount() > 100)
                .collect(Collectors.toList());

        System.out.println("\nSayfa sayısı 100'den fazla olan kitaplar:");
        filteredBooks.forEach(book -> System.out.println(book.getTitle()));
    }
}
