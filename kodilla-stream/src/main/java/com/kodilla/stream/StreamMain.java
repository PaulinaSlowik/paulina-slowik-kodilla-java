package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum theForumUser = new Forum();

        Map<Integer, ForumUser> theResultMapOfUsers = theForumUser.getUserList().stream()
                .filter(user -> user.getSex().equals('M'))
                .filter(user -> user.getDateOfBirth() > LocalDate.now()-20 )
                .filter(user -> user.getNumberOfPostPublished() > 0)
                .collect(Collectors.toMap(ForumUser::getUniqueUserID, user ->user));
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}

