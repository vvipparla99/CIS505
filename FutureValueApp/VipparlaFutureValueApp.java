import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * 
 * @author Venkataramaiah
 *
 */
public class VipparlaFutureValueApp extends Application {

	//create Label
	private Label lblMonthlyPayment = new Label("Monthly Payment:");
	private Label lblInterestRate = new Label("Interest Rate:");
	private Label years = new Label("Years:");
	private Label lblInterestRateTxt = new Label("Enter 11.1% as 11.1");
	
	//create button
	private Button btnClear = new Button("Clear");
	private Button btnCalculate = new Button("Calculate");
	
	//create TextFields
	private TextField tfMonthlyPayment = new TextField();
	private TextField tfInterestrate = new TextField();
	
	//create TextArea
	private TextArea textArea = new TextArea();

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Vipparla Future Value App");
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		Insets insets = new Insets(11.5, 12.5, 13.5, 14.5);
		gridPane.setPadding(insets);
		gridPane.setHgap(5.5);
		gridPane.setVgap(5.5);

		ComboBox<String> comboBox = new ComboBox();
		comboBox.setPrefWidth(200);
		comboBox.getItems().add("1");
		comboBox.getItems().add("2");
		comboBox.getItems().add("3");

		lblInterestRateTxt.setTextFill(Color.RED);

		gridPane.add(lblMonthlyPayment, 0, 0);
		gridPane.add(tfMonthlyPayment, 1, 0);

		gridPane.add(lblInterestRate, 0, 1);
		gridPane.add(tfInterestrate, 1, 1);

		gridPane.add(lblInterestRateTxt, 1, 2);

		gridPane.add(years, 0, 3);
		gridPane.add(comboBox, 1, 3);

		gridPane.setHalignment(lblInterestRateTxt, HPos.RIGHT);

		HBox actionBtnContainer = new HBox();
		actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
		actionBtnContainer.setSpacing(10);
		actionBtnContainer.getChildren().add(btnClear);
		actionBtnContainer.getChildren().add(btnCalculate);
		gridPane.add(actionBtnContainer, 1, 4);
		
		
		textArea.setMaxHeight(300);
		textArea.setMaxWidth(200);
		gridPane.add(textArea, 1, 6);

		
		Scene myScene = new Scene(gridPane, 340, 240);
		
		primaryStage.setScene(myScene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
