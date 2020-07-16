package com.kodilla.testing.forum.statistics;

public class Calculate {
    //korzystam z obiektu statistic?? typu Statistics bez implementacji interfejsu Statistics (jeden pakiet)
    Statistics statistics;

    //pola klasy
    private int usersQuantity; //liczba użytkowników
    private int postsQuantity; //liczba postów
    private int commentsQuantity; //liczba komentarzy
    private double postsAveragePerUser; //średnia liczba postów na użytkownika
    private double commentsAveragePerUser; //średnia liczba komentarzy na użytkownika
    private double commentsAveragePerPost; //średnia liczba komentarzy na post


    //gettery
    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getPostsAveragePerUser() {
        return postsAveragePerUser;
    }

    public double getCommentsAveragePerUser() {
        return commentsAveragePerUser;
    }

    public double getCommentsAveragePerPost() {
        return commentsAveragePerPost;
    }

    /*public Calculate(int usersQuantity, int postsQuantity, int commentsQuantity, double postsAveragePerUser, double commentsAveragePerUser, double commentsAveragePerPost) {
        this.usersQuantity = usersQuantity;
        this.postsQuantity = postsQuantity;
        this.commentsQuantity = commentsQuantity;
        this.postsAveragePerUser = postsAveragePerUser;
        this.commentsAveragePerUser = commentsAveragePerUser;
        this.commentsAveragePerPost = commentsAveragePerPost;
    }*/
    public Calculate(Statistics statistics){
        this.statistics = statistics;
    }

    public Statistics calculateAdvStatistics(Statistics statistics){
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        postsAveragePerUser = postsQuantity/usersQuantity;
        commentsAveragePerUser = commentsQuantity/usersQuantity;
        commentsAveragePerPost = commentsQuantity/postsQuantity;
        return statistics;
    }
    public void showStatistics(){
        System.out.println("Forum statistics:");
        System.out.println("Users quantity: " + usersQuantity);
        System.out.println("Posts quantity: " + postsQuantity);
        System.out.println("Comments quantity: " + commentsQuantity);
        System.out.println("Posts average per user: " + postsAveragePerUser);
        System.out.println("Comments average per user: " + commentsAveragePerUser);
        System.out.println("Comments average per post: " + commentsAveragePerPost);
    }
}
