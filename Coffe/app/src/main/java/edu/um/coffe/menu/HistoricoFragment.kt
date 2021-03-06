package edu.um.coffe.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.um.coffe.R
import edu.um.coffe.data.Cafe
import edu.um.coffe.data.Contacto
import edu.um.coffe.data.Localizacao

class HistoricoFragment() : Fragment() {
    lateinit var viewModel : MenuViewModel
    lateinit var histCafe : MutableList<Cafe>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        val view = inflater.inflate(R.layout.lista_cafesview,container,false)
        viewModel.getHistorico()
        histCafe = viewModel.histUser

        val rvFavs = view.findViewById<RecyclerView>(R.id.rvlistas)
        val adapter = CafeAdapter(histCafe, viewModel,false)
        rvFavs.adapter = adapter
        rvFavs.layoutManager = LinearLayoutManager(this.context)

        return view
    }
}