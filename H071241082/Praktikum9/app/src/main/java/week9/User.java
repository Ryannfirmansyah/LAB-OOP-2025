package week9;

import javafx.scene.image.Image;

public class User {
    private String nickName;
    private String fullName;
    private Image profileImage;

    public User(String nickName, String fullName, Image profileImage) {
        this.nickName = nickName;
        this.fullName = fullName;
        this.profileImage = profileImage;
    }

    // Getter dan Setter
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Image getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }
}