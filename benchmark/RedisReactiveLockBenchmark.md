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
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 112025.371 ops/s
Iteration   1: 58872.232 ops/s
Iteration   2: 82652.732 ops/s
Iteration   3: 80517.656 ops/s
Iteration   4: 82210.389 ops/s
Iteration   5: 84745.835 ops/s

# Run progress: 10.00% complete, ETA 00:13:58
# Fork: 2 of 5
# Warmup Iteration   1: 117786.863 ops/s
Iteration   1: 62906.887 ops/s
Iteration   2: 82375.109 ops/s
Iteration   3: 63658.695 ops/s
Iteration   4: 73434.175 ops/s
Iteration   5: 76374.218 ops/s

# Run progress: 20.00% complete, ETA 00:11:50
# Fork: 3 of 5
# Warmup Iteration   1: 115153.022 ops/s
Iteration   1: 57674.220 ops/s
Iteration   2: 75314.841 ops/s
Iteration   3: 68757.990 ops/s
Iteration   4: 90545.260 ops/s
Iteration   5: 76091.609 ops/s

# Run progress: 30.00% complete, ETA 00:10:06
# Fork: 4 of 5
# Warmup Iteration   1: 109774.553 ops/s
Iteration   1: 61455.372 ops/s
Iteration   2: 103164.844 ops/s
Iteration   3: 47269.813 ops/s
Iteration   4: 84966.613 ops/s
Iteration   5: 82458.235 ops/s

# Run progress: 40.00% complete, ETA 00:08:37
# Fork: 5 of 5
# Warmup Iteration   1: 98474.337 ops/s
Iteration   1: 62544.323 ops/s
Iteration   2: 86861.377 ops/s
Iteration   3: 85593.253 ops/s
Iteration   4: 70847.554 ops/s
Iteration   5: 73736.632 ops/s


Result "pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire":
  75001.195 ±(99.9%) 9350.136 ops/s [Average]
  (min, avg, max) = (47269.813, 75001.195, 103164.844), stdev = 12482.165
  CI (99.9%): [65651.058, 84351.331] (assumes normal distribution)


# JMH version: 1.34
# VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:05
# Fork: 1 of 5
# Warmup Iteration   1: 1320506.896 ops/s
Iteration   1: 1935051.454 ops/s
Iteration   2: 2001821.985 ops/s
Iteration   3: 1754798.196 ops/s
Iteration   4: 1926978.117 ops/s
Iteration   5: 1977305.821 ops/s

# Run progress: 60.00% complete, ETA 00:05:25
# Fork: 2 of 5
# Warmup Iteration   1: 1194802.351 ops/s
Iteration   1: 1715854.708 ops/s
Iteration   2: 1984735.870 ops/s
Iteration   3: 1861597.469 ops/s
Iteration   4: 1844630.682 ops/s
Iteration   5: 1951965.845 ops/s

# Run progress: 70.00% complete, ETA 00:03:55
# Fork: 3 of 5
# Warmup Iteration   1: 942973.060 ops/s
Iteration   1: 1655880.664 ops/s
Iteration   2: 1898760.320 ops/s
Iteration   3: 1971566.005 ops/s
Iteration   4: 2026693.779 ops/s
Iteration   5: 2074582.311 ops/s

# Run progress: 80.00% complete, ETA 00:02:33
# Fork: 4 of 5
# Warmup Iteration   1: 1294588.790 ops/s
Iteration   1: 1731962.899 ops/s
Iteration   2: 1969810.612 ops/s
Iteration   3: 2059429.321 ops/s
Iteration   4: 2023888.807 ops/s
Iteration   5: 1988981.850 ops/s

# Run progress: 90.00% complete, ETA 00:01:14
# Fork: 5 of 5
# Warmup Iteration   1: 976913.904 ops/s
Iteration   1: 1694833.341 ops/s
Iteration   2: 2019270.056 ops/s
Iteration   3: 2079914.038 ops/s
Iteration   4: 1993871.662 ops/s
Iteration   5: 1966970.343 ops/s


Result "pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock":
  1924446.246 ±(99.9%) 92731.764 ops/s [Average]
  (min, avg, max) = (1655880.664, 1924446.246, 2079914.038), stdev = 123794.252
  CI (99.9%): [1831714.482, 2017178.010] (assumes normal distribution)


# Run complete. Total time: 00:12:16

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                                           Mode  Cnt        Score       Error  Units
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire  thrpt   25    75001.195 ±  9350.136  ops/s
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock     thrpt   25  1924446.246 ± 92731.764  ops/s
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
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 97043.138 ±(99.9%) 23984.909 ns/op
Iteration   1: 119523.608 ±(99.9%) 59268.951 ns/op
                 testLockExpire·p0.00:   3008.000 ns/op
                 testLockExpire·p0.50:   6720.000 ns/op
                 testLockExpire·p0.90:   11040.000 ns/op
                 testLockExpire·p0.95:   32160.000 ns/op
                 testLockExpire·p0.99:   339456.000 ns/op
                 testLockExpire·p0.999:  2576384.000 ns/op
                 testLockExpire·p0.9999: 23887872.000 ns/op
                 testLockExpire·p1.00:   3229614080.000 ns/op

Iteration   2: 88344.129 ±(99.9%) 32019.795 ns/op
                 testLockExpire·p0.00:   3048.000 ns/op
                 testLockExpire·p0.50:   4888.000 ns/op
                 testLockExpire·p0.90:   6136.000 ns/op
                 testLockExpire·p0.95:   16256.000 ns/op
                 testLockExpire·p0.99:   157696.000 ns/op
                 testLockExpire·p0.999:  1987256.320 ns/op
                 testLockExpire·p0.9999: 40042496.000 ns/op
                 testLockExpire·p1.00:   1855979520.000 ns/op

