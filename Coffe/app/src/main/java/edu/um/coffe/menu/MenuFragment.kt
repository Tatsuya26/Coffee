package edu.um.coffe.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.um.coffe.R
import edu.um.coffe.R.layout.menu_fragment
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.Contacto
import edu.um.coffe.databinding.MenuFragmentBinding
import edu.um.coffe.login.UserLoginViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MenuFragment : Fragment(menu_fragment) {

    private lateinit var viewModel : MenuViewModel
    private lateinit var adapter: CafeAdapter
    private lateinit var text: EditText

    var cafes : MutableList<Cafe> = mutableListOf()
    companion object{
        fun newInstance() = MenuFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(menu_fragment,container,false)
        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        viewModel.getCafes()

        text = view.findViewById(R.id.lSearch_bar)

        this.cafes = viewModel.cafes
        //adapter = cafes.let { CafeAdapter(it) }
        adapter = CafeAdapter(cafes)
        val rvCafes: RecyclerView = view.findViewById<RecyclerView>(R.id.rvcafes)
        rvCafes.adapter = adapter
        rvCafes.layoutManager = LinearLayoutManager(this.context)

        text.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                var input = s.toString()
                var filteredList : MutableList<Cafe> = mutableListOf()

                for (cafe in cafes) {
                    if (cafe.nome.toLowerCase().contains(input.toLowerCase())) {
                        Log.d("MY FUCKING TAG", cafe.nome)
                        Log.d("MY FUCKING TAG", input.toString())
                        filteredList.add(cafe)
                    }
                }

                Log.d("MY FUCKING TAG", "SIZE: " + cafes.size.toString())
                Log.d("MY FUCKING TAG", "FILTER SIZE: " + filteredList.size.toString())

                adapter.filter(filteredList)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        setHasOptionsMenu(true)
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }
}

