/*
 * Class: CMSC201 
 * Instructor: Professor Lee
 * Description: I graphed a sin and cos curve using Java FX
 * Due: 04/23/2023
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here:Aadarsh Bandyopadhyay
*/



import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Project4_Part2 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Project 4 Part 2");
		primaryStage.setScene(new Scene(new MyPane(), 500, 300));
		primaryStage.show();

	}

}

class MyPane extends Pane {
	private void paint() {
		double w = getWidth();
		double h = getHeight();
		getChildren().clear(); // Clear pane
		
		double scaleFactor = h/4;
		
		// sine curve
		Polyline sineCurve = new Polyline();
		ObservableList<Double> list = sineCurve.getPoints();
		for (int x = 30; x <= getWidth() - 30; x++) {
			list.add(x + 0.0);
			double realX = w/2 - x;
			list.add(h/2 - scaleFactor * Math.sin((realX / (w/4.5)) * 2 * Math.PI));
		}
		sineCurve.setStroke(Color.RED);
		
		// cosine curve
		Polyline cosineCurve = new Polyline();
		ObservableList<Double> list2 = cosineCurve.getPoints();
		for (int x = 30; x <= getWidth() - 30; x++) {
			list2.add(x + 0.0);
			double realX = w/2 - x;
			list2.add(h/2 - scaleFactor * Math.cos((realX / (w/4.5)) * 2 * Math.PI));
		}
		cosineCurve.setStroke(Color.BLUE);
		
		// x axis
		Polyline xAxis = new Polyline();
		ObservableList<Double> listXAxis = xAxis.getPoints();
		for (int x = 30; x <= getWidth() -30; x++) {
			double realX = x;
			double realY = h/2;
			listXAxis.add(realX);
			listXAxis.add(realY);
		}
		
		// y axis
		Polyline yAxis = new Polyline();
		ObservableList<Double> listYAxis = yAxis.getPoints();
		for (int y = 20; y <= getHeight() -20; y++) {
			double realX = w/2;
			double realY = y;
			listYAxis.add(realX);
			listYAxis.add(realY);
		}
		
		// Arrow sign for y axis
		Line line1 = new Line(w/2, 20.0, w/2-5, 30.0);
		Line line2 = new Line(w/2, 20.0, w/2+5, 30.0);
		
		// Arrow sign for x axis
		Line line3 = new Line(w-30, h/2, w-40, h/2+5);
		Line line4 = new Line(w-30, h/2, w-40, h/2-5);
		
		// Labels on the x axis
		Text t1 = new Text(w/2+1, h/2+10, "0");
		List<Node> ts = new ArrayList<>();
		for (int i=-3; i <= 3; i+=1) {
			if (i == 0) continue;
			Double x = w/2 + i * w/9;
			String sign = i < 0 ? "-" : "";
			if (Math.abs(i) == 1) {
				Text t = new Text(x, h/2+10, String.format("%s\u03c0", sign));
				ts.add(t);
			}
			else {
				Text t = new Text(x, h/2+10, String.format("%d\u03c0", i));
				ts.add(t);
			}
		}
		
		/*
		Double x = w/2 - w/9;
		Text t2 = new Text(x, h/2+10, "-\u03c0");
		x -= w/9;
		Text t3 = new Text(x, h/2+10, "-2\u03c0");
		x -= w/9;
		Text t4 = new Text(x, h/2+10, "-3\u03c0");
		*/

		getChildren().addAll(sineCurve, cosineCurve, xAxis, yAxis, line1, line2, line3, line4);
		getChildren().add(t1);
		getChildren().addAll(ts);
	}

	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}

	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}

}
