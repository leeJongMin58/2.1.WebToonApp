package com.jomiroid.webtoonapp

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val mainActivity: MainActivity) :
    FragmentStateAdapter(mainActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                WebViewFragment(position, "https://comic.naver.com/webtoon?tab=mon").apply {
                    listener = mainActivity
                }
            }

            1 -> {
                WebViewFragment(position, "https://comic.naver.com/webtoon?tab=tue").apply {
                    listener = mainActivity
                }
            }

            else -> {
                WebViewFragment(position, "https://comic.naver.com/webtoon/list?titleId=747269&tab=wed").apply {
                    listener = mainActivity
                }
            }
        }
    }
}
