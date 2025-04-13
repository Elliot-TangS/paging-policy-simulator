import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class DemandPagingSimulation {
   private final static int NUM_ALGORITHMS = 7;

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.print("Size of Virtual Memory (pages)? ");
      int numPages = in.nextInt();
      System.out.print("Number of frames allocated per process? ");
      int numAllocated = in.nextInt();
      System.out.print("Reference string length? ");
      int numReferences = in.nextInt();
      System.out.print("Random type (Uniform, Gaussian or Textbook Example)? ");
      char r = in.next().toUpperCase().charAt(0);
      in.close();

      ArrayList<Integer> ref;
      switch (r) {
      case 'U':
         ref = makeReferenceString(numReferences, numPages);
         break;
      case 'T':
         int[] array = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1 };
         numReferences = array.length;
         ref = new ArrayList<Integer>();
         for (int i = 0; i < array.length; i++)
            ref.add(array[i]);
         break;
      default:
         ref = makeNormalReferenceString(numReferences, numPages, 5.0);
      }

      ReplacementAlgorithm[] algos = new ReplacementAlgorithm[NUM_ALGORITHMS];
      algos[0] = new TrivialAlgorithm(numAllocated);
      algos[1] = new RandomAlgorithm(numAllocated);
      algos[2] = new LFUAlgorithm(numAllocated, numPages);
      algos[3] = new MFUAlgorithm(numAllocated, numPages);
      algos[4] = new LRUAlgorithm(numAllocated);
      algos[5] = new FIFOAlgorithm(numAllocated);
      algos[6] = new OptimalAlgorithm(numAllocated, ref);

      System.out.printf("%5s%3s", "Ref", "");
      for (int a = 0; a < NUM_ALGORITHMS; a++) {
         System.out.printf("%-22s ", algos[a].getName());
      }
      System.out.println();

      for (int p : ref) {
         System.out.printf("%5d ", p);
         for (int a = 0; a < NUM_ALGORITHMS; a++) {
            int victim = algos[a].processReference(p);
            if (victim < 0) {
               System.out.printf("%5s ", "HIT");
            } else {
               System.out.printf("%5d ", victim);
            }
            System.out.printf("%-15s  ", algos[a]);
         }
         System.out.println();
      }

      System.out.println();
      for (int a = 0; a < NUM_ALGORITHMS; a++) {
         System.out.printf("Algorithm %-5s: faults/refs = %d/%d = %.2f%% Hit Rate\n", algos[a].getName(),
               algos[a].getFaults(), numReferences,
               100.0 * (double) (numReferences - algos[a].getFaults()) / numReferences);
      }

   }

   private static ArrayList<Integer> makeReferenceString(int n, int max) {
      ArrayList<Integer> a = new ArrayList<>();

      for (int i = 0; i < n; i++)
         a.add((int) (Math.random() * max));

      return a;
   }

   private static ArrayList<Integer> makeNormalReferenceString(int n, int max, double stddev) {
      ArrayList<Integer> a = new ArrayList<>();
      Random rand = new Random();

      int reference = 0;
      for (int i = 0; i < n; i++) {
         a.add(reference);
         reference = reference + (int) (rand.nextGaussian() * stddev);
         if (reference < 0 || reference > max - 1)
            reference = (int) (Math.random() * max);
      }

      return a;
   }
}
