package week9;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HomeController {
    @FXML
    private Label nickNameLabel;
    @FXML
    private Label fullNameLabel;
    @FXML
    private ImageView profileImageView;
    @FXML
    private HBox postContainer;//untuk menampung postingan (gambar)
    private User user;
    private List<Post> posts = new ArrayList<>();

    public void setUser(User user) {
        this.user = user;

        //informasi user ke ui
        nickNameLabel.setText("Nickname: " + user.getNickName());
        fullNameLabel.setText("Full Name: " + user.getFullName());
        profileImageView.setImage(user.getProfileImage());
        // Membuat gambar profil bulat
        double radius = Math.min(profileImageView.getFitWidth(), profileImageView.getFitHeight()) / 2;
        Circle clip = new Circle(
                profileImageView.getFitWidth() / 2,
                profileImageView.getFitHeight() / 2,
                radius);
        profileImageView.setClip(clip);
    }

    @FXML
    private void handleAddPost() {
        //jendela utk choose picture
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            //caption user input
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Input Caption");
            dialog.setHeaderText("Masukkan caption untuk gambar");
            dialog.setContentText("Caption:");

            //jika caption diisi , buat postingan
            dialog.showAndWait().ifPresent(caption -> {
                Image image = new Image(file.toURI().toString());
                Post post = new Post(caption, image);//buat objek  postingan 
                posts.add(post);//simpan ke daftar 
                displayPost(post);//show at UI
            });
        }
    }

    private void displayPost(Post post) {
        ImageView imageView = new ImageView(post.getPostImage());
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        //efek mouse saat masuk
        imageView.setOnMouseEntered((MouseEvent event) -> {
            imageView.setOpacity(0.7);//transparan dkit
            javafx.scene.control.Tooltip tooltip = new javafx.scene.control.Tooltip(post.getCaption());
            javafx.scene.control.Tooltip.install(imageView, tooltip);//show capt
        });
        //efek saat keluar
        imageView.setOnMouseExited((MouseEvent event) -> {
            imageView.setOpacity(1.0);
            javafx.scene.control.Tooltip.uninstall(imageView, null);//delete tooltip
        });
        postContainer.getChildren().add(imageView);//add tampilan
    }
}