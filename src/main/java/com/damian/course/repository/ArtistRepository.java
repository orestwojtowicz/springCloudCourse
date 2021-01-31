package com.damian.course.repository;

import com.damian.course.domain.Artist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Damian Wójtowicz
 * @project course
 * @date 30.01.2021
 */

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {




    List<Artist> findByLastName(String lastName, Pageable pageable);


    @Query(value =
            "SELECT * FROM ARTIST a WHERE a.last_name = ?1"
            , nativeQuery = true)
    Artist getArtist(String lastName);



// findByLastNameAndFirstNameIsNotLikeAllIgnoreCase()
    // findStudentWithNameMarian();

}
