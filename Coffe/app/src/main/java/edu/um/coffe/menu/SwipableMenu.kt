package edu.um.coffe.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import edu.um.coffe.R
import me.relex.circleindicator.CircleIndicator3

class SwipableMenu : Fragment() {
    companion object {
        fun getInstance() = SwipableMenu()
    }
    private lateinit var viewpager :ViewPager2

    inner class ScreenSlidePagerAdapter(fa : Fragment) : FragmentStateAdapter(fa){
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            if (position == 0) return MenuFragment()
            else return UserProfileFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.swipable_menu,container,false)

        viewpager = view.findViewById(R.id.pagerslide)
        val adapter = ScreenSlidePagerAdapter(this)
        viewpager.adapter = adapter

        val indicator = view.findViewById<CircleIndicator3>(R.id.indicatorPage)
        indicator.setViewPager(viewpager)
        return view
    }


}