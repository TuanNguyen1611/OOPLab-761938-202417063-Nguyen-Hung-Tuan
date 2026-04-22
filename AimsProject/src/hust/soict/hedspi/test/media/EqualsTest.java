package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class EqualsTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Aladdin");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin");
        System.out.println("dvd1 equals dvd2: " + dvd1.equals(dvd2));

        Book book1 = new Book(1, "Java", "Programming", 10.0f);
        Book book2 = new Book(2, "Java", "Education", 20.0f);
        System.out.println("book1 equals book2: " + book1.equals(book2));

        Track track1 = new Track("Track A", 4);
        Track track2 = new Track("Track A", 4);
        Track track3 = new Track("Track A", 5);

        System.out.println("track1 equals track2: " + track1.equals(track2));
        System.out.println("track1 equals track3: " + track1.equals(track3));
    }
}