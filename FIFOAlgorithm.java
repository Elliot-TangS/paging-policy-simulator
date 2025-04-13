public class FIFOAlgorithm extends ReplacementAlgorithmBase {
   private int next;

   public FIFOAlgorithm(int numAllocated) {
      super(numAllocated);
      next = 0;
   }

   public String getName() {
      return "FIFO";
   }

   public int nextVictim(int p) {
      int v = next;
      next = (next + 1) % numAllocated;
      return v;
   }
}
