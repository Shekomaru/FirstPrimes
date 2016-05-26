package com.example.shekomaru.wizeproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shekomaru on 5/25/16.
 */
public class RecyclerViewPrimesAdapter extends RecyclerView.Adapter<RecyclerViewPrimesAdapter.PrimeListHolder> {

    ArrayList<Integer> primeList;

    public RecyclerViewPrimesAdapter(ArrayList<Integer> primeList) {
        this.primeList = primeList;
    }

    @Override
    public PrimeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PrimeListHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prime_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(PrimeListHolder holder, int position) {
        holder.primeNumber.setText(String.format("Prime number %d is: %s", position, String.valueOf(primeList.get(position))));
    }

    @Override
    public int getItemCount() {
        return primeList == null ? 0 : primeList.size();
    }

    class PrimeListHolder extends RecyclerView.ViewHolder {
        TextView primeNumber;

        public PrimeListHolder(View itemView) {
            super(itemView);
            primeNumber = (TextView) itemView.findViewById(R.id.tv_main_rv_primes);
        }
    }

}
