package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {
    private String name; //pole z nazwą użytkownika
    private String realName; //pole z rzeczywistą nazwą (imię i nazwisko) użytkownika
    private ArrayList<ForumPost> posts = new ArrayList<ForumPost>(); //pole będące kolekcją opublikowanych postów
    private LinkedList<ForumComment> comments = new LinkedList<ForumComment>(); //pole będące kolekcją opublikowanych komentarzy pod postami

    public ForumUser(String name, String realName) { //konstruktor inicjujący nazwę użytkownika widoczną na forum oraz rzeczywistą nazwę użytkownika
        //name visible on forum
        this.name = name;
        //real name of the user
        this.realName = realName;
    }

    public void addPost(String author, String postBody){ //metodę pozwalającą na dodawanie postów, które zostały opublikowane przez użytkownika
        // do nothing
    }

    public void addComment(ForumPost thePost, String author, String commentBody){ //metodę pozwalającą na dodawanie komentarzy, które zostały wystawione przez użytkownika
        // do nothing
    }
    //metody do odczytu wszystkich pól (gettery)
    public int getPostsQuantity(){
        // return 100 temporarily
        return 100;
    }

    public int getCommentsQuantity(){
        // return 100 temporarily
        return 100;
    }

    public ForumPost getPost(int postNumber){
        // returning null means that the operation was unsuccessful
        return null;
    }

    public ForumComment getComment(int commentNumber){
        // returning null means that the operation was unsuccessful
        return null;
    }
    //metody pozwalające na usunięcie wybranych postów i komentarzy
    public boolean removePost(ForumPost thePost){
        // return true temporarily
        return true;
    }

    public boolean removeComment(ForumComment theComment){
        // return true temporarily
        return true;
    }

    public String getName() {

        return name;
    }

    public String getRealName() {

        return realName;
    }
}
