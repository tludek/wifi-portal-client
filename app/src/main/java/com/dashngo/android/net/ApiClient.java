package com.dashngo.android.net;

import com.dashngo.android.net.model.Product;
import com.dashngo.android.net.model.StoreInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String poloniexApiEndpoint = "http://dashngo.com/";

    private DashNGoApi dashNGoApi;

    private static ApiClient sInstance;

    public static synchronized ApiClient getInstance() {
        if (sInstance == null) {
            sInstance = new ApiClient();
        }
        return sInstance;
    }

    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiClient.poloniexApiEndpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dashNGoApi = retrofit.create(DashNGoApi.class);
    }

    public Call<StoreInfo> storeInfo() {
        return dashNGoApi.storeInfo();
    }

    public Call<Map<String, Product>> productList() {
        return dashNGoApi.productList();
    }
}
