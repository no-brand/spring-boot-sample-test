package com.nobrand.samplewebtest.controller;

import com.nobrand.samplewebtest.domain.MovieEntry;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class MovieController {

    private static final List<MovieEntry> entries = new ArrayList<>();
    static {
        try {
            entries.add(new MovieEntry(
                    "Iron man",
                    "Iron Man is a 2008 American superhero film based on the Marvel Comics character of the same name",
                    "04/14/2008"));
            entries.add(new MovieEntry(
                    "Captain America: The First Avenger",
                    "Captain America: The First Avenger is a 2011 American superhero film based on the Marvel Comics character Captain America.",
                    "07/19/2011"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/movie/all")
    public List<MovieEntry> getAll() {
        return entries;
    }

    @RequestMapping("movie/findBy/title/{title}")
    public List<MovieEntry> findByTitleContains(@PathVariable String title) {
        return entries
                .stream()
                .filter(entry -> entry.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public MovieEntry add(@RequestBody MovieEntry entry) {
        entries.add(entry);
        return entry;
    }
}