Iteration   3: 115548.617 ±(99.9%) 48842.327 ns/op
                 testLockExpire·p0.00:   3120.000 ns/op
                 testLockExpire·p0.50:   4760.000 ns/op
                 testLockExpire·p0.90:   5456.000 ns/op
                 testLockExpire·p0.95:   12608.000 ns/op
                 testLockExpire·p0.99:   128128.000 ns/op
                 testLockExpire·p0.999:  1458210.816 ns/op
                 testLockExpire·p0.9999: 51675601.306 ns/op
                 testLockExpire·p1.00:   2503999488.000 ns/op

Iteration   4: 102532.282 ±(99.9%) 47286.803 ns/op
                 testLockExpire·p0.00:   2864.000 ns/op
                 testLockExpire·p0.50:   4776.000 ns/op
                 testLockExpire·p0.90:   5904.000 ns/op
                 testLockExpire·p0.95:   20064.000 ns/op
                 testLockExpire·p0.99:   252160.000 ns/op
                 testLockExpire·p0.999:  1847484.416 ns/op
                 testLockExpire·p0.9999: 16596992.000 ns/op
                 testLockExpire·p1.00:   3242196992.000 ns/op

Iteration   5: 99304.686 ±(99.9%) 37802.621 ns/op
                 testLockExpire·p0.00:   2924.000 ns/op
                 testLockExpire·p0.50:   4760.000 ns/op
                 testLockExpire·p0.90:   5800.000 ns/op
                 testLockExpire·p0.95:   18624.000 ns/op
                 testLockExpire·p0.99:   198144.000 ns/op
                 testLockExpire·p0.999:  2670788.608 ns/op
                 testLockExpire·p0.9999: 50820363.059 ns/op
                 testLockExpire·p1.00:   3074424832.000 ns/op


# Run progress: 10.00% complete, ETA 00:13:04
# Fork: 2 of 5
# Warmup Iteration   1: 67102.065 ±(99.9%) 15314.756 ns/op
Iteration   1: 116027.279 ±(99.9%) 59260.355 ns/op
                 testLockExpire·p0.00:   3424.000 ns/op
                 testLockExpire·p0.50:   6520.000 ns/op
                 testLockExpire·p0.90:   9456.000 ns/op
                 testLockExpire·p0.95:   21120.000 ns/op
                 testLockExpire·p0.99:   242432.000 ns/op
                 testLockExpire·p0.999:  2738266.112 ns/op
                 testLockExpire·p0.9999: 26352880.845 ns/op
                 testLockExpire·p1.00:   3305111552.000 ns/op

Iteration   2: 73420.385 ±(99.9%) 25597.798 ns/op
                 testLockExpire·p0.00:   2848.000 ns/op
                 testLockExpire·p0.50:   4928.000 ns/op
                 testLockExpire·p0.90:   6304.000 ns/op
                 testLockExpire·p0.95:   21440.000 ns/op
                 testLockExpire·p0.99:   243374.080 ns/op
                 testLockExpire·p0.999:  2195456.000 ns/op
                 testLockExpire·p0.9999: 38600704.000 ns/op
                 testLockExpire·p1.00:   1937768448.000 ns/op

Iteration   3: 174432.217 ±(99.9%) 74914.753 ns/op
                 testLockExpire·p0.00:   3248.000 ns/op
                 testLockExpire·p0.50:   4856.000 ns/op
                 testLockExpire·p0.90:   5624.000 ns/op
                 testLockExpire·p0.95:   14160.000 ns/op
                 testLockExpire·p0.99:   134656.000 ns/op
                 testLockExpire·p0.999:  4927733.760 ns/op
                 testLockExpire·p0.9999: 476053504.000 ns/op
                 testLockExpire·p1.00:   2558525440.000 ns/op

Iteration   4: 100940.905 ±(99.9%) 45202.158 ns/op
                 testLockExpire·p0.00:   2656.000 ns/op
                 testLockExpire·p0.50:   4888.000 ns/op
                 testLockExpire·p0.90:   7312.000 ns/op
                 testLockExpire·p0.95:   37184.000 ns/op
                 testLockExpire·p0.99:   287744.000 ns/op
                 testLockExpire·p0.999:  2220769.280 ns/op
                 testLockExpire·p0.9999: 29464723.456 ns/op
                 testLockExpire·p1.00:   3498049536.000 ns/op

Iteration   5: 101305.100 ±(99.9%) 40899.280 ns/op
                 testLockExpire·p0.00:   3240.000 ns/op
                 testLockExpire·p0.50:   4896.000 ns/op
                 testLockExpire·p0.90:   5904.000 ns/op
                 testLockExpire·p0.95:   17504.000 ns/op
                 testLockExpire·p0.99:   161024.000 ns/op
                 testLockExpire·p0.999:  2206982.144 ns/op
                 testLockExpire·p0.9999: 50289888.461 ns/op
                 testLockExpire·p1.00:   2044723200.000 ns/op


# Run progress: 20.00% complete, ETA 00:11:24
# Fork: 3 of 5
# Warmup Iteration   1: 88665.186 ±(99.9%) 23751.350 ns/op
Iteration   1: 116405.609 ±(99.9%) 61019.883 ns/op
                 testLockExpire·p0.00:   3404.000 ns/op
                 testLockExpire·p0.50:   6992.000 ns/op
                 testLockExpire·p0.90:   10944.000 ns/op
                 testLockExpire·p0.95:   35904.000 ns/op
                 testLockExpire·p0.99:   381952.000 ns/op
                 testLockExpire·p0.999:  3902251.008 ns/op
                 testLockExpire·p0.9999: 36165976.064 ns/op
                 testLockExpire·p1.00:   3766484992.000 ns/op

