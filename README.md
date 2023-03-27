test with json array 

result:
<pre>
Benchmark          (arrayLength)  Mode  Cnt         Score         Error  Units
Benchmark.jackson             10  avgt    5     25896.025 ±    2355.870  ns/op
Benchmark.jackson            100  avgt    5    265394.708 ±   41433.200  ns/op
Benchmark.jackson           5000  avgt    5  15812149.049 ± 3293477.263  ns/op
Benchmark.ktx                 10  avgt    5     16521.289 ±    1348.459  ns/op
Benchmark.ktx                100  avgt    5    165504.672 ±   15424.897  ns/op
Benchmark.ktx               5000  avgt    5   8709948.168 ±  523546.473  ns/op
</pre>