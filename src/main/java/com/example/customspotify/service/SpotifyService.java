package com.example.customspotify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.customspotify.model.SpotifyRequest.SimplifiedAlbumObject;
import com.example.customspotify.model.SpotifyRequest.SpotifyKeyRequestReturn;
import com.example.customspotify.model.SpotifyRequest.SpotifySearchReturn;

import reactor.core.publisher.Mono;

@Service
public class SpotifyService {

        @Autowired
        Environment env;

        public SpotifyService() {
        }

        public String getSpotifyAccessToken() {
                WebClient client = WebClient.builder()
                                .baseUrl("https://accounts.spotify.com/api")
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                .build();
                SpotifyKeyRequestReturn keyRequestReturn = client.method(HttpMethod.POST).uri("/token")
                                .bodyValue("grant_type=client_credentials&client_id="
                                                + env.getProperty("spring.spotify.client.id") +
                                                "&client_secret="
                                                + env.getProperty("spring.spotify.client.secret"))
                                .retrieve().bodyToMono(SpotifyKeyRequestReturn.class).block();
                return keyRequestReturn.getAccess_token();
        }

        public SimplifiedAlbumObject[] searchAlbums(String keyword) {
                String accessToken = this.getSpotifyAccessToken();
                WebClient client = WebClient.builder()
                                .baseUrl("https://api.spotify.com/v1")
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                                .build();
                SimplifiedAlbumObject[] albums = client.method(HttpMethod.GET)
                                .uri("/search?q=" + keyword + "&type=album&limit=20")
                                .exchangeToMono(response -> {
                                        if (response.statusCode().equals(HttpStatus.OK)) {
                                                return response.bodyToMono(SpotifySearchReturn.class);
                                        } else
                                                return Mono.error(new Exception("Error"));
                                }).block().getAlbums().getItems();
                return albums;
        }
}
