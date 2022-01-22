package edu.um.coffe.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import edu.um.coffe.MainActivity
import edu.um.coffe.R
import edu.um.coffe.data.Cafe
import edu.um.coffe.mapa.MapsFragment

class FavAdapter (var cafes : MutableList<Cafe>, var viewModel: MenuViewModel) : RecyclerView.Adapter<FavAdapter.CafeViewHolder>() {
    lateinit var fav_button: AppCompatImageButton
    inner class CafeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cafe_item,parent,false)
        return CafeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.nomeCafe).text = cafes[position].nome
            findViewById<TextView>(R.id.classificacaoCafe).text = cafes[position].rating.toString()
            findViewById<ImageView>(R.id.imagemCafe).setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_home_24))
            findViewById<TextView>(R.id.telefoneCafe).text = cafes[position].contacto.telefone
            findViewById<TextView>(R.id.emailCafe).text = cafes[position].contacto.email
            findViewById<TextView>(R.id.moradaCafe).text = cafes[position].localizacao.endereco

            val visivel = cafes[position].visibilidade
            findViewById<ConstraintLayout>(R.id.cafeMoreInfo).visibility = if (visivel) View.VISIBLE else View.GONE

            findViewById<ConstraintLayout>(R.id.headerCafe).setOnClickListener {
                cafes[position].visibilidade = !cafes[position].visibilidade
                notifyItemChanged(position)
            }

            findViewById<MaterialButton>(R.id.buttonformap).setOnClickListener {
                viewModel.adicionarHistorico(cafes[position].idCafe)
                val activity = this.context as MainActivity
                val commit = activity.supportFragmentManager.beginTransaction().replace(
                    R.id.container,
                    MapsFragment.getInstance(
                        cafes[position].localizacao.latitude,
                        cafes[position].localizacao.longitude
                    )
                ).addToBackStack(null).commit()
            }

            fav_button = findViewById(R.id.favorito)
            fav_button.setImageResource(R.drawable.ic_baseline_remove_24)
            fav_button.setOnClickListener {
                viewModel.removerFavorito(cafes[position].idCafe)
                cafes.removeAt(position)
                notifyDataSetChanged()
            }

        }
    }

    override fun getItemCount(): Int {
        return cafes.size
    }

}