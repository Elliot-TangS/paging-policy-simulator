public interface ReplacementAlgorithm {
   public String getName();
   public int processReference(int p);
   public int nextVictim(int p);
   public int getFaults();
}
