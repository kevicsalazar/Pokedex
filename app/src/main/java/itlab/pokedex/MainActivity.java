package itlab.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Pokemon> pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadPokemonDB();
    }

    public void loadPokemonDB() {
        try {
            InputStream ims = getAssets().open("PokeDB.json");
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(ims);
            Type listType = new TypeToken<ArrayList<Pokemon>>() {
            }.getType();
            pokemonList = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            pokemonList = new ArrayList<>();
        }
    }

}
