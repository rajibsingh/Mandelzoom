package com.sepoysoftware.mandelzoom;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Mandelzoom extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        //Button btn = new Button();
        //btn.setText("Say 'Hello World'");
        //btn.setOnAction(new EventHandler<ActionEvent>() {
        //    public void handle(ActionEvent event) {
        //        System.out.println("Hello World!");
        //    }
        //});
        Renderer renderer = new Renderer(1024, 1024);
        ImageView iv = new ImageView(renderer.getImage());

        StackPane root = new StackPane();
        //root.getChildren().add(btn);
        root.getChildren().add(iv);
        primaryStage.setScene(new Scene(root, 1024, 1024));
        primaryStage.show();
    }

    /**
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
     **/
}
