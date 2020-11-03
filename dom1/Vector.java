package dom1;

import java.util.Random;

public class Vector {

    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public double length_vector() {
        double result1;
        result1 = Math.sqrt(x*x+y*y+z*z);
        return result1;
    }

    public double scalar_vector(Vector v) {
        double result2;
        result2 = x*v.x + y*v.y + z*v.z;
        return result2;
    }

    public Vector mult(Vector vector) {
        int x = y*vector.z-z*vector.y;
        int y = z*vector.x-x*vector.z;
        int z = x*vector.y-y*vector.x;
        return new Vector(x, y, z);
    }

    public double cosin(Vector v){
        double sc = scalar_vector(v);
        double l_1 = length_vector();
        double l_2 = v.length_vector();
        double res_5;
        res_5 = sc/(l_1*l_2);
        return res_5;

    }
    public Vector summa(Vector vector){
        int x = this.x+vector.x;
        int y = this.y+vector.y;
        int z = this.z+vector.z;
        return new Vector(x, y, z);

    }

    public Vector difference(Vector vector){
        int x = this.x-vector.x;
        int y = this.y-vector.y;
        int z = this.z-vector.z;
        return new Vector(x, y, z);
    }

    public static Vector[] generator(int N) {
        Vector vectorsArr[];
        vectorsArr = new Vector[N];
        for (int i = 0; i < N; i++) {
            Random rand = new Random();
            // Generate random integers in range 0 to 999
            int randx = rand.nextInt(100);
            int randy = rand.nextInt(100);
            int randz = rand.nextInt(100);
            vectorsArr[i] = new Vector(randx, randy, randz);
        }

        return vectorsArr;
    }
    public void value(){
        System.out.println(this.x+ " " + this.y + " " + this.z);
    }


}