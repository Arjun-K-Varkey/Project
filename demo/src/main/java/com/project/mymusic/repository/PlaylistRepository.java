package com.project.mymusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mymusic.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}