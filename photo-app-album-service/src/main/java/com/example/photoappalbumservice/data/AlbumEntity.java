
package com.example.photoappalbumservice.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumEntity {
    private long id;
    private String albumId;
    private String userId; 
    private String name;
    private String description;
}
