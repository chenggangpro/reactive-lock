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
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 52656.123 ops/s
Iteration   1: 63209.721 ops/s
Iteration   2: 56227.132 ops/s
Iteration   3: 63478.187 ops/s
Iteration   4: 60736.064 ops/s
Iteration   5: 62051.956 ops/s

# Run progress: 10.00% complete, ETA 00:13:21
# Fork: 2 of 5
# Warmup Iteration   1: 50935.480 ops/s
Iteration   1: 70288.782 ops/s
Iteration   2: 48037.716 ops/s
Iteration   3: 65378.339 ops/s
Iteration   4: 60822.486 ops/s
Iteration   5: 62004.501 ops/s

# Run progress: 20.00% complete, ETA 00:11:41
# Fork: 3 of 5
# Warmup Iteration   1: 50385.521 ops/s
Iteration   1: 79007.751 ops/s
Iteration   2: 39889.747 ops/s
Iteration   3: 63355.414 ops/s
Iteration   4: 75565.036 ops/s
Iteration   5: 57273.751 ops/s

# Run progress: 30.00% complete, ETA 00:09:55
# Fork: 4 of 5
# Warmup Iteration   1: 49642.552 ops/s
Iteration   1: 61167.625 ops/s
Iteration   2: 67703.058 ops/s
Iteration   3: 73989.288 ops/s
Iteration   4: 55560.399 ops/s
Iteration   5: 78536.139 ops/s

# Run progress: 40.00% complete, ETA 00:08:31
# Fork: 5 of 5
# Warmup Iteration   1: 49007.899 ops/s
Iteration   1: 68568.192 ops/s
Iteration   2: 49315.216 ops/s
Iteration   3: 83260.397 ops/s
Iteration   4: 52785.362 ops/s
Iteration   5: 60237.624 ops/s


Result "pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire":
  63137.995 ±(99.9%) 7652.748 ops/s [Average]
  (min, avg, max) = (39889.747, 63137.995, 83260.397), stdev = 10216.199
  CI (99.9%): [55485.248, 70790.743] (assumes normal distribution)


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
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:05
# Fork: 1 of 5
# Warmup Iteration   1: 579607.289 ops/s
Iteration   1: 587684.918 ops/s
Iteration   2: 670289.013 ops/s
Iteration   3: 652498.903 ops/s
Iteration   4: 653434.808 ops/s
Iteration   5: 643362.493 ops/s

# Run progress: 60.00% complete, ETA 00:05:25
# Fork: 2 of 5
# Warmup Iteration   1: 567211.492 ops/s
Iteration   1: 661560.368 ops/s
Iteration   2: 671244.918 ops/s
Iteration   3: 641391.114 ops/s
Iteration   4: 640495.785 ops/s
Iteration   5: 642447.508 ops/s

# Run progress: 70.00% complete, ETA 00:03:56
# Fork: 3 of 5
# Warmup Iteration   1: 531606.648 ops/s
Iteration   1: 666825.542 ops/s
Iteration   2: 653426.490 ops/s
Iteration   3: 660336.071 ops/s
Iteration   4: 639780.957 ops/s
Iteration   5: 654474.138 ops/s

# Run progress: 80.00% complete, ETA 00:02:34
# Fork: 4 of 5
# Warmup Iteration   1: 565449.005 ops/s
Iteration   1: 634182.079 ops/s
Iteration   2: 640468.945 ops/s
Iteration   3: 640062.466 ops/s
Iteration   4: 656415.051 ops/s
Iteration   5: 644788.725 ops/s

# Run progress: 90.00% complete, ETA 00:01:15
# Fork: 5 of 5
# Warmup Iteration   1: 588242.226 ops/s
Iteration   1: 645903.900 ops/s
Iteration   2: 646885.984 ops/s
Iteration   3: 637595.977 ops/s
Iteration   4: 650440.857 ops/s
Iteration   5: 647752.287 ops/s


Result "pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock":
  647349.972 ±(99.9%) 12047.181 ops/s [Average]
  (min, avg, max) = (587684.918, 647349.972, 671244.918), stdev = 16082.642
  CI (99.9%): [635302.791, 659397.153] (assumes normal distribution)


# Run complete. Total time: 00:12:23

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                               Mode  Cnt       Score       Error  Units
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire  thrpt   25   63137.995 ±  7652.748  ops/s
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock     thrpt   25  647349.972 ± 12047.181  ops/s
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
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 176951.960 ±(99.9%) 33110.903 ns/op
Iteration   1: 166141.391 ±(99.9%) 54823.708 ns/op
                 testLockExpire·p0.00:   3420.000 ns/op
                 testLockExpire·p0.50:   25056.000 ns/op
                 testLockExpire·p0.90:   86656.000 ns/op
                 testLockExpire·p0.95:   404480.000 ns/op
                 testLockExpire·p0.99:   1482752.000 ns/op
                 testLockExpire·p0.999:  6019678.208 ns/op
                 testLockExpire·p0.9999: 44373272.166 ns/op
                 testLockExpire·p1.00:   3309305856.000 ns/op

Iteration   2: 138957.082 ±(99.9%) 92856.484 ns/op
                 testLockExpire·p0.00:   2964.000 ns/op
                 testLockExpire·p0.50:   5976.000 ns/op
                 testLockExpire·p0.90:   8640.000 ns/op
                 testLockExpire·p0.95:   57664.000 ns/op
                 testLockExpire·p0.99:   457615.360 ns/op
                 testLockExpire·p0.999:  2463244.288 ns/op
                 testLockExpire·p0.9999: 9834296.115 ns/op
                 testLockExpire·p1.00:   4420796416.000 ns/op

