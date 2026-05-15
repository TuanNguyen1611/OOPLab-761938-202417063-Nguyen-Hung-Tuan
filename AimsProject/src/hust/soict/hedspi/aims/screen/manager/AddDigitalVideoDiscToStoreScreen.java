package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");
    }

    @Override
    protected void addExtraFields(JPanel center) {
        center.add(new JLabel("Director"));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Length"));
        tfLength = new JTextField();
        center.add(tfLength);
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                title,
                category,
                director,
                length,
                cost
        );

        store.addMedia(dvd);

        JOptionPane.showMessageDialog(this, "DVD added successfully!");

        dispose();
        new StoreManagerScreen(store);
    }
}