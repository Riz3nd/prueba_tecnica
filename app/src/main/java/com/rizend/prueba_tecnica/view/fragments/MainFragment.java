package com.rizend.prueba_tecnica.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rizend.prueba_tecnica.databinding.FragmentMainBinding;
import com.rizend.prueba_tecnica.interfaces.IMainFragment;
import com.rizend.prueba_tecnica.model.usermodel.User;
import com.rizend.prueba_tecnica.presenter.MainFragmentPresenter;

import java.util.ArrayList;

public class MainFragment extends Fragment implements IMainFragment.View {
    private FragmentMainBinding binding;
    private IMainFragment.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new MainFragmentPresenter(this);
        presenter.getAllContacts();
    }

    @Override
    public void showAllContacts(ArrayList<User> users) {
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Nombre: "+users.get(i).getName());
        }
    }
}