package com.sepoysoftware.mandelzoom;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Mandelzoom implements MouseListener, MouseMotionListener, MouseWheelListener {
    Component backpointer;
    BaseRenderer renderer;

    public Mandelzoom(int paletteWidth, int paletteHeight, Component backpointer) {
        this.renderer = new BufferedImageRenderer(paletteWidth, paletteHeight);
        this.backpointer = backpointer;
        backpointer.addMouseListener(this);
        backpointer.addMouseMotionListener(this);
        backpointer.addMouseWheelListener(this);
    }

    public void calculate() {
        renderer.calculate();
    }

    public void render(Graphics g) {
        renderer.render(g);
    }

    public void mousePressed(MouseEvent me) {
        // right click - zoom action
        if (me.getButton() == 1) {
            renderer.recenterHandler.registerMousePressed(me);
        }
        if (me.getButton() == 3) {
            renderer.zoomHandler.registerMousePressed(me);
        }
        backpointer.repaint();
    }

    public void mouseReleased(MouseEvent me) {
        //left click - recenter action
        if (me.getButton() == 1) {
            renderer.recenterHandler.registerMouseReleased(me);
            renderer.recenter();
            backpointer.repaint();
        }
        // right click - zoom action
        if (me.getButton() == 3) {
            renderer.zoomHandler.registerMouseReleased(me);
            renderer.zoom();
            renderer.zoomHandler.setZoomActive(false);
            backpointer.repaint();
        }
    }

    public void mouseDragged(MouseEvent me) {
        System.out.println("mouse dragged");
        if (me.getButton() == 3) {
            renderer.zoomHandler.registerMouseDragged(me);
            if (renderer.zoomHandler.isZoomActive()) {
                backpointer.repaint();
            }
            backpointer.repaint();
        }
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseMoved(MouseEvent me) {
    }

    public void mouseWheelMoved(MouseWheelEvent mve) {
        System.out.println("mouseWheelMoved");
        if (mve.getWheelRotation() < 0) {
            renderer.zoomIn();
        }
        else {
            renderer.zoomOut();
        }
        backpointer.repaint();
    }
}
