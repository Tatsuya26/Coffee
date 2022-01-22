package edu.um.coffe.menu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import edu.um.coffe.R
import edu.um.coffe.login.LoginFragment
import edu.um.coffe.login.UserLoginFragment
import edu.um.coffe.register.UserRegisterFragment

class ChangePasswordFragment() : Fragment() {
    companion object{
        fun newInstance() = ChangePasswordFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.change_password,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var oldPassword = view.findViewById<EditText>(R.id.oldPassword)
        var newPassword = view.findViewById<EditText>(R.id.newPassword)
        var verifyNewPassword = view.findViewById<EditText>(R.id.verificarNewPassword)
        var cancelChangePassword = view.findViewById<Button>(R.id.cancelChangePassword)
        var inputPassword = view.findViewById<Button>(R.id.inputPassword)

        var viewModel = ViewModelProvider(this)[MenuViewModel::class.java]

        cancelChangePassword.setOnClickListener(){
            requireActivity().supportFragmentManager.apply {
                beginTransaction()
                    .replace(R.id.container, SwipableMenu.getInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }

        inputPassword.setOnClickListener(){
            var actualPassword = viewModel.getUserPassword()
            if(oldPassword.text.toString() != actualPassword){
                Toast.makeText(context,"Antiga password incorreta", Toast.LENGTH_LONG).show()
            }
            else if (newPassword.text.toString() != verifyNewPassword.text.toString()){
                Toast.makeText(context,"Inseriu passwords diferentes", Toast.LENGTH_LONG).show()
            }
            else{
                //TODO: update palavra passe
                Toast.makeText(context,"Password modificada com sucesso", Toast.LENGTH_LONG).show()
                requireActivity().supportFragmentManager.apply {
                    beginTransaction()
                        .replace(R.id.container, SwipableMenu.getInstance())
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}