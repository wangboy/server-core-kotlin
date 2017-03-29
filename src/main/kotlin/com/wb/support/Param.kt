package com.wb.support

import com.wb.Input
import com.wb.Output
import com.wb.interfaces.ISerilizable
import java.util.stream.Stream

/**
 * Created by wangbo on 2017/3/29.
 */
const val KEY_SINGLE: String = "KEY_SIGLE_PARAM"

class Param : ISerilizable {
    val data = mutableMapOf<String, Any>()

    constructor() : this(Array<Any>(0) {})

    constructor(vararg params: Any) {
        when (params.size) {
            1 -> put(KEY_SINGLE, params[0])
            else ->
                //TODO not even
                for (index in 0..params.lastIndex step 2) {
                    put(params[index] as String, params[index + 1])
                }
        }
    }

    fun <T> get(): T? = get(KEY_SINGLE)

    fun <T> get(key: String): T? = data[key] as? T

    fun <T> get(key: String, defaultValue: T): T = get(key) ?: defaultValue

    fun getInt(): Int? = get()

    fun getInt(key: String): Int? = get(key)

    fun getInt(key: String, defaultValue: Int) = get(key, defaultValue)

    fun getBoolean(): Boolean? = get()

    fun getBoolean(key: String): Boolean? = get(key)

    fun getBoolean(key: String, defaultValue: Boolean): Boolean = get(key, defaultValue)

    fun size(): Int = this.data.size

    fun containsKey(key: String): Boolean = this.data.containsKey(key)

    fun toArray(): Array<Any> = when (data.size) {
        0 -> Array<Any>(0) {}
        1 -> arrayOf(get()!!)
        else -> data.toList().stream().flatMap { Stream.of(it.first, it.second) }.toArray()
    }


    fun put(key: String, value: Any): Param {
        data[key] = value
        return this
    }

    override fun readFrom(stream: Input) {
        data.clear()
        data.putAll(stream.read<Map<String, Any>>())
    }

    override fun writeTo(stream: Output) {
        stream.write(data)
    }

}
