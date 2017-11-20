package dev.uublabs.logginginterceptor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import dev.uublabs.logginginterceptor.Util.NetworkUtils;
import dev.uublabs.logginginterceptor.model.RandomResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
{

    private Retrofit retrofit;
    RandomService randomService;
    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = NetworkUtils.configureRetrofitClient();
        randomService = retrofit.create(RandomService.class);

    }
    
    public void doMagic(View view)
    {
        randomService.getRandomUser().enqueue(new Callback<RandomResponse>()
        {
            @Override
            public void onResponse(Call<RandomResponse> call, retrofit2.Response<RandomResponse> response)
            {
                if(response.isSuccessful())
                    Log.d(TAG, "onResponse: success");
                else
                    Log.e(TAG, "onResponse: error response");
            }

            @Override
            public void onFailure(Call<RandomResponse> call, Throwable t)
            {
                Log.e(TAG, "onFailure: network error",  t);
            }
        });
    }
}
