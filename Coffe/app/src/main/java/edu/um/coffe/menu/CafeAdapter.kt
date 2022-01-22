package edu.um.coffe.menu

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import edu.um.coffe.R
import edu.um.coffe.data.Cafe

class CafeAdapter (var cafes : MutableList<Cafe>) : RecyclerView.Adapter<CafeAdapter.CafeViewHolder>() {
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
            findViewById<TextView>(R.id.moradaCafe).text = cafes[position].endereco

            val visivel = cafes[position].visibilidade
            findViewById<ConstraintLayout>(R.id.cafeMoreInfo).visibility = if (visivel) View.VISIBLE else View.GONE

            findViewById<ConstraintLayout>(R.id.headerCafe).setOnClickListener {
                cafes[position].visibilidade = !cafes[position].visibilidade
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return cafes.size
    }

    fun filter(filteredList: MutableList<Cafe>){
        cafes = filteredList
        Log.d("WHAT THE FUCK?", "IS THIS REAL LIFE?")
        notifyDataSetChanged()
    }
}