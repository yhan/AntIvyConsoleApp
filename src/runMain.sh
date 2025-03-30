#!/bin/bash

# Include the variable definitions
source ./def.sh

# Change to the source directory
cd "$PROJECT_DIR" || exit 1

java  -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 \
  Main


# to disable java debug, compile it without debug info
# javac -d out src/pkg.default2.pkg.default.Main.java