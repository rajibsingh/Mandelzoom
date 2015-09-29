package com.sepoysoftware.mandelzoom;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

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
        PixelWriter writer = image.getPixelWriter();
        Color color = Color.WHITE;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (color == Color.WHITE) {
                    color = Color.BLACK;
                } else if (color == Color.BLACK) {
                    color = Color.WHITE;
                }
                writer.setColor(x, y, color);
            }
        }
        return image;
    }
}
