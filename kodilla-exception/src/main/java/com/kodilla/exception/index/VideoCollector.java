package com.kodilla.exception.index;

import java.util.ArrayList;
import java.util.List;

public class VideoCollector {
    //klasę VideoCollector zawiera metodę getCollection zwracającą listę filmów
    public List<String> getCollection() {
        ArrayList<String> videos = new ArrayList<>();
        videos.add("Extra Movie");
        return videos;
    }
}
