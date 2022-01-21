package edu.um.coffe.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import edu.um.coffe.R
import edu.um.coffe.menu.MenuFragment
import edu.um.coffe.menu.SwipableMenu
import edu.um.coffe.register.UserRegisterFragment

class UserLoginFragment : Fragment() {
    private lateinit var userLoginViewModel : UserLoginViewModel
    companion object {
        fun newInstance() = UserLoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.userlogin_fragment,container,false)
        userLoginViewModel = ViewModelProvider(this).get(UserLoginViewModel::class.java)

        view.findViewById<EditText>(R.id.lusernameBox).addTextChangedListener {
            it?.let {
                userLoginViewModel.updateUsername(it.toString())
            }
        }
        view.findViewById<EditText>(R.id.lPasswordBox).addTextChangedListener {
            it?.let {
                userLoginViewModel.updatePassword(it.toString())
            }
        }
        view.findViewById<ImageButton>(R.id.loginbut).setOnClickListener {
            val b = userLoginViewModel.autenticarUtilizador()
            if (b) {
                Toast.makeText(context,"LOGADO",Toast.LENGTH_LONG).show()
                fragmentManager?.beginTransaction()?.replace(R.id.container, SwipableMenu.getInstance())
                    ?.addToBackStack(null)?.commit()
            }
            else {
                Toast.makeText(context,"Utilizador nao existente",Toast.LENGTH_SHORT).show()
                view.findViewById<EditText>(R.id.lPasswordBox).setText("")
                view.findViewById<EditText>(R.id.lusernameBox).setText("")
            }
        }

        return view
    }



}