Iteration   3: 137333.489 ±(99.9%) 74249.653 ns/op
                 testLockExpire·p0.00:   3204.000 ns/op
                 testLockExpire·p0.50:   5992.000 ns/op
                 testLockExpire·p0.90:   10880.000 ns/op
                 testLockExpire·p0.95:   65536.000 ns/op
                 testLockExpire·p0.99:   407552.000 ns/op
                 testLockExpire·p0.999:  2338680.832 ns/op
                 testLockExpire·p0.9999: 14053870.797 ns/op
                 testLockExpire·p1.00:   3825205248.000 ns/op

Iteration   4: 139833.171 ±(99.9%) 78030.503 ns/op
                 testLockExpire·p0.00:   3252.000 ns/op
                 testLockExpire·p0.50:   5832.000 ns/op
                 testLockExpire·p0.90:   12160.000 ns/op
                 testLockExpire·p0.95:   67072.000 ns/op
                 testLockExpire·p0.99:   422912.000 ns/op
                 testLockExpire·p0.999:  2420736.000 ns/op
                 testLockExpire·p0.9999: 9353519.104 ns/op
                 testLockExpire·p1.00:   3946840064.000 ns/op

Iteration   5: 151567.231 ±(99.9%) 83310.108 ns/op
                 testLockExpire·p0.00:   3128.000 ns/op
                 testLockExpire·p0.50:   5960.000 ns/op
                 testLockExpire·p0.90:   9728.000 ns/op
                 testLockExpire·p0.95:   61120.000 ns/op
                 testLockExpire·p0.99:   424765.440 ns/op
                 testLockExpire·p0.999:  2711552.000 ns/op
                 testLockExpire·p0.9999: 16261919.539 ns/op
                 testLockExpire·p1.00:   4236247040.000 ns/op

<JMH had finished, but forked VM did not exit, are there stray running threads? Waiting 24 seconds more...>

Non-finished threads:

Thread[DestroyJavaVM,5,main]



# Run progress: 10.00% complete, ETA 00:14:55
# Fork: 2 of 5
# Warmup Iteration   1: 185897.910 ±(99.9%) 39811.616 ns/op
Iteration   1: 214796.229 ±(99.9%) 81392.239 ns/op
                 testLockExpire·p0.00:   3960.000 ns/op
                 testLockExpire·p0.50:   24480.000 ns/op
                 testLockExpire·p0.90:   89984.000 ns/op
                 testLockExpire·p0.95:   412160.000 ns/op
                 testLockExpire·p0.99:   1359872.000 ns/op
                 testLockExpire·p0.999:  9489055.744 ns/op
                 testLockExpire·p0.9999: 51027417.498 ns/op
                 testLockExpire·p1.00:   3183476736.000 ns/op

Iteration   2: 108462.255 ±(99.9%) 56326.906 ns/op
                 testLockExpire·p0.00:   3088.000 ns/op
                 testLockExpire·p0.50:   5720.000 ns/op
                 testLockExpire·p0.90:   10128.000 ns/op
                 testLockExpire·p0.95:   70656.000 ns/op
                 testLockExpire·p0.99:   381578.240 ns/op
                 testLockExpire·p0.999:  1772394.496 ns/op
                 testLockExpire·p0.9999: 8092748.186 ns/op
                 testLockExpire·p1.00:   3267362816.000 ns/op

Iteration   3: 121344.268 ±(99.9%) 65513.756 ns/op
                 testLockExpire·p0.00:   3168.000 ns/op
                 testLockExpire·p0.50:   5824.000 ns/op
                 testLockExpire·p0.90:   14400.000 ns/op
                 testLockExpire·p0.95:   82944.000 ns/op
                 testLockExpire·p0.99:   415744.000 ns/op
                 testLockExpire·p0.999:  1699536.896 ns/op
                 testLockExpire·p0.9999: 6903732.634 ns/op
                 testLockExpire·p1.00:   3019898880.000 ns/op

Iteration   4: 121950.997 ±(99.9%) 66860.295 ns/op
                 testLockExpire·p0.00:   3440.000 ns/op
                 testLockExpire·p0.50:   5752.000 ns/op
                 testLockExpire·p0.90:   8416.000 ns/op
                 testLockExpire·p0.95:   58432.000 ns/op
                 testLockExpire·p0.99:   437248.000 ns/op
                 testLockExpire·p0.999:  1806100.480 ns/op
                 testLockExpire·p0.9999: 6512357.376 ns/op
                 testLockExpire·p1.00:   3045064704.000 ns/op

Iteration   5: 93843.227 ±(99.9%) 49868.653 ns/op
                 testLockExpire·p0.00:   2948.000 ns/op
                 testLockExpire·p0.50:   5792.000 ns/op
                 testLockExpire·p0.90:   10816.000 ns/op
                 testLockExpire·p0.95:   70400.000 ns/op
                 testLockExpire·p0.99:   380416.000 ns/op
                 testLockExpire·p0.999:  1685504.000 ns/op
                 testLockExpire·p0.9999: 4858457.293 ns/op
                 testLockExpire·p1.00:   2889875456.000 ns/op


# Run progress: 20.00% complete, ETA 00:12:12
# Fork: 3 of 5
# Warmup Iteration   1: 165630.853 ±(99.9%) 32155.929 ns/op
Iteration   1: 122962.659 ±(99.9%) 50458.195 ns/op
                 testLockExpire·p0.00:   3848.000 ns/op
                 testLockExpire·p0.50:   8864.000 ns/op
                 testLockExpire·p0.90:   37760.000 ns/op
                 testLockExpire·p0.95:   140800.000 ns/op
                 testLockExpire·p0.99:   952320.000 ns/op
                 testLockExpire·p0.999:  3167309.824 ns/op
                 testLockExpire·p0.9999: 21100675.072 ns/op
                 testLockExpire·p1.00:   3288334336.000 ns/op

