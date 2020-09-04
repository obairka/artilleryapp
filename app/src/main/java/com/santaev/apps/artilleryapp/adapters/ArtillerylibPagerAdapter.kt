package com.santaev.apps.artilleryapp.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.santaev.apps.artilleryapp.BookmarksFragment
import com.santaev.apps.artilleryapp.ArtilleryListFragment

const val MY_BOOKMARKS_PAGE_INDEX = 1
const val ARTILLERY_LIST_PAGE_INDEX = 0

class artilleryappPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /**
     * Mapping of the ViewPager page indexes to their respective Fragments
     */
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        MY_BOOKMARKS_PAGE_INDEX to { BookmarksFragment() },
        ARTILLERY_LIST_PAGE_INDEX to { ArtilleryListFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}
