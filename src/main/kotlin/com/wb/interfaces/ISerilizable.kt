package com.wb.interfaces

import com.wb.Input
import com.wb.Output

/**
 * Created by wangbo on 2017/3/28.
 */
interface ISerilizable {
    fun writeTo(stream: Output)
    fun readFrom(stream: Input)
}

