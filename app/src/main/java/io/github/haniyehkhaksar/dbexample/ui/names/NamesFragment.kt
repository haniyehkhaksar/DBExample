package io.github.haniyehkhaksar.dbexample.ui.names

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerFragment
import io.github.haniyehkhaksar.dbexample.R
import io.github.haniyehkhaksar.dbexample.databinding.NamesFragmentBinding
import io.github.haniyehkhaksar.dbexample.domain.domainmodel.Name
import io.github.haniyehkhaksar.dbexample.utils.MyResult
import androidx.lifecycle.Observer
import javax.inject.Inject

class NamesFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: NamesViewModel

    lateinit var dataBinding: NamesFragmentBinding

    private val adapter = NamesAdapter()

    private val namesObserver = Observer<List<Name>> {
        adapter.submitList(it)
    }

    private val messageObserver = Observer<String> {
        if (it.isNotEmpty())
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.names_fragment, container, false)
        dataBinding.executePendingBindings()
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = viewModel

        dataBinding.btnAdd.setOnClickListener {
            viewModel.addName()
            val inputMethodManager = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
        dataBinding.namesList.adapter = adapter

        viewModel.names.observe(viewLifecycleOwner, namesObserver)

        viewModel.message.observe(viewLifecycleOwner, messageObserver)

        return dataBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.names.removeObserver(namesObserver)
        viewModel.message.removeObserver(messageObserver)
    }

}