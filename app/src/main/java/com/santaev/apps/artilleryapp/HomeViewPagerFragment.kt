package com.santaev.apps.artilleryapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.santaev.apps.artilleryapp.adapters.MY_BOOKMARKS_PAGE_INDEX
import com.santaev.apps.artilleryapp.adapters.ARTILLERY_LIST_PAGE_INDEX
import com.santaev.apps.artilleryapp.adapters.artilleryappPagerAdapter
import com.santaev.apps.artilleryapp.databinding.FragmentViewPagerBinding

class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = artilleryappPagerAdapter(this)

        // Set the icon and text for each tab
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            MY_BOOKMARKS_PAGE_INDEX -> R.drawable.bookmarks_tab_selector
            ARTILLERY_LIST_PAGE_INDEX -> R.drawable.artillery_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MY_BOOKMARKS_PAGE_INDEX -> getString(R.string.my_bookmarks)
            ARTILLERY_LIST_PAGE_INDEX -> getString(R.string.artillery_list_title)
            else -> null
        }
    }
}
