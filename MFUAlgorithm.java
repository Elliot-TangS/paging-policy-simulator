public class MFUAlgorithm extends ReplacementAlgorithmBase {
   private int accessCount[];

   public MFUAlgorithm(int numAllocated, int numPages) {
      super(numAllocated);
      accessCount = new int[numPages];
   }

   public String getName() {
      return "MFU";
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

      int maxPos = 0;
      int maxCount = accessCount[0];
      for (int i = 1; i < numAllocated; i++) {
         if (accessCount[i] > maxCount) {
            maxPos = i;
            maxCount = accessCount[i];
         }
      }
      return maxPos;
   }
}
