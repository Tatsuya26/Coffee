package edu.um.coffe.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import edu.um.coffe.R
import edu.um.coffe.login.LoginFragment
import edu.um.coffe.login.UserLoginFragment
import edu.um.coffe.register.UserRegisterFragment

import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import edu.um.coffe.MainActivity
import kotlinx.coroutines.NonDisposableHandle.parent

class MenuFragment : Fragment() {

    private lateinit var search_bar : EditText
    private lateinit var adapter: ArrayAdapter<*>

    companion object{
        fun newInstance() = MenuFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.menu_fragment,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ArrayAdapter(parentFragment,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.lista_nomes_cafes))
        search_bar = view.findViewById(R.id.lSearch_bar)


        search_bar.ser
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