package com.example.shekomaru.wizeproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView primesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primesRecyclerView = (RecyclerView) findViewById(R.id.rv_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        primesRecyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewPrimesAdapter adapter = new RecyclerViewPrimesAdapter(new ArrayList<Integer>());

        primesRecyclerView.setAdapter(adapter);

        findViewById(R.id.bt_main_show_primes).setOnClickListener(this);
    }

    /**
     * @param n
     * @return
     */
    public static ArrayList<Integer> getPrimeNumbers(int n) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        int lastPrime = 1;
        for (int i = 0; i < n; i++) {
            lastPrime = getNextPrime(lastPrime);
            primeNumbers.add(lastPrime);
        }

        return primeNumbers;
    }

    private static int getNextPrime(int n) {
        for (int i = n + 1; ; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_main_show_primes:

                EditText primesQuantity = (EditText) findViewById(R.id.et_main_prime_cuantity);
                String primeInput = primesQuantity.getText().toString();
                if (primeInput.equals("")) {
                    primesQuantity.setError("Debes ingresar un número para poder mostrar los números primos");
                } else {
                    Integer primes = Integer.valueOf(primeInput);
                    primesRecyclerView.setAdapter(new RecyclerViewPrimesAdapter(getPrimeNumbers(primes)));
                }

                break;
        }
    }
}
