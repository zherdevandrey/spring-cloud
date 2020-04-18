package com.example.photoappalbumservice.service;


import com.example.photoappalbumservice.data.AlbumEntity;
import java.util.List;

public interface AlbumsService {
    List<AlbumEntity> getAlbums(String userId);
}
