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
        ForumPost thePost = new ForumPost(postBody, author);
        posts.add(thePost);
    }

    public void addComment(ForumPost thePost, String author, String commentBody){ //metodę pozwalającą na dodawanie komentarzy, które zostały wystawione przez użytkownika
        ForumComment theComment = new ForumComment(thePost, commentBody, author);
        comments.add(theComment);
    }
    //metody do odczytu wszystkich pól (gettery)
    public int getPostsQuantity(){
        return posts.size();
    }

    public int getCommentsQuantity(){
        return comments.size();
    }

    public ForumPost getPost(int postNumber){
        ForumPost thePost = null;
        if (postNumber >= 0 && postNumber < posts.size()) {
            thePost = posts.get(postNumber);
        }
        return thePost;
    }

    public ForumComment getComment(int commentNumber){
        ForumComment theComment = null;
        if (commentNumber >= 0 && commentNumber < comments.size()){
            theComment = comments.get(commentNumber);
        }
        return theComment;
    }
    //metody pozwalające na usunięcie wybranych postów i komentarzy
    public boolean removePost(ForumPost thePost){
        boolean result = false;
        if (posts.contains(thePost)){
            posts.remove(thePost);
            result = true;
        }
        return result;
    }

    public boolean removeComment(ForumComment theComment){
        boolean result = false;
        if (comments.contains(theComment)){
            comments.remove(theComment);
            result = true;
        }
        return result;
    }

    public String getName() {

        return name;
    }

    public String getRealName() {

        return realName;
    }
}
