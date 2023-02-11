package com.rizend.prueba_tecnica.interfaces;

import com.rizend.prueba_tecnica.model.usermodel.User;

import java.util.ArrayList;

public interface IMainFragment {
    interface Interator {
        void getAllContacts();
    }
    interface Presenter {
        void getAllContacts();
        void showAllContacts(ArrayList<User> users);
        void showProgressBar();
        void onFailureConsult();
    }
    interface View {
        void showAllContacts(ArrayList<User> users);
        void showProgressBar();
        void onFailureConsult();
    }
}
