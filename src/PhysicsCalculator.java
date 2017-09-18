import java.util.ArrayList;

public class PhysicsCalculator {
    public Vector3D calculateAcceleration(IPhysicsObject particle){
        ArrayList<Double> forces = particle.getNetForces();

        double accelX = forces.get(0) / particle.getMass();
        double accelY = forces.get(1) / particle.getMass();
        double accelZ = forces.get(2) / particle.getMass();

        return new Vector3D(accelX, accelY, accelZ);
    }

    public double calculateKineticEnergy(IPhysicsObject particle){
        Vector3D velocity = particle.getVelocity();
        double velocityMagnitude = Math.sqrt(Math.pow(velocity.getX(), 2) + Math.pow(velocity.getY(), 2) + Math.pow(velocity.getZ(), 2));

        double kineticEnergy = particle.getMass() * Math.pow(velocityMagnitude, 2);

        return Math.round(kineticEnergy*10000)/10000; // Rounds KE to 4 decimal places
    }
}
