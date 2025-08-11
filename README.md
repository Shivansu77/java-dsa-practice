# Java DSA Practice Repository

A collection of Java implementations for common Data Structures and Algorithms (DSA), organized by topic (graphs, trees, heaps, recursion/backtracking, stacks/queues, etc.). This repository is intended for practice, interview prep, and reference. It’s structured so you can run or focus on a single problem/class easily from your IDE or the command line.

Last updated: 2025-08-11

## Contents
- Overview
- Project structure
- Prerequisites
- Running code
  - From IntelliJ IDEA
  - From the command line
  - Compiling a single file with the provided script
- Adding a new problem/class
- Tips and conventions
- Notes on licensing

## Overview
Each topic has its own package under `src/`. Many classes implement a specific problem (often from platforms like LeetCode/GFG) and may contain a `main` method or methods you can call from a small driver/main.

Notable packages include:
- `src/graphs` – Graph algorithms/problems (e.g., cycles, connectivity, islands, shortest paths)
- `src/trees` – Tree traversals, serialization/deserialization, BST corrections
- `src/stackandques` – Stack/queue problems (e.g., stock span, next greater element, daily temperatures)
- `src/heaps` – Heap utilities and problems
- `src/recursion` and `src/recursionBacktracking` – Recursion, N-Queens, word search, etc.
- `src/GFG`, `src/arc2`, `src/codeforcez` – Problem-specific or contest solutions

## Project structure
Example (truncated):
```
java-dsa/
├─ README.md
├─ compile_single_file.sh
├─ src/
│  ├─ graphs/
│  │  ├─ LongestCycleInaGraph.java
│  │  ├─ makeConnected.java
│  │  ├─ numIslands.java
│  │  └─ ...
│  ├─ trees/
│  │  ├─ Node.java
│  │  ├─ serializeAndDeserial.java
│  │  └─ ...
│  ├─ stackandques/
│  │  ├─ stockspan.java
│  │  ├─ nextGreater.java
│  │  └─ dailyTemp.java
│  └─ ...
└─ out/production/java-dsa/... (compiled classes if using IntelliJ)
```

## Prerequisites
- Java JDK 8 or later (JDK 17 recommended)
- Bash (for the optional helper script)
- IntelliJ IDEA (recommended) or any Java-compatible IDE/editor

Check your Java version:
```
java -version
javac -version
```

## Running code
You can run problems either from IntelliJ IDEA or the command line.

### 1) IntelliJ IDEA (recommended)
- Open the project in IntelliJ IDEA.
- Locate the class you want to run (preferably one with a `public static void main(String[] args)` method).
- Right-click the file and choose Run.

If a class doesn’t include a `main` method, you can either:
- Create a small driver `Main` in the same package to call the methods you want to test, or
- Temporarily add a `main` method in that class for quick testing.

### 2) Command line
From the project root, compile a file and run it. For example, to run a class with a `main` in `src/stackandques/stockspan.java` (class name is `StockSpan`):
```
javac -d out src/stackandques/stockspan.java
java -cp out stackandques.StockSpan
```
Notes:
- Ensure the package declaration at the top of the file matches its folder path (e.g., `package stackandques;`).
- The class names follow PascalCase (e.g., StockSpan, NextGreater, DailyTemperatures) but some filenames may remain lowercase on case-insensitive filesystems.
- If the class has dependencies in the same package, compile the entire package:
```
javac -d out src/stackandques/*.java
java -cp out stackandques.StockSpan
```

### 3) Compile only a specific Java file (IntelliJ integration)
This repository includes a utility script to configure IntelliJ IDEA so that only a specific Java file is compiled when you build the project. This can speed up iteration on a single problem.

Usage:
```
./compile_single_file.sh <path_to_java_file>
```
Example:
```
./compile_single_file.sh src/arc2/maxPathSum.java
```
What it does:
- Updates IntelliJ’s `.idea/compiler.xml` to exclude all Java files except the one you specify.
- After running the script, build the project in IntelliJ; only that file will compile.

Requirements for the script:
- Bash shell
- IntelliJ IDEA

Note: The script edits your IntelliJ configuration. You can revert by re-enabling compilation for other files in IntelliJ or by re-running the script with a different target file.

## Adding a new problem/class
1. Choose the appropriate package under `src/` (e.g., `graphs`, `trees`, `stackandques`).
2. Create a new `.java` file with a clear name and correct `package` declaration.
3. Implement your solution. Optionally add a small `main` for quick manual tests.
4. If needed, write a tiny driver in the same package to exercise non-`main` utilities.

Example template:
```
package graphs;

public class MyGraphProblem {
    public static void main(String[] args) {
        // quick manual tests
    }

    // solution methods here
}
```

## Tips and conventions
- Keep classes in the correct package and folder.
- Prefer descriptive class names that reflect the problem.
- For algorithms that require input parsing (e.g., from standard input), consider adding a simple `main` that demonstrates usage or reads sample input.
- For performance-sensitive problems, document time/space complexities in comments.

## Notes on licensing
No explicit license file is provided. If you plan to reuse or distribute code, please contact the repository owner or add a suitable license file (e.g., MIT) to clarify terms.

---
If you run into issues or want a quick start for a specific file, feel free to use the single-file compile helper and run from IntelliJ. Happy coding!
