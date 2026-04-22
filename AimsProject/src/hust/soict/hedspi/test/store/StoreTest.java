package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book(1, "Java Basic", "Programming", 15.5f);
        book.addAuthor("Author A");

        CompactDisc cd = new CompactDisc(
                "Greatest Hits", "Music", 18.0f, "Director X", "Artist Y");
        cd.addTrack(new Track("Track 1", 4));
        cd.addTrack(new Track("Track 2", 5));

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        store.printStore();

        store.removeMedia(book);
        store.printStore();
    }
}