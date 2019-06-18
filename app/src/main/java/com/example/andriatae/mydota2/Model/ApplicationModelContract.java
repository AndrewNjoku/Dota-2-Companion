package com.example.andriatae.mydota2.Model;


import java.util.Map;

public interface ApplicationModelContract {

    //get users for listing in the main scree
    Map <String, Integer> getUsers();

    //get hero information for listing in the hero list screen
    void getHeroes();
}
