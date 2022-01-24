package edu.um.coffe.register

import android.graphics.BitmapFactory
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
import edu.um.coffe.login.LoginFragment
import edu.um.coffe.menu.SwipableMenu

class UserRegisterFragment : Fragment() {
    companion object {
        fun newInstance() = UserRegisterFragment()
    }

    private lateinit var registerViewModel: UserRegisterViewModel
    private lateinit var registerBtn : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.userregister_fragment,container,false)
        registerBtn = view.findViewById(R.id.signup)

        view.findViewById<EditText>(R.id.rusernameBox).addTextChangedListener {
            it?.let {
                registerViewModel.updateUsername(it.toString())
            }
        }
        view.findViewById<EditText>(R.id.rPasswordBox).addTextChangedListener {
            it?.let {
                registerViewModel.updatePassword(it.toString())
            }
        }
        view.findViewById<EditText>(R.id.emailBox).addTextChangedListener {
            it?.let {
                registerViewModel.updateEmail(it.toString())
            }
        }

        registerBtn.setOnClickListener {
            var b = false
            registerViewModel.run {
                registarUtilizador(BitmapFactory.decodeResource(resources,R.drawable.user))
                b = autenticarUtilizador()
            }
            if (b) {
                requireActivity().supportFragmentManager.popBackStack()
                requireActivity().supportFragmentManager.apply {
                    beginTransaction()
                        .replace(R.id.container, SwipableMenu.getInstance())
                        .addToBackStack(null)
                        .commit()
                }
                Toast.makeText(context,"Utilizador criado e logado",Toast.LENGTH_LONG).show()
            }
            else {
                view.findViewById<EditText>(R.id.rusernameBox).setText("")
                view.findViewById<EditText>(R.id.rPasswordBox).setText("")
                view.findViewById<EditText>(R.id.emailBox).setText("")
                Toast.makeText(context,"Utilizador nao pode ser criado",Toast.LENGTH_LONG).show()
            }
        }

        view.findViewById<ImageButton>(R.id.signupBack).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commit()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerViewModel = ViewModelProvider(this).get(UserRegisterViewModel::class.java)
    }
}