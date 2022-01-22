package edu.um.coffe.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.um.coffe.R

class UserProfileFragment : Fragment() {

    private lateinit var viewModel : MenuViewModel
    private lateinit var viewpager : ViewPager2
    private lateinit var tabLayout : TabLayout
    inner class CafeSlidePagerAdapter(fa : Fragment) : FragmentStateAdapter(fa){
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            if (position == 0) return FavoritosFragment()
            else return HistoricoFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.user_profile,container,false)
        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        val nomeUser = view.findViewById<TextView>(R.id.usernameProfile)
        nomeUser.text = viewModel.getUsername()
        viewpager = view.findViewById(R.id.viewpageuser)
        tabLayout = view.findViewById(R.id.tabsfavhist)
        val adapter = CafeSlidePagerAdapter(this)
        viewpager.adapter = adapter

        TabLayoutMediator(tabLayout,viewpager) { tab,position ->
            if (position == 0) tab.text = "Favoritos"
            else tab.text = "Historico"
        }.attach()

        return view
    }

    override fun onResume() {
        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        val adapter = CafeSlidePagerAdapter(this)
        viewpager.adapter = adapter

        TabLayoutMediator(tabLayout,viewpager) { tab,position ->
            if (position == 0) tab.text = "Favoritos"
            else tab.text = "Historico"
        }.attach()

        super.onResume()
    }
}