Iteration   2: 100019.061 ±(99.9%) 40061.203 ns/op
                 testLockExpire·p0.00:   2688.000 ns/op
                 testLockExpire·p0.50:   5024.000 ns/op
                 testLockExpire·p0.90:   6576.000 ns/op
                 testLockExpire·p0.95:   17248.000 ns/op
                 testLockExpire·p0.99:   179200.000 ns/op
                 testLockExpire·p0.999:  2883584.000 ns/op
                 testLockExpire·p0.9999: 52209614.848 ns/op
                 testLockExpire·p1.00:   2382364672.000 ns/op

Iteration   3: 116515.923 ±(99.9%) 49610.276 ns/op
                 testLockExpire·p0.00:   3000.000 ns/op
                 testLockExpire·p0.50:   5008.000 ns/op
                 testLockExpire·p0.90:   6456.000 ns/op
                 testLockExpire·p0.95:   22720.000 ns/op
                 testLockExpire·p0.99:   162560.000 ns/op
                 testLockExpire·p0.999:  1908107.264 ns/op
                 testLockExpire·p0.9999: 48824320.000 ns/op
                 testLockExpire·p1.00:   2128609280.000 ns/op

Iteration   4: 100498.611 ±(99.9%) 52193.543 ns/op
                 testLockExpire·p0.00:   2480.000 ns/op
                 testLockExpire·p0.50:   4784.000 ns/op
                 testLockExpire·p0.90:   7896.000 ns/op
                 testLockExpire·p0.95:   52979.200 ns/op
                 testLockExpire·p0.99:   332288.000 ns/op
                 testLockExpire·p0.999:  1966194.688 ns/op
                 testLockExpire·p0.9999: 16459025.613 ns/op
                 testLockExpire·p1.00:   3154116608.000 ns/op

Iteration   5: 80861.705 ±(99.9%) 28516.881 ns/op
                 testLockExpire·p0.00:   2580.000 ns/op
                 testLockExpire·p0.50:   4800.000 ns/op
                 testLockExpire·p0.90:   7008.000 ns/op
                 testLockExpire·p0.95:   35072.000 ns/op
                 testLockExpire·p0.99:   248320.000 ns/op
                 testLockExpire·p0.999:  2031486.976 ns/op
                 testLockExpire·p0.9999: 36447820.186 ns/op
                 testLockExpire·p1.00:   1994391552.000 ns/op


# Run progress: 30.00% complete, ETA 00:09:59
# Fork: 4 of 5
# Warmup Iteration   1: 73148.366 ±(99.9%) 17286.391 ns/op
Iteration   1: 132405.761 ±(99.9%) 65831.842 ns/op
                 testLockExpire·p0.00:   3344.000 ns/op
                 testLockExpire·p0.50:   7152.000 ns/op
                 testLockExpire·p0.90:   11568.000 ns/op
                 testLockExpire·p0.95:   35264.000 ns/op
                 testLockExpire·p0.99:   418304.000 ns/op
                 testLockExpire·p0.999:  3478482.944 ns/op
                 testLockExpire·p0.9999: 27233835.418 ns/op
                 testLockExpire·p1.00:   3095396352.000 ns/op

Iteration   2: 78656.022 ±(99.9%) 27678.496 ns/op
                 testLockExpire·p0.00:   3300.000 ns/op
                 testLockExpire·p0.50:   5064.000 ns/op
                 testLockExpire·p0.90:   7280.000 ns/op
                 testLockExpire·p0.95:   37568.000 ns/op
                 testLockExpire·p0.99:   238848.000 ns/op
                 testLockExpire·p0.999:  1943791.616 ns/op
                 testLockExpire·p0.9999: 31850843.341 ns/op
                 testLockExpire·p1.00:   1885339648.000 ns/op

Iteration   3: 158361.958 ±(99.9%) 71694.059 ns/op
                 testLockExpire·p0.00:   3132.000 ns/op
                 testLockExpire·p0.50:   4920.000 ns/op
                 testLockExpire·p0.90:   5568.000 ns/op
                 testLockExpire·p0.95:   10448.000 ns/op
                 testLockExpire·p0.99:   94595.840 ns/op
                 testLockExpire·p0.999:  1938649.088 ns/op
                 testLockExpire·p0.9999: 405149109.453 ns/op
                 testLockExpire·p1.00:   2311061504.000 ns/op

Iteration   4: 92623.269 ±(99.9%) 42589.496 ns/op
                 testLockExpire·p0.00:   2956.000 ns/op
                 testLockExpire·p0.50:   5016.000 ns/op
                 testLockExpire·p0.90:   8592.000 ns/op
                 testLockExpire·p0.95:   44032.000 ns/op
                 testLockExpire·p0.99:   270848.000 ns/op
                 testLockExpire·p0.999:  2187264.000 ns/op
                 testLockExpire·p0.9999: 18744744.346 ns/op
                 testLockExpire·p1.00:   3217031168.000 ns/op

Iteration   5: 101489.536 ±(99.9%) 40156.663 ns/op
                 testLockExpire·p0.00:   3196.000 ns/op
                 testLockExpire·p0.50:   5016.000 ns/op
                 testLockExpire·p0.90:   7592.000 ns/op
                 testLockExpire·p0.95:   31840.000 ns/op
                 testLockExpire·p0.99:   221696.000 ns/op
                 testLockExpire·p0.999:  1784733.696 ns/op
                 testLockExpire·p0.9999: 37692132.557 ns/op
                 testLockExpire·p1.00:   3107979264.000 ns/op


