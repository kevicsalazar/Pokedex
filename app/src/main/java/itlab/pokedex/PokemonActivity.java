package itlab.pokedex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Kevin.
 */

public class PokemonActivity extends AppCompatActivity {

    ImageView ivStar;
    ImageView ivPokemon;
    TextView tvNumber;
    TextView tvName;
    TextView tvType;

    public static String favoriteNumber = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        setTitle(getIntent().getStringExtra("name"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivStar = (ImageView) findViewById(R.id.ivStar);
        ivPokemon = (ImageView) findViewById(R.id.ivPokemon);
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        tvName = (TextView) findViewById(R.id.tvName);
        tvType = (TextView) findViewById(R.id.tvType);

        Picasso.with(this).load(getIntent().getStringExtra("imageUrl")).into(ivPokemon);
        tvNumber.setText(getIntent().getStringExtra("number"));
        tvName.setText(getIntent().getStringExtra("name"));
        tvType.setText(getIntent().getStringExtra("type"));

        ivStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getIntent().getStringExtra("number").equals(favoriteNumber)) {
                    favoriteNumber = "";
                    ivStar.setImageResource(R.drawable.ic_star_outline);
                } else {
                    favoriteNumber = getIntent().getStringExtra("number");
                    ivStar.setImageResource(R.drawable.ic_star);
                }
            }
        });

        if (getIntent().getStringExtra("number").equals(favoriteNumber)) {
            ivStar.setImageResource(R.drawable.ic_star);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
