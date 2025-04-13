public class LFUAlgorithm extends ReplacementAlgorithmBase {
   private int accessCount[];

   public LFUAlgorithm(int numAllocated, int numPages) {
      super(numAllocated);
      accessCount = new int[numPages];
   }

   public String getName() {
      return "LFU";
   }

   public int processReference(int p) {
      accessCount[p]++;
      return super.processReference(p);
   }

   public int nextVictim(int p) {
      for (int i = 0; i < numAllocated; i++) {
         if (!validTable[i])
            return i;
      }

      int minPos = 0;
      int minCount = accessCount[0];
      for (int i = 1; i < numAllocated; i++) {
         if (accessCount[i] < minCount) {
            minPos = i;
            minCount = accessCount[i];
         }
      }
      return minPos;
   }
}
