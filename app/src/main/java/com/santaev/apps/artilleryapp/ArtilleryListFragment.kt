package com.santaev.apps.artilleryapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.santaev.apps.artilleryapp.adapters.ArtilleryAdapter
import com.santaev.apps.artilleryapp.databinding.FragmentArtilleryListBinding
import com.santaev.apps.artilleryapp.utilities.InjectorUtils
import com.santaev.apps.artilleryapp.viewmodels.ArtilleryListViewModel

class ArtilleryListFragment : Fragment() {

    private val viewModel: ArtilleryListViewModel by viewModels {
        InjectorUtils.provideArtilleryListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentArtilleryListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = ArtilleryAdapter()
        binding.artilleryList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_artillery_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.filter_zone -> {
                updateData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun subscribeUi(adapter: ArtilleryAdapter) {
        viewModel.artilleryList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    private fun updateData() {
        with(viewModel) {
            if (isFiltered()) {
                clearGrowZoneNumber()
            } else {
                setGrowZoneNumber(9)
            }
        }
    }
}
