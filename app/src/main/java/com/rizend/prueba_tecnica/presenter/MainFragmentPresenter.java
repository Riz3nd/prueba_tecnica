package com.rizend.prueba_tecnica.presenter;

import com.rizend.prueba_tecnica.interfaces.IMainFragment;
import com.rizend.prueba_tecnica.model.interactors.MainFragmentInteractor;
import com.rizend.prueba_tecnica.model.usermodel.User;

import java.util.ArrayList;

public class MainFragmentPresenter implements IMainFragment.Presenter {
    private IMainFragment.Interator interator;
    private IMainFragment.View view;

    public MainFragmentPresenter(IMainFragment.View view) {
        this.interator = new MainFragmentInteractor(this);
        this.view = view;
    }

    @Override
    public void getAllContacts() {
        interator.getAllContacts();
    }

    @Override
    public void showAllContacts(ArrayList<User> users) {
        view.showAllContacts(users);
    }

}
