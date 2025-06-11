package week9;

import javafx.scene.image.Image;

public class Post {
    private String caption;
    private Image postImage;

    public Post(String caption, Image postImage) {
        this.caption = caption;
        this.postImage = postImage;
    }

    // Getter dan Setter
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Image getPostImage() {
        return postImage;
    }

    public void setPostImage(Image postImage) {
        this.postImage = postImage;
    }
}