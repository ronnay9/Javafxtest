package event;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MultipleShapesAnimation extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create two rectangles
        Rectangle rect1 = new Rectangle(50, 50, 100, 50);
        rect1.setFill(Color.BLUE);
        Rectangle rect2 = new Rectangle(150, 150, 100, 50);
        rect2.setFill(Color.RED);

        // Group the rectangles together
        Group group = new Group(rect1, rect2);

        // Create a translate transition that moves the group 100 pixels to the right
        TranslateTransition translate = new TranslateTransition(Duration.seconds(2), group);
        translate.setToX(100);

        // Start the animation
        translate.setCycleCount(-1);
        translate.play();

        // Show the scene
        Scene scene = new Scene(group, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