# Run progress: 40.00% complete, ETA 00:08:30
# Fork: 5 of 5
# Warmup Iteration   1: 74960.907 ±(99.9%) 22365.402 ns/op
Iteration   1: 122989.438 ±(99.9%) 59783.796 ns/op
                 testLockExpire·p0.00:   3500.000 ns/op
                 testLockExpire·p0.50:   6488.000 ns/op
                 testLockExpire·p0.90:   8800.000 ns/op
                 testLockExpire·p0.95:   24544.000 ns/op
                 testLockExpire·p0.99:   341504.000 ns/op
                 testLockExpire·p0.999:  2990080.000 ns/op
                 testLockExpire·p0.9999: 19706039.501 ns/op
                 testLockExpire·p1.00:   2759852032.000 ns/op

Iteration   2: 98769.993 ±(99.9%) 39825.290 ns/op
                 testLockExpire·p0.00:   2540.000 ns/op
                 testLockExpire·p0.50:   4552.000 ns/op
                 testLockExpire·p0.90:   6576.000 ns/op
                 testLockExpire·p0.95:   20032.000 ns/op
                 testLockExpire·p0.99:   218880.000 ns/op
                 testLockExpire·p0.999:  2498560.000 ns/op
                 testLockExpire·p0.9999: 47799277.978 ns/op
                 testLockExpire·p1.00:   3179282432.000 ns/op

Iteration   3: 85631.819 ±(99.9%) 34756.355 ns/op
                 testLockExpire·p0.00:   2904.000 ns/op
                 testLockExpire·p0.50:   4888.000 ns/op
                 testLockExpire·p0.90:   5752.000 ns/op
                 testLockExpire·p0.95:   17312.000 ns/op
                 testLockExpire·p0.99:   153856.000 ns/op
                 testLockExpire·p0.999:  834560.000 ns/op
                 testLockExpire·p0.9999: 41716960.461 ns/op
                 testLockExpire·p1.00:   1990197248.000 ns/op

Iteration   4: 87390.827 ±(99.9%) 34732.981 ns/op
                 testLockExpire·p0.00:   3068.000 ns/op
                 testLockExpire·p0.50:   4976.000 ns/op
                 testLockExpire·p0.90:   6456.000 ns/op
                 testLockExpire·p0.95:   24544.000 ns/op
                 testLockExpire·p0.99:   197376.000 ns/op
                 testLockExpire·p0.999:  1921024.000 ns/op
                 testLockExpire·p0.9999: 32513851.392 ns/op
                 testLockExpire·p1.00:   1914699776.000 ns/op

Iteration   5: 98589.228 ±(99.9%) 40793.198 ns/op
                 testLockExpire·p0.00:   3276.000 ns/op
                 testLockExpire·p0.50:   4984.000 ns/op
                 testLockExpire·p0.90:   5912.000 ns/op
                 testLockExpire·p0.95:   18720.000 ns/op
                 testLockExpire·p0.99:   175360.000 ns/op
                 testLockExpire·p0.999:  2223767.552 ns/op
                 testLockExpire·p0.9999: 44875487.642 ns/op
                 testLockExpire·p1.00:   1998585856.000 ns/op



Result "pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire":
  N = 20347533
  mean = 103026.470 ±(99.9%) 8987.630 ns/op

  Histogram, ns/op:
    [         0.000,  250000000.000) = 20346412 
    [ 250000000.000,  500000000.000) = 146 
    [ 500000000.000,  750000000.000) = 98 
    [ 750000000.000, 1000000000.000) = 186 
    [1000000000.000, 1250000000.000) = 118 
    [1250000000.000, 1500000000.000) = 88 
    [1500000000.000, 1750000000.000) = 64 
    [1750000000.000, 2000000000.000) = 170 
    [2000000000.000, 2250000000.000) = 89 
    [2250000000.000, 2500000000.000) = 14 
    [2500000000.000, 2750000000.000) = 62 
    [2750000000.000, 3000000000.000) = 12 
    [3000000000.000, 3250000000.000) = 57 
    [3250000000.000, 3500000000.000) = 9 
    [3500000000.000, 3750000000.000) = 0 

  Percentiles, ns/op:
      p(0.0000) =   2480.000 ns/op
     p(50.0000) =   4992.000 ns/op
     p(90.0000) =   8184.000 ns/op
     p(95.0000) =  24032.000 ns/op
     p(99.0000) = 229376.000 ns/op
     p(99.9000) = 2301952.000 ns/op
     p(99.9900) = 37814272.000 ns/op
     p(99.9990) = 2120220672.000 ns/op
     p(99.9999) = 3229614080.000 ns/op
    p(100.0000) = 3766484992.000 ns/op


# JMH version: 1.34
# VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Sampling time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:00
# Fork: 1 of 5
# Warmup Iteration   1: 10736.574 ±(99.9%) 1028.044 ns/op
Iteration   1: 6603.995 ±(99.9%) 290.345 ns/op
                 testTryLock·p0.00:   1692.000 ns/op
                 testTryLock·p0.50:   2860.000 ns/op
                 testTryLock·p0.90:   3164.000 ns/op
                 testTryLock·p0.95:   3536.000 ns/op
                 testTryLock·p0.99:   20256.000 ns/op
                 testTryLock·p0.999:  379231.232 ns/op
                 testTryLock·p0.9999: 6889472.000 ns/op
                 testTryLock·p1.00:   26771456.000 ns/op

