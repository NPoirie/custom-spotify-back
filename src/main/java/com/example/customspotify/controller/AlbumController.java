package com.example.customspotify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.customspotify.model.AlbumSearchBody;
import com.example.customspotify.model.SpotifyRequest.SimplifiedAlbumObject;
import com.example.customspotify.service.SpotifyService;

@Controller
@RequestMapping(path = "/api/")
public class AlbumController {

    public final SpotifyService spotifyService;

    @Autowired
    public AlbumController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @CrossOrigin
    @PostMapping("/albums")
    @ResponseBody
    public SimplifiedAlbumObject[] searchAlbums(@RequestBody AlbumSearchBody keyword) {
        return spotifyService.searchAlbums(keyword.getSearch());
    }
}
