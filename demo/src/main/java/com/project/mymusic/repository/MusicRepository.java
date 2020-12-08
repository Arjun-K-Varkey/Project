package com.project.mymusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.mymusic.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
}