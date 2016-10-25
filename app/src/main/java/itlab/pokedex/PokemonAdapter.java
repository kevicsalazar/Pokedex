package itlab.pokedex;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kevin.
 */

class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> implements View.OnClickListener {

    private Activity activity;
    private List<Pokemon> pokemonList;

    PokemonAdapter(Activity activity, List<Pokemon> pokemonList) {
        this.activity = activity;
        this.pokemonList = pokemonList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        Picasso.with(activity).load(pokemon.getImageUrl()).into(holder.ivPokemon);
        holder.tvNumber.setText(pokemon.getId());
        holder.tvName.setText(pokemon.getName());
        holder.tvType.setText(pokemon.getType());
        holder.itemView.setTag(pokemon);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    @Override
    public void onClick(View view) {
        Pokemon pokemon = (Pokemon) view.getTag();
        Intent intent = new Intent(activity, PokemonActivity.class);
        intent.putExtra("imageUrl", pokemon.getImageUrl());
        intent.putExtra("number", pokemon.getId());
        intent.putExtra("name", pokemon.getName());
        intent.putExtra("type", pokemon.getType());
        activity.startActivity(intent);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPokemon;
        TextView tvNumber;
        TextView tvName;
        TextView tvType;

        ViewHolder(View view) {
            super(view);
            ivPokemon = (ImageView) view.findViewById(R.id.ivPokemon);
            tvNumber = (TextView) view.findViewById(R.id.tvNumber);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvType = (TextView) view.findViewById(R.id.tvType);
        }
    }

}
