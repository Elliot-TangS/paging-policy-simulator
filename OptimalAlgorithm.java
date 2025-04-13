import java.util.ArrayList;

public class OptimalAlgorithm extends ReplacementAlgorithmBase {
   private int index;
   private ArrayList<Integer> references;

   public OptimalAlgorithm(int numAllocated, ArrayList<Integer> ref) {
      super(numAllocated);
      index = 0;
      references = ref;
   }

   public String getName() {
      return "OPT";
   }

   public int processReference(int p) {
      index++;
      return super.processReference(p);
   }

   public int nextVictim(int p) {
      for (int i = 0; i < numAllocated; i++) {
         if (!validTable[i])
            return i;
      }

      boolean[] seen = new boolean[numAllocated];

      int longest = 0;
      for (int i = index; i < references.size(); i++) {
         int r = references.get(i);

         int l = inMemory(r);
         if (l >= 0 && !seen[l]) {
            seen[l] = true;
            longest = l;
         }
      }

      for (int i = 0; i < numAllocated; i++) {
         if (!seen[i])
            return i;
      }

      return longest;
   }
}
