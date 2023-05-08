
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.event.Event;
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
 * This class is used to Calucate the Future Value
 * 
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
	private TextField txtMonthlyPayment = new TextField();
	private TextField txtInterestrate = new TextField();
	
	//create TextArea
	private TextArea textArea = new TextArea();
	
	private ComboBox<Integer> comboBox = new ComboBox();
	
	private String formattedFutureValue;
	
	private Label lblcalDate = new Label("");

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Vipparla Future Value App");
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		Insets insets = new Insets(11.5, 12.5, 13.5, 14.5);
		gridPane.setPadding(insets);
		gridPane.setHgap(5.5);
		gridPane.setVgap(5.5);

		comboBox.setPrefWidth(200);
		comboBox.getItems().add(Integer.valueOf(0));
		comboBox.getItems().add(Integer.valueOf(1));
		comboBox.getItems().add(Integer.valueOf(2));
		comboBox.getItems().add(Integer.valueOf(3));

		lblInterestRateTxt.setTextFill(Color.RED);

		gridPane.add(lblMonthlyPayment, 0, 0);
		gridPane.add(txtMonthlyPayment, 1, 0);

		gridPane.add(lblInterestRate, 0, 1);
		gridPane.add(txtInterestrate, 1, 1);

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
		
		gridPane.add(lblcalDate,1,6);
		
		textArea.setMaxHeight(300);
		textArea.setMaxWidth(200);
		gridPane.add(textArea, 1, 7);

		
		
		
		Scene myScene = new Scene(gridPane, 350, 250);
		
		primaryStage.setScene(myScene);
		primaryStage.show();
		btnCalculate.setOnAction(e->calculateResults());
		btnClear.setOnAction(e->clearFormFields());
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void clearFormFields() {
		this.txtMonthlyPayment.setText("");
		this.txtInterestrate.setText("");
		this.comboBox.setValue(0);
		this.formattedFutureValue = "";
		this.lblcalDate.setText("");
		this.formattedFutureValue="";
		this.textArea.setText("");
		
	}
	
	private void calculateResults() {
		
		double futureValue = FinanceCalculator.calculateFutureValue(Double.valueOf(txtMonthlyPayment.getText()), Double.valueOf(txtInterestrate.getText()), comboBox.getValue());
		formattedFutureValue = String.valueOf(Math.floor(futureValue * 100) / 100);
		this.lblcalDate.setText("Calculation as of "+new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		textArea.setText("The future value is $ " +formattedFutureValue );
		
		
	}
}
