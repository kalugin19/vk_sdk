package com.vk.tools.vktools.view.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.vk.tools.vktools.R
import com.vk.tools.vktools.view.base.BaseFragment

class MainFriendsFragment : BaseFragment() {

    companion object {
        fun getInstance(): MainFriendsFragment {
            return MainFriendsFragment()
        }
    }

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_friends_main, container, false)
        val viewPager = view.findViewById<ViewPager>(R.id.viewpager)
        val tabs = view.findViewById<TabLayout>(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        viewPager.adapter = fragmentManager?.let { FriendsViewPagerAdapter(it) }
        return view
    }

    class FriendsViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            return FriendsFragment.getInstance()
        }

        override fun getPageTitle(position: Int): CharSequence {
            return "All"
        }
    }



}