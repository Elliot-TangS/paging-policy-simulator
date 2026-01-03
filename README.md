# Page Replacement Simulator (Demand Paging Simulation)

A Java-based demand paging simulator that benchmarks classic page replacement algorithms (FIFO, LRU, LFU, MFU, Optimal, Random) under different memory frame sizes and reference string patterns.  
This project is designed to help understand OS virtual memory behavior and compare algorithm performance by measuring page faults and fault rates.

---

## ✨ Features

- Implements multiple **page replacement algorithms**:
  - FIFO (First In First Out)
  - LRU (Least Recently Used)
  - LFU (Least Frequently Used)
  - MFU (Most Frequently Used)
  - OPT / Optimal
  - Random
- Simulates **demand paging** with configurable memory frame sizes
- Tracks:
  - Total page faults
  - Page fault rate
  - Replacement decisions
- Allows easy extension: add your own algorithm by implementing `ReplacementAlgorithm`

---

## 🧠 Background

In OS virtual memory, **demand paging** loads pages into memory only when accessed.  
When the frame (memory capacity) is full, the OS must evict a page based on a **page replacement policy**.

This simulator demonstrates how different policies behave under various workloads and helps visualize tradeoffs:
- locality-aware algorithms (e.g., LRU) often outperform simple policies (e.g., FIFO)
- OPT provides the theoretical minimum page faults but is not implementable in real systems

---

## 🏗 Project Structure

```text
.
├── DemandPagingSimulation.java        # Main entry: runs simulations and reports results
├── ReplacementAlgorithm.java          # Interface for all algorithms
├── ReplacementAlgorithmBase.java      # Base class with shared logic
├── FIFOAlgorithm.java
├── LRUAlgorithm.java
├── LFUAlgorithm.java
├── MFUAlgorithm.java
├── OptimalAlgorithm.java
└── RandomAlgorithm.java
