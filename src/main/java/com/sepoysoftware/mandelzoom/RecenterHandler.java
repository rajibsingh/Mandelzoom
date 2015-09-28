package com.sepoysoftware.mandelzoom;

import java.awt.event.MouseEvent;

public class RecenterHandler {
    int endX;
    int endY;
    int startX;
    int startY;

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
    }

    void registerMouseReleased(MouseEvent me) {
        endX = me.getX();
        endY = me.getY();
    }

    int getDeltaX() {
        return endX - startX;
    }

    int getDeltaY() {
        return endY - startY;
    }
}
