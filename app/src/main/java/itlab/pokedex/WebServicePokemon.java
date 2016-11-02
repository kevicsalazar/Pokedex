package itlab.pokedex;


import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Kevin.
 */

class WebServicePokemon {

    private Service service;

    WebServicePokemon() {
        service = getRetrofit().create(Service.class);
    }

    Observable<List<Pokemon>> getPokemones() {
        return service.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    interface Service {

        @GET("docs/PokeDB.json")
        Observable<List<Pokemon>> getData();

    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://itlab.fis.ulima.edu.pe/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
