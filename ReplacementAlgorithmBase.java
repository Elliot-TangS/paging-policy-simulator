public abstract class ReplacementAlgorithmBase implements ReplacementAlgorithm {
   protected int numAllocated;
   protected int[] pageTable;
   protected boolean[] validTable;
   protected int faults;

   public ReplacementAlgorithmBase(int numAllocated) {
      this.numAllocated = numAllocated;
      pageTable = new int[numAllocated];
      validTable = new boolean[numAllocated];
      faults = 0;
      for (int i = 0; i < numAllocated; i++) {
         validTable[i] = false;
      }
   }

   public int processReference(int p) {
      if (inMemory(p) >= 0) {
         return -1;
      } else {
         int victim = nextVictim(p);
         pageTable[victim] = p;
         validTable[victim] = true;
         faults++;
         return victim;
      }
   }

   protected int inMemory(int target) {
      int i = 0;

      for (i = 0; i < pageTable.length && !(validTable[i] && pageTable[i] == target); i++)
         ;

      if (i < pageTable.length)
         return i;
      else
         return -1;
   }

   public int nextVictim() {
      return 0;
   }
   
   public int getFaults() {
      return faults;
   }
   
   public String toString() {
      String s = "[";
      for (int i = 0; i < numAllocated; i++) {
         s = s + (validTable[i] ? pageTable[i] : "-") + " ";
      }
      return s + "]";
   }
}