Iteration   2: 4507.016 ±(99.9%) 123.299 ns/op
                 testTryLock·p0.00:   1678.000 ns/op
                 testTryLock·p0.50:   2932.000 ns/op
                 testTryLock·p0.90:   3156.000 ns/op
                 testTryLock·p0.95:   3552.000 ns/op
                 testTryLock·p0.99:   19680.000 ns/op
                 testTryLock·p0.999:  243200.000 ns/op
                 testTryLock·p0.9999: 1749769.830 ns/op
                 testTryLock·p1.00:   39256064.000 ns/op

Iteration   3: 5891.695 ±(99.9%) 213.593 ns/op
                 testTryLock·p0.00:   1804.000 ns/op
                 testTryLock·p0.50:   3172.000 ns/op
                 testTryLock·p0.90:   3396.000 ns/op
                 testTryLock·p0.95:   3548.000 ns/op
                 testTryLock·p0.99:   25568.000 ns/op
                 testTryLock·p0.999:  369664.000 ns/op
                 testTryLock·p0.9999: 4450688.205 ns/op
                 testTryLock·p1.00:   24576000.000 ns/op

Iteration   4: 5383.580 ±(99.9%) 145.426 ns/op
                 testTryLock·p0.00:   1390.000 ns/op
                 testTryLock·p0.50:   3196.000 ns/op
                 testTryLock·p0.90:   3416.000 ns/op
                 testTryLock·p0.95:   3544.000 ns/op
                 testTryLock·p0.99:   25216.000 ns/op
                 testTryLock·p0.999:  344576.000 ns/op
                 testTryLock·p0.9999: 2579950.387 ns/op
                 testTryLock·p1.00:   19267584.000 ns/op

Iteration   5: 4579.789 ±(99.9%) 72.030 ns/op
                 testTryLock·p0.00:   1840.000 ns/op
                 testTryLock·p0.50:   3220.000 ns/op
                 testTryLock·p0.90:   3436.000 ns/op
                 testTryLock·p0.95:   3548.000 ns/op
                 testTryLock·p0.99:   20864.000 ns/op
                 testTryLock·p0.999:  244992.000 ns/op
                 testTryLock·p0.9999: 1133225.574 ns/op
                 testTryLock·p1.00:   11878400.000 ns/op


# Run progress: 60.00% complete, ETA 00:05:22
# Fork: 2 of 5
# Warmup Iteration   1: 11119.512 ±(99.9%) 961.365 ns/op
Iteration   1: 6547.989 ±(99.9%) 337.455 ns/op
                 testTryLock·p0.00:   1520.000 ns/op
                 testTryLock·p0.50:   2560.000 ns/op
                 testTryLock·p0.90:   2832.000 ns/op
                 testTryLock·p0.95:   3144.000 ns/op
                 testTryLock·p0.99:   17792.000 ns/op
                 testTryLock·p0.999:  384407.552 ns/op
                 testTryLock·p0.9999: 8536064.000 ns/op
                 testTryLock·p1.00:   32243712.000 ns/op

Iteration   2: 3740.953 ±(99.9%) 68.129 ns/op
                 testTryLock·p0.00:   1418.000 ns/op
                 testTryLock·p0.50:   2580.000 ns/op
                 testTryLock·p0.90:   2748.000 ns/op
                 testTryLock·p0.95:   2864.000 ns/op
                 testTryLock·p0.99:   15440.000 ns/op
                 testTryLock·p0.999:  223232.000 ns/op
                 testTryLock·p0.9999: 1050624.000 ns/op
                 testTryLock·p1.00:   17596416.000 ns/op

Iteration   3: 3769.481 ±(99.9%) 82.566 ns/op
                 testTryLock·p0.00:   1560.000 ns/op
                 testTryLock·p0.50:   2636.000 ns/op
                 testTryLock·p0.90:   2784.000 ns/op
                 testTryLock·p0.95:   2880.000 ns/op
                 testTryLock·p0.99:   15280.000 ns/op
                 testTryLock·p0.999:  222208.000 ns/op
                 testTryLock·p0.9999: 925696.000 ns/op
                 testTryLock·p1.00:   29818880.000 ns/op

Iteration   4: 3776.224 ±(99.9%) 85.098 ns/op
                 testTryLock·p0.00:   1118.000 ns/op
                 testTryLock·p0.50:   2596.000 ns/op
                 testTryLock·p0.90:   2760.000 ns/op
                 testTryLock·p0.95:   2868.000 ns/op
                 testTryLock·p0.99:   15232.000 ns/op
                 testTryLock·p0.999:  223488.000 ns/op
                 testTryLock·p0.9999: 963460.506 ns/op
                 testTryLock·p1.00:   30277632.000 ns/op

Iteration   5: 3978.031 ±(99.9%) 91.483 ns/op
                 testTryLock·p0.00:   1510.000 ns/op
                 testTryLock·p0.50:   2624.000 ns/op
                 testTryLock·p0.90:   2780.000 ns/op
                 testTryLock·p0.95:   2900.000 ns/op
                 testTryLock·p0.99:   16672.000 ns/op
                 testTryLock·p0.999:  233472.000 ns/op
                 testTryLock·p0.9999: 1278048.256 ns/op
                 testTryLock·p1.00:   18120704.000 ns/op


# Run progress: 70.00% complete, ETA 00:03:53
# Fork: 3 of 5
# Warmup Iteration   1: 13109.894 ±(99.9%) 1168.513 ns/op
Iteration   1: 6805.603 ±(99.9%) 311.644 ns/op
                 testTryLock·p0.00:   1810.000 ns/op
                 testTryLock·p0.50:   3016.000 ns/op
                 testTryLock·p0.90:   3320.000 ns/op
                 testTryLock·p0.95:   3580.000 ns/op
                 testTryLock·p0.99:   21792.000 ns/op
                 testTryLock·p0.999:  363520.000 ns/op
                 testTryLock·p0.9999: 7069414.195 ns/op
                 testTryLock·p1.00:   31326208.000 ns/op

