package com.wb.interfaces

/**
 * Created by wangbo on 2017/3/28.
 */

interface IThreadCase {
    val INTERVAL_DEFAULT: Int
        get() = 10

    fun caseStart()

    fun caseStop()

    fun caseRunOnce()

    fun interval(): Int = INTERVAL_DEFAULT
}