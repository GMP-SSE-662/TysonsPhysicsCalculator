import java.util.ArrayList;

public class PhysicsObject implements IPhysicsObject {
    private double mass = 0;
    private Vector3D velocity = new Vector3D(0, 0, 0);
    private Vector3D acceleration = new Vector3D(0, 0, 0);
    ArrayList<Double> xForces = new ArrayList<Double>();
    ArrayList<Double> yForces = new ArrayList<Double>();
    ArrayList<Double> zForces = new ArrayList<Double>();

    public PhysicsObject(double mass){
        this.mass = mass > 0 ?  mass : 1;
    }

    @Override
    public ArrayList<Double> getNetForces() {
        ArrayList<Double> netForces = new ArrayList<Double>();
        double xNet = 0;
        double yNet = 0;
        double zNet = 0;

        for (Double xForce: xForces){
            xNet += xForce;
        }
        for (Double yForce: yForces){
            yNet += yForce;
        }
        for (Double zForce: zForces){
            zNet += zForce;
        }

        netForces.add(xNet);
        netForces.add(yNet);
        netForces.add(zNet);

        return netForces;
    }

    @Override
    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        if (mass > 0) this.mass = mass;
    }
}
