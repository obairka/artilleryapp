package com.santaev.apps.artilleryapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.viewpager2.widget.ViewPager2
import com.santaev.apps.artilleryapp.adapters.BookmarksAdapter
import com.santaev.apps.artilleryapp.adapters.ARTILLERY_LIST_PAGE_INDEX
import com.santaev.apps.artilleryapp.databinding.FragmentBookmarksBinding
import com.santaev.apps.artilleryapp.utilities.InjectorUtils
import com.santaev.apps.artilleryapp.viewmodels.ArtilleryBookmarkListViewModel

class BookmarksFragment : Fragment() {

    private lateinit var binding: FragmentBookmarksBinding

    private val viewModel: ArtilleryBookmarkListViewModel by viewModels {
        InjectorUtils.provideArtilleryBookmarkListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        val adapter = BookmarksAdapter()
        binding.artilleryList.adapter = adapter

        binding.addArtillery.setOnClickListener {
            navigateToPlantListPage()
        }

        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: BookmarksAdapter, binding: FragmentBookmarksBinding) {
        viewModel.artilleryWithBookmark.observe(viewLifecycleOwner) { result ->
            binding.hasArtillery = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }

    // TODO: convert to data binding if applicable
    private fun navigateToPlantListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            ARTILLERY_LIST_PAGE_INDEX
    }
}
