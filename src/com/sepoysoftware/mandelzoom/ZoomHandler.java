package com.sepoysoftware.mandelzoom;

import java.awt.event.MouseEvent;

public class ZoomHandler {
    int startX;
    int endX;
    int startY;
    int endY;
    boolean zoomActive;

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    void registerMousePressed(MouseEvent me) {
        startX = me.getX();
        startY = me.getY();
        zoomActive = true;
    }

    void registerMouseReleased(MouseEvent me) {
        // normalizing zoomed area to be a square so that not
        // to introduce distortions over multiple zooms
        endX = me.getX();
        endY = me.getY();
        if (getDeltaX() > getDeltaY()) {
            endY = startY + (endX - startX);
        }
        else {
            endX = startX + (endY - startY);
        }
    }

    void registerMouseDragged(MouseEvent me) {
        endX = me.getX();
        endY = me.getY();
    }

    int getDeltaX() {
        return endX - startX;
    }

    int getDeltaY() {
        return endY - startY;
    }

    boolean isZoomActive() {
        return zoomActive;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public void setZoomActive(boolean zoomActive) {
        this.zoomActive = zoomActive;
    }

    public void reset() {
        startX = 0;
        endX = 0;
        startY = 0;
        endY = 0;
        zoomActive = false;
    }
}
