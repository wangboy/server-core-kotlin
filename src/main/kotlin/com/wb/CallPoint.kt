package com.wb

import com.wb.interfaces.ISerilizable

/**
 * Created by wangbo on 2017/3/28.
 */
class CallPoint(var nodeId: String, var portId: String, var servId: String) : ISerilizable {

    override fun writeTo(stream: Output) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readFrom(stream: Input) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
