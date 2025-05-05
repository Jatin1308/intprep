package com.streamwikimedia.repository;

import com.streamwikimedia.entity.WikiMediaDataEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMediaDataRepo extends JpaRepository<WikiMediaDataEntity, Long> {

}
