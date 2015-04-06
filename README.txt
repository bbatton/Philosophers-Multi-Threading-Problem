Philosophers Multi-Threading Problem
====================================
Five philosophers are seated around a circular table. Each philosopher has a plate of spaghetti. The spaghetti is so slippery that a philosopher needs two forks to eat it. Between each pair of plates is one fork.The life of a philosopher consists of alternating periods of eating and thinking. (This is something of an abstraction, even for philosophers, but the other activities are irrelevant here.) When a philosopher gets sufficiently hungry, she tries to acquire her left and right forks, one at a time, in either order. If successful in acquiring two forks, she eats for a while, then puts down the forks, and continues to think.

The goal is to prevent dead locks where all the philosophers pick up their left or inversely their right fork and become stuck. Also to prevent starvation were some of the philosophers are not able to eat since the other philosophers are hoarding the forks.


#Solution

I simply created a semaphore for each fork with a fairness argument so that all the philosophers would equally have a chance to eat. My solution comes with a very simply GUI to illustrate what is going on as well as a detailed console out for every state change.
