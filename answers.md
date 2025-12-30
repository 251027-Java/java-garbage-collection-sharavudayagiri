### Questions and Answers

1. How many Minor GCs occurred?

99 Minor GCs

2. How many Major/Full GCs occurred?

3 Full GCs 

3. What was the longest GC pause time?

50.146 ms 



| GC Type | Total GC Events | Longest Pause | Throughput |
|---------|-----------------|---------------|------------|
| Serial  | 18              | 33.537ms      | 98.97%     |
| G1GC    | 208             | 41.879ms      | 96.57%     |
| ZGC     | 38              | 0.074ms       | 99.99%     |


1. Did G1GC achieve the target pause time?

Yes

2. What trade-offs did you observe?

- Lower pause times (41.9ms → 31.2ms) 
- Same number of GC events (no increase in GC frequency)
- Slightly faster runtime


