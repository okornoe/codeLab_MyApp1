package com.t.myapp1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FirstFragment extends Fragment {

    private String mOrderMessage;
    private static final String EXTRA_MESSAGE = "com.t.myappp1.extra.MESSAGE";
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        view.findViewById(R.id.donut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOrderMessage = getString(R.string.donut_order_message);
                displayToast(R.string.donut_order_message);
                passMessage(mOrderMessage);
            }
        });

        view.findViewById(R.id.ice_cream).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOrderMessage = getString(R.string.ice_cream_order_message);
                displayToast(R.string.ice_cream_order_message);
                passMessage(mOrderMessage);
            }
        });

        view.findViewById(R.id.froyo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOrderMessage = getString(R.string.froyo_order_message);
                displayToast(R.string.froyo_order_message);
                passMessage(mOrderMessage);
            }
        });

    }

    public void displayToast(int message) {
        Toast.makeText(getActivity(), message,
                Toast.LENGTH_SHORT).show();
    }

    private void passMessage(String message) {
        SecondFragment secondFragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(SecondFragment.DATA_RECEIVE, message);
        secondFragment.setArguments(args);
        getParentFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment,secondFragment)
                .commit();
    }
}