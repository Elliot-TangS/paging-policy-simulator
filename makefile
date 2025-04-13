all : DemandPagingSimulation.class FIFOAlgorithm.class LFUAlgorithm.class LRUAlgorithm.class MFUAlgorithm.class OptimalAlgorithm.class RandomAlgorithm.class ReplacementAlgorithm.class ReplacementAlgorithmBase.class TrivialAlgorithm.class

clean :
	-rm *.class 2> /dev/null

DemandPagingSimulation.class : DemandPagingSimulation.java
	javac DemandPagingSimulation.java

FIFOAlgorithm.class : FIFOAlgorithm.java
	javac FIFOAlgorithm.java

LFUAlgorithm.class : LFUAlgorithm.java
	javac LFUAlgorithm.java

LRUAlgorithm.class : LRUAlgorithm.java
	javac LRUAlgorithm.java

MFUAlgorithm.class : MFUAlgorithm.java
	javac MFUAlgorithm.java

OptimalAlgorithm.class : OptimalAlgorithm.java
	javac OptimalAlgorithm.java

RandomAlgorithm.class : RandomAlgorithm.java
	javac RandomAlgorithm.java

ReplacementAlgorithm.class : ReplacementAlgorithm.java
	javac ReplacementAlgorithm.java

ReplacementAlgorithmBase.class : ReplacementAlgorithmBase.java
	javac ReplacementAlgorithmBase.java

TrivialAlgorithm.class : TrivialAlgorithm.java
	javac TrivialAlgorithm.java
