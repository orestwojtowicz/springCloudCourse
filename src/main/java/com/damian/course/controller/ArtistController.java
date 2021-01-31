package com.damian.course.controller;


import com.damian.course.domain.Artist;
import com.damian.course.repository.ArtistRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author Damian Wójtowicz
 * @project course
 * @date 30.01.2021
 */

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistRepository artistRepository;


    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @GetMapping
    public List<Artist> getArtists() {
        return artistRepository.findAll();

    }

    @PostMapping
    public Artist addStudent(@RequestBody @Valid Artist artist) {
        return artistRepository.save(artist);
    }
/*
    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtist(@PathVariable Long id) {
         Optional<Artist> artistOptional = artistRepository.findById(id);

         if (artistOptional.isPresent()) {
             return ResponseEntity.ok(artistOptional.get());
         } else {
             return ResponseEntity.notFound().build();
         }
    }*/



    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Artist> getArtist(@PathVariable Long id) {
        return artistRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
        // .map(artist -> ResponseEntity.ok(artist)).orElse(ResponseEntity.notFound().build())
    }




    @PostMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @Valid @RequestBody Artist artist) {
        Optional<Artist> foundArtist = artistRepository.findById(id);
        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        return artistRepository.findById(id)
                .map(artist ->{
                     artistRepository.delete(artist);
                     return ResponseEntity.ok().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/artist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable Long id) {
        try {
            artistRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e) {

        }
   }


   /*
   * Jesli nie istnieje to stworz a jesli istnieje to aktualizuj caly obiekt
   *
   *
   * */


    @PutMapping
    public ResponseEntity<Artist> addOrUpdateArtist(@RequestBody @Valid  Artist artist) {
        return ResponseEntity.ok().body(artistRepository.save(artist));
    }


   @PutMapping("/{id}")
   public ResponseEntity<Artist> addArtist(@RequestBody @Valid  Artist artist, Long id) {

    return artistRepository.findById(id)
            .map(artistFromDb -> {
                artistFromDb.setEmail(artist.getEmail());
                return ResponseEntity.ok().body(artistRepository.save(artistFromDb));
            }).orElseGet(() -> ResponseEntity.notFound().build());
   }



    @PatchMapping("/{id}")
    public ResponseEntity<Artist> patchArtist(@RequestBody @Valid  Artist artist, Long id) {

        return artistRepository.findById(id)
                .map(artistFromDb -> {
                    if (StringUtils.isEmpty(artist.getFirstName())) {
                        artistFromDb.setEmail(artist.getEmail());
                        return ResponseEntity.ok().body(artistRepository.save(artistFromDb));
                    }
                  return null;
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }



}

// orElse wykonuje sie zawsze czy istnieje czy nie istnieje
// orElseGet( ()) wykonuje sie tylko wtedy, kiedy optional jest pusty
// @Valid sprawdza dnotacje w encji



















