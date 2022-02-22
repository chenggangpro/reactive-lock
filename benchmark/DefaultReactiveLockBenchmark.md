### Throughput

```txt
# Detecting actual CPU count: 8 detected
# JMH version: 1.34
# VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 114777.060 ops/s
Iteration   1: 47686.120 ops/s
Iteration   2: 21885.276 ops/s
Iteration   3: 78704.013 ops/s
Iteration   4: 78268.418 ops/s
Iteration   5: 85202.340 ops/s

# Run progress: 10.00% complete, ETA 00:13:57
# Fork: 2 of 5
# Warmup Iteration   1: 103310.686 ops/s
Iteration   1: 57101.001 ops/s
Iteration   2: 41055.038 ops/s
Iteration   3: 82416.857 ops/s
Iteration   4: 74430.282 ops/s
Iteration   5: 74674.144 ops/s

# Run progress: 20.00% complete, ETA 00:12:03
# Fork: 3 of 5
# Warmup Iteration   1: 124582.624 ops/s
Iteration   1: 62659.807 ops/s
Iteration   2: 75677.325 ops/s
Iteration   3: 73659.317 ops/s
Iteration   4: 76756.586 ops/s
Iteration   5: 77990.120 ops/s

# Run progress: 30.00% complete, ETA 00:10:17
# Fork: 4 of 5
# Warmup Iteration   1: 124635.774 ops/s
Iteration   1: 67778.841 ops/s
Iteration   2: 76364.866 ops/s
Iteration   3: 73277.990 ops/s
Iteration   4: 73205.054 ops/s
Iteration   5: 74284.736 ops/s

# Run progress: 40.00% complete, ETA 00:08:42
# Fork: 5 of 5
# Warmup Iteration   1: 132251.728 ops/s
Iteration   1: 66383.643 ops/s
Iteration   2: 67160.324 ops/s
Iteration   3: 82669.241 ops/s
Iteration   4: 74604.474 ops/s
Iteration   5: 73213.516 ops/s


Result "pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire":
  69484.373 ±(99.9%) 10690.659 ops/s [Average]
  (min, avg, max) = (21885.276, 69484.373, 85202.340), stdev = 14271.724
  CI (99.9%): [58793.714, 80175.032] (assumes normal distribution)


# JMH version: 1.34
# VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:13
# Fork: 1 of 5
# Warmup Iteration   1: 1634723.664 ops/s
Iteration   1: 1371304.720 ops/s
Iteration   2: 1300993.755 ops/s
Iteration   3: 1528313.640 ops/s
Iteration   4: 1286488.991 ops/s
Iteration   5: 1453102.171 ops/s

# Run progress: 60.00% complete, ETA 00:05:37
# Fork: 2 of 5
# Warmup Iteration   1: 1633174.215 ops/s
Iteration   1: 1304463.749 ops/s
Iteration   2: 1474317.438 ops/s
Iteration   3: 1299837.834 ops/s
Iteration   4: 1543049.470 ops/s
Iteration   5: 1260974.235 ops/s

# Run progress: 70.00% complete, ETA 00:04:07
# Fork: 3 of 5
# Warmup Iteration   1: 1621412.084 ops/s
Iteration   1: 1276881.880 ops/s
Iteration   2: 1251603.696 ops/s
Iteration   3: 1400158.667 ops/s
Iteration   4: 1282586.518 ops/s
Iteration   5: 1437404.511 ops/s

# Run progress: 80.00% complete, ETA 00:02:42
# Fork: 4 of 5
# Warmup Iteration   1: 1646184.855 ops/s
Iteration   1: 1318144.456 ops/s
Iteration   2: 1435354.985 ops/s
Iteration   3: 1296365.904 ops/s
Iteration   4: 1437217.511 ops/s
Iteration   5: 1350622.877 ops/s

# Run progress: 90.00% complete, ETA 00:01:20
# Fork: 5 of 5
# Warmup Iteration   1: 1677176.099 ops/s
Iteration   1: 1221785.120 ops/s
Iteration   2: 1328497.900 ops/s
Iteration   3: 1382325.571 ops/s
Iteration   4: 1180384.729 ops/s
Iteration   5: 1335952.246 ops/s


Result "pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock":
  1350325.303 ±(99.9%) 70065.971 ops/s [Average]
  (min, avg, max) = (1180384.729, 1350325.303, 1543049.470), stdev = 93536.066
  CI (99.9%): [1280259.332, 1420391.274] (assumes normal distribution)


# Run complete. Total time: 00:13:14

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                                       Mode  Cnt        Score       Error  Units
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire  thrpt   25    69484.373 ± 10690.659  ops/s
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock     thrpt   25  1350325.303 ± 70065.971  ops/s
```

### Sample Time

