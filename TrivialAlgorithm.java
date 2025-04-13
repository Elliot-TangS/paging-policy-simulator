public class TrivialAlgorithm extends ReplacementAlgorithmBase {
   public TrivialAlgorithm(int numAllocated) {   
      super(numAllocated);
   }
   
   public String getName() {
      return "TRIV";
   }

   public int nextVictim(int p) {
      return 0;
   }
}
