package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
    }

    @Override
    protected void addExtraFields(JPanel center) {
        // Book lab04 chỉ cần title, category, cost là đủ đơn giản
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        Book book = new Book(title, category, cost);
        store.addMedia(book);

        JOptionPane.showMessageDialog(this, "Book added successfully!");

        dispose();
        new StoreManagerScreen(store);
    }
}