```txt
# Detecting actual CPU count: 8 detected
# JMH version: 1.34
# VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Sampling time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 69491.666 ±(99.9%) 20620.662 ns/op
Iteration   1: 138546.201 ±(99.9%) 77175.900 ns/op
                 testLockExpire·p0.00:   3200.000 ns/op
                 testLockExpire·p0.50:   7296.000 ns/op
                 testLockExpire·p0.90:   9680.000 ns/op
                 testLockExpire·p0.95:   24096.000 ns/op
                 testLockExpire·p0.99:   386048.000 ns/op
                 testLockExpire·p0.999:  2490875.904 ns/op
                 testLockExpire·p0.9999: 15689265.971 ns/op
                 testLockExpire·p1.00:   3535798272.000 ns/op

Iteration   2: 119494.395 ±(99.9%) 61459.435 ns/op
                 testLockExpire·p0.00:   3032.000 ns/op
                 testLockExpire·p0.50:   7752.000 ns/op
                 testLockExpire·p0.90:   10672.000 ns/op
                 testLockExpire·p0.95:   31456.000 ns/op
                 testLockExpire·p0.99:   420864.000 ns/op
                 testLockExpire·p0.999:  3302670.336 ns/op
                 testLockExpire·p0.9999: 13150748.672 ns/op
                 testLockExpire·p1.00:   2621440000.000 ns/op

Iteration   3: 96316.212 ±(99.9%) 53309.979 ns/op
                 testLockExpire·p0.00:   2552.000 ns/op
                 testLockExpire·p0.50:   4068.000 ns/op
                 testLockExpire·p0.90:   9216.000 ns/op
                 testLockExpire·p0.95:   62336.000 ns/op
                 testLockExpire·p0.99:   289792.000 ns/op
                 testLockExpire·p0.999:  1148928.000 ns/op
                 testLockExpire·p0.9999: 4381241.344 ns/op
                 testLockExpire·p1.00:   3087007744.000 ns/op

Iteration   4: 95058.145 ±(99.9%) 52338.723 ns/op
                 testLockExpire·p0.00:   2452.000 ns/op
                 testLockExpire·p0.50:   4052.000 ns/op
                 testLockExpire·p0.90:   6968.000 ns/op
                 testLockExpire·p0.95:   60032.000 ns/op
                 testLockExpire·p0.99:   306688.000 ns/op
                 testLockExpire·p0.999:  1286144.000 ns/op
                 testLockExpire·p0.9999: 5953265.664 ns/op
                 testLockExpire·p1.00:   3313500160.000 ns/op

Iteration   5: 82709.706 ±(99.9%) 43636.422 ns/op
                 testLockExpire·p0.00:   2428.000 ns/op
                 testLockExpire·p0.50:   4056.000 ns/op
                 testLockExpire·p0.90:   6701.600 ns/op
                 testLockExpire·p0.95:   58432.000 ns/op
                 testLockExpire·p0.99:   288256.000 ns/op
                 testLockExpire·p0.999:  1431552.000 ns/op
                 testLockExpire·p0.9999: 8066624.717 ns/op
                 testLockExpire·p1.00:   3279945728.000 ns/op

<JMH had finished, but forked VM did not exit, are there stray running threads? Waiting 24 seconds more...>

Non-finished threads:

Thread[DestroyJavaVM,5,main]



# Run progress: 10.00% complete, ETA 00:13:11
# Fork: 2 of 5
# Warmup Iteration   1: 71676.145 ±(99.9%) 20332.360 ns/op
Iteration   1: 136572.433 ±(99.9%) 76221.447 ns/op
                 testLockExpire·p0.00:   2836.000 ns/op
                 testLockExpire·p0.50:   6072.000 ns/op
                 testLockExpire·p0.90:   9328.000 ns/op
                 testLockExpire·p0.95:   31424.000 ns/op
                 testLockExpire·p0.99:   368640.000 ns/op
                 testLockExpire·p0.999:  2531328.000 ns/op
                 testLockExpire·p0.9999: 14049427.456 ns/op
                 testLockExpire·p1.00:   3435134976.000 ns/op

Iteration   2: 134425.349 ±(99.9%) 66235.091 ns/op
                 testLockExpire·p0.00:   2192.000 ns/op
                 testLockExpire·p0.50:   4824.000 ns/op
                 testLockExpire·p0.90:   8512.000 ns/op
                 testLockExpire·p0.95:   44288.000 ns/op
                 testLockExpire·p0.99:   315904.000 ns/op
                 testLockExpire·p0.999:  1939456.000 ns/op
                 testLockExpire·p0.9999: 12114178.867 ns/op
                 testLockExpire·p1.00:   2642411520.000 ns/op

Iteration   3: 77552.329 ±(99.9%) 41240.210 ns/op
                 testLockExpire·p0.00:   2388.000 ns/op
                 testLockExpire·p0.50:   4104.000 ns/op
                 testLockExpire·p0.90:   14704.000 ns/op
                 testLockExpire·p0.95:   68864.000 ns/op
                 testLockExpire·p0.99:   293376.000 ns/op
                 testLockExpire·p0.999:  1345667.072 ns/op
                 testLockExpire·p0.9999: 6214503.629 ns/op
                 testLockExpire·p1.00:   2936012800.000 ns/op

Iteration   4: 98653.966 ±(99.9%) 52167.889 ns/op
                 testLockExpire·p0.00:   2696.000 ns/op
                 testLockExpire·p0.50:   4120.000 ns/op
                 testLockExpire·p0.90:   9968.000 ns/op
                 testLockExpire·p0.95:   60672.000 ns/op
                 testLockExpire·p0.99:   301056.000 ns/op
                 testLockExpire·p0.999:  1473988.608 ns/op
                 testLockExpire·p0.9999: 7034832.486 ns/op
                 testLockExpire·p1.00:   3204448256.000 ns/op

Iteration   5: 94127.186 ±(99.9%) 49224.095 ns/op
                 testLockExpire·p0.00:   2564.000 ns/op
                 testLockExpire·p0.50:   4096.000 ns/op
                 testLockExpire·p0.90:   8608.000 ns/op
                 testLockExpire·p0.95:   58624.000 ns/op
                 testLockExpire·p0.99:   316416.000 ns/op
                 testLockExpire·p0.999:  1376768.000 ns/op
                 testLockExpire·p0.9999: 7697408.000 ns/op
                 testLockExpire·p1.00:   2965372928.000 ns/op

<JMH had finished, but forked VM did not exit, are there stray running threads? Waiting 24 seconds more...>

Non-finished threads:

Thread[DestroyJavaVM,5,main]



# Run progress: 20.00% complete, ETA 00:11:52
# Fork: 3 of 5
# Warmup Iteration   1: 68479.761 ±(99.9%) 20129.475 ns/op
Iteration   1: 134126.292 ±(99.9%) 75782.386 ns/op
                 testLockExpire·p0.00:   2960.000 ns/op
                 testLockExpire·p0.50:   5760.000 ns/op
                 testLockExpire·p0.90:   10032.000 ns/op
                 testLockExpire·p0.95:   34240.000 ns/op
                 testLockExpire·p0.99:   380416.000 ns/op
                 testLockExpire·p0.999:  2170023.936 ns/op
                 testLockExpire·p0.9999: 10840950.374 ns/op
                 testLockExpire·p1.00:   3388997632.000 ns/op

Iteration   2: 114108.023 ±(99.9%) 56332.096 ns/op
                 testLockExpire·p0.00:   2840.000 ns/op
                 testLockExpire·p0.50:   4068.000 ns/op
                 testLockExpire·p0.90:   8976.000 ns/op
                 testLockExpire·p0.95:   62016.000 ns/op
                 testLockExpire·p0.99:   322048.000 ns/op
                 testLockExpire·p0.999:  1369415.680 ns/op
                 testLockExpire·p0.9999: 7699349.504 ns/op
                 testLockExpire·p1.00:   2805989376.000 ns/op

Iteration   3: 84593.048 ±(99.9%) 45192.247 ns/op
                 testLockExpire·p0.00:   2508.000 ns/op
                 testLockExpire·p0.50:   4160.000 ns/op
                 testLockExpire·p0.90:   16240.000 ns/op
                 testLockExpire·p0.95:   77056.000 ns/op
                 testLockExpire·p0.99:   336896.000 ns/op
                 testLockExpire·p0.999:  1406363.648 ns/op
                 testLockExpire·p0.9999: 6603334.451 ns/op
                 testLockExpire·p1.00:   3179282432.000 ns/op

Iteration   4: 101097.061 ±(99.9%) 54620.617 ns/op
                 testLockExpire·p0.00:   2580.000 ns/op
                 testLockExpire·p0.50:   4144.000 ns/op
                 testLockExpire·p0.90:   7352.000 ns/op
                 testLockExpire·p0.95:   57664.000 ns/op
                 testLockExpire·p0.99:   330752.000 ns/op
                 testLockExpire·p0.999:  1431552.000 ns/op
                 testLockExpire·p0.9999: 4962002.534 ns/op
                 testLockExpire·p1.00:   2915041280.000 ns/op

Iteration   5: 81618.520 ±(99.9%) 44866.404 ns/op
                 testLockExpire·p0.00:   2488.000 ns/op
                 testLockExpire·p0.50:   4136.000 ns/op
                 testLockExpire·p0.90:   13216.000 ns/op
                 testLockExpire·p0.95:   67200.000 ns/op
                 testLockExpire·p0.99:   323584.000 ns/op
                 testLockExpire·p0.999:  1317683.200 ns/op
                 testLockExpire·p0.9999: 3815096.320 ns/op
                 testLockExpire·p1.00:   2894069760.000 ns/op

<JMH had finished, but forked VM did not exit, are there stray running threads? Waiting 24 seconds more...>

Non-finished threads:

Thread[DestroyJavaVM,5,main]



# Run progress: 30.00% complete, ETA 00:10:22
# Fork: 4 of 5
# Warmup Iteration   1: 70884.292 ±(99.9%) 20022.651 ns/op
Iteration   1: 141780.515 ±(99.9%) 77847.007 ns/op
                 testLockExpire·p0.00:   4008.000 ns/op
                 testLockExpire·p0.50:   7056.000 ns/op
                 testLockExpire·p0.90:   12144.000 ns/op
                 testLockExpire·p0.95:   36160.000 ns/op
                 testLockExpire·p0.99:   430592.000 ns/op
                 testLockExpire·p0.999:  2528972.800 ns/op
                 testLockExpire·p0.9999: 14626201.600 ns/op
                 testLockExpire·p1.00:   3535798272.000 ns/op

Iteration   2: 126066.976 ±(99.9%) 61530.170 ns/op
                 testLockExpire·p0.00:   2452.000 ns/op
                 testLockExpire·p0.50:   4272.000 ns/op
                 testLockExpire·p0.90:   8656.000 ns/op
                 testLockExpire·p0.95:   45440.000 ns/op
                 testLockExpire·p0.99:   311808.000 ns/op
                 testLockExpire·p0.999:  1941504.000 ns/op
                 testLockExpire·p0.9999: 11613962.240 ns/op
                 testLockExpire·p1.00:   2831155200.000 ns/op

Iteration   3: 89853.512 ±(99.9%) 49222.134 ns/op
                 testLockExpire·p0.00:   2436.000 ns/op
                 testLockExpire·p0.50:   4168.000 ns/op
                 testLockExpire·p0.90:   14032.000 ns/op
                 testLockExpire·p0.95:   65920.000 ns/op
                 testLockExpire·p0.99:   312832.000 ns/op
                 testLockExpire·p0.999:  1318912.000 ns/op
                 testLockExpire·p0.9999: 4381155.328 ns/op
                 testLockExpire·p1.00:   3087007744.000 ns/op

Iteration   4: 93277.038 ±(99.9%) 49629.023 ns/op
                 testLockExpire·p0.00:   2584.000 ns/op
                 testLockExpire·p0.50:   4176.000 ns/op
                 testLockExpire·p0.90:   16016.000 ns/op
                 testLockExpire·p0.95:   73856.000 ns/op
                 testLockExpire·p0.99:   333312.000 ns/op
                 testLockExpire·p0.999:  1337239.552 ns/op
                 testLockExpire·p0.9999: 4923392.000 ns/op
                 testLockExpire·p1.00:   2915041280.000 ns/op

Iteration   5: 88863.888 ±(99.9%) 49210.256 ns/op
                 testLockExpire·p0.00:   2552.000 ns/op
                 testLockExpire·p0.50:   4176.000 ns/op
                 testLockExpire·p0.90:   11744.000 ns/op
                 testLockExpire·p0.95:   63680.000 ns/op
                 testLockExpire·p0.99:   306176.000 ns/op
                 testLockExpire·p0.999:  1140736.000 ns/op
                 testLockExpire·p0.9999: 4560729.702 ns/op
                 testLockExpire·p1.00:   2994733056.000 ns/op

<JMH had finished, but forked VM did not exit, are there stray running threads? Waiting 24 seconds more...>

Non-finished threads:

Thread[DestroyJavaVM,5,main]



# Run progress: 40.00% complete, ETA 00:08:56
# Fork: 5 of 5
# Warmup Iteration   1: 72948.683 ±(99.9%) 20062.636 ns/op
Iteration   1: 133240.664 ±(99.9%) 72581.237 ns/op
                 testLockExpire·p0.00:   3312.000 ns/op
                 testLockExpire·p0.50:   7048.000 ns/op
                 testLockExpire·p0.90:   10128.000 ns/op
                 testLockExpire·p0.95:   30464.000 ns/op
                 testLockExpire·p0.99:   435143.680 ns/op
                 testLockExpire·p0.999:  2557087.744 ns/op
                 testLockExpire·p0.9999: 12976128.000 ns/op
                 testLockExpire·p1.00:   3355443200.000 ns/op

Iteration   2: 132405.923 ±(99.9%) 63760.658 ns/op
                 testLockExpire·p0.00:   2412.000 ns/op
                 testLockExpire·p0.50:   5656.000 ns/op
                 testLockExpire·p0.90:   9632.000 ns/op
                 testLockExpire·p0.95:   29056.000 ns/op
                 testLockExpire·p0.99:   328704.000 ns/op
                 testLockExpire·p0.999:  2515820.544 ns/op
                 testLockExpire·p0.9999: 14637631.078 ns/op
                 testLockExpire·p1.00:   2613051392.000 ns/op

Iteration   3: 92819.523 ±(99.9%) 49503.842 ns/op
                 testLockExpire·p0.00:   2556.000 ns/op
                 testLockExpire·p0.50:   4112.000 ns/op
                 testLockExpire·p0.90:   15264.000 ns/op
                 testLockExpire·p0.95:   71424.000 ns/op
                 testLockExpire·p0.99:   303104.000 ns/op
                 testLockExpire·p0.999:  1267712.000 ns/op
                 testLockExpire·p0.9999: 6257940.890 ns/op
                 testLockExpire·p1.00:   2969567232.000 ns/op

Iteration   4: 93896.007 ±(99.9%) 49883.343 ns/op
                 testLockExpire·p0.00:   2408.000 ns/op
                 testLockExpire·p0.50:   4088.000 ns/op
                 testLockExpire·p0.90:   11200.000 ns/op
                 testLockExpire·p0.95:   65024.000 ns/op
                 testLockExpire·p0.99:   316928.000 ns/op
                 testLockExpire·p0.999:  1392640.000 ns/op
                 testLockExpire·p0.9999: 5305737.216 ns/op
                 testLockExpire·p1.00:   3045064704.000 ns/op

Iteration   5: 86139.372 ±(99.9%) 47940.229 ns/op
                 testLockExpire·p0.00:   2500.000 ns/op
                 testLockExpire·p0.50:   4060.000 ns/op
                 testLockExpire·p0.90:   7296.000 ns/op
                 testLockExpire·p0.95:   55040.000 ns/op
                 testLockExpire·p0.99:   291328.000 ns/op
                 testLockExpire·p0.999:  1179197.440 ns/op
                 testLockExpire·p0.9999: 5055021.056 ns/op
                 testLockExpire·p1.00:   3103784960.000 ns/op

<JMH had finished, but forked VM did not exit, are there stray running threads? Waiting 24 seconds more...>

Non-finished threads:

Thread[DestroyJavaVM,5,main]




Result "pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire":
  N = 19995332
  mean = 104168.645 ±(99.9%) 11120.767 ns/op

  Histogram, ns/op:
    [         0.000,  250000000.000) = 19994670 
    [ 250000000.000,  500000000.000) = 3 
    [ 500000000.000,  750000000.000) = 27 
    [ 750000000.000, 1000000000.000) = 29 
    [1000000000.000, 1250000000.000) = 10 
    [1250000000.000, 1500000000.000) = 0 
    [1500000000.000, 1750000000.000) = 11 
    [1750000000.000, 2000000000.000) = 13 
    [2000000000.000, 2250000000.000) = 16 
    [2250000000.000, 2500000000.000) = 83 
    [2500000000.000, 2750000000.000) = 189 
    [2750000000.000, 3000000000.000) = 177 
    [3000000000.000, 3250000000.000) = 53 
    [3250000000.000, 3500000000.000) = 35 
    [3500000000.000, 3750000000.000) = 16 

  Percentiles, ns/op:
      p(0.0000) =   2192.000 ns/op
     p(50.0000) =   4248.000 ns/op
     p(90.0000) =  10224.000 ns/op
     p(95.0000) =  55872.000 ns/op
     p(99.0000) = 324096.000 ns/op
     p(99.9000) = 1660928.000 ns/op
     p(99.9900) = 8380416.000 ns/op
     p(99.9990) = 2877292544.000 ns/op
     p(99.9999) = 3435134976.000 ns/op
    p(100.0000) = 3535798272.000 ns/op


# JMH version: 1.34
# VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Sampling time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:26
# Fork: 1 of 5
# Warmup Iteration   1: 10433.937 ±(99.9%) 4956.630 ns/op
Iteration   1: 11343.101 ±(99.9%) 6551.647 ns/op
                 testTryLock·p0.00:   672.000 ns/op
                 testTryLock·p0.50:   1294.000 ns/op
                 testTryLock·p0.90:   1564.000 ns/op
                 testTryLock·p0.95:   1664.000 ns/op
                 testTryLock·p0.99:   3080.000 ns/op
                 testTryLock·p0.999:  179200.000 ns/op
                 testTryLock·p0.9999: 6241053.901 ns/op
                 testTryLock·p1.00:   2046820352.000 ns/op

Iteration   2: 12322.602 ±(99.9%) 6299.980 ns/op
                 testTryLock·p0.00:   670.000 ns/op
                 testTryLock·p0.50:   1296.000 ns/op
                 testTryLock·p0.90:   1546.000 ns/op
                 testTryLock·p0.95:   1640.000 ns/op
                 testTryLock·p0.99:   9488.000 ns/op
                 testTryLock·p0.999:  271360.000 ns/op
                 testTryLock·p0.9999: 5153597.850 ns/op
                 testTryLock·p1.00:   1409286144.000 ns/op

Iteration   3: 13059.622 ±(99.9%) 6666.011 ns/op
                 testTryLock·p0.00:   675.000 ns/op
                 testTryLock·p0.50:   1284.000 ns/op
                 testTryLock·p0.90:   1534.000 ns/op
                 testTryLock·p0.95:   1624.000 ns/op
                 testTryLock·p0.99:   8032.000 ns/op
                 testTryLock·p0.999:  537600.000 ns/op
                 testTryLock·p0.9999: 9609333.965 ns/op
                 testTryLock·p1.00:   1375731712.000 ns/op

Iteration   4: 12574.633 ±(99.9%) 7093.334 ns/op
                 testTryLock·p0.00:   708.000 ns/op
                 testTryLock·p0.50:   1294.000 ns/op
                 testTryLock·p0.90:   1542.000 ns/op
                 testTryLock·p0.95:   1628.000 ns/op
                 testTryLock·p0.99:   8496.000 ns/op
                 testTryLock·p0.999:  259695.104 ns/op
                 testTryLock·p0.9999: 8080016.998 ns/op
                 testTryLock·p1.00:   1635778560.000 ns/op

Iteration   5: 14088.397 ±(99.9%) 9298.266 ns/op
                 testTryLock·p0.00:   722.000 ns/op
                 testTryLock·p0.50:   1324.000 ns/op
                 testTryLock·p0.90:   1568.000 ns/op
                 testTryLock·p0.95:   1654.000 ns/op
                 testTryLock·p0.99:   10816.000 ns/op
                 testTryLock·p0.999:  244480.000 ns/op
                 testTryLock·p0.9999: 6128286.925 ns/op
                 testTryLock·p1.00:   2103443456.000 ns/op


# Run progress: 60.00% complete, ETA 00:05:46
# Fork: 2 of 5
# Warmup Iteration   1: 11467.901 ±(99.9%) 5733.750 ns/op
Iteration   1: 12082.557 ±(99.9%) 10936.356 ns/op
                 testTryLock·p0.00:   704.000 ns/op
                 testTryLock·p0.50:   1370.000 ns/op
                 testTryLock·p0.90:   1662.000 ns/op
                 testTryLock·p0.95:   1742.000 ns/op
                 testTryLock·p0.99:   3850.200 ns/op
                 testTryLock·p0.999:  188672.000 ns/op
                 testTryLock·p0.9999: 7268446.208 ns/op
                 testTryLock·p1.00:   2675965952.000 ns/op

Iteration   2: 9640.012 ±(99.9%) 6217.001 ns/op
                 testTryLock·p0.00:   686.000 ns/op
                 testTryLock·p0.50:   1314.000 ns/op
                 testTryLock·p0.90:   1592.000 ns/op
                 testTryLock·p0.95:   1674.000 ns/op
                 testTryLock·p0.99:   3040.000 ns/op
                 testTryLock·p0.999:  152064.000 ns/op
                 testTryLock·p0.9999: 5826414.182 ns/op
                 testTryLock·p1.00:   1587544064.000 ns/op

Iteration   3: 6978.985 ±(99.9%) 4109.405 ns/op
                 testTryLock·p0.00:   704.000 ns/op
                 testTryLock·p0.50:   1314.000 ns/op
                 testTryLock·p0.90:   1600.000 ns/op
                 testTryLock·p0.95:   1680.000 ns/op
                 testTryLock·p0.99:   2932.000 ns/op
                 testTryLock·p0.999:  138496.000 ns/op
                 testTryLock·p0.9999: 2646627.123 ns/op
                 testTryLock·p1.00:   1455423488.000 ns/op

Iteration   4: 11786.666 ±(99.9%) 6030.067 ns/op
                 testTryLock·p0.00:   669.000 ns/op
                 testTryLock·p0.50:   1304.000 ns/op
                 testTryLock·p0.90:   1602.000 ns/op
                 testTryLock·p0.95:   1694.000 ns/op
                 testTryLock·p0.99:   12688.000 ns/op
                 testTryLock·p0.999:  400393.216 ns/op
                 testTryLock·p0.9999: 10289299.456 ns/op
                 testTryLock·p1.00:   1470103552.000 ns/op

Iteration   5: 9859.038 ±(99.9%) 6604.481 ns/op
                 testTryLock·p0.00:   698.000 ns/op
                 testTryLock·p0.50:   1300.000 ns/op
                 testTryLock·p0.90:   1604.000 ns/op
                 testTryLock·p0.95:   1692.000 ns/op
                 testTryLock·p0.99:   2816.000 ns/op
                 testTryLock·p0.999:  123357.568 ns/op
                 testTryLock·p0.9999: 3869239.706 ns/op
                 testTryLock·p1.00:   1713373184.000 ns/op


# Run progress: 70.00% complete, ETA 00:04:13
# Fork: 3 of 5
# Warmup Iteration   1: 9942.051 ±(99.9%) 5015.486 ns/op
Iteration   1: 11282.436 ±(99.9%) 6147.783 ns/op
                 testTryLock·p0.00:   655.000 ns/op
                 testTryLock·p0.50:   1272.000 ns/op
                 testTryLock·p0.90:   1628.000 ns/op
                 testTryLock·p0.95:   1730.000 ns/op
                 testTryLock·p0.99:   3348.000 ns/op
                 testTryLock·p0.999:  189919.232 ns/op
                 testTryLock·p0.9999: 6508996.198 ns/op
                 testTryLock·p1.00:   1491075072.000 ns/op

Iteration   2: 17201.241 ±(99.9%) 12183.297 ns/op
                 testTryLock·p0.00:   626.000 ns/op
                 testTryLock·p0.50:   1276.000 ns/op
                 testTryLock·p0.90:   1614.000 ns/op
                 testTryLock·p0.95:   1694.000 ns/op
                 testTryLock·p0.99:   11552.000 ns/op
                 testTryLock·p0.999:  372224.000 ns/op
                 testTryLock·p0.9999: 10150821.888 ns/op
                 testTryLock·p1.00:   2734686208.000 ns/op

Iteration   3: 12541.980 ±(99.9%) 7570.755 ns/op
                 testTryLock·p0.00:   702.000 ns/op
                 testTryLock·p0.50:   1250.000 ns/op
                 testTryLock·p0.90:   1586.000 ns/op
                 testTryLock·p0.95:   1664.000 ns/op
                 testTryLock·p0.99:   3400.000 ns/op
                 testTryLock·p0.999:  175268.864 ns/op
                 testTryLock·p0.9999: 7752269.824 ns/op
                 testTryLock·p1.00:   1761607680.000 ns/op

Iteration   4: 12344.056 ±(99.9%) 5176.790 ns/op
                 testTryLock·p0.00:   707.000 ns/op
                 testTryLock·p0.50:   1238.000 ns/op
                 testTryLock·p0.90:   1586.000 ns/op
                 testTryLock·p0.95:   1678.000 ns/op
                 testTryLock·p0.99:   12064.000 ns/op
                 testTryLock·p0.999:  557056.000 ns/op
                 testTryLock·p0.9999: 10748615.066 ns/op
                 testTryLock·p1.00:   1279262720.000 ns/op

Iteration   5: 9840.534 ±(99.9%) 4132.474 ns/op
                 testTryLock·p0.00:   678.000 ns/op
                 testTryLock·p0.50:   1254.000 ns/op
                 testTryLock·p0.90:   1610.000 ns/op
                 testTryLock·p0.95:   1698.000 ns/op
                 testTryLock·p0.99:   14480.000 ns/op
                 testTryLock·p0.999:  480537.600 ns/op
                 testTryLock·p0.9999: 6398894.080 ns/op
                 testTryLock·p1.00:   1043333120.000 ns/op


# Run progress: 80.00% complete, ETA 00:02:47
# Fork: 4 of 5
# Warmup Iteration   1: 8827.064 ±(99.9%) 4257.146 ns/op
Iteration   1: 12654.790 ±(99.9%) 6186.477 ns/op
                 testTryLock·p0.00:   681.000 ns/op
                 testTryLock·p0.50:   1346.000 ns/op
                 testTryLock·p0.90:   1606.000 ns/op
                 testTryLock·p0.95:   1712.000 ns/op
                 testTryLock·p0.99:   4474.800 ns/op
                 testTryLock·p0.999:  356080.640 ns/op
                 testTryLock·p0.9999: 10022477.824 ns/op
                 testTryLock·p1.00:   1453326336.000 ns/op

Iteration   2: 12399.062 ±(99.9%) 7401.539 ns/op
                 testTryLock·p0.00:   683.000 ns/op
                 testTryLock·p0.50:   1312.000 ns/op
                 testTryLock·p0.90:   1544.000 ns/op
                 testTryLock·p0.95:   1630.000 ns/op
                 testTryLock·p0.99:   7181.920 ns/op
                 testTryLock·p0.999:  332800.000 ns/op
                 testTryLock·p0.9999: 7139940.762 ns/op
                 testTryLock·p1.00:   2197815296.000 ns/op

Iteration   3: 14769.975 ±(99.9%) 8890.248 ns/op
                 testTryLock·p0.00:   712.000 ns/op
                 testTryLock·p0.50:   1324.000 ns/op
                 testTryLock·p0.90:   1574.000 ns/op
                 testTryLock·p0.95:   1674.000 ns/op
                 testTryLock·p0.99:   7720.000 ns/op
                 testTryLock·p0.999:  279040.000 ns/op
                 testTryLock·p0.9999: 10709096.858 ns/op
                 testTryLock·p1.00:   2399141888.000 ns/op

Iteration   4: 12070.386 ±(99.9%) 6027.967 ns/op
                 testTryLock·p0.00:   638.000 ns/op
                 testTryLock·p0.50:   1218.000 ns/op
                 testTryLock·p0.90:   1480.000 ns/op
                 testTryLock·p0.95:   1618.000 ns/op
                 testTryLock·p0.99:   17248.000 ns/op
                 testTryLock·p0.999:  527360.000 ns/op
                 testTryLock·p0.9999: 7778856.141 ns/op
                 testTryLock·p1.00:   1851785216.000 ns/op

Iteration   5: 10867.973 ±(99.9%) 4510.297 ns/op
                 testTryLock·p0.00:   532.000 ns/op
                 testTryLock·p0.50:   1262.000 ns/op
                 testTryLock·p0.90:   1526.000 ns/op
                 testTryLock·p0.95:   1666.000 ns/op
                 testTryLock·p0.99:   29280.000 ns/op
                 testTryLock·p0.999:  246016.000 ns/op
                 testTryLock·p0.9999: 10616832.000 ns/op
                 testTryLock·p1.00:   1068498944.000 ns/op


# Run progress: 90.00% complete, ETA 00:01:23
# Fork: 5 of 5
# Warmup Iteration   1: 10333.951 ±(99.9%) 5269.879 ns/op
Iteration   1: 9279.856 ±(99.9%) 6008.593 ns/op
                 testTryLock·p0.00:   688.000 ns/op
                 testTryLock·p0.50:   1284.000 ns/op
                 testTryLock·p0.90:   1546.000 ns/op
                 testTryLock·p0.95:   1632.000 ns/op
                 testTryLock·p0.99:   2472.000 ns/op
                 testTryLock·p0.999:  139531.520 ns/op
                 testTryLock·p0.9999: 5772230.656 ns/op
                 testTryLock·p1.00:   2499805184.000 ns/op

Iteration   2: 9957.978 ±(99.9%) 5497.539 ns/op
                 testTryLock·p0.00:   657.000 ns/op
                 testTryLock·p0.50:   1252.000 ns/op
                 testTryLock·p0.90:   1512.000 ns/op
                 testTryLock·p0.95:   1594.000 ns/op
                 testTryLock·p0.99:   2536.000 ns/op
                 testTryLock·p0.999:  134400.000 ns/op
                 testTryLock·p0.9999: 4977148.723 ns/op
                 testTryLock·p1.00:   1621098496.000 ns/op

Iteration   3: 13490.039 ±(99.9%) 6965.621 ns/op
                 testTryLock·p0.00:   651.000 ns/op
                 testTryLock·p0.50:   1262.000 ns/op
                 testTryLock·p0.90:   1524.000 ns/op
                 testTryLock·p0.95:   1612.000 ns/op
                 testTryLock·p0.99:   7136.000 ns/op
                 testTryLock·p0.999:  233728.512 ns/op
                 testTryLock·p0.9999: 9943452.877 ns/op
                 testTryLock·p1.00:   1486880768.000 ns/op

Iteration   4: 9521.683 ±(99.9%) 5391.376 ns/op
                 testTryLock·p0.00:   634.000 ns/op
                 testTryLock·p0.50:   1238.000 ns/op
                 testTryLock·p0.90:   1496.000 ns/op
                 testTryLock·p0.95:   1576.000 ns/op
                 testTryLock·p0.99:   2708.000 ns/op
                 testTryLock·p0.999:  189696.000 ns/op
                 testTryLock·p0.9999: 5707530.240 ns/op
                 testTryLock·p1.00:   1411383296.000 ns/op

Iteration   5: 13951.821 ±(99.9%) 7629.366 ns/op
                 testTryLock·p0.00:   666.000 ns/op
                 testTryLock·p0.50:   1246.000 ns/op
                 testTryLock·p0.90:   1496.000 ns/op
                 testTryLock·p0.95:   1582.000 ns/op
                 testTryLock·p0.99:   3548.240 ns/op
                 testTryLock·p0.999:  168910.336 ns/op
                 testTryLock·p0.9999: 5024753.254 ns/op
                 testTryLock·p1.00:   1348468736.000 ns/op



Result "pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock":
  N = 41830912
  mean =  11815.775 ±(99.9%) 1398.239 ns/op

  Histogram, ns/op:
    [         0.000,  250000000.000) = 41830437 
    [ 250000000.000,  500000000.000) = 316 
    [ 500000000.000,  750000000.000) = 40 
    [ 750000000.000, 1000000000.000) = 36 
    [1000000000.000, 1250000000.000) = 18 
    [1250000000.000, 1500000000.000) = 34 
    [1500000000.000, 1750000000.000) = 8 
    [1750000000.000, 2000000000.000) = 6 
    [2000000000.000, 2250000000.000) = 6 
    [2250000000.000, 2500000000.000) = 4 
    [2500000000.000, 2750000000.000) = 7 

  Percentiles, ns/op:
      p(0.0000) =    532.000 ns/op
     p(50.0000) =   1288.000 ns/op
     p(90.0000) =   1572.000 ns/op
     p(95.0000) =   1666.000 ns/op
     p(99.0000) =   7480.000 ns/op
     p(99.9000) = 268288.000 ns/op
     p(99.9900) = 7503872.000 ns/op
     p(99.9990) = 278396928.000 ns/op
     p(99.9999) = 1442871030.844 ns/op
    p(100.0000) = 2734686208.000 ns/op


# Run complete. Total time: 00:13:43

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                                                               Mode       Cnt           Score       Error  Units
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire                         sample  19995332      104168.645 ± 11120.767  ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.00    sample                  2192.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.50    sample                  4248.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.90    sample                 10224.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.95    sample                 55872.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.99    sample                324096.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.999   sample               1660928.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.9999  sample               8380416.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p1.00    sample            3535798272.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock                            sample  41830912       11815.775 ±  1398.239  ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.00          sample                   532.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.50          sample                  1288.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.90          sample                  1572.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.95          sample                  1666.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.99          sample                  7480.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.999         sample                268288.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.9999        sample               7503872.000              ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock:testTryLock·p1.00          sample            2734686208.000              ns/op
```

