package com.santaev.apps.artilleryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.santaev.apps.artilleryapp.HomeViewPagerFragmentDirections
import com.santaev.apps.artilleryapp.ArtilleryListFragment
import com.santaev.apps.artilleryapp.data.Artillery
import com.santaev.apps.artilleryapp.databinding.ListItemArtilleryBinding

/**
 * Adapter for the [RecyclerView] in [ArtilleryListFragment].
 */
class ArtilleryAdapter : ListAdapter<Artillery, RecyclerView.ViewHolder>(ArtilleryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArtilleryViewHolder(
            ListItemArtilleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val artillery = getItem(position)
        (holder as ArtilleryViewHolder).bind(artillery)
    }

    class ArtilleryViewHolder(
        private val binding: ListItemArtilleryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.artillery?.let { artillery ->
                    navigateToArtillery(artillery, it)
                }
            }
        }

        private fun navigateToArtillery(
                artillery: Artillery,
                view: View
        ) {
            val direction =
                HomeViewPagerFragmentDirections.actionViewPagerFragmentToArtilleryDetailFragment(
                    artillery.artilleryId
                )
            view.findNavController().navigate(direction)
        }

        fun bind(item: Artillery) {
            binding.apply {
                artillery = item
                executePendingBindings()
            }
        }
    }
}

private class ArtilleryDiffCallback : DiffUtil.ItemCallback<Artillery>() {

    override fun areItemsTheSame(oldItem: Artillery, newItem: Artillery): Boolean {
        return oldItem.artilleryId == newItem.artilleryId
    }

    override fun areContentsTheSame(oldItem: Artillery, newItem: Artillery): Boolean {
        return oldItem == newItem
    }
}
