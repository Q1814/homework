import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class LibrarySystem {

    private ArrayList<Book> bookList = new ArrayList<>();
    private HashSet<String> genres = new HashSet<>();
    private HashMap<Integer, Book> bookMap = new HashMap<>();


    public void addBook(Book book) {
        bookList.add(book);
        genres.add(book.getGenre());
        bookMap.put(book.getId(), book);
    }


    public void removeBooksByKeyword(String keyword) {
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().contains(keyword)) {

                bookMap.remove(book.getId());

                iterator.remove();


                boolean genreHasBooks = false;
                for (Book b : bookList) {
                    if (b.getGenre().equals(book.getGenre())) {
                        genreHasBooks = true;
                        break;
                    }
                }
                if (!genreHasBooks) {
                    genres.remove(book.getGenre());
                }
            }
        }
    }


    public void displayStatus() {
        System.out.println("\n=== 图书馆状态 ===");
        System.out.println("1. 书籍列表（ArrayList）：" + bookList);
        System.out.println("2. 唯一流派（HashSet）：" + genres);
        System.out.println("3. 书籍ID映射（HashMap）：" + bookMap);
    }


    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook(new Book(1, "Java编程思想", "编程"));
        library.addBook(new Book(2, "三体", "科幻"));

        library.displayStatus();

        library.removeBooksByKeyword("Java");

        library.displayStatus();
    }
}