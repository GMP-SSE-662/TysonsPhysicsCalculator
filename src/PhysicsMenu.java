import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PhysicsMenu extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome to Tyson's Physicks Calculator!");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label massLabel = new Label("Mass (kg):");
        grid.add(massLabel, 0, 0);

        TextField massField = new TextField();
        grid.add(massField, 1, 0);

        Label forceX = new Label("Force X Component (N):");
        grid.add(forceX, 0, 1);

        TextField forceXField = new TextField();
        grid.add(forceXField, 1, 1);

        Label forceY = new Label("Force Y Component (N):");
        grid.add(forceY, 0, 2);

        TextField forceYField = new TextField();
        grid.add(forceYField, 1, 2);

        Label forceZ = new Label("Force Z Component (N):");
        grid.add(forceZ, 0, 3);

        TextField forceZField = new TextField();
        grid.add(forceZField, 1, 3);

        Button calcAccel = new Button();
        calcAccel.setText("Calculate Acceleration");
        grid.add(calcAccel, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        calcAccel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (!massField.getText().isEmpty()) {
                    PhysicsObject physObj = new PhysicsObject((Double.parseDouble(massField.getText())));
                    physObj.xForces.add(Double.parseDouble(forceXField.getText()));

                    PhysicsCalculator physCalc = new PhysicsCalculator();

                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText(String.valueOf(physCalc.calculateAcceleration(physObj).getX()));
                }
            }
        });

        Scene scene = new Scene(grid, 500, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setScene1(){

    }
}