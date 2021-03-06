package com.mohanfoundation.mohanfoundation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mohanfoundation.mohanfoundation.Repositories.BodyDonationRepo;
import com.mohanfoundation.mohanfoundation.Repositories.EyeBackRepo;
import com.mohanfoundation.mohanfoundation.Repositories.NgoListRepo;
import com.mohanfoundation.mohanfoundation.Repositories.SkinBackRepo;
import com.mohanfoundation.mohanfoundation.Repositories.TransplantRepo;
import com.mohanfoundation.mohanfoundation.models.BodyDonation;
import com.mohanfoundation.mohanfoundation.models.EyeBank;
import com.mohanfoundation.mohanfoundation.models.NGOlist;
import com.mohanfoundation.mohanfoundation.models.SkinBank;
import com.mohanfoundation.mohanfoundation.models.TrasnplantHospital;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import okhttp3.*;

public class StartScreen extends AppCompatActivity {

    public static Gson GSON = new Gson();
    public AVLoadingIndicatorView indicatorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        indicatorView =(AVLoadingIndicatorView)findViewById(R.id.avi);
        startAnim();
        try {
            getEyeBankDetails();
            getSkinBankDetails();

            getNGOlist();//ngoorgandonation
            getDonationHospital();//organdonationhospital
            geTranplantList();
            getBodyDonationDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getEyeBankDetails() throws IOException {


        final Request requestOutBound = new Request.Builder()
                .url("http://mohan-93120.onmodulus.net/crud/rest/list/transplantcentre")
                .get()
                .build();


        OkHttpClient client = new OkHttpClient();

        client.newCall(requestOutBound).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                Log.d("postUrl", "Failure");


            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Type collectionType = new TypeToken<Collection<TrasnplantHospital>>(){}.getType();
                Collection<TrasnplantHospital> eyeBanks = GSON.fromJson(response.body().string(), collectionType);
                TransplantRepo eyeBackRepo = new TransplantRepo (getApplicationContext());
                int reponseFromDb=eyeBackRepo.insert(eyeBanks);

            }


        });




    }
    public void getSkinBankDetails() throws IOException {


        final Request requestOutBound = new Request.Builder()
                .url("http://mohan-93120.onmodulus.net/crud/rest/list/skinbank")
                .get()
                .build();


        OkHttpClient client = new OkHttpClient();

        client.newCall(requestOutBound).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                Log.d("postUrl", "Failure");


            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Type collectionType = new TypeToken<Collection<SkinBank>>(){}.getType();
                Collection<SkinBank> skinBanks = GSON.fromJson(response.body().string(), collectionType);

                SkinBackRepo eyeBackRepo = new  SkinBackRepo(getApplicationContext());
                int reponseFromDb=eyeBackRepo.insert(skinBanks);


            }


        });




    }
    public void getNGOlist() throws IOException {


        final Request requestOutBound = new Request.Builder()
                .url("http://mohan-93120.onmodulus.net/crud/rest/list/ngoorgandonation")
                .get()
                .build();


        OkHttpClient client = new OkHttpClient();

        client.newCall(requestOutBound).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                Log.d("postUrl", "Failure");


            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Type collectionType = new TypeToken<Collection<NGOlist>>(){}.getType();
                Collection<NGOlist> bodyDonations = GSON.fromJson(response.body().string(), collectionType);
                NgoListRepo eyeBackRepo = new NgoListRepo(getApplicationContext());
                int reponseFromDb=eyeBackRepo.insert(bodyDonations);



            }


        });




    }

    public void getDonationHospital() throws IOException {


        final Request requestOutBound = new Request.Builder()
                .url("http://mohan-93120.onmodulus.net/crud/rest/list/organdonationhospital")
                .get()
                .build();


        OkHttpClient client = new OkHttpClient();

        client.newCall(requestOutBound).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                Log.d("postUrl", "Failure");


            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Type collectionType = new TypeToken<Collection<TrasnplantHospital>>(){}.getType();
                Collection<TrasnplantHospital> bodyDonations = GSON.fromJson(response.body().string(), collectionType);
                TransplantRepo eyeBackRepo = new TransplantRepo(getApplicationContext());
                int reponseFromDb=eyeBackRepo.insert(bodyDonations);



            }


        });




    }

    public void getBodyDonationDetails() throws IOException {


        final Request requestOutBound = new Request.Builder()
                .url("http://mohan-93120.onmodulus.net/crud/rest/list/bodydonation")
                .get()
                .build();


        OkHttpClient client = new OkHttpClient();

        client.newCall(requestOutBound).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                Log.d("postUrl", "Failure");


            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Type collectionType = new TypeToken<Collection<BodyDonation>>(){}.getType();
                Collection<BodyDonation> bodyDonations = GSON.fromJson(response.body().string(), collectionType);
                BodyDonationRepo eyeBackRepo = new BodyDonationRepo(getApplicationContext());
                int reponseFromDb=eyeBackRepo.insert(bodyDonations);



            }


        });




    }

    public void geTranplantList() throws IOException {


        final Request requestOutBound = new Request.Builder()
                .url("http://mohan-93120.onmodulus.net/crud/rest/list/transplantcentre")
                .get()
                .build();


        OkHttpClient client = new OkHttpClient();

        client.newCall(requestOutBound).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                Log.d("postUrl", "Failure");


            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Type collectionType = new TypeToken<Collection<TrasnplantHospital>>(){}.getType();
                Collection<TrasnplantHospital> bodyDonations = GSON.fromJson(response.body().string(), collectionType);
                TransplantRepo eyeBackRepo = new TransplantRepo(getApplicationContext());
                int reponseFromDb=eyeBackRepo.insert(bodyDonations);

                if(reponseFromDb>0)
                {
                    Intent goToHomeScreen = new Intent(getApplicationContext(),HomeScreen.class);
                    startActivity(goToHomeScreen);
                }

            }


        });




    }


    void startAnim(){
        indicatorView.show();
        // or avi.smoothToShow();
    }

    void stopAnim(){
        indicatorView.hide();
        // or avi.smoothToHide();
    }
}
