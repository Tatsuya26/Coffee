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

class FavoritosFragment : Fragment() {
    lateinit var viewModel : MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_cafesview,container,false)
        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]
        var cafes = mutableListOf(
            Cafe(
                "1234", "Garrafeira", 5F, Localizacao("Rua das finanças",  41.65433066576365, -8.43504224690325),
                Contacto("253222543", "garrafeira@cafe.com"), "naoseicomo"
            )
        )

        val rvFavs = view.findViewById<RecyclerView>(R.id.rvlistas)
        var adapter = CafeAdapter(cafes,viewModel)
        rvFavs.adapter = adapter
        rvFavs.layoutManager = LinearLayoutManager(this.context)

        return view
    }
}