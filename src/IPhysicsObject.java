import java.util.ArrayList;

public interface IPhysicsObject {
    public ArrayList<Double> getNetForces();
    public double getMass();
    public Vector3D getVelocity();
}
