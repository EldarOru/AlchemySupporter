package com.example.zhoraapplication.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ObserveData<T> {

    fun observe(owner: LifecycleOwner, observer: Observer<T>)
}