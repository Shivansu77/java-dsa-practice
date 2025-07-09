#!/bin/bash

# Check if a file path is provided
if [ $# -ne 1 ]; then
    echo "Usage: $0 <java_file_path>"
    echo "Example: $0 src/arc2/maxPathSum.java"
    exit 1
fi

# Get the absolute path of the file
FILE_TO_COMPILE=$(realpath "$1")
PROJECT_DIR=$(pwd)

# Check if the file exists
if [ ! -f "$FILE_TO_COMPILE" ]; then
    echo "Error: File $FILE_TO_COMPILE does not exist"
    exit 1
fi

# Check if it's a Java file
if [[ "$FILE_TO_COMPILE" != *.java ]]; then
    echo "Error: $FILE_TO_COMPILE is not a Java file"
    exit 1
fi

# Create a temporary file for the new compiler.xml
TEMP_FILE=$(mktemp)

# Start writing the new compiler.xml
cat > "$TEMP_FILE" << EOL
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="CompilerConfiguration">
    <excludeFromCompile>
EOL

# Find all Java files and exclude all except the one to compile
find "$PROJECT_DIR/src" -name "*.java" | while read -r java_file; do
    # Get the relative path for IntelliJ format
    rel_path=${java_file#"$PROJECT_DIR/"}

    # Skip the file we want to compile and TreeNode.java if compiling maxPathSum.java
    if [ "$java_file" != "$FILE_TO_COMPILE" ] && ([ "$FILE_TO_COMPILE" != *"maxPathSum.java" ] || [ "$java_file" != *"TreeNode.java" ]); then
        echo "      <file url=\"file://\$PROJECT_DIR\$/${rel_path}\" />" >> "$TEMP_FILE"
    fi
done

# Finish the compiler.xml file
cat >> "$TEMP_FILE" << EOL
    </excludeFromCompile>
  </component>
</project>
EOL

# Replace the original compiler.xml with our new one
cp "$TEMP_FILE" "$PROJECT_DIR/.idea/compiler.xml"
rm "$TEMP_FILE"

echo "Configuration updated. Only $1 will be compiled."
