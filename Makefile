# Compiler and compiler flags
JC = javac
JFLAGS = -g

# Directory structure
SRC_DIR = src\clubSimulation
BIN_DIR = bin\clubSimulation

# Source files and class files
SOURCES := $(wildcard $(SRC_DIR)/*.java)
CLASSES := $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

# Targets
.PHONY: all clean

all: $(CLASSES)

$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(BIN_DIR)
	$(JC) $(JFLAGS) -d $(BIN_DIR) $<

clean:
	@rm -rf $(BIN_DIR)

run: all
	java -cp $(BIN_DIR) ClubSimulation

