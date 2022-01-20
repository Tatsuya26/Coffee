package edu.um.coffe.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.*
import edu.um.coffe.R
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

        loginbtn.setOnClickListener {
            fragmentManager?.apply {
                beginTransaction()
                    .add(R.id.container, UserLoginFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }

        registText.setOnClickListener {
            fragmentManager?.apply {
                beginTransaction()
                    .add(R.id.container, UserRegisterFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}