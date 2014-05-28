JFLAGS = -g
JC = javac
JVM = java
JDOC = javadoc -d

FILE=
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        PhysicsLab.java \
        Ball.java \
        BallView.java \
        LabMenuListener.java \
        PhysicsElement.java \
        ShapesDemo2D.java \
		MenuDemo.java \
		Simulateable.java \
		MyWorldView.java \
		MyWorld.java 
		
		
MAIN = PhysicsLab

.PHONY: all run clean doc

all: $(CLASSES:.java=.class)

run: $(MAIN).class 
	$(JVM) $(MAIN) $(FILE)

clean:
	$(RM) *.class

doc:
	$(JDOC) . *.java		
