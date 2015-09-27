package com.sepoysoftware.mandelzoom;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

class BaseRenderer {
    double startX = 0;
    double startY = 0;
    double endX = 0;
    double endY = 0;
    double stepX = 0;
    double stepY = 0;;
    int paletteHeight = 800;
    int paletteWidth = 800;
    int maxIterations = 100;
    double zoomFactor = 1.4;
    int[][] view = null;
    Component backpointer =  null;
    RecenterHandler recenterHandler = new RecenterHandler();
    ZoomHandler zoomHandler = new ZoomHandler();
    BufferedImage background = new BufferedImage(paletteWidth, paletteHeight, BufferedImage.TYPE_INT_RGB);

    BaseRenderer(int paletteWidth, int paletteHeight) {
        this.paletteWidth = paletteWidth;
        this.paletteHeight = paletteHeight;
        startX = -2d;
        startY = 2d;
        endX = 1d;
        endY = -1d;
        view = new int[paletteWidth][paletteHeight];
        //good to have later and not recalculated repeatedly
        stepX = (endX - startX) / paletteWidth;
        stepY = (endY - startY) / paletteHeight;
        this.calculate();
    }
    public void render(Graphics g) {
    }

    public void recenter() {
    }

    public void zoom() {
    };

    public void calculate() {
        for (int y = 0; y < paletteHeight - 1; y++) {
            double imaginary = startY + stepY * y;
            for (int x = 0; x < paletteWidth - 1; x++) {
                double real = startX + stepX * x;
                ComplexNumber c = new ComplexNumber(real, imaginary);
                int count = 0;
                ComplexNumber cnum = c.copy();
                while (count < maxIterations && cnum.getSize() < 2.0d) {
                    cnum.square();
                    cnum.add(c);
                    count++;
                }
                view[y][x] = count;
            }
        }
    }

    public void zoomIn() {
        startX = startX / zoomFactor;
        endX = endX / zoomFactor;
        startY = startY / zoomFactor;
        endY = endY / zoomFactor;
        stepX = (endX - startX) / paletteWidth;
        stepY = (endY - startY) / paletteHeight;
        this.calculate();
    }

    public void zoomOut() {
        startX = startX * zoomFactor;
        endX = endX * zoomFactor;
        startY = startY * zoomFactor;
        endY = endY * zoomFactor;
        stepX = (endX - startX) / paletteWidth;
        stepY = (endY - startY) / paletteHeight;
        this.calculate();
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int y = 0; y < paletteHeight; y++) {
            for (int x = 0; x < paletteWidth; x++) {
                // buf.append( view[y][x] + " " );
            }
            buf.append("\n");
        }
        return buf.toString();
    }
}
