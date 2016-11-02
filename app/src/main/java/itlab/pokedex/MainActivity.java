package itlab.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        WebServicePokemon ws = new WebServicePokemon();
        ws.getPokemones().subscribe(this::addPokemonList, Throwable::printStackTrace);

    }

    public void addPokemonList(List<Pokemon> pokemonList) {
        progressBar.setVisibility(View.GONE);
        PokemonAdapter pokemonAdapter = new PokemonAdapter(this, pokemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pokemonAdapter);
    }

}
