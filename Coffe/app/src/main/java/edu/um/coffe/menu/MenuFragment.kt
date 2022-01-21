package edu.um.coffe.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.um.coffe.R
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.Contacto
import edu.um.coffe.login.UserLoginViewModel

class MenuFragment : Fragment() {

    private lateinit var viewModel : MenuViewModel
    var cafes : List<Cafe> = ArrayList<Cafe>()
    companion object{
        fun newInstance() = MenuFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.menu_fragment,container,false)
        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        viewModel.getCafes()
        cafes = mutableListOf(
            Cafe("1234","Garrafeira",5F,"Rua das finanças",Contacto("253222543","garrafeira@cafe.com"),"naoseicomo")
        )
        val adapter = cafes.let { CafeAdapter(it) }
        val rvCafes = view.findViewById<RecyclerView>(R.id.rvcafes)
        rvCafes.adapter = adapter
        rvCafes.layoutManager = LinearLayoutManager(this.context)

        view.findViewById<EditText>(R.id.lSearch_bar).addTextChangedListener {
            rvCafes.adapter = CafeAdapter(cafes)
        }
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }
}
