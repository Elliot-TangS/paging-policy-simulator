public class LRUAlgorithm extends ReplacementAlgorithmBase {
   private int index;
   private int accessTime[];

   public LRUAlgorithm(int numAllocated) {
      super(numAllocated);
      accessTime = new int[numAllocated];
   }

   public String getName() {
      return "LRU";
   }

   public int processReference(int p) {
      int l = inMemory(p);
      if (l >= 0) {
         accessTime[l] = index;
      }
      index++;
      return super.processReference(p);
   }

   public int nextVictim(int p) {
      for (int i = 0; i < numAllocated; i++) {
         if (!validTable[i])
            return i;
      }

      int minPos = 0;
      int minTime = accessTime[0];
      for (int i = 1; i < numAllocated; i++) {
         if (accessTime[i] < minTime) {
            minPos = i;
            minTime = accessTime[i];
         }
      }
      accessTime[minPos] = index - 1;
      return minPos;
   }
}
