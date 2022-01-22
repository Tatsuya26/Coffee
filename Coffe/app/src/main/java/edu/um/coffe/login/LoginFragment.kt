package edu.um.coffe.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.*
import androidx.lifecycle.MutableLiveData
import com.google.android.material.button.MaterialButton
import edu.um.coffe.R
import edu.um.coffe.menu.SwipableMenu
import edu.um.coffe.register.UserRegisterFragment

class LoginFragment : Fragment() {

    private lateinit var loginbtn : Button
    private lateinit var registText : TextView

    companion object{
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.login_fragment,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginbtn = view.findViewById(R.id.entrar)
        registText = view.findViewById(R.id.cliqueaqui)
        var skipbtn = view.findViewById<MaterialButton>(R.id.skipbtn)

        loginbtn.setOnClickListener {
            fragmentManager?.apply {
                beginTransaction()
                    .replace(R.id.container, UserLoginFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }

        registText.setOnClickListener {
            fragmentManager?.apply {
                beginTransaction()
                    .replace(R.id.container, UserRegisterFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }

        skipbtn.setOnClickListener {
            fragmentManager?.apply {
                beginTransaction()
                    .replace(R.id.container, SwipableMenu.getInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}