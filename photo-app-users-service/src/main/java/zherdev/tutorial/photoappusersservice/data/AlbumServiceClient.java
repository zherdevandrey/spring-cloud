package zherdev.tutorial.photoappusersservice.data;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zherdev.tutorial.photoappusersservice.ui.model.AlbumsResponseModel;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "ALBUMS-WS", fallbackFactory = AlbumFallBackFactory.class)
public interface AlbumServiceClient {

    @GetMapping("/users/{id}/albumss")
    List<AlbumsResponseModel> userAlbums(@PathVariable String id);

}

@Component
class AlbumFallBackFactory implements FallbackFactory<AlbumServiceClient>{

    @Override
    public AlbumServiceClient create(Throwable throwable) {
        return new AlbumServiceClientFallBack(throwable);
    }
}

@AllArgsConstructor
@Slf4j
class AlbumServiceClientFallBack implements AlbumServiceClient{

    private Throwable error;

    @Override
    public List<AlbumsResponseModel> userAlbums(String id) {
        if (error instanceof FeignException && ((FeignException)error).status() == 404){
            log.error("error during album service call. " + error.getMessage());
        }
        else {
            log.error("error: " + error.getMessage());
        }
        return new ArrayList<>();
    }
}



//@Component
//@Slf4j
//class AlbumServiceClientFallBack implements AlbumServiceClient{
//    @Override
//    public List<AlbumsResponseModel> userAlbums(String id) {
//        log.debug("fall back method was called");
//        return new ArrayList<>();
//    }
//}
