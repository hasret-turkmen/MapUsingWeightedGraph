# MapUsingWeightedGraph
Two projects which work as a navigation app with different requirements

FIRST PROJECT------
In the input, the first line defines the total number of streets, the second line defines the number of 
connections between the streets, and the rest of the lines define the connections and the distance 
between the streets. And the last lines define the starting points and the delivery addresses for the 
letters you need to deliver.

Let assume that you need to deliver the letter from street A to street F by using the streets which 
shorten the distance. Here is a example input:
6
8
A B 3
A D 7
B C 5
B E 4
C E 2
D E 1
D F 7
E F 10
A B
B C
C D
D E
E F

Here is the output:
3
6
3
1
8
------

SECOND PROJECT---
In the input, the first line defines the total number of roads, the second line defines the number of 
connections between the roads, and the rest of the lines define the connections and the duration 
you wait on the traffic lights between the roads.

Let assume that your house is on the road A and post office is on the road F, you need to find the 
total time you waste on traffic lights when you eliminate some of the roads according to the rules 
explained above.
Here is an example input:
6
8
A B 11
A D 5
B C 12
B D 7
C E 14
C F 22
D E 16
E F 20
A F

Output will show how many roads you excluded and which roads are they. Also, the total lenght.
58
3
A B
D E 
C F
