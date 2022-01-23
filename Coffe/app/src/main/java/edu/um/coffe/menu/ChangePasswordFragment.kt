package edu.um.coffe.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import edu.um.coffe.R

class ChangePasswordFragment : Fragment() {
    private lateinit var viewModel: MenuViewModel

    companion object{
        fun newInstance() = ChangePasswordFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.change_password,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val oldPassword = view.findViewById<EditText>(R.id.oldPassword)
        val newPassword = view.findViewById<EditText>(R.id.newPassword)
        val verifyNewPassword = view.findViewById<EditText>(R.id.verificarNewPassword)
        val cancelChangePassword = view.findViewById<Button>(R.id.cancelChangePassword)
        val inputPassword = view.findViewById<Button>(R.id.inputPassword)

        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]

        cancelChangePassword.setOnClickListener(){
            requireActivity().supportFragmentManager.apply {
                beginTransaction()
                    .replace(R.id.container, SwipableMenu.getInstance())
                    .commit()
            }
        }

        inputPassword.setOnClickListener(){
            val actualPassword = viewModel.getUserPassword()
            if(oldPassword.text.toString() != actualPassword){
                Toast.makeText(context,"Antiga password incorreta", Toast.LENGTH_LONG).show()
            }
            else if (newPassword.text.toString() != verifyNewPassword.text.toString()){
                Toast.makeText(context,"Inseriu passwords diferentes", Toast.LENGTH_LONG).show()
            }
            else{
                viewModel.atualizaPassword(newPassword.text.toString())
                Toast.makeText(context,"Password modificada com sucesso", Toast.LENGTH_LONG).show()
                requireActivity().supportFragmentManager.apply {
                    beginTransaction()
                        .replace(R.id.container, SwipableMenu.getInstance())
                        .commit()
                }
            }
        }
    }

}