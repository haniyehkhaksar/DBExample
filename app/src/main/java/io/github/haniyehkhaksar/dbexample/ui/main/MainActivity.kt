package io.github.haniyehkhaksar.dbexample.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatActivity
import io.github.haniyehkhaksar.dbexample.R
import io.github.haniyehkhaksar.dbexample.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databinding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        databinding.viewModel = viewModel
        databinding.lifecycleOwner = this
        databinding.executePendingBindings()

    }

}