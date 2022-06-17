### Throughput

```txt
# Detecting actual CPU count: 8 detected
# JMH version: 1.34
# VM version: JDK 11.0.11, OpenJDK 64-Bit Server VM, 11.0.11+9
# VM invoker: /Users/evans/.sdkman/candidates/java/11.0.11.hs-adpt/bin/java
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 56170.502 ops/s
Iteration   1: 66283.304 ops/s
Iteration   2: 59738.953 ops/s
Iteration   3: 64251.570 ops/s
Iteration   4: 63455.216 ops/s
Iteration   5: 63764.393 ops/s

# Run progress: 10.00% complete, ETA 00:13:25
# Fork: 2 of 5
# Warmup Iteration   1: 51315.929 ops/s
Iteration   1: 63799.281 ops/s
Iteration   2: 69631.224 ops/s
Iteration   3: 63736.945 ops/s
Iteration   4: 60021.806 ops/s
Iteration   5: 71025.507 ops/s

# Run progress: 20.00% complete, ETA 00:11:24
# Fork: 3 of 5
# Warmup Iteration   1: 50817.478 ops/s
Iteration   1: 73781.681 ops/s
Iteration   2: 42153.387 ops/s
Iteration   3: 80602.281 ops/s
Iteration   4: 54195.384 ops/s
Iteration   5: 62026.208 ops/s

# Run progress: 30.00% complete, ETA 00:09:56
# Fork: 4 of 5
# Warmup Iteration   1: 49856.511 ops/s
Iteration   1: 72271.905 ops/s
Iteration   2: 54908.894 ops/s
Iteration   3: 85052.194 ops/s
Iteration   4: 54682.432 ops/s
Iteration   5: 60345.132 ops/s

# Run progress: 40.00% complete, ETA 00:08:30
# Fork: 5 of 5
# Warmup Iteration   1: 88385.397 ops/s
Iteration   1: 58986.161 ops/s
Iteration   2: 36726.491 ops/s
Iteration   3: 64875.232 ops/s
Iteration   4: 74010.140 ops/s
Iteration   5: 62733.169 ops/s


Result "pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire":
  63322.356 ±(99.9%) 7832.461 ops/s [Average]
  (min, avg, max) = (36726.491, 63322.356, 85052.194), stdev = 10456.112
  CI (99.9%): [55489.894, 71154.817] (assumes normal distribution)


# JMH version: 1.34
# VM version: JDK 11.0.11, OpenJDK 64-Bit Server VM, 11.0.11+9
# VM invoker: /Users/evans/.sdkman/candidates/java/11.0.11.hs-adpt/bin/java
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:07
# Fork: 1 of 5
# Warmup Iteration   1: 579063.837 ops/s
Iteration   1: 568259.963 ops/s
Iteration   2: 648472.888 ops/s
Iteration   3: 596567.914 ops/s
Iteration   4: 650928.794 ops/s
Iteration   5: 597477.094 ops/s

# Run progress: 60.00% complete, ETA 00:05:29
# Fork: 2 of 5
# Warmup Iteration   1: 548008.356 ops/s
Iteration   1: 623455.777 ops/s
Iteration   2: 586832.924 ops/s
Iteration   3: 652063.889 ops/s
Iteration   4: 659247.565 ops/s
Iteration   5: 606001.926 ops/s

# Run progress: 70.00% complete, ETA 00:04:00
# Fork: 3 of 5
# Warmup Iteration   1: 557643.433 ops/s
Iteration   1: 664311.321 ops/s
Iteration   2: 564076.696 ops/s
Iteration   3: 654375.657 ops/s
Iteration   4: 593142.052 ops/s
Iteration   5: 660056.753 ops/s

# Run progress: 80.00% complete, ETA 00:02:37
# Fork: 4 of 5
# Warmup Iteration   1: 551025.606 ops/s
Iteration   1: 626647.248 ops/s
Iteration   2: 593282.941 ops/s
Iteration   3: 648062.688 ops/s
Iteration   4: 639707.460 ops/s
Iteration   5: 572612.806 ops/s

# Run progress: 90.00% complete, ETA 00:01:17
# Fork: 5 of 5
# Warmup Iteration   1: 554271.519 ops/s
Iteration   1: 623381.242 ops/s
Iteration   2: 662186.133 ops/s
Iteration   3: 650047.429 ops/s
Iteration   4: 611664.782 ops/s
Iteration   5: 627492.123 ops/s


Result "pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock":
  623214.243 ±(99.9%) 24038.862 ops/s [Average]
  (min, avg, max) = (564076.696, 623214.243, 664311.321), stdev = 32091.193
  CI (99.9%): [599175.380, 647253.105] (assumes normal distribution)


# Run complete. Total time: 00:12:49

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                               Mode  Cnt       Score       Error  Units
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire  thrpt   25   63322.356 ±  7832.461  ops/s
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock     thrpt   25  623214.243 ± 24038.862  ops/s
```

### Sample Time

