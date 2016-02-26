import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class BookTest {

	@Test
	public void sortBooks() {
		Book[] books = { new Book("foo", "1", "author1", "pub1"),
				new Book("bar", "2", "author2", "pub2"),
				null};

		
		Arrays.sort(books, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.id.compareTo(o2.id);
			}
		});
		System.out.println(Arrays.asList(books));
	}
}