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
    int width;
    int height;
    double xMin = -2.0;
    double xMax = 0.5;
    double yMin = -1.25;
    double yMax =  1.25;
    double boxWidth= Math.abs(xMax - xMin / width);
    double boxHeight = Math.abs(yMax - yMin / height);
    double[][] array;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
        array = new double[height][width];
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

    void calculate() {
        for (double y = yMax; y > yMin; y -= boxHeight ) {
            for (double x = xMin; x < xMax; x += boxWidth) {
                //TODO - actual Mandelbrot calculation

            }
        }
    }
}
