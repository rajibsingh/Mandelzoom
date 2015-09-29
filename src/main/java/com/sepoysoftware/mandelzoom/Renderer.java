package com.sepoysoftware.mandelzoom;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

/**
 * Created by raj on 9/28/15.
 */
public class Renderer {
    public int width;
    public int height;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    Image getImage() {
        WritableImage image = new WritableImage(width, height);
        return image;
    }
}