Iteration   2: 4468.917 ±(99.9%) 86.856 ns/op
                 testTryLock·p0.00:   1620.000 ns/op
                 testTryLock·p0.50:   3096.000 ns/op
                 testTryLock·p0.90:   3328.000 ns/op
                 testTryLock·p0.95:   3440.000 ns/op
                 testTryLock·p0.99:   20640.000 ns/op
                 testTryLock·p0.999:  237568.000 ns/op
                 testTryLock·p0.9999: 1263587.738 ns/op
                 testTryLock·p1.00:   30408704.000 ns/op

Iteration   3: 4613.665 ±(99.9%) 103.136 ns/op
                 testTryLock·p0.00:   1690.000 ns/op
                 testTryLock·p0.50:   3044.000 ns/op
                 testTryLock·p0.90:   3264.000 ns/op
                 testTryLock·p0.95:   3384.000 ns/op
                 testTryLock·p0.99:   21920.000 ns/op
                 testTryLock·p0.999:  250368.000 ns/op
                 testTryLock·p0.9999: 1543420.928 ns/op
                 testTryLock·p1.00:   17072128.000 ns/op

Iteration   4: 4856.242 ±(99.9%) 117.067 ns/op
                 testTryLock·p0.00:   1336.000 ns/op
                 testTryLock·p0.50:   3084.000 ns/op
                 testTryLock·p0.90:   3312.000 ns/op
                 testTryLock·p0.95:   3424.000 ns/op
                 testTryLock·p0.99:   22720.000 ns/op
                 testTryLock·p0.999:  270088.192 ns/op
                 testTryLock·p0.9999: 1882323.354 ns/op
                 testTryLock·p1.00:   19628032.000 ns/op

Iteration   5: 5065.809 ±(99.9%) 138.306 ns/op
                 testTryLock·p0.00:   1790.000 ns/op
                 testTryLock·p0.50:   3072.000 ns/op
                 testTryLock·p0.90:   3312.000 ns/op
                 testTryLock·p0.95:   3428.000 ns/op
                 testTryLock·p0.99:   23072.000 ns/op
                 testTryLock·p0.999:  302080.000 ns/op
                 testTryLock·p0.9999: 2694811.648 ns/op
                 testTryLock·p1.00:   23461888.000 ns/op


# Run progress: 80.00% complete, ETA 00:02:32
# Fork: 4 of 5
# Warmup Iteration   1: 11495.456 ±(99.9%) 939.890 ns/op
Iteration   1: 5666.547 ±(99.9%) 262.013 ns/op
                 testTryLock·p0.00:   1578.000 ns/op
                 testTryLock·p0.50:   2596.000 ns/op
                 testTryLock·p0.90:   2824.000 ns/op
                 testTryLock·p0.95:   3208.000 ns/op
                 testTryLock·p0.99:   16480.000 ns/op
                 testTryLock·p0.999:  314880.000 ns/op
                 testTryLock·p0.9999: 6386634.752 ns/op
                 testTryLock·p1.00:   42401792.000 ns/op

Iteration   2: 3828.202 ±(99.9%) 70.055 ns/op
                 testTryLock·p0.00:   1478.000 ns/op
                 testTryLock·p0.50:   2692.000 ns/op
                 testTryLock·p0.90:   2860.000 ns/op
                 testTryLock·p0.95:   2968.000 ns/op
                 testTryLock·p0.99:   15520.000 ns/op
                 testTryLock·p0.999:  223488.000 ns/op
                 testTryLock·p0.9999: 922080.051 ns/op
                 testTryLock·p1.00:   16711680.000 ns/op

Iteration   3: 3785.100 ±(99.9%) 66.148 ns/op
                 testTryLock·p0.00:   1500.000 ns/op
                 testTryLock·p0.50:   2636.000 ns/op
                 testTryLock·p0.90:   2808.000 ns/op
                 testTryLock·p0.95:   2928.000 ns/op
                 testTryLock·p0.99:   15648.000 ns/op
                 testTryLock·p0.999:  223488.000 ns/op
                 testTryLock·p0.9999: 893952.000 ns/op
                 testTryLock·p1.00:   13860864.000 ns/op

Iteration   4: 3932.543 ±(99.9%) 82.976 ns/op
                 testTryLock·p0.00:   1516.000 ns/op
                 testTryLock·p0.50:   2648.000 ns/op
                 testTryLock·p0.90:   2820.000 ns/op
                 testTryLock·p0.95:   2952.000 ns/op
                 testTryLock·p0.99:   16188.000 ns/op
                 testTryLock·p0.999:  228096.000 ns/op
                 testTryLock·p0.9999: 1247933.440 ns/op
                 testTryLock·p1.00:   18350080.000 ns/op

Iteration   5: 4535.183 ±(99.9%) 151.731 ns/op
                 testTryLock·p0.00:   773.000 ns/op
                 testTryLock·p0.50:   2640.000 ns/op
                 testTryLock·p0.90:   2816.000 ns/op
                 testTryLock·p0.95:   2964.000 ns/op
                 testTryLock·p0.99:   19520.000 ns/op
                 testTryLock·p0.999:  259584.000 ns/op
                 testTryLock·p0.9999: 2599147.520 ns/op
                 testTryLock·p1.00:   23855104.000 ns/op


