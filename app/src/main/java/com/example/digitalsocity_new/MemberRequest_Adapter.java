package com.example.digitalsocity_new;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberRequest_Adapter extends RecyclerView.Adapter<MemberRequest_Adapter.Myclass>{

   List<MemberRequest_model> memberRequest_models;
    Context context;




    public MemberRequest_Adapter(List<MemberRequest_model> memberRequest_models) {
        this.memberRequest_models = memberRequest_models;
        this.context = context;
    }



    @NonNull
    @Override
    public Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_request_layout,parent,false);
        return new Myclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myclass holder, int position) {

        MemberRequest_model gl = memberRequest_models.get(position);

        holder.txt_name.setText(gl.getName());
        holder.txt_houseno.setText(gl.getEmail());
        holder.txt_email.setText(gl.getHouse_no());

        holder.btnaccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface apiInterface;
                apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                Call<List<MemberRequest_model>> call = apiInterface.getMemberRequest("name","house_no","emsil");
                call.enqueue(new Callback<List<MemberRequest_model>>() {
                    @Override
                    public void onResponse(Call<List<MemberRequest_model>> call, Response<List<MemberRequest_model>> response) {
                        Toast.makeText(view.getContext(), "update", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<MemberRequest_model>> call, Throwable t) {

                        Log.d("mydata","Failuer"+t.getMessage());
                        Toast.makeText(view.getContext(), "Failuer", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {

        return memberRequest_models.size();
    }

    class  Myclass extends RecyclerView.ViewHolder
    {
            TextView txt_name,txt_houseno,txt_email;
            Button btnaccept,btnreject;

        public Myclass(@NonNull View itemView) {
            super(itemView);

            txt_name = itemView.findViewById(R.id.txtname);
            txt_houseno = itemView.findViewById(R.id.txthouseno);
            txt_email = itemView.findViewById(R.id.txtemail);
        }
    }

}
