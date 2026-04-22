package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        initStore(store);

        int choice;
        do {
            showMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    viewStore(store, cart);
                    break;
                case 2:
                    updateStore(store);
                    break;
                case 3:
                    seeCurrentCart(cart);
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Media details:");
        System.out.println(media.toString());
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof Playable) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number:");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void viewStore(Store store, Cart cart) {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    seeMediaDetails(store, cart);
                    break;
                case 2:
                    addMediaToCartFromStore(store, cart);
                    break;
                case 3:
                    playMediaInStore(store);
                    break;
                case 4:
                    seeCurrentCart(cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails(Store store, Cart cart) {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        int choice;
        do {
            mediaDetailsMenu(media);
            choice = readInt();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addMediaToCartFromStore(Store store, Cart cart) {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        cart.addMedia(media);
        System.out.println("Current number of items in cart: " + cart.getItemsOrdered().size());
    }

    private static void playMediaInStore(Store store) {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void updateStore(Store store) {
        int choice;
        do {
            System.out.println("Update Store Options:");
            System.out.println("--------------------------------");
            System.out.println("1. Add media");
            System.out.println("2. Remove media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    Media mediaToAdd = createMedia();
                    if (mediaToAdd != null) {
                        store.addMedia(mediaToAdd);
                    }
                    break;
                case 2:
                    System.out.print("Enter media title to remove: ");
                    String title = scanner.nextLine();
                    Media mediaToRemove = store.searchByTitle(title);
                    if (mediaToRemove != null) {
                        store.removeMedia(mediaToRemove);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void seeCurrentCart(Cart cart) {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    filterMediaInCart(cart);
                    break;
                case 2:
                    sortMediaInCart(cart);
                    break;
                case 3:
                    removeMediaFromCart(cart);
                    break;
                case 4:
                    playMediaInCart(cart);
                    break;
                case 5:
                    placeOrder(cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void filterMediaInCart(Cart cart) {
        System.out.println("Filter Options:");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.print("Choose: ");
        int choice = readInt();

        switch (choice) {
            case 1:
                System.out.print("Enter id: ");
                int id = readInt();
                cart.searchById(id);
                break;
            case 2:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void sortMediaInCart(Cart cart) {
        System.out.println("Sort Options:");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.print("Choose: ");
        int choice = readInt();

        switch (choice) {
            case 1:
                cart.sortByTitleCost();
                cart.print();
                break;
            case 2:
                cart.sortByCostTitle();
                cart.print();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void removeMediaFromCart(Cart cart) {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();

        ArrayList<Media> found = cart.filterByTitle(title);
        if (found.isEmpty()) {
            System.out.println("Media not found in cart.");
            return;
        }

        cart.removeMedia(found.get(0));
    }

    private static void playMediaInCart(Cart cart) {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();

        ArrayList<Media> found = cart.filterByTitle(title);
        if (found.isEmpty()) {
            System.out.println("Media not found in cart.");
            return;
        }

        cart.playMedia(found.get(0));
    }

    private static void placeOrder(Cart cart) {
        System.out.println("An order has been created.");
        cart.emptyCart();
    }

    private static Media createMedia() {
        System.out.println("Choose media type:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.print("Choose: ");
        int choice = readInt();

        switch (choice) {
            case 1:
                return createBook();
            case 2:
                return createDVD();
            case 3:
                return createCD();
            default:
                System.out.println("Invalid media type.");
                return null;
        }
    }

    private static Book createBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = readFloat();

        Book book = new Book(title, category, cost);

        System.out.print("Enter number of authors: ");
        int n = readInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter author " + (i + 1) + ": ");
            String author = scanner.nextLine();
            book.addAuthor(author);
        }

        return book;
    }

    private static DigitalVideoDisc createDVD() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter director: ");
        String director = scanner.nextLine();
        System.out.print("Enter length: ");
        int length = readInt();
        System.out.print("Enter cost: ");
        float cost = readFloat();

        return new DigitalVideoDisc(title, category, director, length, cost);
    }

    private static CompactDisc createCD() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = readFloat();
        System.out.print("Enter director: ");
        String director = scanner.nextLine();
        System.out.print("Enter artist: ");
        String artist = scanner.nextLine();

        CompactDisc cd = new CompactDisc(title, category, cost, director, artist);

        System.out.print("Enter number of tracks: ");
        int n = readInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter track title " + (i + 1) + ": ");
            String trackTitle = scanner.nextLine();
            System.out.print("Enter track length " + (i + 1) + ": ");
            int trackLength = readInt();
            cd.addTrack(new Track(trackTitle, trackLength));
        }

        return cd;
    }

    private static void initStore(Store store) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        Book book1 = new Book("Java Programming", "Education", 15.50f);
        book1.addAuthor("Author A");
        book1.addAuthor("Author B");

        CompactDisc cd1 = new CompactDisc(
                "Greatest Hits", "Music", 18.0f, "Director X", "Artist Y");
        cd1.addTrack(new Track("Track 1", 4));
        cd1.addTrack(new Track("Track 2", 5));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);
    }

    private static int readInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }

    private static float readFloat() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Float.parseFloat(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}