Iteration   2: 137667.808 ±(99.9%) 69021.801 ns/op
                 testLockExpire·p0.00:   3280.000 ns/op
                 testLockExpire·p0.50:   5736.000 ns/op
                 testLockExpire·p0.90:   9616.000 ns/op
                 testLockExpire·p0.95:   65664.000 ns/op
                 testLockExpire·p0.99:   375296.000 ns/op
                 testLockExpire·p0.999:  1323008.000 ns/op
                 testLockExpire·p0.9999: 4461748.224 ns/op
                 testLockExpire·p1.00:   2764046336.000 ns/op

Iteration   3: 125077.833 ±(99.9%) 60405.494 ns/op
                 testLockExpire·p0.00:   3088.000 ns/op
                 testLockExpire·p0.50:   5744.000 ns/op
                 testLockExpire·p0.90:   17472.000 ns/op
                 testLockExpire·p0.95:   87424.000 ns/op
                 testLockExpire·p0.99:   381608.960 ns/op
                 testLockExpire·p0.999:  1621673.984 ns/op
                 testLockExpire·p0.9999: 6115873.587 ns/op
                 testLockExpire·p1.00:   3196059648.000 ns/op

Iteration   4: 128667.911 ±(99.9%) 63004.388 ns/op
                 testLockExpire·p0.00:   3316.000 ns/op
                 testLockExpire·p0.50:   5776.000 ns/op
                 testLockExpire·p0.90:   13824.000 ns/op
                 testLockExpire·p0.95:   74368.000 ns/op
                 testLockExpire·p0.99:   358912.000 ns/op
                 testLockExpire·p0.999:  1495183.360 ns/op
                 testLockExpire·p0.9999: 6226092.032 ns/op
                 testLockExpire·p1.00:   3133145088.000 ns/op

Iteration   5: 137021.727 ±(99.9%) 66187.132 ns/op
                 testLockExpire·p0.00:   3112.000 ns/op
                 testLockExpire·p0.50:   5808.000 ns/op
                 testLockExpire·p0.90:   16336.000 ns/op
                 testLockExpire·p0.95:   88192.000 ns/op
                 testLockExpire·p0.99:   385536.000 ns/op
                 testLockExpire·p0.999:  1497088.000 ns/op
                 testLockExpire·p0.9999: 8019688.653 ns/op
                 testLockExpire·p1.00:   3028287488.000 ns/op


# Run progress: 30.00% complete, ETA 00:10:46
# Fork: 4 of 5
# Warmup Iteration   1: 93069.436 ±(99.9%) 21496.272 ns/op
Iteration   1: 133701.714 ±(99.9%) 61538.323 ns/op
                 testLockExpire·p0.00:   4112.000 ns/op
                 testLockExpire·p0.50:   9040.000 ns/op
                 testLockExpire·p0.90:   12368.000 ns/op
                 testLockExpire·p0.95:   41792.000 ns/op
                 testLockExpire·p0.99:   513536.000 ns/op
                 testLockExpire·p0.999:  3234095.104 ns/op
                 testLockExpire·p0.9999: 28084754.842 ns/op
                 testLockExpire·p1.00:   3149922304.000 ns/op

Iteration   2: 155468.270 ±(99.9%) 76441.101 ns/op
                 testLockExpire·p0.00:   3032.000 ns/op
                 testLockExpire·p0.50:   5976.000 ns/op
                 testLockExpire·p0.90:   8576.000 ns/op
                 testLockExpire·p0.95:   49344.000 ns/op
                 testLockExpire·p0.99:   418816.000 ns/op
                 testLockExpire·p0.999:  2224545.792 ns/op
                 testLockExpire·p0.9999: 10384346.317 ns/op
                 testLockExpire·p1.00:   2818572288.000 ns/op

Iteration   3: 93564.337 ±(99.9%) 49112.285 ns/op
                 testLockExpire·p0.00:   3716.000 ns/op
                 testLockExpire·p0.50:   5784.000 ns/op
                 testLockExpire·p0.90:   13264.000 ns/op
                 testLockExpire·p0.95:   72704.000 ns/op
                 testLockExpire·p0.99:   359424.000 ns/op
                 testLockExpire·p0.999:  1411072.000 ns/op
                 testLockExpire·p0.9999: 5107210.650 ns/op
                 testLockExpire·p1.00:   3116367872.000 ns/op

Iteration   4: 146187.681 ±(99.9%) 71808.092 ns/op
                 testLockExpire·p0.00:   3240.000 ns/op
                 testLockExpire·p0.50:   5752.000 ns/op
                 testLockExpire·p0.90:   9808.000 ns/op
                 testLockExpire·p0.95:   69632.000 ns/op
                 testLockExpire·p0.99:   407552.000 ns/op
                 testLockExpire·p0.999:  1570183.168 ns/op
                 testLockExpire·p0.9999: 6122254.336 ns/op
                 testLockExpire·p1.00:   2713714688.000 ns/op

Iteration   5: 108605.271 ±(99.9%) 58368.531 ns/op
                 testLockExpire·p0.00:   2864.000 ns/op
                 testLockExpire·p0.50:   5792.000 ns/op
                 testLockExpire·p0.90:   18784.000 ns/op
                 testLockExpire·p0.95:   88576.000 ns/op
                 testLockExpire·p0.99:   380928.000 ns/op
                 testLockExpire·p0.999:  1531256.832 ns/op
                 testLockExpire·p0.9999: 5639868.416 ns/op
                 testLockExpire·p1.00:   3179282432.000 ns/op