```txt
# Detecting actual CPU count: 8 detected
# JMH version: 1.34
# VM version: JDK 11.0.11, OpenJDK 64-Bit Server VM, 11.0.11+9
# VM invoker: /Users/evans/.sdkman/candidates/java/11.0.11.hs-adpt/bin/java
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Sampling time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 174050.958 ±(99.9%) 30218.811 ns/op
Iteration   1: 159421.928 ±(99.9%) 70675.628 ns/op
                 testLockExpire·p0.00:   2800.000 ns/op
                 testLockExpire·p0.50:   22464.000 ns/op
                 testLockExpire·p0.90:   77568.000 ns/op
                 testLockExpire·p0.95:   363520.000 ns/op
                 testLockExpire·p0.99:   1343488.000 ns/op
                 testLockExpire·p0.999:  4456448.000 ns/op
                 testLockExpire·p0.9999: 23789568.000 ns/op
                 testLockExpire·p1.00:   4999610368.000 ns/op

Iteration   2: 116910.861 ±(99.9%) 60705.330 ns/op
                 testLockExpire·p0.00:   2892.000 ns/op
                 testLockExpire·p0.50:   5592.000 ns/op
                 testLockExpire·p0.90:   13440.000 ns/op
                 testLockExpire·p0.95:   75776.000 ns/op
                 testLockExpire·p0.99:   452608.000 ns/op
                 testLockExpire·p0.999:  2389098.496 ns/op
                 testLockExpire·p0.9999: 9606109.594 ns/op
                 testLockExpire·p1.00:   3632267264.000 ns/op

Iteration   3: 141078.122 ±(99.9%) 78323.594 ns/op
                 testLockExpire·p0.00:   2808.000 ns/op
                 testLockExpire·p0.50:   5728.000 ns/op
                 testLockExpire·p0.90:   10640.000 ns/op
                 testLockExpire·p0.95:   68352.000 ns/op
                 testLockExpire·p0.99:   437248.000 ns/op
                 testLockExpire·p0.999:  2699264.000 ns/op
                 testLockExpire·p0.9999: 11990325.658 ns/op
                 testLockExpire·p1.00:   4236247040.000 ns/op

Iteration   4: 115739.863 ±(99.9%) 63049.639 ns/op
                 testLockExpire·p0.00:   3068.000 ns/op
                 testLockExpire·p0.50:   5656.000 ns/op
                 testLockExpire·p0.90:   15472.000 ns/op
                 testLockExpire·p0.95:   80512.000 ns/op
                 testLockExpire·p0.99:   385536.000 ns/op
                 testLockExpire·p0.999:  1713782.784 ns/op
                 testLockExpire·p0.9999: 6112713.114 ns/op
                 testLockExpire·p1.00:   3321888768.000 ns/op

Iteration   5: 136648.504 ±(99.9%) 74422.523 ns/op
                 testLockExpire·p0.00:   3048.000 ns/op
                 testLockExpire·p0.50:   5592.000 ns/op
                 testLockExpire·p0.90:   12208.000 ns/op
                 testLockExpire·p0.95:   67328.000 ns/op
                 testLockExpire·p0.99:   426496.000 ns/op
                 testLockExpire·p0.999:  2809856.000 ns/op
                 testLockExpire·p0.9999: 17188329.882 ns/op
                 testLockExpire·p1.00:   3787456512.000 ns/op


# Run progress: 10.00% complete, ETA 00:14:30
# Fork: 2 of 5
# Warmup Iteration   1: 164165.417 ±(99.9%) 28268.763 ns/op
Iteration   1: 122394.749 ±(99.9%) 50286.270 ns/op
                 testLockExpire·p0.00:   3212.000 ns/op
                 testLockExpire·p0.50:   8704.000 ns/op
                 testLockExpire·p0.90:   39744.000 ns/op
                 testLockExpire·p0.95:   140800.000 ns/op
                 testLockExpire·p0.99:   899072.000 ns/op
                 testLockExpire·p0.999:  3305472.000 ns/op
                 testLockExpire·p0.9999: 30539776.000 ns/op
                 testLockExpire·p1.00:   3309305856.000 ns/op

Iteration   2: 151069.437 ±(99.9%) 86455.613 ns/op
                 testLockExpire·p0.00:   3184.000 ns/op
                 testLockExpire·p0.50:   5768.000 ns/op
                 testLockExpire·p0.90:   9392.000 ns/op
                 testLockExpire·p0.95:   67968.000 ns/op
                 testLockExpire·p0.99:   379904.000 ns/op
                 testLockExpire·p0.999:  1562900.480 ns/op
                 testLockExpire·p0.9999: 7054639.104 ns/op
                 testLockExpire·p1.00:   3300917248.000 ns/op

Iteration   3: 107525.743 ±(99.9%) 57131.840 ns/op
                 testLockExpire·p0.00:   2936.000 ns/op
                 testLockExpire·p0.50:   5832.000 ns/op
                 testLockExpire·p0.90:   12944.000 ns/op
                 testLockExpire·p0.95:   76800.000 ns/op
                 testLockExpire·p0.99:   399360.000 ns/op
                 testLockExpire·p0.999:  1897904.128 ns/op
                 testLockExpire·p0.9999: 5826841.805 ns/op
                 testLockExpire·p1.00:   3372220416.000 ns/op

Iteration   4: 118533.911 ±(99.9%) 65170.489 ns/op
                 testLockExpire·p0.00:   3356.000 ns/op
                 testLockExpire·p0.50:   5776.000 ns/op
                 testLockExpire·p0.90:   10688.000 ns/op
                 testLockExpire·p0.95:   70272.000 ns/op
                 testLockExpire·p0.99:   387072.000 ns/op
                 testLockExpire·p0.999:  1490944.000 ns/op
                 testLockExpire·p0.9999: 5005131.776 ns/op
                 testLockExpire·p1.00:   3078619136.000 ns/op

Iteration   5: 115195.632 ±(99.9%) 62501.720 ns/op
                 testLockExpire·p0.00:   3160.000 ns/op
                 testLockExpire·p0.50:   5800.000 ns/op
                 testLockExpire·p0.90:   16480.000 ns/op
                 testLockExpire·p0.95:   83328.000 ns/op
                 testLockExpire·p0.99:   385536.000 ns/op
                 testLockExpire·p0.999:  1560782.848 ns/op
                 testLockExpire·p0.9999: 5365760.000 ns/op
                 testLockExpire·p1.00:   3137339392.000 ns/op


# Run progress: 20.00% complete, ETA 00:12:16
# Fork: 3 of 5
# Warmup Iteration   1: 154236.911 ±(99.9%) 25416.079 ns/op
Iteration   1: 114346.629 ±(99.9%) 54594.547 ns/op
                 testLockExpire·p0.00:   3372.000 ns/op
                 testLockExpire·p0.50:   6552.000 ns/op
                 testLockExpire·p0.90:   13408.000 ns/op
                 testLockExpire·p0.95:   69760.000 ns/op
                 testLockExpire·p0.99:   433664.000 ns/op
                 testLockExpire·p0.999:  2152067.072 ns/op
                 testLockExpire·p0.9999: 12534713.549 ns/op
                 testLockExpire·p1.00:   2998927360.000 ns/op

Iteration   2: 148349.763 ±(99.9%) 73480.013 ns/op
                 testLockExpire·p0.00:   3104.000 ns/op
                 testLockExpire·p0.50:   5880.000 ns/op
                 testLockExpire·p0.90:   11280.000 ns/op
                 testLockExpire·p0.95:   69120.000 ns/op
                 testLockExpire·p0.99:   384512.000 ns/op
                 testLockExpire·p0.999:  1556480.000 ns/op
                 testLockExpire·p0.9999: 6776471.552 ns/op
                 testLockExpire·p1.00:   2818572288.000 ns/op

Iteration   3: 108687.079 ±(99.9%) 58432.735 ns/op
                 testLockExpire·p0.00:   2924.000 ns/op
                 testLockExpire·p0.50:   5848.000 ns/op
                 testLockExpire·p0.90:   18912.000 ns/op
                 testLockExpire·p0.95:   86528.000 ns/op
                 testLockExpire·p0.99:   372224.000 ns/op
                 testLockExpire·p0.999:  1745471.488 ns/op
                 testLockExpire·p0.9999: 6553342.771 ns/op
                 testLockExpire·p1.00:   3355443200.000 ns/op

Iteration   4: 110610.062 ±(99.9%) 59948.942 ns/op
                 testLockExpire·p0.00:   3036.000 ns/op
                 testLockExpire·p0.50:   5824.000 ns/op
                 testLockExpire·p0.90:   17344.000 ns/op
                 testLockExpire·p0.95:   79616.000 ns/op
                 testLockExpire·p0.99:   366592.000 ns/op
                 testLockExpire·p0.999:  1397106.688 ns/op
                 testLockExpire·p0.9999: 5372461.875 ns/op
                 testLockExpire·p1.00:   3120562176.000 ns/op

Iteration   5: 125359.456 ±(99.9%) 67923.332 ns/op
                 testLockExpire·p0.00:   2952.000 ns/op
                 testLockExpire·p0.50:   5808.000 ns/op
                 testLockExpire·p0.90:   15664.000 ns/op
                 testLockExpire·p0.95:   80128.000 ns/op
                 testLockExpire·p0.99:   390466.560 ns/op
                 testLockExpire·p0.999:  2023553.024 ns/op
                 testLockExpire·p0.9999: 10025679.258 ns/op
                 testLockExpire·p1.00:   2952790016.000 ns/op


# Run progress: 30.00% complete, ETA 00:10:39
# Fork: 4 of 5
# Warmup Iteration   1: 161396.784 ±(99.9%) 27439.289 ns/op
Iteration   1: 123774.655 ±(99.9%) 51127.293 ns/op
                 testLockExpire·p0.00:   2944.000 ns/op
                 testLockExpire·p0.50:   7864.000 ns/op
                 testLockExpire·p0.90:   48640.000 ns/op
                 testLockExpire·p0.95:   187904.000 ns/op
                 testLockExpire·p0.99:   1075200.000 ns/op
                 testLockExpire·p0.999:  2912256.000 ns/op
                 testLockExpire·p0.9999: 14619246.592 ns/op
                 testLockExpire·p1.00:   3435134976.000 ns/op

Iteration   2: 143190.394 ±(99.9%) 70699.524 ns/op
                 testLockExpire·p0.00:   3196.000 ns/op
                 testLockExpire·p0.50:   5640.000 ns/op
                 testLockExpire·p0.90:   11120.000 ns/op
                 testLockExpire·p0.95:   79744.000 ns/op
                 testLockExpire·p0.99:   373248.000 ns/op
                 testLockExpire·p0.999:  1243136.000 ns/op
                 testLockExpire·p0.9999: 4952702.976 ns/op
                 testLockExpire·p1.00:   2764046336.000 ns/op

Iteration   3: 120358.850 ±(99.9%) 68787.515 ns/op
                 testLockExpire·p0.00:   2988.000 ns/op
                 testLockExpire·p0.50:   5552.000 ns/op
                 testLockExpire·p0.90:   16480.000 ns/op
                 testLockExpire·p0.95:   83584.000 ns/op
                 testLockExpire·p0.99:   359424.000 ns/op
                 testLockExpire·p0.999:  1556480.000 ns/op
                 testLockExpire·p0.9999: 6805921.792 ns/op
                 testLockExpire·p1.00:   3829399552.000 ns/op

Iteration   4: 213118.940 ±(99.9%) 151680.755 ns/op
                 testLockExpire·p0.00:   3276.000 ns/op
                 testLockExpire·p0.50:   5776.000 ns/op
                 testLockExpire·p0.90:   8816.000 ns/op
                 testLockExpire·p0.95:   58176.000 ns/op
                 testLockExpire·p0.99:   373765.120 ns/op
                 testLockExpire·p0.999:  3907997.696 ns/op
                 testLockExpire·p0.9999: 27328512.000 ns/op
                 testLockExpire·p1.00:   5653921792.000 ns/op

Iteration   5: 113037.013 ±(99.9%) 59894.064 ns/op
                 testLockExpire·p0.00:   3008.000 ns/op
                 testLockExpire·p0.50:   5832.000 ns/op
                 testLockExpire·p0.90:   12976.000 ns/op
                 testLockExpire·p0.95:   78208.000 ns/op
                 testLockExpire·p0.99:   399360.000 ns/op
                 testLockExpire·p0.999:  1920393.216 ns/op
                 testLockExpire·p0.9999: 6774069.658 ns/op
                 testLockExpire·p1.00:   3745513472.000 ns/op

<JMH had finished, but forked VM did not exit, are there stray running threads? Waiting 24 seconds more...>

Non-finished threads:

Thread[DestroyJavaVM,5,main]



# Run progress: 40.00% complete, ETA 00:09:17
# Fork: 5 of 5
# Warmup Iteration   1: 159905.493 ±(99.9%) 28908.746 ns/op
Iteration   1: 111915.465 ±(99.9%) 51881.002 ns/op
                 testLockExpire·p0.00:   2852.000 ns/op
                 testLockExpire·p0.50:   8304.000 ns/op
                 testLockExpire·p0.90:   33984.000 ns/op
                 testLockExpire·p0.95:   105984.000 ns/op
                 testLockExpire·p0.99:   819200.000 ns/op
                 testLockExpire·p0.999:  2953216.000 ns/op
                 testLockExpire·p0.9999: 16725575.270 ns/op
                 testLockExpire·p1.00:   3275751424.000 ns/op

Iteration   2: 116203.747 ±(99.9%) 63818.211 ns/op
                 testLockExpire·p0.00:   2812.000 ns/op
                 testLockExpire·p0.50:   5544.000 ns/op
                 testLockExpire·p0.90:   10304.000 ns/op
                 testLockExpire·p0.95:   68352.000 ns/op
                 testLockExpire·p0.99:   368640.000 ns/op
                 testLockExpire·p0.999:  1408768.000 ns/op
                 testLockExpire·p0.9999: 5898342.400 ns/op
                 testLockExpire·p1.00:   2977955840.000 ns/op

Iteration   3: 129570.448 ±(99.9%) 70269.476 ns/op
                 testLockExpire·p0.00:   3060.000 ns/op
                 testLockExpire·p0.50:   5784.000 ns/op
                 testLockExpire·p0.90:   12032.000 ns/op
                 testLockExpire·p0.95:   71808.000 ns/op
                 testLockExpire·p0.99:   425472.000 ns/op
                 testLockExpire·p0.999:  1929216.000 ns/op
                 testLockExpire·p0.9999: 10558229.709 ns/op
                 testLockExpire·p1.00:   2965372928.000 ns/op

Iteration   4: 105817.926 ±(99.9%) 57230.135 ns/op
                 testLockExpire·p0.00:   3220.000 ns/op
                 testLockExpire·p0.50:   5776.000 ns/op
                 testLockExpire·p0.90:   16251.200 ns/op
                 testLockExpire·p0.95:   81920.000 ns/op
                 testLockExpire·p0.99:   376832.000 ns/op
                 testLockExpire·p0.999:  1452032.000 ns/op
                 testLockExpire·p0.9999: 5428252.672 ns/op
                 testLockExpire·p1.00:   2919235584.000 ns/op

Iteration   5: 113706.699 ±(99.9%) 61497.382 ns/op
                 testLockExpire·p0.00:   3008.000 ns/op
                 testLockExpire·p0.50:   5776.000 ns/op
                 testLockExpire·p0.90:   18720.000 ns/op
                 testLockExpire·p0.95:   86784.000 ns/op
                 testLockExpire·p0.99:   365568.000 ns/op
                 testLockExpire·p0.999:  1294336.000 ns/op
                 testLockExpire·p0.9999: 5379280.077 ns/op
                 testLockExpire·p1.00:   2910846976.000 ns/op



Result "pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire":
  N = 17765734
  mean = 125104.458 ±(99.9%) 13210.713 ns/op

  Histogram, ns/op:
    [         0.000,  500000000.000) = 17765113 
    [ 500000000.000, 1000000000.000) = 48 
    [1000000000.000, 1500000000.000) = 6 
    [1500000000.000, 2000000000.000) = 24 
    [2000000000.000, 2500000000.000) = 94 
    [2500000000.000, 3000000000.000) = 271 
    [3000000000.000, 3500000000.000) = 106 
    [3500000000.000, 4000000000.000) = 40 
    [4000000000.000, 4500000000.000) = 16 
    [4500000000.000, 5000000000.000) = 8 
    [5000000000.000, 5500000000.000) = 0 

  Percentiles, ns/op:
      p(0.0000) =   2800.000 ns/op
     p(50.0000) =   5840.000 ns/op
     p(90.0000) =  29536.000 ns/op
     p(95.0000) =  88448.000 ns/op
     p(99.0000) = 501760.000 ns/op
     p(99.9000) = 2199552.000 ns/op
     p(99.9900) = 10787659.776 ns/op
     p(99.9990) = 3074424832.000 ns/op
     p(99.9999) = 4303355904.000 ns/op
    p(100.0000) = 5653921792.000 ns/op


# JMH version: 1.34
# VM version: JDK 11.0.11, OpenJDK 64-Bit Server VM, 11.0.11+9
# VM invoker: /Users/evans/.sdkman/candidates/java/11.0.11.hs-adpt/bin/java
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Sampling time
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:34
# Fork: 1 of 5
# Warmup Iteration   1: 19406.055 ±(99.9%) 5322.433 ns/op
Iteration   1: 17631.204 ±(99.9%) 4253.217 ns/op
                 testTryLock·p0.00:   827.000 ns/op
                 testTryLock·p0.50:   2652.000 ns/op
                 testTryLock·p0.90:   6192.000 ns/op
                 testTryLock·p0.95:   18432.000 ns/op
                 testTryLock·p0.99:   143360.000 ns/op
                 testTryLock·p0.999:  1081344.000 ns/op
                 testTryLock·p0.9999: 7141086.003 ns/op
                 testTryLock·p1.00:   889192448.000 ns/op

Iteration   2: 14702.570 ±(99.9%) 3379.122 ns/op
                 testTryLock·p0.00:   823.000 ns/op
                 testTryLock·p0.50:   2652.000 ns/op
                 testTryLock·p0.90:   6712.000 ns/op
                 testTryLock·p0.95:   22112.000 ns/op
                 testTryLock·p0.99:   136448.000 ns/op
                 testTryLock·p0.999:  851968.000 ns/op
                 testTryLock·p0.9999: 5275648.000 ns/op
                 testTryLock·p1.00:   905969664.000 ns/op

Iteration   3: 15712.529 ±(99.9%) 3801.247 ns/op
                 testTryLock·p0.00:   823.000 ns/op
                 testTryLock·p0.50:   2684.000 ns/op
                 testTryLock·p0.90:   6832.000 ns/op
                 testTryLock·p0.95:   22720.000 ns/op
                 testTryLock·p0.99:   132864.000 ns/op
                 testTryLock·p0.999:  840704.000 ns/op
                 testTryLock·p0.9999: 6850614.067 ns/op
                 testTryLock·p1.00:   958398464.000 ns/op

Iteration   4: 16432.754 ±(99.9%) 3750.804 ns/op
                 testTryLock·p0.00:   840.000 ns/op
                 testTryLock·p0.50:   2708.000 ns/op
                 testTryLock·p0.90:   7096.000 ns/op
                 testTryLock·p0.95:   23328.000 ns/op
                 testTryLock·p0.99:   138240.000 ns/op
                 testTryLock·p0.999:  826368.000 ns/op
                 testTryLock·p0.9999: 6154862.592 ns/op
                 testTryLock·p1.00:   939524096.000 ns/op

Iteration   5: 16717.845 ±(99.9%) 3922.305 ns/op
                 testTryLock·p0.00:   833.000 ns/op
                 testTryLock·p0.50:   2756.000 ns/op
                 testTryLock·p0.90:   7368.000 ns/op
                 testTryLock·p0.95:   25504.000 ns/op
                 testTryLock·p0.99:   140800.000 ns/op
                 testTryLock·p0.999:  841800.704 ns/op
                 testTryLock·p0.9999: 6559508.890 ns/op
                 testTryLock·p1.00:   857735168.000 ns/op


# Run progress: 60.00% complete, ETA 00:05:51
# Fork: 2 of 5
# Warmup Iteration   1: 22326.319 ±(99.9%) 6586.787 ns/op
Iteration   1: 16655.057 ±(99.9%) 3591.225 ns/op
                 testTryLock·p0.00:   855.000 ns/op
                 testTryLock·p0.50:   2808.000 ns/op
                 testTryLock·p0.90:   6480.000 ns/op
                 testTryLock·p0.95:   20384.000 ns/op
                 testTryLock·p0.99:   146944.000 ns/op
                 testTryLock·p0.999:  1040384.000 ns/op
                 testTryLock·p0.9999: 5333409.792 ns/op
                 testTryLock·p1.00:   490209280.000 ns/op

Iteration   2: 17787.999 ±(99.9%) 5456.259 ns/op
                 testTryLock·p0.00:   838.000 ns/op
                 testTryLock·p0.50:   2816.000 ns/op
                 testTryLock·p0.90:   7056.000 ns/op
                 testTryLock·p0.95:   23360.000 ns/op
                 testTryLock·p0.99:   146432.000 ns/op
                 testTryLock·p0.999:  1039406.080 ns/op
                 testTryLock·p0.9999: 9175040.000 ns/op
                 testTryLock·p1.00:   2092957696.000 ns/op

Iteration   3: 17059.323 ±(99.9%) 4389.175 ns/op
                 testTryLock·p0.00:   857.000 ns/op
                 testTryLock·p0.50:   2736.000 ns/op
                 testTryLock·p0.90:   6288.000 ns/op
                 testTryLock·p0.95:   17600.000 ns/op
                 testTryLock·p0.99:   130432.000 ns/op
                 testTryLock·p0.999:  866304.000 ns/op
                 testTryLock·p0.9999: 5874050.662 ns/op
                 testTryLock·p1.00:   824180736.000 ns/op

Iteration   4: 19154.698 ±(99.9%) 4895.831 ns/op
                 testTryLock·p0.00:   846.000 ns/op
                 testTryLock·p0.50:   2756.000 ns/op
                 testTryLock·p0.90:   6072.000 ns/op
                 testTryLock·p0.95:   16176.000 ns/op
                 testTryLock·p0.99:   127360.000 ns/op
                 testTryLock·p0.999:  1039077.376 ns/op
                 testTryLock·p0.9999: 10207232.000 ns/op
                 testTryLock·p1.00:   799014912.000 ns/op

Iteration   5: 15752.799 ±(99.9%) 3839.652 ns/op
                 testTryLock·p0.00:   836.000 ns/op
                 testTryLock·p0.50:   2740.000 ns/op
                 testTryLock·p0.90:   6848.000 ns/op
                 testTryLock·p0.95:   21344.000 ns/op
                 testTryLock·p0.99:   131072.000 ns/op
                 testTryLock·p0.999:  822934.528 ns/op
                 testTryLock·p0.9999: 5322053.222 ns/op
                 testTryLock·p1.00:   775946240.000 ns/op


# Run progress: 70.00% complete, ETA 00:04:16
# Fork: 3 of 5
# Warmup Iteration   1: 20148.338 ±(99.9%) 3953.811 ns/op
Iteration   1: 16449.167 ±(99.9%) 3846.283 ns/op
                 testTryLock·p0.00:   818.000 ns/op
                 testTryLock·p0.50:   2732.000 ns/op
                 testTryLock·p0.90:   6320.000 ns/op
                 testTryLock·p0.95:   19648.000 ns/op
                 testTryLock·p0.99:   150016.000 ns/op
                 testTryLock·p0.999:  971176.960 ns/op
                 testTryLock·p0.9999: 5256667.136 ns/op
                 testTryLock·p1.00:   849346560.000 ns/op

Iteration   2: 16186.059 ±(99.9%) 3751.793 ns/op
                 testTryLock·p0.00:   831.000 ns/op
                 testTryLock·p0.50:   2720.000 ns/op
                 testTryLock·p0.90:   5968.000 ns/op
                 testTryLock·p0.95:   16480.000 ns/op
                 testTryLock·p0.99:   134656.000 ns/op
                 testTryLock·p0.999:  956416.000 ns/op
                 testTryLock·p0.9999: 8887245.210 ns/op
                 testTryLock·p1.00:   1032847360.000 ns/op

Iteration   3: 15753.025 ±(99.9%) 3935.544 ns/op
                 testTryLock·p0.00:   824.000 ns/op
                 testTryLock·p0.50:   2740.000 ns/op
                 testTryLock·p0.90:   6264.000 ns/op
                 testTryLock·p0.95:   18208.000 ns/op
                 testTryLock·p0.99:   133888.000 ns/op
                 testTryLock·p0.999:  851968.000 ns/op
                 testTryLock·p0.9999: 7678853.120 ns/op
                 testTryLock·p1.00:   954204160.000 ns/op

Iteration   4: 17185.809 ±(99.9%) 5240.356 ns/op
                 testTryLock·p0.00:   884.000 ns/op
                 testTryLock·p0.50:   2724.000 ns/op
                 testTryLock·p0.90:   6864.000 ns/op
                 testTryLock·p0.95:   20736.000 ns/op
                 testTryLock·p0.99:   119424.000 ns/op
                 testTryLock·p0.999:  625664.000 ns/op
                 testTryLock·p0.9999: 4397419.725 ns/op
                 testTryLock·p1.00:   1021313024.000 ns/op

Iteration   5: 16965.193 ±(99.9%) 4579.399 ns/op
                 testTryLock·p0.00:   900.000 ns/op
                 testTryLock·p0.50:   2768.000 ns/op
                 testTryLock·p0.90:   6128.000 ns/op
                 testTryLock·p0.95:   16768.000 ns/op
                 testTryLock·p0.99:   132352.000 ns/op
                 testTryLock·p0.999:  899620.864 ns/op
                 testTryLock·p0.9999: 7782386.893 ns/op
                 testTryLock·p1.00:   982515712.000 ns/op


# Run progress: 80.00% complete, ETA 00:02:47
# Fork: 4 of 5
# Warmup Iteration   1: 22851.758 ±(99.9%) 6937.148 ns/op
Iteration   1: 17497.899 ±(99.9%) 4389.193 ns/op
                 testTryLock·p0.00:   816.000 ns/op
                 testTryLock·p0.50:   2692.000 ns/op
                 testTryLock·p0.90:   6120.000 ns/op
                 testTryLock·p0.95:   18112.000 ns/op
                 testTryLock·p0.99:   144128.000 ns/op
                 testTryLock·p0.999:  1079296.000 ns/op
                 testTryLock·p0.9999: 6139797.504 ns/op
                 testTryLock·p1.00:   832569344.000 ns/op

Iteration   2: 15204.758 ±(99.9%) 3320.821 ns/op
                 testTryLock·p0.00:   823.000 ns/op
                 testTryLock·p0.50:   2680.000 ns/op
                 testTryLock·p0.90:   6240.000 ns/op
                 testTryLock·p0.95:   18560.000 ns/op
                 testTryLock·p0.99:   135936.000 ns/op
                 testTryLock·p0.999:  856935.424 ns/op
                 testTryLock·p0.9999: 6317182.157 ns/op
                 testTryLock·p1.00:   917504000.000 ns/op

Iteration   3: 16644.108 ±(99.9%) 4874.339 ns/op
                 testTryLock·p0.00:   861.000 ns/op
                 testTryLock·p0.50:   2720.000 ns/op
                 testTryLock·p0.90:   6096.000 ns/op
                 testTryLock·p0.95:   16480.000 ns/op
                 testTryLock·p0.99:   131072.000 ns/op
                 testTryLock·p0.999:  897024.000 ns/op
                 testTryLock·p0.9999: 7048291.942 ns/op
                 testTryLock·p1.00:   1673527296.000 ns/op

Iteration   4: 17317.867 ±(99.9%) 4333.173 ns/op
                 testTryLock·p0.00:   839.000 ns/op
                 testTryLock·p0.50:   2728.000 ns/op
                 testTryLock·p0.90:   6232.000 ns/op
                 testTryLock·p0.95:   17728.000 ns/op
                 testTryLock·p0.99:   137472.000 ns/op
                 testTryLock·p0.999:  922957.824 ns/op
                 testTryLock·p0.9999: 7258112.000 ns/op
                 testTryLock·p1.00:   857735168.000 ns/op

Iteration   5: 15794.719 ±(99.9%) 3148.426 ns/op
                 testTryLock·p0.00:   904.000 ns/op
                 testTryLock·p0.50:   2800.000 ns/op
                 testTryLock·p0.90:   6392.000 ns/op
                 testTryLock·p0.95:   17632.000 ns/op
                 testTryLock·p0.99:   131584.000 ns/op
                 testTryLock·p0.999:  999197.696 ns/op
                 testTryLock·p0.9999: 7683009.741 ns/op
                 testTryLock·p1.00:   418381824.000 ns/op


# Run progress: 90.00% complete, ETA 00:01:22
# Fork: 5 of 5
# Warmup Iteration   1: 16471.337 ±(99.9%) 3254.283 ns/op
Iteration   1: 16739.898 ±(99.9%) 3516.763 ns/op
                 testTryLock·p0.00:   203.000 ns/op
                 testTryLock·p0.50:   2792.000 ns/op
                 testTryLock·p0.90:   6752.000 ns/op
                 testTryLock·p0.95:   21856.000 ns/op
                 testTryLock·p0.99:   146688.000 ns/op
                 testTryLock·p0.999:  1107968.000 ns/op
                 testTryLock·p0.9999: 4980732.723 ns/op
                 testTryLock·p1.00:   443023360.000 ns/op

Iteration   2: 18523.136 ±(99.9%) 4765.935 ns/op
                 testTryLock·p0.00:   836.000 ns/op
                 testTryLock·p0.50:   2852.000 ns/op
                 testTryLock·p0.90:   6680.000 ns/op
                 testTryLock·p0.95:   21312.000 ns/op
                 testTryLock·p0.99:   146432.000 ns/op
                 testTryLock·p0.999:  1214464.000 ns/op
                 testTryLock·p0.9999: 6315503.616 ns/op
                 testTryLock·p1.00:   921698304.000 ns/op

Iteration   3: 15897.233 ±(99.9%) 3632.347 ns/op
                 testTryLock·p0.00:   861.000 ns/op
                 testTryLock·p0.50:   2776.000 ns/op
                 testTryLock·p0.90:   6728.000 ns/op
                 testTryLock·p0.95:   20832.000 ns/op
                 testTryLock·p0.99:   134912.000 ns/op
                 testTryLock·p0.999:  850944.000 ns/op
                 testTryLock·p0.9999: 6389325.824 ns/op
                 testTryLock·p1.00:   787480576.000 ns/op

Iteration   4: 16272.559 ±(99.9%) 3746.813 ns/op
                 testTryLock·p0.00:   861.000 ns/op
                 testTryLock·p0.50:   2788.000 ns/op
                 testTryLock·p0.90:   6872.000 ns/op
                 testTryLock·p0.95:   22144.000 ns/op
                 testTryLock·p0.99:   132864.000 ns/op
                 testTryLock·p0.999:  778240.000 ns/op
                 testTryLock·p0.9999: 5398528.000 ns/op
                 testTryLock·p1.00:   829423616.000 ns/op

Iteration   5: 16758.609 ±(99.9%) 4216.197 ns/op
                 testTryLock·p0.00:   921.000 ns/op
                 testTryLock·p0.50:   2788.000 ns/op
                 testTryLock·p0.90:   6936.000 ns/op
                 testTryLock·p0.95:   21504.000 ns/op
                 testTryLock·p0.99:   128512.000 ns/op
                 testTryLock·p0.999:  770155.520 ns/op
                 testTryLock·p0.9999: 5334716.416 ns/op
                 testTryLock·p1.00:   682622976.000 ns/op



Result "pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock":
  N = 40584590
  mean =  16660.122 ±(99.9%) 826.936 ns/op

  Histogram, ns/op:
    [         0.000,  250000000.000) = 40584070 
    [ 250000000.000,  500000000.000) = 469 
    [ 500000000.000,  750000000.000) = 10 
    [ 750000000.000, 1000000000.000) = 34 
    [1000000000.000, 1250000000.000) = 5 
    [1250000000.000, 1500000000.000) = 0 
    [1500000000.000, 1750000000.000) = 1 
    [1750000000.000, 2000000000.000) = 0 
    [2000000000.000, 2250000000.000) = 1 
    [2250000000.000, 2500000000.000) = 0 
    [2500000000.000, 2750000000.000) = 0 

  Percentiles, ns/op:
      p(0.0000) =    203.000 ns/op
     p(50.0000) =   2744.000 ns/op
     p(90.0000) =   6520.000 ns/op
     p(95.0000) =  19840.000 ns/op
     p(99.0000) = 136192.000 ns/op
     p(99.9000) = 922624.000 ns/op
     p(99.9900) = 6476111.053 ns/op
     p(99.9990) = 319533754.617 ns/op
     p(99.9999) = 780302119.063 ns/op
    p(100.0000) = 2092957696.000 ns/op


# Run complete. Total time: 00:13:30

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                                                       Mode       Cnt           Score       Error  Units
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire                         sample  17765734      125104.458 ± 13210.713  ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.00    sample                  2800.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.50    sample                  5840.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.90    sample                 29536.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.95    sample                 88448.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.99    sample                501760.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.999   sample               2199552.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.9999  sample              10787659.776              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p1.00    sample            5653921792.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock                            sample  40584590       16660.122 ±   826.936  ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.00          sample                   203.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.50          sample                  2744.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.90          sample                  6520.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.95          sample                 19840.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.99          sample                136192.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.999         sample                922624.000              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.9999        sample               6476111.053              ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p1.00          sample            2092957696.000              ns/op
```

