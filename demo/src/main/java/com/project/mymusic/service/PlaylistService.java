package com.project.mymusic.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.mymusic.model.Playlist;
import com.project.mymusic.repository.PlaylistRepository;
import com.project.mymusic.service.exceptions.ObjectNotFoundException;

@Service
public class PlaylistService {
	@Autowired
	private PlaylistRepository repo;

	public List<Playlist> searchAll() {
		return this.repo.findAll();
	}

	public Playlist searchById(Long id) {
		Optional<Playlist> obj = this.repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}

	public Playlist create(Playlist obj) {
		return this.repo.save(obj);
	}

	public Playlist update(Playlist obj) {
		this.searchById(obj.getId());
		return this.repo.save(obj);
	}

	public void delete(Long id) {
		this.searchById(id);
		this.repo.deleteById(id);
	}
}