# Run progress: 40.00% complete, ETA 00:09:06
# Fork: 5 of 5
# Warmup Iteration   1: 157921.295 ±(99.9%) 29277.656 ns/op
Iteration   1: 114255.550 ±(99.9%) 51242.635 ns/op
                 testLockExpire·p0.00:   3508.000 ns/op
                 testLockExpire·p0.50:   9312.000 ns/op
                 testLockExpire·p0.90:   34240.000 ns/op
                 testLockExpire·p0.95:   103552.000 ns/op
                 testLockExpire·p0.99:   865280.000 ns/op
                 testLockExpire·p0.999:  3145191.424 ns/op
                 testLockExpire·p0.9999: 24536249.139 ns/op
                 testLockExpire·p1.00:   3191865344.000 ns/op

Iteration   2: 146522.901 ±(99.9%) 72498.159 ns/op
                 testLockExpire·p0.00:   3632.000 ns/op
                 testLockExpire·p0.50:   5784.000 ns/op
                 testLockExpire·p0.90:   9856.000 ns/op
                 testLockExpire·p0.95:   68096.000 ns/op
                 testLockExpire·p0.99:   370176.000 ns/op
                 testLockExpire·p0.999:  1399971.840 ns/op
                 testLockExpire·p0.9999: 8059117.568 ns/op
                 testLockExpire·p1.00:   2759852032.000 ns/op

Iteration   3: 92794.807 ±(99.9%) 48718.891 ns/op
                 testLockExpire·p0.00:   3380.000 ns/op
                 testLockExpire·p0.50:   5760.000 ns/op
                 testLockExpire·p0.90:   14928.000 ns/op
                 testLockExpire·p0.95:   78464.000 ns/op
                 testLockExpire·p0.99:   364032.000 ns/op
                 testLockExpire·p0.999:  1803096.064 ns/op
                 testLockExpire·p0.9999: 7404688.179 ns/op
                 testLockExpire·p1.00:   3015704576.000 ns/op

Iteration   4: 144983.139 ±(99.9%) 70629.717 ns/op
                 testLockExpire·p0.00:   3528.000 ns/op
                 testLockExpire·p0.50:   5720.000 ns/op
                 testLockExpire·p0.90:   9648.000 ns/op
                 testLockExpire·p0.95:   75136.000 ns/op
                 testLockExpire·p0.99:   416256.000 ns/op
                 testLockExpire·p0.999:  1461592.064 ns/op
                 testLockExpire·p0.9999: 6275072.000 ns/op
                 testLockExpire·p1.00:   2759852032.000 ns/op

Iteration   5: 127153.337 ±(99.9%) 60924.990 ns/op
                 testLockExpire·p0.00:   3048.000 ns/op
                 testLockExpire·p0.50:   5752.000 ns/op
                 testLockExpire·p0.90:   16992.000 ns/op
                 testLockExpire·p0.95:   87168.000 ns/op
                 testLockExpire·p0.99:   385024.000 ns/op
                 testLockExpire·p0.999:  1464686.592 ns/op
                 testLockExpire·p0.9999: 6333442.458 ns/op
                 testLockExpire·p1.00:   2994733056.000 ns/op



Result "pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire":
  N = 17801805
  mean = 129631.454 ±(99.9%) 12975.130 ns/op

  Histogram, ns/op:
    [         0.000,  500000000.000) = 17801127 
    [ 500000000.000, 1000000000.000) = 39 
    [1000000000.000, 1500000000.000) = 26 
    [1500000000.000, 2000000000.000) = 60 
    [2000000000.000, 2500000000.000) = 95 
    [2500000000.000, 3000000000.000) = 277 
    [3000000000.000, 3500000000.000) = 119 
    [3500000000.000, 4000000000.000) = 48 
    [4000000000.000, 4500000000.000) = 14 

  Percentiles, ns/op:
      p(0.0000) =   2864.000 ns/op
     p(50.0000) =   5952.000 ns/op
     p(90.0000) =  28832.000 ns/op
     p(95.0000) =  84864.000 ns/op
     p(99.0000) = 508928.000 ns/op
     p(99.9000) = 2327322.624 ns/op
     p(99.9900) = 13860864.000 ns/op
     p(99.9990) = 3007315968.000 ns/op
     p(99.9999) = 3942645760.000 ns/op
    p(100.0000) = 4420796416.000 ns/op


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
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:35
# Fork: 1 of 5
# Warmup Iteration   1: 18701.896 ±(99.9%) 2975.316 ns/op
Iteration   1: 15384.719 ±(99.9%) 2235.534 ns/op
                 testTryLock·p0.00:   956.000 ns/op
                 testTryLock·p0.50:   3792.000 ns/op
                 testTryLock·p0.90:   8688.000 ns/op
                 testTryLock·p0.95:   23072.000 ns/op
                 testTryLock·p0.99:   149760.000 ns/op
                 testTryLock·p0.999:  958464.000 ns/op
                 testTryLock·p0.9999: 3610721.075 ns/op
                 testTryLock·p1.00:   237240320.000 ns/op

Iteration   2: 13701.757 ±(99.9%) 1759.568 ns/op
                 testTryLock·p0.00:   935.000 ns/op
                 testTryLock·p0.50:   3732.000 ns/op
                 testTryLock·p0.90:   8432.000 ns/op
                 testTryLock·p0.95:   21632.000 ns/op
                 testTryLock·p0.99:   141312.000 ns/op
                 testTryLock·p0.999:  828416.000 ns/op
                 testTryLock·p0.9999: 3669447.475 ns/op
                 testTryLock·p1.00:   217579520.000 ns/op

