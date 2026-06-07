package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, Integer> colMediaId;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;

    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label costLabel;

    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    private Cart cart;
    private Store store;

    private ObservableList<Media> items;
    private FilteredList<Media> filteredItems;

    public CartController() {
        this.cart = new Cart();
        this.store = new Store();
    }

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    public void initialize() {
        items = FXCollections.observableArrayList(cart.getItemsOrdered());
        filteredItems = new FilteredList<>(items, p -> true);

        tblMedia.setItems(filteredItems);

        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                updateButtonBar(newSelection);
            }
        });

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });

        radioBtnFilterId.setOnAction(e -> showFilteredMedia(tfFilter.getText()));
        radioBtnFilterTitle.setOnAction(e -> showFilteredMedia(tfFilter.getText()));

        updateTotalCost();
    }

    private void showFilteredMedia(String filter) {
        if (filter == null || filter.trim().isEmpty()) {
            filteredItems.setPredicate(media -> true);
            return;
        }

        String lowerFilter = filter.toLowerCase();

        filteredItems.setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerFilter);
            }

            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerFilter);
            }

            return true;
        });
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void updateTotalCost() {
        costLabel.setText(cart.totalCost() + " $");
    }

    @FXML
    void btnRemovePressed() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            items.remove(selectedMedia);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlayPressed() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Play");
                alert.setHeaderText(null);
                alert.setContentText("Playing: " + selectedMedia.getTitle());
                alert.showAndWait();

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"
            ));

            loader.setController(new ViewStoreController(store, cart));

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("AIMS Store");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlaceOrderPressed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText(null);
        alert.setContentText("An order is created.");
        alert.showAndWait();

        for (Media media : FXCollections.observableArrayList(cart.getItemsOrdered())) {
            cart.removeMedia(media);
        }

        items.clear();
        updateTotalCost();
    }
}