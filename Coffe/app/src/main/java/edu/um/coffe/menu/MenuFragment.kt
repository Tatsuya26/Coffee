package edu.um.coffe.menu

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.um.coffe.R
import edu.um.coffe.R.layout.menu_fragment
import edu.um.coffe.data.Cafe

class MenuFragment (): Fragment(menu_fragment) {
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

        text = view.findViewById(R.id.lSearch_bar)
        viewModel.getCafes()
        cafes = viewModel.cafes
        adapter = CafeAdapter(cafes,viewModel,false)
        val rvCafes: RecyclerView = view.findViewById<RecyclerView>(R.id.rvcafes)
        rvCafes.adapter = adapter
        rvCafes.layoutManager = LinearLayoutManager(this.context)
        text.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                var input = s.toString()
                var filteredList : MutableList<Cafe> = mutableListOf()

                for (cafe in cafes) {
                    if (cafe.nome.toLowerCase().contains(input.toLowerCase())) {
                        filteredList.add(cafe)
                    }
                }

                adapter.filter(filteredList)
            }
        })

        setHasOptionsMenu(true)
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }
}