Iteration   3: 15086.548 ±(99.9%) 2284.051 ns/op
                 testTryLock·p0.00:   958.000 ns/op
                 testTryLock·p0.50:   3932.000 ns/op
                 testTryLock·p0.90:   9936.000 ns/op
                 testTryLock·p0.95:   26912.000 ns/op
                 testTryLock·p0.99:   142848.000 ns/op
                 testTryLock·p0.999:  680960.000 ns/op
                 testTryLock·p0.9999: 3015041.024 ns/op
                 testTryLock·p1.00:   217841664.000 ns/op

Iteration   4: 14547.215 ±(99.9%) 2030.623 ns/op
                 testTryLock·p0.00:   930.000 ns/op
                 testTryLock·p0.50:   3828.000 ns/op
                 testTryLock·p0.90:   8880.000 ns/op
                 testTryLock·p0.95:   23296.000 ns/op
                 testTryLock·p0.99:   143872.000 ns/op
                 testTryLock·p0.999:  788480.000 ns/op
                 testTryLock·p0.9999: 3910673.613 ns/op
                 testTryLock·p1.00:   243269632.000 ns/op

Iteration   5: 14308.088 ±(99.9%) 2053.001 ns/op
                 testTryLock·p0.00:   620.000 ns/op
                 testTryLock·p0.50:   3852.000 ns/op
                 testTryLock·p0.90:   9344.000 ns/op
                 testTryLock·p0.95:   25536.000 ns/op
                 testTryLock·p0.99:   149760.000 ns/op
                 testTryLock·p0.999:  708608.000 ns/op
                 testTryLock·p0.9999: 3049932.390 ns/op
                 testTryLock·p1.00:   257949696.000 ns/op


# Run progress: 60.00% complete, ETA 00:05:46
# Fork: 2 of 5
# Warmup Iteration   1: 19187.907 ±(99.9%) 3524.770 ns/op
Iteration   1: 15208.238 ±(99.9%) 2317.647 ns/op
                 testTryLock·p0.00:   904.000 ns/op
                 testTryLock·p0.50:   3832.000 ns/op
                 testTryLock·p0.90:   9296.000 ns/op
                 testTryLock·p0.95:   23872.000 ns/op
                 testTryLock·p0.99:   141056.000 ns/op
                 testTryLock·p0.999:  791700.480 ns/op
                 testTryLock·p0.9999: 3481718.784 ns/op
                 testTryLock·p1.00:   261357568.000 ns/op

Iteration   2: 14902.815 ±(99.9%) 2072.392 ns/op
                 testTryLock·p0.00:   911.000 ns/op
                 testTryLock·p0.50:   3856.000 ns/op
                 testTryLock·p0.90:   8800.000 ns/op
                 testTryLock·p0.95:   21376.000 ns/op
                 testTryLock·p0.99:   139264.000 ns/op
                 testTryLock·p0.999:  836418.560 ns/op
                 testTryLock·p0.9999: 3574306.816 ns/op
                 testTryLock·p1.00:   208928768.000 ns/op

Iteration   3: 14952.268 ±(99.9%) 2138.020 ns/op
                 testTryLock·p0.00:   926.000 ns/op
                 testTryLock·p0.50:   3924.000 ns/op
                 testTryLock·p0.90:   10144.000 ns/op
                 testTryLock·p0.95:   26240.000 ns/op
                 testTryLock·p0.99:   137984.000 ns/op
                 testTryLock·p0.999:  733257.728 ns/op
                 testTryLock·p0.9999: 3389908.582 ns/op
                 testTryLock·p1.00:   222560256.000 ns/op

Iteration   4: 13934.612 ±(99.9%) 1898.692 ns/op
                 testTryLock·p0.00:   923.000 ns/op
                 testTryLock·p0.50:   3872.000 ns/op
                 testTryLock·p0.90:   8896.000 ns/op
                 testTryLock·p0.95:   21216.000 ns/op
                 testTryLock·p0.99:   137984.000 ns/op
                 testTryLock·p0.999:  859136.000 ns/op
                 testTryLock·p0.9999: 3093703.066 ns/op
                 testTryLock·p1.00:   239599616.000 ns/op

Iteration   5: 15119.954 ±(99.9%) 2234.679 ns/op
                 testTryLock·p0.00:   923.000 ns/op
                 testTryLock·p0.50:   3860.000 ns/op
                 testTryLock·p0.90:   8928.000 ns/op
                 testTryLock·p0.95:   22048.000 ns/op
                 testTryLock·p0.99:   141312.000 ns/op
                 testTryLock·p0.999:  917504.000 ns/op
                 testTryLock·p0.9999: 3714403.123 ns/op
                 testTryLock·p1.00:   258736128.000 ns/op


# Run progress: 70.00% complete, ETA 00:04:10
# Fork: 3 of 5
# Warmup Iteration   1: 20995.062 ±(99.9%) 3086.073 ns/op
Iteration   1: 17044.398 ±(99.9%) 2814.063 ns/op
                 testTryLock·p0.00:   899.000 ns/op
                 testTryLock·p0.50:   3768.000 ns/op
                 testTryLock·p0.90:   8560.000 ns/op
                 testTryLock·p0.95:   22400.000 ns/op
                 testTryLock·p0.99:   150784.000 ns/op
                 testTryLock·p0.999:  1018880.000 ns/op
                 testTryLock·p0.9999: 4198740.787 ns/op
                 testTryLock·p1.00:   273678336.000 ns/op

