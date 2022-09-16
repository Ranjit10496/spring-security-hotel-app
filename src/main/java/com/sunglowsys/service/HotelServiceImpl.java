package com.sunglowsys.service;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class HotelServiceImpl implements HotelService{
    private final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel save(Hotel hotel) {
        logger.debug("request to save hotel:{}",hotel);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        logger.debug("request to update hotel:{}",hotel);
        return hotelRepository.save(hotel);
    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        logger.debug("request to findAll hotle");
        return hotelRepository.findAll(pageable);
    }

    @Override
    public Optional<Hotel> findOne(Long id) {
        logger.debug("request to findOne hotel;{}",id);
        return hotelRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        logger.debug("request to delete hotel:{}",id);
        hotelRepository.deleteById(id);

    }
}
