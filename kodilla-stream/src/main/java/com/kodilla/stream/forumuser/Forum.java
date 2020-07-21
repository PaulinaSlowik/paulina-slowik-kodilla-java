package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    //lista użytkowników
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum(){
        theUserList.add(new ForumUser(001,"Adam Nowak", 'M',
                1988,12,1,12));
        theUserList.add(new ForumUser(002,"Alina Gac", 'F',
                2005,5,12,10));
        theUserList.add(new ForumUser(003,"Jacek Szustak", 'M',
                1992,10,18,0));
        theUserList.add(new ForumUser(004,"Dylan Murphy", 'M',
                1999,11,5,2));
        theUserList.add(new ForumUser(005,"Lucja Kowalska", 'F',
                2008,2,1,8));
        theUserList.add(new ForumUser(006,"Marek Sztos", 'M',
                2010,8,8,19));
        theUserList.add(new ForumUser(007,"Stanisław Szopa", 'M',
                1992,10,31,5));
    }
    //metoda zwracająca kolekcję
    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
