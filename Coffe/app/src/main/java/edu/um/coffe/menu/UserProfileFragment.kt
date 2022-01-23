package edu.um.coffe.menu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.um.coffe.R

import androidx.core.app.ActivityCompat.startActivityForResult



import android.util.Log
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import edu.um.coffe.data.User
import edu.um.coffe.login.LoginFragment
import edu.um.coffe.login.UserLoginFragment



class UserProfileFragment : Fragment() {

    private lateinit var viewModel : MenuViewModel
    private lateinit var viewpager : ViewPager2
    private lateinit var tabLayout : TabLayout
    private lateinit var changePic: ImageButton
    private lateinit var userImage: ImageView


    companion object{
        fun newInstance() = UserProfileFragment()
        val IMAGE_REQUEST_CODE = 100
    }


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
        changePic = view.findViewById(R.id.change_image)
        userImage = view.findViewById(R.id.avataruser)
        changePic.bringToFront()

        changePic.setOnClickListener{
            pickImageGallery()
        }


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

        var changePassword = view.findViewById<MaterialButton>(R.id.mudarpass)
        changePassword.setOnClickListener {
            requireActivity().supportFragmentManager.apply {
                    beginTransaction()
                        .replace(R.id.container, ChangePasswordFragment.newInstance())
                        .addToBackStack(null)
                        .commit()
            }
        }

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

    private fun pickImageGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), IMAGE_REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE) {
            userImage.setImageURI(data?.data)
            userImage.layout(150,150,150,150)

            val name : String = java.lang.String.valueOf(userImage.tag)
            val res = resources.getIdentifier(name,"drawable","drawable" )

            


        }
    }
}