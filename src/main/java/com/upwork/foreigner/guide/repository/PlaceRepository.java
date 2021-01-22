package com.upwork.foreigner.guide.repository;

import com.upwork.foreigner.guide.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByNameAndType(final String name, final String type);
}
