import java.util.ArrayList;

public class PhysicsCalculator {
    public Vector3D calculateAcceleration(IPhysicsObject particle){
        ArrayList<Double> forces = particle.getNetForces();

        double accelX = forces.get(0) / particle.getMass();
        double accelY = forces.get(1) / particle.getMass();
        double accelZ = forces.get(2) / particle.getMass();

        return new Vector3D(accelX, accelY, accelZ);
    }
}
