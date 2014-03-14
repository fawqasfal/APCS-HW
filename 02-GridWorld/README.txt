This is the Part II homework of the Case Study (to see the problems, go to the Student Manual and head over to Part II).

To see the code that I wrote, go to GridWorldCode/projects/firstProject. All the java files should be there. To check the functionality of each variant bug, just run 

java -cp ../../gridworld.jar:. [NAME-OF-VARIANT-BUG]Runner

So, for example, to deal with CircleBugs:

java -cp ../../gridworld.jar:. BoxBugRunner

PROBLEMS : 

I realized that loops in act() is a problem because it blocks computation which messes with animation. So, my ZBug does indeed go in Z-shape, but you don't see it moving because my act() is looping so it prevents the computer from running WhateverHasToBeDoneEveryXSecondsToDisplayAnimation(). 


