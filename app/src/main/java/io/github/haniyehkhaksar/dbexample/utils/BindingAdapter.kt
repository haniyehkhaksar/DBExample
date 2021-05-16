package io.github.haniyehkhaksar.dbexample.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("hasFixedSize")
    fun setHasFixedSize(view: RecyclerView, hasFixedSize: Boolean) {
        view.setHasFixedSize(hasFixedSize)
    }

}