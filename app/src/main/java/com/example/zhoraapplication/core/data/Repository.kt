package com.example.zhoraapplication.core.data

interface Repository<T> {

    fun getData(): T

}