package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int uniqueUserID;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int numberOfPostPublished;

    public ForumUser(final int uniqueUserID, final String userName, final char sex, final int yearOfBirth, final int monthOfBirth, final int dayOfBirth,final int numberOfPostPublished) {
        this.uniqueUserID = uniqueUserID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(yearOfBirth,monthOfBirth,dayOfBirth);
        this.numberOfPostPublished = numberOfPostPublished;
    }

    public int getUniqueUserID() {
        return uniqueUserID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPostPublished() {
        return numberOfPostPublished;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "uniqueUserID=" + uniqueUserID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPostPublished=" + numberOfPostPublished +
                '}';
    }
}
