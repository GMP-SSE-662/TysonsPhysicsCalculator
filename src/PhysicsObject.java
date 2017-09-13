import java.util.ArrayList;

public class PhysicsObject implements IPhysicsObject {
    double mass = 0;
    Vector3D velocity = new Vector3D();
    Vector3D acceleration = new Vector3D();
    ArrayList xForces = new ArrayList<Double>();
    ArrayList yForces = new ArrayList<Double>();
    ArrayList zForces = new ArrayList<Double>();

    public PhysicsObject(double mass){
        this.mass = mass;
    }
}