# Run progress: 90.00% complete, ETA 00:01:14
# Fork: 5 of 5
# Warmup Iteration   1: 10065.514 ±(99.9%) 857.263 ns/op
Iteration   1: 5933.351 ±(99.9%) 264.842 ns/op
                 testTryLock·p0.00:   1094.000 ns/op
                 testTryLock·p0.50:   2580.000 ns/op
                 testTryLock·p0.90:   2824.000 ns/op
                 testTryLock·p0.95:   3188.000 ns/op
                 testTryLock·p0.99:   17408.000 ns/op
                 testTryLock·p0.999:  360960.000 ns/op
                 testTryLock·p0.9999: 6822866.944 ns/op
                 testTryLock·p1.00:   23068672.000 ns/op

Iteration   2: 4980.654 ±(99.9%) 224.282 ns/op
                 testTryLock·p0.00:   1550.000 ns/op
                 testTryLock·p0.50:   2636.000 ns/op
                 testTryLock·p0.90:   2856.000 ns/op
                 testTryLock·p0.95:   3044.000 ns/op
                 testTryLock·p0.99:   21081.920 ns/op
                 testTryLock·p0.999:  330240.000 ns/op
                 testTryLock·p0.9999: 3061506.458 ns/op
                 testTryLock·p1.00:   43646976.000 ns/op

Iteration   3: 4203.592 ±(99.9%) 95.097 ns/op
                 testTryLock·p0.00:   878.000 ns/op
                 testTryLock·p0.50:   2652.000 ns/op
                 testTryLock·p0.90:   2844.000 ns/op
                 testTryLock·p0.95:   2976.000 ns/op
                 testTryLock·p0.99:   16512.000 ns/op
                 testTryLock·p0.999:  264704.000 ns/op
                 testTryLock·p0.9999: 1662733.517 ns/op
                 testTryLock·p1.00:   28049408.000 ns/op

Iteration   4: 3830.095 ±(99.9%) 63.736 ns/op
                 testTryLock·p0.00:   1514.000 ns/op
                 testTryLock·p0.50:   2680.000 ns/op
                 testTryLock·p0.90:   2860.000 ns/op
                 testTryLock·p0.95:   2984.000 ns/op
                 testTryLock·p0.99:   15440.000 ns/op
                 testTryLock·p0.999:  227840.000 ns/op
                 testTryLock·p0.9999: 962115.379 ns/op
                 testTryLock·p1.00:   15220736.000 ns/op

Iteration   5: 3991.231 ±(99.9%) 89.933 ns/op
                 testTryLock·p0.00:   1210.000 ns/op
                 testTryLock·p0.50:   2672.000 ns/op
                 testTryLock·p0.90:   2856.000 ns/op
                 testTryLock·p0.95:   2980.000 ns/op
                 testTryLock·p0.99:   16032.000 ns/op
                 testTryLock·p0.999:  233472.000 ns/op
                 testTryLock·p0.9999: 1236680.499 ns/op
                 testTryLock·p1.00:   28082176.000 ns/op



Result "pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock":
  N = 65206393
  mean =   4690.081 ±(99.9%) 31.527 ns/op

  Histogram, ns/op:
    [       0.000,  5000000.000) = 65202877 
    [ 5000000.000, 10000000.000) = 2745 
    [10000000.000, 15000000.000) = 556 
    [15000000.000, 20000000.000) = 136 
    [20000000.000, 25000000.000) = 49 
    [25000000.000, 30000000.000) = 18 
    [30000000.000, 35000000.000) = 6 
    [35000000.000, 40000000.000) = 4 
    [40000000.000, 45000000.000) = 2 

  Percentiles, ns/op:
      p(0.0000) =    773.000 ns/op
     p(50.0000) =   2728.000 ns/op
     p(90.0000) =   3244.000 ns/op
     p(95.0000) =   3416.000 ns/op
     p(99.0000) =  18560.000 ns/op
     p(99.9000) = 257280.000 ns/op
     p(99.9900) = 2826240.000 ns/op
     p(99.9990) = 10485760.000 ns/op
     p(99.9999) = 20604308.881 ns/op
    p(100.0000) = 43646976.000 ns/op


# Run complete. Total time: 00:12:13

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                                                                   Mode       Cnt           Score      Error  Units
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire                         sample  20347533      103026.470 ± 8987.630  ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.00    sample                  2480.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.50    sample                  4992.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.90    sample                  8184.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.95    sample                 24032.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.99    sample                229376.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.999   sample               2301952.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.9999  sample              37814272.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p1.00    sample            3766484992.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock                            sample  65206393        4690.081 ±   31.527  ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.00          sample                   773.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.50          sample                  2728.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.90          sample                  3244.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.95          sample                  3416.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.99          sample                 18560.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.999         sample                257280.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.9999        sample               2826240.000             ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p1.00          sample              43646976.000             ns/op
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
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 92216.863 ±(99.9%) 8927.894 ns/op
Iteration   1: 127601.899 ±(99.9%) 6739.935 ns/op
Iteration   2: 118260.050 ±(99.9%) 9227.932 ns/op
Iteration   3: 104700.551 ±(99.9%) 9641.834 ns/op
Iteration   4: 95283.663 ±(99.9%) 4447.718 ns/op
Iteration   5: 95563.535 ±(99.9%) 3213.389 ns/op

# Run progress: 10.00% complete, ETA 00:12:27
# Fork: 2 of 5
# Warmup Iteration   1: 87862.175 ±(99.9%) 7016.372 ns/op
Iteration   1: 132701.188 ±(99.9%) 8686.074 ns/op
Iteration   2: 117391.583 ±(99.9%) 6501.587 ns/op
Iteration   3: 108561.800 ±(99.9%) 4961.264 ns/op
Iteration   4: 98044.538 ±(99.9%) 2349.041 ns/op
Iteration   5: 100534.530 ±(99.9%) 7790.976 ns/op

