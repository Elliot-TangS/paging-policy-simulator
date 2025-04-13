public class RandomAlgorithm extends ReplacementAlgorithmBase {
   private int numAllocated;

   public RandomAlgorithm(int numAllocated) {
      super(numAllocated);
      this.numAllocated = numAllocated;
   }

   public String getName() {
      return "RAND";
   }

   public int nextVictim(int p) {
      for (int i = 0; i < numAllocated; i++) {
         if (!validTable[i])
            return i;
      }
      return (int)(Math.random() * numAllocated);
   }
}
