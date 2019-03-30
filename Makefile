ifeq (run,$(firstword $(MAKECMDGOALS)))
 RUN_ARGS := $(wordlist 2, $(words $(MAKECMDGOALS)), $(MAKECMDGOALS))
 $(eval $(RUN_ARGS):;@:)
endif

all:
	@find . -name "*.java" -print0 | xargs -0 javac -sourcepath ./src 

.phony: run all

run:
	@java -classpath ./src/ avaj/Simulator/Simulator $(RUN_ARGS)

