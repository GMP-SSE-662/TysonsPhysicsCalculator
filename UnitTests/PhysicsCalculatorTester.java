import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PhysicsCalculatorTester {
    @Test
    void AccelerationShouldReturnZeroIfNoForce() {
        PhysicsCalculator testCalc = new PhysicsCalculator();
        PhysicsObject testObject = new PhysicsObject(10);
        Assertions.assertTrue(testCalc.calculateAcceleration(testObject).equals(0));
    }
}
