package com.example.lab1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var items = MutableLiveData<MutableList<Item>>()

    init {
        items.value = ArrayList()
    }

    data class Item(
        val value: String = "kek"
    )

    fun createItem(value: String): Item {
        return Item(value)
    }

    fun addItem(item: Item) {
        items.value?.add(item)
        items.value = items.value

    }

}