Iteration   2: 13950.942 ±(99.9%) 1846.607 ns/op
                 testTryLock·p0.00:   933.000 ns/op
                 testTryLock·p0.50:   3692.000 ns/op
                 testTryLock·p0.90:   7880.000 ns/op
                 testTryLock·p0.95:   18464.000 ns/op
                 testTryLock·p0.99:   143872.000 ns/op
                 testTryLock·p0.999:  902144.000 ns/op
                 testTryLock·p0.9999: 3475988.480 ns/op
                 testTryLock·p1.00:   223870976.000 ns/op

Iteration   3: 14672.548 ±(99.9%) 2172.435 ns/op
                 testTryLock·p0.00:   899.000 ns/op
                 testTryLock·p0.50:   3752.000 ns/op
                 testTryLock·p0.90:   8848.000 ns/op
                 testTryLock·p0.95:   22720.000 ns/op
                 testTryLock·p0.99:   144384.000 ns/op
                 testTryLock·p0.999:  741376.000 ns/op
                 testTryLock·p0.9999: 2832649.421 ns/op
                 testTryLock·p1.00:   231735296.000 ns/op

Iteration   4: 14780.183 ±(99.9%) 2227.209 ns/op
                 testTryLock·p0.00:   904.000 ns/op
                 testTryLock·p0.50:   3796.000 ns/op
                 testTryLock·p0.90:   9456.000 ns/op
                 testTryLock·p0.95:   24096.000 ns/op
                 testTryLock·p0.99:   145920.000 ns/op
                 testTryLock·p0.999:  733184.000 ns/op
                 testTryLock·p0.9999: 3040566.886 ns/op
                 testTryLock·p1.00:   231473152.000 ns/op

Iteration   5: 16359.809 ±(99.9%) 2223.620 ns/op
                 testTryLock·p0.00:   934.000 ns/op
                 testTryLock·p0.50:   3832.000 ns/op
                 testTryLock·p0.90:   9024.000 ns/op
                 testTryLock·p0.95:   23936.000 ns/op
                 testTryLock·p0.99:   157696.000 ns/op
                 testTryLock·p0.999:  1085440.000 ns/op
                 testTryLock·p0.9999: 4497408.000 ns/op
                 testTryLock·p1.00:   220987392.000 ns/op


# Run progress: 80.00% complete, ETA 00:02:42
# Fork: 4 of 5
# Warmup Iteration   1: 19907.900 ±(99.9%) 2920.823 ns/op
Iteration   1: 16007.779 ±(99.9%) 2512.808 ns/op
                 testTryLock·p0.00:   312.000 ns/op
                 testTryLock·p0.50:   3768.000 ns/op
                 testTryLock·p0.90:   8072.000 ns/op
                 testTryLock·p0.95:   18688.000 ns/op
                 testTryLock·p0.99:   139776.000 ns/op
                 testTryLock·p0.999:  982016.000 ns/op
                 testTryLock·p0.9999: 4046279.475 ns/op
                 testTryLock·p1.00:   261881856.000 ns/op

Iteration   2: 17304.022 ±(99.9%) 2202.701 ns/op
                 testTryLock·p0.00:   923.000 ns/op
                 testTryLock·p0.50:   3920.000 ns/op
                 testTryLock·p0.90:   8672.000 ns/op
                 testTryLock·p0.95:   21536.000 ns/op
                 testTryLock·p0.99:   152064.000 ns/op
                 testTryLock·p0.999:  1340975.104 ns/op
                 testTryLock·p0.9999: 6133983.642 ns/op
                 testTryLock·p1.00:   213385216.000 ns/op

Iteration   3: 15483.557 ±(99.9%) 2344.644 ns/op
                 testTryLock·p0.00:   102.000 ns/op
                 testTryLock·p0.50:   3908.000 ns/op
                 testTryLock·p0.90:   8720.000 ns/op
                 testTryLock·p0.95:   20960.000 ns/op
                 testTryLock·p0.99:   147200.000 ns/op
                 testTryLock·p0.999:  832512.000 ns/op
                 testTryLock·p0.9999: 2986935.910 ns/op
                 testTryLock·p1.00:   207618048.000 ns/op

Iteration   4: 14012.300 ±(99.9%) 1997.113 ns/op
                 testTryLock·p0.00:   909.000 ns/op
                 testTryLock·p0.50:   3896.000 ns/op
                 testTryLock·p0.90:   8720.000 ns/op
                 testTryLock·p0.95:   21312.000 ns/op
                 testTryLock·p0.99:   143616.000 ns/op
                 testTryLock·p0.999:  731136.000 ns/op
                 testTryLock·p0.9999: 2482176.000 ns/op
                 testTryLock·p1.00:   208142336.000 ns/op

Iteration   5: 14189.239 ±(99.9%) 1983.859 ns/op
                 testTryLock·p0.00:   882.000 ns/op
                 testTryLock·p0.50:   3968.000 ns/op
                 testTryLock·p0.90:   9872.000 ns/op
                 testTryLock·p0.95:   25472.000 ns/op
                 testTryLock·p0.99:   145152.000 ns/op
                 testTryLock·p0.999:  710656.000 ns/op
                 testTryLock·p0.9999: 2965504.000 ns/op
                 testTryLock·p1.00:   261357568.000 ns/op


# Run progress: 90.00% complete, ETA 00:01:19
# Fork: 5 of 5
# Warmup Iteration   1: 20154.437 ±(99.9%) 3533.653 ns/op
Iteration   1: 15538.569 ±(99.9%) 2554.135 ns/op
                 testTryLock·p0.00:   889.000 ns/op
                 testTryLock·p0.50:   3700.000 ns/op
                 testTryLock·p0.90:   8208.000 ns/op
                 testTryLock·p0.95:   19936.000 ns/op
                 testTryLock·p0.99:   149504.000 ns/op
                 testTryLock·p0.999:  821248.000 ns/op
                 testTryLock·p0.9999: 3390941.184 ns/op
                 testTryLock·p1.00:   245366784.000 ns/op

