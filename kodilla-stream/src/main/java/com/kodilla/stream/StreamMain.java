package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.*;

public class StreamMain {
    public static void main(String[] args) {
        Forum theForumUser = new Forum();

        Map<Integer, ForumUser> theResultMapOfUsers = theForumUser.getUserList().stream()
                .filter(user -> user.getSex()==('M'))
                .filter(user -> user.getDateOfBirth().getYear() < (LocalDate.now().getYear())-20)
                .filter(user -> user.getNumberOfPostPublished() > 0)
                .collect(Collectors.toMap(ForumUser::getUniqueUserID, user ->user));
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}

