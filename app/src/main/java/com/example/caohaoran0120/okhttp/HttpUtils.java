package com.example.caohaoran0120.okhttp;

import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {
    private static final String TAG = "HttpUtils";
    private static volatile HttpUtils instance;
    public Handler handler = new Handler();
    private OkHttpClient client;
    private Interceptor getAppInterceptor(){
        //拦截器
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.e("++++++++++","拦截前");
                Response response = chain.proceed(request);
                Log.e("++++++++++","拦截后");
                return response;
            }
        };
        return interceptor;
    }
    private HttpUtils() {
        File file = new File(Environment.getExternalStorageDirectory(), "cache11");
        client = new OkHttpClient().newBuilder()
                .readTimeout(3000, TimeUnit.SECONDS)
                .connectTimeout(3000, TimeUnit.SECONDS)
                .addInterceptor(getAppInterceptor())
                .cache(new Cache(file, 10 * 1024))
                .build();
    }
    //单例
    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if(null == instance) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }
    public void doGet(String url, final Class clazz, final NetCallBack netCallBack) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.onFailure(e);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final Object oj = gson.fromJson(result, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.onSuccess(oj);

                    }
                });
            }
        });
    }
    public void doPost(String url, final Class clazz, Map<String,String> parms, final NetCallBack netCallBack){

        FormBody.Builder body = new FormBody.Builder();
        for (String key:parms.keySet()){
            body.add(key,parms.get(key));
        }
        Request request = new Request.Builder()
                .url(url)
                .post(body.build())
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.onFailure(e);
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final Object oj = gson.fromJson(result, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.onSuccess(oj);
                    }
                });
            }
        });
    }
    public interface NetCallBack {
        void onSuccess(Object oj);

        void onFailure(Exception e);
    }


}
