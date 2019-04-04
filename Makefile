ifeq (run,$(firstword $(MAKECMDGOALS)))
 RUN_ARGS := $(wordlist 2, $(words $(MAKECMDGOALS)), $(MAKECMDGOALS))
 $(eval $(RUN_ARGS):;@:)
endif

all:
	@find . -name "*.java" -print0 | xargs -0 javac

clean:
	@find . -name "*.class" -print0 | xargs -0 rm -rf

re: clean all

run:
	java avaj.Simulator.Simulator $(RUN_ARGS)

.phony: run all
