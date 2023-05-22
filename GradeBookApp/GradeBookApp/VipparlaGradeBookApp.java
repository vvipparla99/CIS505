
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class VipparlaGradeBookApp extends Application {

	// create Label
	private Label firstName = new Label("First Name:");
	private Label lastName = new Label("Last Name:");
	private Label course = new Label("Course:");
	private Label grade = new Label("Grade:");

	// create TextFields
	private TextField txtFirstName = new TextField();
	private TextField txtLastName = new TextField();
	private TextField txtCourse = new TextField();

	private ComboBox comboBox = new ComboBox();

	// create button
	private Button btnClear = new Button("Clear");
	private Button btnView = new Button("View");
	private Button btnSave = new Button("Save");

	private File csvOutputFile = new File("/users/Vipparla/grades.csv");

	List<String[]> dataLines = new ArrayList<>();

	String rowsData = "<tr><td>firstName</td><td>lastName</td><td>course</td><td>grade</td></tr>";

	public VipparlaGradeBookApp() {
		dataLines.add(new String[] { "firstName", "lastName", "course", "grade" });
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Vipparla Grade Book App");

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		Insets insets = new Insets(11.5, 12.5, 13.5, 14.5);
		gridPane.setPadding(insets);
		gridPane.setHgap(5.5);
		gridPane.setVgap(5.5);

		comboBox.setPrefWidth(200);
		comboBox.getItems().add("A");
		comboBox.getItems().add("B");
		comboBox.getItems().add("C");
		comboBox.getItems().add("D");
		comboBox.getItems().add("F");

		gridPane.add(firstName, 0, 0);
		gridPane.add(txtFirstName, 1, 0);

		gridPane.add(lastName, 0, 1);
		gridPane.add(txtLastName, 1, 1);

		gridPane.add(course, 0, 2);
		gridPane.add(txtCourse, 1, 2);

		gridPane.add(grade, 0, 3);
		gridPane.add(comboBox, 1, 3);

		HBox actionBtnContainer = new HBox();
		actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
		actionBtnContainer.setSpacing(10);
		actionBtnContainer.getChildren().add(btnClear);
		actionBtnContainer.getChildren().add(btnView);
		actionBtnContainer.getChildren().add(btnSave);
		gridPane.add(actionBtnContainer, 1, 4);

		Scene myScene = new Scene(gridPane, 350, 250);

		primaryStage.setScene(myScene);
		primaryStage.show();
		

	}



	public String convertToCSV(String[] data) {
		return Stream.of(data).collect(Collectors.joining(","));
	}

	
	public static void main(String[] args) {
		launch(args);
	}

}
