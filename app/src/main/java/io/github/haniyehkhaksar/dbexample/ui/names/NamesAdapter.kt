package io.github.haniyehkhaksar.dbexample.ui.names

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.haniyehkhaksar.dbexample.databinding.ItemNamesBinding
import io.github.haniyehkhaksar.dbexample.domain.domainmodel.Name

class NamesAdapter : ListAdapter<Name, NamesAdapter.ViewHolder>(NameDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNamesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    inner class ViewHolder(private val binding: ItemNamesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Name) {
            binding.tvTitle.text = item.name
            binding.executePendingBindings()
        }
    }

    class NameDiff : DiffUtil.ItemCallback<Name>() {
        override fun areItemsTheSame(oldItem: Name, newItem: Name): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Name, newItem: Name): Boolean {
            return oldItem.name == newItem.name
        }
    }
}