Iteration   2: 15569.863 ±(99.9%) 2323.513 ns/op
                 testTryLock·p0.00:   934.000 ns/op
                 testTryLock·p0.50:   3852.000 ns/op
                 testTryLock·p0.90:   9344.000 ns/op
                 testTryLock·p0.95:   24324.800 ns/op
                 testTryLock·p0.99:   152064.000 ns/op
                 testTryLock·p0.999:  805888.000 ns/op
                 testTryLock·p0.9999: 3291428.864 ns/op
                 testTryLock·p1.00:   218365952.000 ns/op

Iteration   3: 15189.970 ±(99.9%) 2180.276 ns/op
                 testTryLock·p0.00:   932.000 ns/op
                 testTryLock·p0.50:   3852.000 ns/op
                 testTryLock·p0.90:   10144.000 ns/op
                 testTryLock·p0.95:   27872.000 ns/op
                 testTryLock·p0.99:   155648.000 ns/op
                 testTryLock·p0.999:  764928.000 ns/op
                 testTryLock·p0.9999: 3665920.000 ns/op
                 testTryLock·p1.00:   216006656.000 ns/op

Iteration   4: 14151.399 ±(99.9%) 1798.541 ns/op
                 testTryLock·p0.00:   950.000 ns/op
                 testTryLock·p0.50:   3944.000 ns/op
                 testTryLock·p0.90:   10144.000 ns/op
                 testTryLock·p0.95:   27360.000 ns/op
                 testTryLock·p0.99:   152320.000 ns/op
                 testTryLock·p0.999:  769024.000 ns/op
                 testTryLock·p0.9999: 3227648.000 ns/op
                 testTryLock·p1.00:   236978176.000 ns/op

Iteration   5: 15026.321 ±(99.9%) 2170.536 ns/op
                 testTryLock·p0.00:   842.000 ns/op
                 testTryLock·p0.50:   3924.000 ns/op
                 testTryLock·p0.90:   10640.000 ns/op
                 testTryLock·p0.95:   28864.000 ns/op
                 testTryLock·p0.99:   150272.000 ns/op
                 testTryLock·p0.999:  714752.000 ns/op
                 testTryLock·p0.9999: 3259055.309 ns/op
                 testTryLock·p1.00:   231211008.000 ns/op



Result "pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock":
  N = 40136633
  mean =  15044.424 ±(99.9%) 436.492 ns/op

  Histogram, ns/op:
    [        0.000,  25000000.000) = 40135810 
    [ 25000000.000,  50000000.000) = 46 
    [ 50000000.000,  75000000.000) = 4 
    [ 75000000.000, 100000000.000) = 45 
    [100000000.000, 125000000.000) = 43 
    [125000000.000, 150000000.000) = 59 
    [150000000.000, 175000000.000) = 37 
    [175000000.000, 200000000.000) = 281 
    [200000000.000, 225000000.000) = 239 
    [225000000.000, 250000000.000) = 50 
    [250000000.000, 275000000.000) = 19 

  Percentiles, ns/op:
      p(0.0000) =    102.000 ns/op
     p(50.0000) =   3840.000 ns/op
     p(90.0000) =   9024.000 ns/op
     p(95.0000) =  23232.000 ns/op
     p(99.0000) = 146176.000 ns/op
     p(99.9000) = 835584.000 ns/op
     p(99.9900) = 3620864.000 ns/op
     p(99.9990) = 193200128.000 ns/op
     p(99.9999) = 238598277.301 ns/op
    p(100.0000) = 273678336.000 ns/op


# Run complete. Total time: 00:12:57

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                                                       Mode       Cnt           Score       Error  Units
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire                         sample  17801805      129631.454 ± 12975.130  ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.00    sample                  2864.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.50    sample                  5952.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.90    sample                 28832.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.95    sample                 84864.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.99    sample                508928.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.999   sample               2327322.624              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.9999  sample              13860864.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p1.00    sample            4420796416.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock                            sample  40136633       15044.424 ±   436.492  ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.00          sample                   102.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.50          sample                  3840.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.90          sample                  9024.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.95          sample                 23232.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.99          sample                146176.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.999         sample                835584.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.9999        sample               3620864.000              ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock:testTryLock·p1.00          sample             273678336.000              ns/op
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
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire

# Run progress: 0.00% complete, ETA 00:09:10
# Fork: 1 of 5
# Warmup Iteration   1: 172738.430 ±(99.9%) 6560.737 ns/op
Iteration   1: 184109.981 ±(99.9%) 5799.054 ns/op
Iteration   2: 130604.630 ±(99.9%) 3250.222 ns/op
Iteration   3: 133969.095 ±(99.9%) 3651.569 ns/op
Iteration   4: 116708.767 ±(99.9%) 4212.481 ns/op
Iteration   5: 131261.821 ±(99.9%) 2261.764 ns/op

# Run progress: 10.00% complete, ETA 00:12:26
# Fork: 2 of 5
# Warmup Iteration   1: 162311.575 ±(99.9%) 3317.883 ns/op
Iteration   1: 120878.961 ±(99.9%) 2905.846 ns/op
Iteration   2: 145822.448 ±(99.9%) 4562.564 ns/op
Iteration   3: 123453.939 ±(99.9%) 3250.827 ns/op
Iteration   4: 128819.608 ±(99.9%) 1707.990 ns/op
Iteration   5: 131479.931 ±(99.9%) 3331.754 ns/op

