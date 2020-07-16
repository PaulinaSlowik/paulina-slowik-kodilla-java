package com.kodilla.testing.forum.statistics;

public class Calculate {
    //korzystam z obiektu statistic?? typu Statistics bez implementacji interfejsu Statistics (jeden pakiet)
    Statistics statistic;

    //pola klasy
    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double postsAveragePerUser;
    private double commentsAveragePerUser;
    private double commentsAveragePerPost;

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


    public Calculate(Statistics statistic) {
        this.statistic = statistic;
    }

    public void calculateAdvStatistics(Statistics statistic){
        usersQuantity = statistic.usersNames().size();
        postsQuantity = statistic.postsCount();
        commentsQuantity = statistic.commentsCount();
        postsAveragePerUser = postsQuantity/usersQuantity;
        commentsAveragePerUser = commentsQuantity/usersQuantity;
        commentsAveragePerPost = commentsQuantity/postsQuantity;
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
