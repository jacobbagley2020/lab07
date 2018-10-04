import java.util.Random;
import java.util.ArrayList;
/**
 * Use an ArrayList to store a collection of objects and use a for-each loop to process the objects.
 * 
 * @author Jacob Bagley
 *
 */
public class ArrayListExercise {

    public static void main(String[] args)
    {
        Random rand = new Random();
        final int RADIUS_MAX = 100;
        //TODO: declare a constant for the number of spheres NUM_SPHERES and 
        //      initialize it appropriately
        final int NUM_SPHERES = 4;
        //TODO: Declare the ArrayList to hold the Sphere objects
        ArrayList<Sphere> spheres = new ArrayList<Sphere>();
        //TODO: Create the spheres using a normal for loop and add them to an ArrayList<Sphere>
        for (int i = 0; i < NUM_SPHERES; i++ ) {
        	spheres.add(new Sphere(rand.nextInt(RADIUS_MAX)));
        }  
        //TODO: Convert to a for-each loop to print out the spheres
        for (int i = 0; i < NUM_SPHERES; i++) {
        	System.out.println("Sphere " + (i + 1) + "\t" + spheres.get(i) + "\n");
        }
        for (Sphere i : spheres) {
        	System.out.println("Sphere " + "\t" + i.toString() + "\n");
        }
        
        
        //TODO: Convert to a for-each loop to find the volume of the smallest sphere
        double current, min = 4 * Math.PI / 3 * Math.pow(RADIUS_MAX, 3);
        for (Sphere o : spheres) {
        	current = o.getVolume();
        	if (current < min) {
        		min = current;
        	}
        }
        
        System.out.printf("Volume of the smallest sphere: %.2f\n", min);
    }
}
