import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PhysicsMenu extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome to Tyson's Physics Calculator!");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label massLabel = new Label("Mass (kg):");
        grid.add(massLabel, 0, 0);

        TextField massField = new TextField();
        grid.add(massField, 1, 0);

        Label forceX = new Label("Net Force X Component (N):");
        grid.add(forceX, 0, 1);

        TextField forceXField = new TextField();
        grid.add(forceXField, 1, 1);

        Label forceY = new Label("Net Force Y Component (N):");
        grid.add(forceY, 0, 2);

        TextField forceYField = new TextField();
        grid.add(forceYField, 1, 2);

        Label forceZ = new Label("Net Force Z Component (N):");
        grid.add(forceZ, 0, 3);

        TextField forceZField = new TextField();
        grid.add(forceZField, 1, 3);

        Button calcAccel = new Button();
        calcAccel.setText("Calculate Acceleration");
        grid.add(calcAccel, 1, 4);

        Label velocityX = new Label("Velocity X Component (m/s):");
        grid.add(velocityX, 2, 1);

        TextField velocityXField = new TextField();
        grid.add(velocityXField, 3, 1);

        Label velocityY = new Label("Velocity Y Component (m/s):");
        grid.add(velocityY, 2, 2);

        TextField velocityYField = new TextField();
        grid.add(velocityYField, 3, 2);

        Label velocityZ = new Label("Velocity Z Component (m/s):");
        grid.add(velocityZ, 2, 3);

        TextField velocityZField = new TextField();
        grid.add(velocityZField, 3, 3);

        Button calcKE = new Button();
        calcKE.setText("Calculate Kinetic Engergy");
        grid.add(calcKE, 3, 4);

        final Text accelOutput = new Text();
        grid.add(accelOutput, 1, 6);

        calcAccel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (!massField.getText().isEmpty()) {
                    PhysicsObject physObj = new PhysicsObject((Double.parseDouble(massField.getText())));
                    physObj.xForces.add(Double.parseDouble(forceXField.getText()));
                    physObj.yForces.add(Double.parseDouble(forceYField.getText()));
                    physObj.zForces.add(Double.parseDouble(forceZField.getText()));

                    PhysicsCalculator physCalc = new PhysicsCalculator();

                    accelOutput.setFill(Color.FIREBRICK);

                    String xString = String.valueOf(physCalc.calculateAcceleration(physObj).getX());
                    String yString = String.valueOf(physCalc.calculateAcceleration(physObj).getY());
                    String zString = String.valueOf(physCalc.calculateAcceleration(physObj).getZ());

                    String accelString = "The acceleration is ("+xString+", "+yString+", "+zString+")";

                    accelOutput.setText(accelString);
                }
            }
        });

        final Text kineticEnergyOutput = new Text();
        grid.add(kineticEnergyOutput, 3, 6);

        calcKE.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (!massField.getText().isEmpty()) {
                    PhysicsObject physObj = new PhysicsObject((Double.parseDouble(massField.getText())));
                    physObj.setVelocity(new Vector3D(Double.parseDouble(velocityXField.getText()),
                            Double.parseDouble(velocityYField.getText()),
                            Double.parseDouble(velocityZField.getText())));

                    PhysicsCalculator physCalc = new PhysicsCalculator();

                    kineticEnergyOutput.setFill(Color.FIREBRICK);

                    String kineticEnergyString = "The kinetic energy is " + physCalc.calculateKineticEnergy(physObj) + "J";

                    kineticEnergyOutput.setText(kineticEnergyString);
                }
            }
        });

        Scene scene = new Scene(grid, 700, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setScene1(){

    }
}