import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PhysicsCalculatorTester {
    @Test
    void AccelerationShouldReturnZeroIfNoForce() {
        PhysicsCalculator testCalc = new PhysicsCalculator();
        PhysicsObject testObject = new PhysicsObject(10);
        Vector3D calculatedAccel = testCalc.calculateAcceleration(testObject);
        Assertions.assertTrue(calculatedAccel.equals(new Vector3D(0, 0, 0)));
    }

    @Test
    void AccelerationShouldCalculateCorrectlyWithNormalValues() {
        PhysicsCalculator testCalc = new PhysicsCalculator();
        PhysicsObject testObject = new PhysicsObject(10);
        testObject.xForces.add(new Double(30));
        Vector3D calculatedAccel = testCalc.calculateAcceleration(testObject);
        Assertions.assertTrue(calculatedAccel.equals(new Vector3D(3, 0, 0)));
    }

    @Test
    void KineticEngergyShouldCalculateCorrectlyWithNormalValues() {
        PhysicsCalculator testCalc = new PhysicsCalculator();
        PhysicsObject testObject = new PhysicsObject(10);
        testObject.setVelocity(new Vector3D(Math.sqrt(3), Math.sqrt(3), Math.sqrt(3))); //Velocity has magnitude 3
        double calculatedKE = testCalc.calculateKineticEnergy(testObject);
        Assertions.assertTrue(calculatedKE == 90);
    }
}
