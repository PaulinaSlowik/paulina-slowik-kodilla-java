package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class ForumUser {
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(final String username, final String realName,
                     final String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public void addFriend(ForumUser user) {
        friends.add(user);
    }

    public boolean removeFriend(ForumUser user) {
        return friends.remove(user);
    }

    //metoda która zwraca zbiór lokalizacji przyjaciół
    public Set<String> getLocationsOfFriends() {
        //tworzenie strumienia na kolekcji friends(jest to Set zawierający obiekty typu ForumUser)
        return friends.stream()
                //operacja transformująca z wykorzystaniem wyrażenia lambda, friend -> friend.getLocation(), czyli dokonuje zmiany obiektów w strumieniu z ForumUser na obiekty typu String
                .map(friend -> friend.getLocation())
                //tworzona jest kolekcja wynikowa typu Set przy użyciu kolektora strumienia - Collectors.toSet()
                .collect(Collectors.toSet());
    }
    //
    public Set<String> getLocationsOfFriendsOfFriends() {
        //tworzony jest i uruchamiany strumień na kolekcji friends
        return friends.stream()
                //dokonujemy spłaszczenia strumienia - dla każdego przyjaciela (user) pobieramy jego listę przyjaciół (user.getFriends()) i ją przekazujemy do dalszego przetwarzania w postaci nowego strumienia Stream.
                //Od tego momentu pracujemy nie na liście przyjaciół, lecz na liście "przyjaciół przyjaciół".
                .flatMap(user -> user.getFriends().stream())
                //wykluczamy ze zbioru wynikowego odwołania do "samego siebie" - wiadomo, że my też jesteśmy przyjacielem naszych przyjaciół, jednak interesują nas ich lokalizacje, a nie nasza własna.
                .filter(user -> user != this)
                //transformujemy strumień tak, że zamiast obiektów ForumUser, dalej będą już przez niego przepływały jedynie obiekty String będące lokalizacjami użytkowników (pobieramy je przy pomocy metody ForumUser::getLocation)
                .map(ForumUser::getLocation)
                //dokonujemy złożenia strumienia wynikowego w kolekcję typu Set zawierającą listę lokalizacji "przyjaciół przyjaciół"
                //kolekcja Set działa w ten sposób, że nie wstawia duplikatów obiektów. Dany obiekt może istnieć w kolekcji Set co najwyżej jeden raz.
                .collect(Collectors.toSet());
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser)) return false;
        ForumUser forumUser = (ForumUser) o;
        return username.equals(forumUser.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
