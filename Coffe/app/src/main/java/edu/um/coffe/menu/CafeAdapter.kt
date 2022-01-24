package edu.um.coffe.menu

import android.annotation.SuppressLint

import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
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
import org.w3c.dom.Text
import java.time.Duration
import java.time.LocalTime

class CafeAdapter (var cafes : MutableList<Cafe>,var viewModel: MenuViewModel,var favoritos : Boolean) : RecyclerView.Adapter<CafeAdapter.CafeViewHolder>() {
    lateinit var fav_button: AppCompatImageButton
    inner class CafeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cafe_item,parent,false)
        return CafeViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        holder.itemView.apply {
            fav_button = findViewById(R.id.favorito)
            fav_button.setOnClickListener {
                if(favoritos) {
                    viewModel.removerFavorito(cafes[position].idCafe)
                    cafes.removeAt(position)
                    notifyDataSetChanged()
                }
                else {
                    viewModel.adicionarFavorito(cafes[position].idCafe)
                }
                fav_button.setImageResource(R.drawable.fav2)
                notifyItemChanged(position)
                fav_button.setImageResource(R.drawable.fav)
                notifyItemChanged(position)
            }

            val res = context.resources.getIdentifier(cafes[position].fotos,"drawable",context.packageName)
            findViewById<TextView>(R.id.nomeCafe).text = cafes[position].nome
            findViewById<TextView>(R.id.classificacaoCafe).text = cafes[position].rating.toString()
            findViewById<ImageView>(R.id.imagemCafe).setImageDrawable(resources.getDrawable(res))

            var telefone = "Telefone: " + cafes[position].contacto.telefone.replace("+351", "")
            findViewById<TextView>(R.id.telefoneCafe).text = telefone
            findViewById<TextView>(R.id.moradaCafe).text = cafes[position].localizacao.endereco
            cafes[position].horario.apply {
                var timeAbertura = LocalTime.of(this.horaAbertura,minAbertura).toString()
                var timeFecho = LocalTime.of(this.horaFecho,minFecho).toString()
                findViewById<TextView>(R.id.horarioCafe).setText("Horário: $timeAbertura - $timeFecho")

            }

            val visivel = cafes[position].visibilidade
            findViewById<ConstraintLayout>(R.id.cafeMoreInfo).visibility = if (visivel) View.VISIBLE else View.GONE

            findViewById<ConstraintLayout>(R.id.headerCafe).setOnClickListener {
                cafes[position].visibilidade = !cafes[position].visibilidade
                notifyItemChanged(position)
            }

            findViewById<ImageButton>(R.id.buttonformap).setOnClickListener {
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

        }
    }

    override fun getItemCount(): Int {
        return cafes.size
    }

    fun filter(filteredList: MutableList<Cafe>){
        cafes = filteredList
        notifyDataSetChanged()
    }
}