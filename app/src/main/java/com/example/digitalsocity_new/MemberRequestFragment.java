package com.example.digitalsocity_new;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MemberRequestFragment extends Fragment {

    ApiInterface apiInterface;
    List<MemberRequest_model>memberRequest_models;
    RecyclerView rev;

    public MemberRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=   inflater.inflate(R.layout.fragment_member_request, container, false);

        rev = v.findViewById(R.id.rev);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rev.setLayoutManager(layoutManager);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<MemberRequest_model>> call = apiInterface.getMemberRequest("name","house_no","email");
        call.enqueue(new Callback<List<MemberRequest_model>>() {
            @Override
            public void onResponse(Call<List<MemberRequest_model>> call, Response<List<MemberRequest_model>> response) {

                memberRequest_models = response.body();
                MemberRequest_Adapter memberRequest_adapter = new MemberRequest_Adapter(memberRequest_models);
                rev.setAdapter(memberRequest_adapter);
            }

            @Override
            public void onFailure(Call<List<MemberRequest_model>> call, Throwable t) {


            }
        });
        return v;

    }
}