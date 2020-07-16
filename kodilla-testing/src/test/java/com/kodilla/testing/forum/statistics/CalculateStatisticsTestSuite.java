package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateStatisticsTestSuite {
    @Test
    public void testPostsQuantityIsZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> forumUsers = new ArrayList<String>();
        for (int i =0; i<100; i++){
            forumUsers.add("Users"+i);
        }

        int posts = 0;
        int comments = 100;
        when(statisticsMock.usersNames()).thenReturn(forumUsers);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        int forumHasPosts = calculate.getPostsQuantity();
        //Then
        Assert.assertEquals(0,forumHasPosts);
    }
    @Test
    public void testPostsQuantityIsThousand(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> forumUsers = new ArrayList<String>();
        for (int i =0; i<100; i++){
            forumUsers.add("Users"+i);
        }

        int posts = 1000;
        int comments = 100;
        when(statisticsMock.usersNames()).thenReturn(forumUsers);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        calculate.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(1000,calculate.getPostsQuantity());
    }
    @Test
    public void testCommentQuantityIsZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> forumUsers = new ArrayList<String>();
        for (int i =0; i<100; i++){
            forumUsers.add("Users"+i);
        }
        int posts = 1000;
        int comments = 0;
        when(statisticsMock.usersNames()).thenReturn(forumUsers);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        calculate.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0,calculate.getCommentsQuantity());
    }
    @Test
    public void testCommentsQuantityLessThanPostsQuantity(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> forumUsers = new ArrayList<String>();
        for (int i =0; i<100; i++){
            forumUsers.add("Users"+i);
        }
        int posts = 1000;
        int comments = 100;
        when(statisticsMock.usersNames()).thenReturn(forumUsers);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        calculate.calculateAdvStatistics(statisticsMock);
        double commentsAveragePerPost = calculate.getCommentsAveragePerPost();
        double expectedCalculate = 0.1;
        //Calculate expectedCalculate = new Calculate(100,150,500,150/100.0,500/100.0,500/150.0);
        //Then
        Assert.assertEquals(expectedCalculate,commentsAveragePerPost, 0.1);
    }
    @Test
    public void testCommentsQuantityMoreThanPostsQuantity(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> forumUsers = new ArrayList<String>();
        for (int i =0; i<100; i++){
            forumUsers.add("Users"+i);
        }
        int posts = 100;
        int comments = 1000;
        when(statisticsMock.usersNames()).thenReturn(forumUsers);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        calculate.calculateAdvStatistics(statisticsMock);
        double commentsAveragePerPost = calculate.getCommentsAveragePerPost();
        double expectedCalculate = 10;
        //Calculate expectedCalculate = new Calculate(100,500,150,500/100.0,150/100.0,150/500.0);
        //Then
        Assert.assertEquals(expectedCalculate,commentsAveragePerPost,0.01);
    }
    @Test
    public void testUserQuantityIsZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> forumUsers = new ArrayList<String>();

        int posts = 500;
        int comments = 1000;
        when(statisticsMock.usersNames()).thenReturn(forumUsers);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        int forumHasUsers = calculate.getUsersQuantity();
        //Then
        Assert.assertEquals(0,forumHasUsers);
    }
    @Test
    public void testUserQuantityIsHundred(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> forumUsers = new ArrayList<String>();
        for (int i =0; i<100; i++){
            forumUsers.add("Users"+i);
        }

        int posts = 500;
        int comments = 100;
        when(statisticsMock.usersNames()).thenReturn(forumUsers);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        calculate.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(100,calculate.getUsersQuantity());
    }
}
