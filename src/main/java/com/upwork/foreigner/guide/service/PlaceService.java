package com.upwork.foreigner.guide.service;

import com.upwork.foreigner.guide.crypto.CaesarCipherEncrypt;
import com.upwork.foreigner.guide.dto.PlaceDTO;
import com.upwork.foreigner.guide.exception.PlaceNotFoundException;
import com.upwork.foreigner.guide.model.Place;
import com.upwork.foreigner.guide.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final ModelMapper modelMapper;
    private final PlaceRepository placeRepository;
    private final CaesarCipherEncrypt caesarCipherEncrypt;

    @Transactional
    public void save(final PlaceDTO placeDTO) {
        final Place place = modelMapper.map(placeDTO, Place.class);
        caesarCipherEncrypt.encrypt(place);
        placeRepository.save(place);
    }

    @Transactional(readOnly = true)
    public PlaceDTO findByNameAndType(final String name, final String type) throws PlaceNotFoundException {
        final Place place = placeRepository.findByNameAndType(caesarCipherEncrypt.encrypt(name), caesarCipherEncrypt.encrypt(type));
        if (place == null) {
            throw new PlaceNotFoundException("Place not found with given name and type");
        }
        caesarCipherEncrypt.decrypt(place);
        return modelMapper.map(place, PlaceDTO.class);
    }
}
