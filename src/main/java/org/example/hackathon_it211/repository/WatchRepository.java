package org.example.hackathon_it211.repository;

import org.example.hackathon_it211.entity.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Long> {

    Page<Watch> findAllByDeletedFalse(Pageable pageable);

    Optional<Watch> findByIdAndDeletedFalse(Long id);

}
