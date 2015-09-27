package com.sepoysoftware.mandelzoom;

import java.awt.Color;
import java.awt.Graphics;

public class BufferedImageRenderer extends BaseRenderer {

    public BufferedImageRenderer(int paletteWidth, int paletteHeight) {
        super(paletteWidth, paletteHeight);
    }

    public void renderBackground() {
        for (int y = 0; y < paletteHeight - 1; y++) {
            for (int x = 0; x < paletteWidth - 1; x++) {
                if (view[y][x] == maxIterations) {
                    background.setRGB(x, y, 0x000000);
                } else if (view[y][x] == 2) {
                    background.setRGB(x, y, 0xFF0000);
                } else {
                    background.setRGB(x, y, 0xFFFFFF);
                }
            }
        }
    }
    public void render(Graphics g) {
        g.drawImage(background, 0, 0, null);
        if (zoomHandler.isZoomActive()) {
            g.setColor(Color.YELLOW);
            g.drawRect(zoomHandler.getStartX(), zoomHandler.getStartY(),
                    zoomHandler.getDeltaX(), zoomHandler.getDeltaX());
        }
    }

    public void calculate() {
        super.calculate();
        renderBackground();
    }

    public void recenter() {
        startX = startX - recenterHandler.getDeltaX() * stepX;
        endX = endX - recenterHandler.getDeltaX() * stepX;
        startY = startY + recenterHandler.getDeltaY() * stepX;
        endY = endY + recenterHandler.getDeltaY() * stepX;
        this.calculate();
    }

    public void zoom() {
        startX = zoomHandler.getStartX() * stepX + startX;
        endX = zoomHandler.getEndX() * stepX + startX;
        startY = zoomHandler.getStartY() * stepY + startY;
        endY = zoomHandler.getEndY() * stepY + startY;
        stepX = (endX - startX) / paletteWidth;
        stepY = (endY - startY) / paletteHeight;
        this.calculate();
    }


}
