package dev.uublabs.logginginterceptor;

import dev.uublabs.logginginterceptor.model.RandomResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Admin on 11/20/2017.
 */

public interface RandomService
{
    @GET("api")
    Call<RandomResponse> getRandomUser();
}
