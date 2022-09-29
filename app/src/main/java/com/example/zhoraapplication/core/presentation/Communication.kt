package com.example.zhoraapplication.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

interface Communication {

    interface Observe<A: Any> {
        fun observe(owner: LifecycleOwner, observer: Observer<A>)
    }

    interface SetValue<A: Any> : Mapper<A, Unit>

    interface Mutable<A: Any> : Observe<A>, SetValue<A>

    class Base<A: Any>(private val liveData: MutableLiveData<A>) : Mutable<A> {

        override fun map(data: A) {
            liveData.value = data
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<A>) =
            liveData.observe(owner, observer)
    }
}

interface Mapper<S, R> {
    fun map(data: S): R
}