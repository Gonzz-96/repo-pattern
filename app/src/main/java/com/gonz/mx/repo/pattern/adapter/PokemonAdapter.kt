package com.gonz.mx.repo.pattern.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gonz.mx.repo.pattern.R
import com.gonz.mx.repo.pattern.domain.entities.Pokemon
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonAdapter(
    private var pokemonList: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val rootView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)

        return PokemonViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount(): Int =
        pokemonList.size

    class PokemonViewHolder(val v: View) : RecyclerView.ViewHolder(v) {

        fun bind(p: Pokemon) {
            v.itemPokemonId.text = p.id.toString()
            v.itemPokemonName.text = p.name
        }
    }

}