# Run progress: 20.00% complete, ETA 00:11:20
# Fork: 3 of 5
# Warmup Iteration   1: 73151.486 ±(99.9%) 3556.515 ns/op
Iteration   1: 128958.359 ±(99.9%) 3125.088 ns/op
Iteration   2: 97750.043 ±(99.9%) 2536.566 ns/op
Iteration   3: 98355.297 ±(99.9%) 4273.849 ns/op
Iteration   4: 97143.840 ±(99.9%) 2491.616 ns/op
Iteration   5: 96630.093 ±(99.9%) 3973.189 ns/op

# Run progress: 30.00% complete, ETA 00:10:13
# Fork: 4 of 5
# Warmup Iteration   1: 73619.233 ±(99.9%) 4157.537 ns/op
Iteration   1: 124765.457 ±(99.9%) 7269.801 ns/op
Iteration   2: 96268.327 ±(99.9%) 4607.696 ns/op
Iteration   3: 95430.003 ±(99.9%) 4550.314 ns/op
Iteration   4: 100098.430 ±(99.9%) 2392.296 ns/op
Iteration   5: 98974.048 ±(99.9%) 3252.998 ns/op

# Run progress: 40.00% complete, ETA 00:08:48
# Fork: 5 of 5
# Warmup Iteration   1: 81203.436 ±(99.9%) 52377.375 ns/op
Iteration   1: 129919.123 ±(99.9%) 6957.641 ns/op
Iteration   2: 97392.063 ±(99.9%) 2657.996 ns/op
Iteration   3: 96112.134 ±(99.9%) 2401.655 ns/op
Iteration   4: 100833.546 ±(99.9%) 19830.961 ns/op
Iteration   5: 79348.524 ±(99.9%) 1923.478 ns/op


Result "pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire":
  105464.905 ±(99.9%) 10506.329 ns/op [Average]
  (min, avg, max) = (79348.524, 105464.905, 132701.188), stdev = 14025.649
  CI (99.9%): [94958.576, 115971.234] (assumes normal distribution)


# JMH version: 1.34
# VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:23
# Fork: 1 of 5
# Warmup Iteration   1: 5779.552 ±(99.9%) 534.366 ns/op
Iteration   1: 3826.249 ±(99.9%) 16.841 ns/op
Iteration   2: 3636.686 ±(99.9%) 11.770 ns/op
Iteration   3: 3966.915 ±(99.9%) 33.831 ns/op
Iteration   4: 3951.528 ±(99.9%) 20.224 ns/op
Iteration   5: 3971.696 ±(99.9%) 28.444 ns/op

# Run progress: 60.00% complete, ETA 00:05:36
# Fork: 2 of 5
# Warmup Iteration   1: 5831.315 ±(99.9%) 684.254 ns/op
Iteration   1: 4183.036 ±(99.9%) 11.241 ns/op
Iteration   2: 4330.652 ±(99.9%) 19.768 ns/op
Iteration   3: 3720.147 ±(99.9%) 14.153 ns/op
Iteration   4: 3689.492 ±(99.9%) 17.714 ns/op
Iteration   5: 3718.812 ±(99.9%) 18.216 ns/op

# Run progress: 70.00% complete, ETA 00:04:03
# Fork: 3 of 5
# Warmup Iteration   1: 6874.338 ±(99.9%) 756.646 ns/op
Iteration   1: 5008.415 ±(99.9%) 32.838 ns/op
Iteration   2: 4496.484 ±(99.9%) 15.221 ns/op
Iteration   3: 4030.072 ±(99.9%) 29.426 ns/op
Iteration   4: 4001.139 ±(99.9%) 29.936 ns/op
Iteration   5: 3946.554 ±(99.9%) 15.689 ns/op

# Run progress: 80.00% complete, ETA 00:02:37
# Fork: 4 of 5
# Warmup Iteration   1: 9395.475 ±(99.9%) 954.976 ns/op
Iteration   1: 5028.214 ±(99.9%) 20.580 ns/op
Iteration   2: 4164.873 ±(99.9%) 17.827 ns/op
Iteration   3: 4298.923 ±(99.9%) 20.981 ns/op
Iteration   4: 4338.135 ±(99.9%) 9.068 ns/op
Iteration   5: 4525.404 ±(99.9%) 42.803 ns/op

# Run progress: 90.00% complete, ETA 00:01:16
# Fork: 5 of 5
# Warmup Iteration   1: 5644.481 ±(99.9%) 699.148 ns/op
Iteration   1: 4722.927 ±(99.9%) 23.474 ns/op
Iteration   2: 4098.743 ±(99.9%) 14.998 ns/op
Iteration   3: 4216.576 ±(99.9%) 15.632 ns/op
Iteration   4: 4036.829 ±(99.9%) 14.204 ns/op
Iteration   5: 4092.363 ±(99.9%) 12.221 ns/op


Result "pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock":
  4160.035 ±(99.9%) 279.581 ns/op [Average]
  (min, avg, max) = (3636.686, 4160.035, 5028.214), stdev = 373.232
  CI (99.9%): [3880.454, 4439.615] (assumes normal distribution)


# Run complete. Total time: 00:12:33

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                                          Mode  Cnt       Score       Error  Units
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testLockExpire  avgt   25  105464.905 ± 10506.329  ns/op
RedisReactiveLockBenchmarkTests.RedisReactiveLockRegistryBenchmark.testTryLock     avgt   25    4160.035 ±   279.581  ns/op
```