### Average Time

```txt
# Detecting actual CPU count: 8 detected
# JMH version: 1.34
# VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 64621.468 ±(99.9%) 4448.308 ns/op
Iteration   1: 136905.718 ±(99.9%) 7489.121 ns/op
Iteration   2: 119525.613 ±(99.9%) 4972.010 ns/op
Iteration   3: 115556.686 ±(99.9%) 6204.476 ns/op
Iteration   4: 94145.484 ±(99.9%) 2205.882 ns/op
Iteration   5: 116705.308 ±(99.9%) 6658.640 ns/op

# Run progress: 10.00% complete, ETA 00:12:12
# Fork: 2 of 5
# Warmup Iteration   1: 63987.659 ±(99.9%) 3656.506 ns/op
Iteration   1: 134090.405 ±(99.9%) 4257.178 ns/op
Iteration   2: 140431.230 ±(99.9%) 6191.428 ns/op
Iteration   3: 95588.369 ±(99.9%) 3200.736 ns/op
Iteration   4: 98162.698 ±(99.9%) 2763.819 ns/op
Iteration   5: 94414.091 ±(99.9%) 3497.244 ns/op

# Run progress: 20.00% complete, ETA 00:10:49
# Fork: 3 of 5
# Warmup Iteration   1: 73219.735 ±(99.9%) 2713.025 ns/op
Iteration   1: 128259.645 ±(99.9%) 5482.475 ns/op
Iteration   2: 165266.970 ±(99.9%) 4893.660 ns/op
Iteration   3: 92284.125 ±(99.9%) 1991.619 ns/op
Iteration   4: 98791.295 ±(99.9%) 4376.254 ns/op
Iteration   5: 97083.815 ±(99.9%) 3570.101 ns/op

# Run progress: 30.00% complete, ETA 00:09:27
# Fork: 4 of 5
# Warmup Iteration   1: 71082.302 ±(99.9%) 2341.141 ns/op
Iteration   1: 129379.860 ±(99.9%) 9899.653 ns/op
Iteration   2: 119264.109 ±(99.9%) 4751.174 ns/op
Iteration   3: 92541.928 ±(99.9%) 3005.078 ns/op
Iteration   4: 95066.980 ±(99.9%) 3372.690 ns/op
Iteration   5: 93450.800 ±(99.9%) 3526.832 ns/op

# Run progress: 40.00% complete, ETA 00:08:05
# Fork: 5 of 5
# Warmup Iteration   1: 69249.537 ±(99.9%) 2579.848 ns/op
Iteration   1: 135862.136 ±(99.9%) 7568.502 ns/op
Iteration   2: 163046.625 ±(99.9%) 10122.925 ns/op
Iteration   3: 97746.381 ±(99.9%) 2932.007 ns/op
Iteration   4: 93088.644 ±(99.9%) 2024.837 ns/op
Iteration   5: 86611.051 ±(99.9%) 1377.025 ns/op


Result "pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire":
  113330.799 ±(99.9%) 17221.271 ns/op [Average]
  (min, avg, max) = (86611.051, 113330.799, 165266.970), stdev = 22989.904
  CI (99.9%): [96109.528, 130552.069] (assumes normal distribution)


# JMH version: 1.34
# VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:06:44
# Fork: 1 of 5
# Warmup Iteration   1: 6410.311 ±(99.9%) 270.824 ns/op
Iteration   1: 5753.613 ±(99.9%) 59.180 ns/op
Iteration   2: 6538.006 ±(99.9%) 156.686 ns/op
Iteration   3: 6885.178 ±(99.9%) 117.134 ns/op
Iteration   4: 5948.643 ±(99.9%) 111.021 ns/op
Iteration   5: 6703.473 ±(99.9%) 65.505 ns/op

# Run progress: 60.00% complete, ETA 00:05:17
# Fork: 2 of 5
# Warmup Iteration   1: 4974.425 ±(99.9%) 230.443 ns/op
Iteration   1: 6769.827 ±(99.9%) 284.510 ns/op
Iteration   2: 6704.716 ±(99.9%) 198.894 ns/op
Iteration   3: 6559.526 ±(99.9%) 77.167 ns/op
Iteration   4: 6583.229 ±(99.9%) 53.805 ns/op
Iteration   5: 6741.443 ±(99.9%) 198.684 ns/op

# Run progress: 70.00% complete, ETA 00:03:55
# Fork: 3 of 5
# Warmup Iteration   1: 5218.452 ±(99.9%) 204.912 ns/op
Iteration   1: 6752.029 ±(99.9%) 647.241 ns/op
Iteration   2: 6423.617 ±(99.9%) 70.046 ns/op
Iteration   3: 5856.907 ±(99.9%) 58.048 ns/op
Iteration   4: 5772.315 ±(99.9%) 225.216 ns/op
Iteration   5: 7111.179 ±(99.9%) 179.095 ns/op

# Run progress: 80.00% complete, ETA 00:02:35
# Fork: 4 of 5
# Warmup Iteration   1: 5170.566 ±(99.9%) 80.751 ns/op
Iteration   1: 6532.320 ±(99.9%) 157.433 ns/op
Iteration   2: 5556.094 ±(99.9%) 49.003 ns/op
Iteration   3: 6632.635 ±(99.9%) 64.299 ns/op
Iteration   4: 6907.941 ±(99.9%) 80.390 ns/op
Iteration   5: 7047.326 ±(99.9%) 144.962 ns/op

# Run progress: 90.00% complete, ETA 00:01:16
# Fork: 5 of 5
# Warmup Iteration   1: 4808.757 ±(99.9%) 147.120 ns/op
Iteration   1: 6885.271 ±(99.9%) 175.079 ns/op
Iteration   2: 7150.393 ±(99.9%) 78.927 ns/op
Iteration   3: 6617.652 ±(99.9%) 143.799 ns/op
Iteration   4: 6540.657 ±(99.9%) 163.385 ns/op
Iteration   5: 6540.951 ±(99.9%) 139.049 ns/op


Result "pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock":
  6540.598 ±(99.9%) 325.970 ns/op [Average]
  (min, avg, max) = (5556.094, 6540.598, 7150.393), stdev = 435.161
  CI (99.9%): [6214.628, 6866.568] (assumes normal distribution)


# Run complete. Total time: 00:12:43

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                                      Mode  Cnt       Score       Error  Units
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testLockExpire  avgt   25  113330.799 ± 17221.271  ns/op
DefaultReactiveLockBenchmarkTests.DefaultReactiveLockBenchmark.testTryLock     avgt   25    6540.598 ±   325.970  ns/op
```