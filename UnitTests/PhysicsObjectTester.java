import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhysicsObjectTester {
    @Test
    void MassShouldDefaultToOneWhenSetToZero() {
        PhysicsObject testObject = new PhysicsObject(0);
        Assertions.assertEquals(testObject.getMass(), 1);
    }

    @Test
    void MassShouldDefaultToOneWhenSetToNegative() {
        PhysicsObject testObject = new PhysicsObject(-5);
        Assertions.assertEquals(testObject.getMass(), 1);
    }
}
