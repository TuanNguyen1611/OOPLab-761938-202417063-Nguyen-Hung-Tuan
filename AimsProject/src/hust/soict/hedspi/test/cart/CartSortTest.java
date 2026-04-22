package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class CartSortTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "Aladdin", "Animation", "Director A", 90, 18.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book = new Book(1, "Java Basic", "Programming", 15.50f);

        CompactDisc cd = new CompactDisc(
                "Aladdin", "Music", 20.00f, "Director X", "Artist Y");
        cd.addTrack(new Track("Track 1", 4));
        cd.addTrack(new Track("Track 2", 5));

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(book);
        cart.addMedia(cd);

        System.out.println("===== Original cart =====");
        cart.print();

        System.out.println("===== Sort by title then cost =====");
        cart.sortByTitleCost();
        cart.print();

        System.out.println("===== Sort by cost then title =====");
        cart.sortByCostTitle();
        cart.print();
    }
}