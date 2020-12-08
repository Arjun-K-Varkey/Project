package com.project.mymusic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mymusic.model.Music;
import com.project.mymusic.repository.MusicRepository;
import com.project.mymusic.service.exceptions.ObjectNotFoundException;

@Service
public class MusicService {
	@Autowired
	private MusicRepository repo;

	public List<Music> searchAll() {
		 return this.repo.findAll();
		 }
	
	public Music searchById(Long id) {
		Optional<Music> obj = this.repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}

	public Music create(Music obj) {
		return this.repo.save(obj);
	}

	public Music update(Music obj) {
		this.searchById(obj.getId());
		return this.repo.save(obj);
	}
	
	public void delete(Long id) {
		this.searchById(id);
		this.repo.deleteById(id);
	}
	


}