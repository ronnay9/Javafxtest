import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestImage extends Application {

    @Override
    public void start(Stage primaryStage) {
        
    	GridPane root = new GridPane();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setHgap(10);
        root.setVgap(10);

        List<Image> images = new ArrayList<>();
        images.add(new Image("morteza-khalili-qe2RkzzMx9A-unsplash.jpg"));
        images.add(new Image("robbin-grimm-PGQxDybhl90-unsplash.jpg"));
        images.add(new Image("janosch-diggelmann-ZuPoH3Ti-Gw-unsplash.jpg"));
        
        Random rand = new Random();
        
        for (int row=0; row<3; row++) {
        	for (int col=0; col<3; col++) {
        		Image image = images.get(rand.nextInt(images.size()));
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setFitWidth(200);
                imageView.setFitHeight(200);
                root.add(imageView, col, row);
        	}
        }
        
        VBox vBox = new VBox(root);
        Scene scene = new Scene(vBox, 660, 660);

        primaryStage.setTitle("Show an 3 x 3 Image grid of randomly chosen images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
