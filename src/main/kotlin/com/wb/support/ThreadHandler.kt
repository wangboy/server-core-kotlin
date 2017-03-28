package com.wb.support

import com.google.common.base.Stopwatch
import com.wb.interfaces.IThreadCase
import java.util.concurrent.TimeUnit

/**
 * Created by wangbo on 2017/3/28.
 */

class ThreadHandler(
        val member: IThreadCase
) : Thread() {
    var running: Boolean = false
    var watch: Stopwatch = Stopwatch.createUnstarted()

    fun startUp() {
        if (running) return
        running = true
        start()
    }

    fun cleanUp() {
        if (!running) return
        running = false
    }

    override fun run() {

        member.caseStart()

        while (true) {
            try {
                watch.reset()
                watch.start()

                member.caseRunOnce()

                watch.stop()

                var timeRunning = watch.elapsed(TimeUnit.MILLISECONDS)
                var interval = member.interval()
                if (timeRunning < interval) {
                    Thread.sleep(interval - timeRunning)
                }

            } catch (t: Throwable) {
                t.printStackTrace()
            } finally {
                watch.reset()
            }
            if (!running) break

        }
        member.caseStop()
    }


}