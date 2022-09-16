package com.sunglowsys.resource;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelResource {
    private final Logger logger = LoggerFactory.getLogger(HotelResource.class);
    private final HotelService hotelService;

    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @PostMapping("/hotels")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        logger.debug("request to save hotel:{}",hotel);
        Hotel result = hotelService.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/hotels")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
        logger.debug("request to update hotel:{}",hotel);
        if (hotel.getId()==null){
            throw new RuntimeException("it not be must null");
        }
        Hotel result = hotelService.update(hotel);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/hotels")
    public ResponseEntity<Page<Hotel>> findAll(Pageable pageable) {
        logger.debug("request to findAll hotel:{}",pageable);
        Page<Hotel> result = hotelService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/hotels/{id}")
    public ResponseEntity<Optional<Hotel>> findOne(@PathVariable Long id){
        logger.debug("request to findOne hotel:{}",id);
        Optional<Hotel> result = hotelService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        logger.debug("request to delete hotel:{}",id);
        hotelService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