### Average Time

```txt
# Detecting actual CPU count: 8 detected
# JMH version: 1.34
# VM version: JDK 11.0.11, OpenJDK 64-Bit Server VM, 11.0.11+9
# VM invoker: /Users/evans/.sdkman/candidates/java/11.0.11.hs-adpt/bin/java
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 171404.264 ±(99.9%) 4537.801 ns/op
Iteration   1: 113784.954 ±(99.9%) 2790.963 ns/op
Iteration   2: 143046.497 ±(99.9%) 5969.238 ns/op
Iteration   3: 105384.444 ±(99.9%) 4284.346 ns/op
Iteration   4: 131882.092 ±(99.9%) 2194.290 ns/op
Iteration   5: 130245.970 ±(99.9%) 4008.133 ns/op

# Run progress: 10.00% complete, ETA 00:13:01
# Fork: 2 of 5
# Warmup Iteration   1: 149979.756 ±(99.9%) 5073.629 ns/op
Iteration   1: 92718.997 ±(99.9%) 2875.732 ns/op
Iteration   2: 178309.562 ±(99.9%) 6650.898 ns/op
Iteration   3: 120472.333 ±(99.9%) 3797.063 ns/op
Iteration   4: 143569.026 ±(99.9%) 6876.270 ns/op
Iteration   5: 139918.128 ±(99.9%) 4521.273 ns/op

# Run progress: 20.00% complete, ETA 00:11:23
# Fork: 3 of 5
# Warmup Iteration   1: 197235.229 ±(99.9%) 9654.525 ns/op
Iteration   1: 144617.549 ±(99.9%) 5299.029 ns/op
Iteration   2: 111906.927 ±(99.9%) 4642.414 ns/op
Iteration   3: 105667.468 ±(99.9%) 3929.242 ns/op
Iteration   4: 145501.514 ±(99.9%) 4661.581 ns/op
Iteration   5: 127136.889 ±(99.9%) 3830.264 ns/op

# Run progress: 30.00% complete, ETA 00:09:57
# Fork: 4 of 5
# Warmup Iteration   1: 166698.753 ±(99.9%) 4657.793 ns/op
Iteration   1: 121157.873 ±(99.9%) 2022.834 ns/op
Iteration   2: 133208.888 ±(99.9%) 3983.503 ns/op
Iteration   3: 121108.682 ±(99.9%) 2393.571 ns/op
Iteration   4: 130462.754 ±(99.9%) 2697.690 ns/op
Iteration   5: 124421.874 ±(99.9%) 4179.847 ns/op

# Run progress: 40.00% complete, ETA 00:08:38
# Fork: 5 of 5
# Warmup Iteration   1: 161881.433 ±(99.9%) 4355.005 ns/op
Iteration   1: 120864.828 ±(99.9%) 3336.733 ns/op
Iteration   2: 138459.175 ±(99.9%) 4384.750 ns/op
Iteration   3: 100114.559 ±(99.9%) 1503.450 ns/op
Iteration   4: 138682.709 ±(99.9%) 2570.444 ns/op
Iteration   5: 128239.902 ±(99.9%) 4717.070 ns/op


Result "pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire":
  127635.344 ±(99.9%) 13423.417 ns/op [Average]
  (min, avg, max) = (92718.997, 127635.344, 178309.562), stdev = 17919.877
  CI (99.9%): [114211.927, 141058.761] (assumes normal distribution)


# JMH version: 1.34
# VM version: JDK 11.0.11, OpenJDK 64-Bit Server VM, 11.0.11+9
# VM invoker: /Users/evans/.sdkman/candidates/java/11.0.11.hs-adpt/bin/java
# VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 1 iterations, 5 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:12
# Fork: 1 of 5
# Warmup Iteration   1: 13898.218 ±(99.9%) 529.789 ns/op
Iteration   1: 12739.744 ±(99.9%) 145.511 ns/op
Iteration   2: 13601.180 ±(99.9%) 233.527 ns/op
Iteration   3: 12048.912 ±(99.9%) 324.420 ns/op
Iteration   4: 14041.935 ±(99.9%) 333.655 ns/op
Iteration   5: 13794.248 ±(99.9%) 300.635 ns/op

# Run progress: 60.00% complete, ETA 00:05:32
# Fork: 2 of 5
# Warmup Iteration   1: 14859.757 ±(99.9%) 564.626 ns/op
Iteration   1: 12968.489 ±(99.9%) 217.808 ns/op
Iteration   2: 12055.838 ±(99.9%) 285.744 ns/op
Iteration   3: 12782.470 ±(99.9%) 376.563 ns/op
Iteration   4: 13127.862 ±(99.9%) 1554.346 ns/op
Iteration   5: 13729.862 ±(99.9%) 281.749 ns/op

# Run progress: 70.00% complete, ETA 00:04:03
# Fork: 3 of 5
# Warmup Iteration   1: 14368.945 ±(99.9%) 363.279 ns/op
Iteration   1: 13498.211 ±(99.9%) 297.146 ns/op
Iteration   2: 12162.680 ±(99.9%) 261.507 ns/op
Iteration   3: 13742.785 ±(99.9%) 248.843 ns/op
Iteration   4: 12249.229 ±(99.9%) 122.276 ns/op
Iteration   5: 13764.143 ±(99.9%) 280.246 ns/op

# Run progress: 80.00% complete, ETA 00:02:39
# Fork: 4 of 5
# Warmup Iteration   1: 14035.275 ±(99.9%) 259.390 ns/op
Iteration   1: 12941.622 ±(99.9%) 296.245 ns/op
Iteration   2: 13499.131 ±(99.9%) 340.472 ns/op
Iteration   3: 12374.812 ±(99.9%) 885.508 ns/op
Iteration   4: 13604.641 ±(99.9%) 264.788 ns/op
Iteration   5: 12413.135 ±(99.9%) 167.835 ns/op

# Run progress: 90.00% complete, ETA 00:01:18
# Fork: 5 of 5
# Warmup Iteration   1: 14049.678 ±(99.9%) 386.889 ns/op
Iteration   1: 13047.896 ±(99.9%) 376.036 ns/op
Iteration   2: 12673.575 ±(99.9%) 207.764 ns/op
Iteration   3: 12453.258 ±(99.9%) 207.132 ns/op
Iteration   4: 13643.316 ±(99.9%) 141.730 ns/op
Iteration   5: 12212.248 ±(99.9%) 299.470 ns/op


Result "pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock":
  13006.849 ±(99.9%) 483.094 ns/op [Average]
  (min, avg, max) = (12048.912, 13006.849, 14041.935), stdev = 644.916
  CI (99.9%): [12523.755, 13489.942] (assumes normal distribution)


# Run complete. Total time: 00:12:53

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                              Mode  Cnt       Score       Error  Units
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire  avgt   25  127635.344 ± 13423.417  ns/op
CLHReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock     avgt   25   13006.849 ±   483.094  ns/op
```