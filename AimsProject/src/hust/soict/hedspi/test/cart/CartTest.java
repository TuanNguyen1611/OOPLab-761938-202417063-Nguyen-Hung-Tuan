package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book(1, "Java Basic", "Programming", 15.5f);
        book.addAuthor("Author A");

        CompactDisc cd = new CompactDisc(
                "Greatest Hits", "Music", 18.0f, "Director X", "Artist Y");
        cd.addTrack(new Track("Track 1", 4));
        cd.addTrack(new Track("Track 2", 5));

        cart.addMedia(dvd);
        cart.addMedia(book);
        cart.addMedia(cd);

        cart.print();

        cart.searchById(dvd.getId());
        cart.searchByTitle("Java");

        cart.playMedia(dvd);
        cart.playMedia(cd);
        cart.playMedia(book);
    }
}