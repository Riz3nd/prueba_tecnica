package com.rizend.prueba_tecnica.view.fragments;

import static com.rizend.prueba_tecnica.view.MainActivity.actionBar;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rizend.prueba_tecnica.R;
import com.rizend.prueba_tecnica.databinding.FragmentMainBinding;
import com.rizend.prueba_tecnica.interfaces.IMainFragment;
import com.rizend.prueba_tecnica.model.usermodel.User;
import com.rizend.prueba_tecnica.presenter.MainFragmentPresenter;
import com.rizend.prueba_tecnica.utils.Utils;
import com.rizend.prueba_tecnica.view.UserAdapter;

import java.util.ArrayList;

public class MainFragment extends Fragment implements IMainFragment.View, SearchView.OnQueryTextListener {
    private FragmentMainBinding binding;
    private IMainFragment.Presenter presenter;
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private Handler handler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
        initComponents();
    }

    private void initComponents(){
        actionBar.show();
        actionBar.setTitle(R.string.user_list);
        recyclerView = binding.recyclerUsers;
        presenter = new MainFragmentPresenter(this);
        presenter.getAllContacts();
    }

    @Override
    public void showAllContacts(ArrayList<User> users) {
            adapter = new UserAdapter(binding.getRoot().getContext(), users);
            recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
            recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailureConsult() {
        binding.progressBar.setVisibility(View.GONE);
        binding.animation.setVisibility(View.VISIBLE);
        if(!Utils.isOnline(getContext())) {
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(Utils.isOnline(getContext())) {
                        presenter.getAllContacts();
                        binding.progressBar.setVisibility(View.VISIBLE);
                        binding.animation.setVisibility(View.GONE);
                    } else
                        handler.postDelayed( this,500);
                }
            }, 500);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem buscador = menu.findItem(R.id.action_search);
        SearchView searchView1 = (SearchView) MenuItemCompat.getActionView(buscador);
        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });
    }



}