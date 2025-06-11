package week9;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class RegisterController {
    @FXML
    private TextField nickNameField;
    @FXML
    private TextField fullNameField;
    @FXML
    private ImageView profileImageView;
    private Image profileImage;
    @FXML
    private void handleUpload() {
        //buka jendela file chooser utk plih gambar
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            //buat image dari file dan tampilkan di imageview
            profileImage = new Image(file.toURI().toString());
            profileImageView.setImage(profileImage);
            // limgkaran profil
            double radius = Math.min(profileImageView.getFitWidth(), profileImageView.getFitHeight()) / 2;
            Circle clip = new Circle(
                    profileImageView.getFitWidth() / 2,
                    profileImageView.getFitHeight() / 2,
                    radius);
            profileImageView.setClip(clip);
        }
    }
    @FXML
private void handleRegister() throws Exception {
    System.out.println("Tombol Register diklik"); // log
    if (nickNameField.getText().isEmpty() || fullNameField.getText().isEmpty() || profileImage == null) {
        System.out.println("Isi semua field dan upload foto dulu!");
        return;
    }

    User user = new User(nickNameField.getText(), fullNameField.getText(), profileImage);
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
    Stage stage = (Stage) nickNameField.getScene().getWindow();
    Scene scene = new Scene(loader.load());

    HomeController homeController = loader.getController();
    homeController.setUser(user);

    stage.setScene(scene);
    System.out.println("Pindah ke halaman Home berhasil!");
}
}