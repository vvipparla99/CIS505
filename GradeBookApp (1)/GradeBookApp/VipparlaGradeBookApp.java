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

	private File csvOutputFile = new File("/users/vipparla/grades.csv");

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
		btnClear.setOnAction(e -> clearFormFields());
		btnSave.setOnAction(e -> saveDataToCSV());
		btnView.setOnAction(e -> viewData());

	}

	/*
	 * this method is used to clear the form fields
	 */
	private void clearFormFields() {
		this.txtFirstName.clear();
		this.txtLastName.clear();
		this.comboBox.setValue("");
		this.txtCourse.clear();

	}

	/*
	 * this method is used to save data to csv file
	 */
	public void saveDataToCSV() {

		dataLines.add(new String[] { txtFirstName.getText(), txtLastName.getText(), txtCourse.getText(),
				comboBox.getValue().toString() });

		try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
			dataLines.stream().map(this::convertToCSV).forEach(pw::println);
			this.txtFirstName.clear();
			this.txtLastName.clear();
			this.comboBox.setValue("");
			this.txtCourse.clear();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String convertToCSV(String[] data) {
		return Stream.of(data).collect(Collectors.joining(","));
	}

	/*
	 * this method is used to view data from csv
	 */
	public void viewData() {
		Scanner sc = null;

		try {
			sc = new Scanner(new File("grades.csv"));
			String skipHeader = sc.nextLine();
			List<Student> listStudent = new ArrayList();
			// sets the delimiter pattern
			while (sc.hasNext()) // returns a boolean value
			{
				String[] data = sc.nextLine().split(",");
				listStudent.add(new Student(data[0], data[1], data[2], data[3]));

			}

			viewDta(listStudent);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			sc.close(); // closes the scanner
		}

	}

	public void viewDta(List<Student> list) {
		String output = "";
		StringBuilder sb = new StringBuilder();
		for (Student std : list) {
			output = rowsData.replace("firstName", std.getFirstName()).replace("lastName", std.getLastName())
					.replace("course", std.getCourse()).replace("grade", std.getGrade());

			sb.append(output);
		}

		String header = "<html><table border=1><tr><th>First Name</td><th>Last Name</td><th>Course</td><th>Grade</td></tr>"
				+ sb.toString() + "</table></html>";

		JLabel newLabel = new JLabel(header);
		JOptionPane.showMessageDialog(null, newLabel);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
