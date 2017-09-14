public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void equals(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean equals(Vector3D otherVector){
        return ((this.x == otherVector.getX()) && (this.y == otherVector.getY()) && (this.z == otherVector.getZ()));
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }
}
