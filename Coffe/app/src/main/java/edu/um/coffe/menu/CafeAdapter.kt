package edu.um.coffe.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import edu.um.coffe.R
import edu.um.coffe.data.Cafe
import edu.um.coffe.login.UserLoginFragment
import edu.um.coffe.login.UserLoginViewModel
import org.w3c.dom.Text

class CafeAdapter (var cafes : List<Cafe>,var viewModel: MenuViewModel) : RecyclerView.Adapter<CafeAdapter.CafeViewHolder>() {
    lateinit var fav_button: AppCompatImageButton
    inner class CafeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cafe_item,parent,false)
        return CafeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        holder.itemView.apply {
            fav_button = findViewById(R.id.favorito)
            fav_button.setOnClickListener {
                viewModel.adicionarFavorito(cafes[position].idCafe)
            }
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
}