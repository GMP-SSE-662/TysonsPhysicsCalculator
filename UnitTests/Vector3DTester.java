import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Vector3DTester {
    @Test
    void MagnitudeShouldCalculateCorrectly(){
        Vector3D testVector = new Vector3D(10, 10, 10);
        Assertions.assertTrue(testVector.getMagnitude() == Math.sqrt(300));
    }
}
