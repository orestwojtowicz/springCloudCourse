package com.damian.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Slf4j
@Component
@Transactional
public class LoadData implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

    }

    private void createArtists() {

}



}
