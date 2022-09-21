package com.spring.buysell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.buysell.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
