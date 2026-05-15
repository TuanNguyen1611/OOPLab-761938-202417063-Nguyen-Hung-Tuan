package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfDirector;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");
    }

    @Override
    protected void addExtraFields(JPanel center) {
        center.add(new JLabel("Director"));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Artist"));
        tfArtist = new JTextField();
        center.add(tfArtist);
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        String artist = tfArtist.getText();

        CompactDisc cd = new CompactDisc(title, category, cost, director, artist);

        store.addMedia(cd);

        JOptionPane.showMessageDialog(this, "CD added successfully!");

        dispose();
        new StoreManagerScreen(store);
    }
}