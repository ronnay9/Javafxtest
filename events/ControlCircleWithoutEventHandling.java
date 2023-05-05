package event;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircleWithoutEventHandling extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    StackPane pane = new StackPane();
    Circle circle = new Circle(50);
    DoubleProperty radiusProperty = circle.radiusProperty();
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
    pane.getChildren().add(circle);
    
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    Button btEnlarge = new Button("Enlarge");
    btEnlarge.setOnAction(new EnlargeCircle(radiusProperty));
    Button btShrink = new Button("Shrink");
    btShrink.setOnAction(new ShrinkCircle(radiusProperty));
    hBox.getChildren().add(btEnlarge);
    hBox.getChildren().add(btShrink);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.CENTER);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 200, 150);
    primaryStage.setTitle("ControlCircle"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  /**
   * The main method is only needed for IDEs with limited
   * JavaFX support. It is not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

class EnlargeCircle implements EventHandler<ActionEvent> {
	DoubleProperty radius;
	
	public EnlargeCircle(DoubleProperty radius) {
		this.radius = radius;
	}

	@Override
	public void handle(ActionEvent arg0) {
		System.out.println("Enlarge circle");
	    radius.set(radius.doubleValue() + 5);
	    System.out.println(radius.doubleValue());
	}	
}

class ShrinkCircle implements EventHandler<ActionEvent> {

	DoubleProperty radius;
	
	public ShrinkCircle(DoubleProperty radius) {
		this.radius = radius;
	}

	@Override
	public void handle(ActionEvent arg0) {
		System.out.println("Shrink circle");
	    radius.set(radius.doubleValue() - 5);
	    System.out.println(radius.doubleValue());
	}
}

