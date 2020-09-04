package com.santaev.apps.artilleryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.santaev.apps.artilleryapp.HomeViewPagerFragmentDirections
import com.santaev.apps.artilleryapp.R
import com.santaev.apps.artilleryapp.data.ArtilleryWithBookmark
import com.santaev.apps.artilleryapp.databinding.ListItemBookmarkBinding
import com.santaev.apps.artilleryapp.viewmodels.ArtilleryWithBookmarkViewModel

class BookmarksAdapter :
    ListAdapter<ArtilleryWithBookmark, BookmarksAdapter.ViewHolder>(
        ArtilleryBookmarkDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_bookmark,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ListItemBookmarkBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.viewModel?.artilleryId?.let { artilleryId ->
                    navigateToArtillery(artilleryId, view)
                }
            }
        }

        private fun navigateToArtillery(artilleryId: String, view: View) {
            val direction = HomeViewPagerFragmentDirections
                .actionViewPagerFragmentToArtilleryDetailFragment(artilleryId)
            view.findNavController().navigate(direction)
        }

        fun bind(artilleryWithBookmark: ArtilleryWithBookmark) {
            with(binding) {
                viewModel = ArtilleryWithBookmarkViewModel(artilleryWithBookmark)
                executePendingBindings()
            }
        }
    }
}

private class ArtilleryBookmarkDiffCallback : DiffUtil.ItemCallback<ArtilleryWithBookmark>() {

    override fun areItemsTheSame(
            oldItem: ArtilleryWithBookmark,
            newItem: ArtilleryWithBookmark
    ): Boolean {
        return oldItem.artillery.artilleryId == newItem.artillery.artilleryId
    }

    override fun areContentsTheSame(
            oldItem: ArtilleryWithBookmark,
            newItem: ArtilleryWithBookmark
    ): Boolean {
        return oldItem.artillery == newItem.artillery
    }
}
