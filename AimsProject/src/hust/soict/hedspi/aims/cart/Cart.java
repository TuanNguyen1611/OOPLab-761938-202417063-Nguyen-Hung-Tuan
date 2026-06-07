package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public Cart() {
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("The media is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media has been added.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed.");
        } else {
            System.out.println("The media was not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Search result by ID:");
                System.out.println(media.toString());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No media found with id = " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("Search result by title:");
        for (Media media : itemsOrdered) {
            if (media.getTitle() != null &&
                    media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(media.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media found with title = " + title);
        }
    }

    public Media filterById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> filterByTitle(String title) {
        ArrayList<Media> result = new ArrayList<Media>();
        for (Media media : itemsOrdered) {
            if (media.getTitle() != null &&
                    media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(media);
            }
        }
        return result;
    }

    public void playMedia(Media media) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("The cart is now empty.");
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The cart has been sorted by title then cost.");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The cart has been sorted by cost then title.");
    }
}