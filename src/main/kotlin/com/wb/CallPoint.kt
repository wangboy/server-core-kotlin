package com.wb

import com.google.common.base.MoreObjects
import com.wb.interfaces.ISerilizable
import java.util.*

/**
 * Created by wangbo on 2017/3/28.
 */
data class CallPoint(var nodeId: String, var portId: String, var servId: String) : ISerilizable {

    override fun writeTo(stream: Output) {
        with(stream) {
            write(nodeId)
            write(portId)
            write(servId)
        }
    }

    override fun readFrom(stream: Input) {
        nodeId = stream.read()
        portId = stream.read()
        servId = stream.read()
    }

    override fun equals(other: Any?): Boolean {
        if (other !is CallPoint) {
            return false
        }
        return Objects.equals(this.nodeId, other.nodeId)
                && Objects.equals(this.portId, other.portId)
                && Objects.equals(this.portId, other.servId)
    }

    override fun toString(): String = MoreObjects.toStringHelper(this)
            .add("@", System.identityHashCode(this))
            .add("nodeId", this.nodeId)
            .add("portId", this.portId)
            .add("servId", this.servId).toString()
}
