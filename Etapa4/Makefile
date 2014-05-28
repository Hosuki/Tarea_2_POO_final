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
        FixedHook.java \
        FixedHookView.java \
        LabMenuListener.java \
        MouseListener.java \
        PhysicsElement.java \
        Simulateable.java \
		MyWorldView.java \
		Spring.java \
		SpringView.java \
		SpringAttachable.java \
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
