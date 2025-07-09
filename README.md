# java-dsa-practice

## Single File Compilation

This repository includes a utility script to compile only a specific Java file, rather than compiling all files in the project simultaneously. This can be useful when working on individual data structure or algorithm implementations.

### Usage

To compile only a specific Java file:

```bash
./compile_single_file.sh <path_to_java_file>
```

Example:

```bash
./compile_single_file.sh src/arc2/maxPathSum.java
```

This will update the IntelliJ IDEA compiler configuration to exclude all Java files except the specified one. After running this script, when you build the project in IntelliJ IDEA, only the specified file will be compiled.

### How It Works

The script modifies the `.idea/compiler.xml` file to exclude all Java files except the one you want to compile. This is done by:

1. Finding all Java files in the project
2. Adding all files except the specified one to the `excludeFromCompile` list in the compiler configuration
3. Updating the compiler.xml file with the new configuration

### Requirements

- Bash shell
- IntelliJ IDEA