# Run progress: 20.00% complete, ETA 00:11:28
# Fork: 3 of 5
# Warmup Iteration   1: 151532.630 ±(99.9%) 5609.439 ns/op
Iteration   1: 116649.379 ±(99.9%) 3253.270 ns/op
Iteration   2: 196149.157 ±(99.9%) 7610.564 ns/op
Iteration   3: 96667.085 ±(99.9%) 3125.769 ns/op
Iteration   4: 152080.997 ±(99.9%) 2844.979 ns/op
Iteration   5: 137659.561 ±(99.9%) 3944.840 ns/op

# Run progress: 30.00% complete, ETA 00:10:03
# Fork: 4 of 5
# Warmup Iteration   1: 164167.526 ±(99.9%) 6978.034 ns/op
Iteration   1: 117774.346 ±(99.9%) 4911.502 ns/op
Iteration   2: 136939.707 ±(99.9%) 4667.926 ns/op
Iteration   3: 118874.952 ±(99.9%) 1260.975 ns/op
Iteration   4: 131278.348 ±(99.9%) 3341.860 ns/op
Iteration   5: 126262.938 ±(99.9%) 2932.380 ns/op

# Run progress: 40.00% complete, ETA 00:08:37
# Fork: 5 of 5
# Warmup Iteration   1: 148738.262 ±(99.9%) 4532.253 ns/op
Iteration   1: 120834.653 ±(99.9%) 6295.311 ns/op
Iteration   2: 145607.861 ±(99.9%) 4681.681 ns/op
Iteration   3: 122090.191 ±(99.9%) 3498.469 ns/op
Iteration   4: 132375.236 ±(99.9%) 5716.224 ns/op
Iteration   5: 129762.884 ±(99.9%) 6781.621 ns/op


Result "pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire":
  133124.659 ±(99.9%) 15444.404 ns/op [Average]
  (min, avg, max) = (96667.085, 133124.659, 196149.157), stdev = 20617.838
  CI (99.9%): [117680.255, 148569.064] (assumes normal distribution)


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
# Benchmark: pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock

# Run progress: 50.00% complete, ETA 00:07:05
# Fork: 1 of 5
# Warmup Iteration   1: 15210.396 ±(99.9%) 437.282 ns/op
Iteration   1: 13361.277 ±(99.9%) 161.819 ns/op
Iteration   2: 12591.337 ±(99.9%) 179.424 ns/op
Iteration   3: 12913.813 ±(99.9%) 143.286 ns/op
Iteration   4: 12639.127 ±(99.9%) 323.219 ns/op
Iteration   5: 12885.010 ±(99.9%) 229.973 ns/op

# Run progress: 60.00% complete, ETA 00:05:26
# Fork: 2 of 5
# Warmup Iteration   1: 15338.119 ±(99.9%) 174.286 ns/op
Iteration   1: 13140.351 ±(99.9%) 200.415 ns/op
Iteration   2: 13086.819 ±(99.9%) 212.340 ns/op
Iteration   3: 13243.207 ±(99.9%) 172.064 ns/op
Iteration   4: 12889.950 ±(99.9%) 143.121 ns/op
Iteration   5: 12602.519 ±(99.9%) 163.301 ns/op

# Run progress: 70.00% complete, ETA 00:03:56
# Fork: 3 of 5
# Warmup Iteration   1: 15741.966 ±(99.9%) 477.939 ns/op
Iteration   1: 13345.448 ±(99.9%) 256.684 ns/op
Iteration   2: 13299.534 ±(99.9%) 160.275 ns/op
Iteration   3: 13041.122 ±(99.9%) 264.672 ns/op
Iteration   4: 13294.990 ±(99.9%) 168.159 ns/op
Iteration   5: 13389.254 ±(99.9%) 203.848 ns/op

# Run progress: 80.00% complete, ETA 00:02:34
# Fork: 4 of 5
# Warmup Iteration   1: 15590.526 ±(99.9%) 261.639 ns/op
Iteration   1: 13365.956 ±(99.9%) 158.293 ns/op
Iteration   2: 13044.803 ±(99.9%) 250.764 ns/op
Iteration   3: 13135.219 ±(99.9%) 216.987 ns/op
Iteration   4: 12841.934 ±(99.9%) 171.245 ns/op
Iteration   5: 12896.637 ±(99.9%) 221.512 ns/op

# Run progress: 90.00% complete, ETA 00:01:15
# Fork: 5 of 5
# Warmup Iteration   1: 15675.505 ±(99.9%) 235.788 ns/op
Iteration   1: 13300.112 ±(99.9%) 253.834 ns/op
Iteration   2: 13108.688 ±(99.9%) 279.035 ns/op
Iteration   3: 13168.491 ±(99.9%) 115.619 ns/op
Iteration   4: 13171.060 ±(99.9%) 178.366 ns/op
Iteration   5: 13555.134 ±(99.9%) 254.789 ns/op


Result "pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock":
  13092.472 ±(99.9%) 193.290 ns/op [Average]
  (min, avg, max) = (12591.337, 13092.472, 13555.134), stdev = 258.037
  CI (99.9%): [12899.181, 13285.762] (assumes normal distribution)


# Run complete. Total time: 00:12:24

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                              Mode  Cnt       Score       Error  Units
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testLockExpire  avgt   25  133124.659 ± 15444.404  ns/op
MCSReactiveLockBenchmarkTests.CLHReactiveLockBenchmark.testTryLock     avgt   25   13092.472 ±   193.290  ns/op
```