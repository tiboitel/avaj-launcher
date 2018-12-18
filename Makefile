
all:
	find . -name "*.java" -print0 | xargs -0 javac -sourcepath ./src 

run:
	java -classpath ./src/ avaj/Simulator/Simulator $(FILE)
