package com.project.mymusic.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.project.mymusic.model.Playlist;
import com.project.mymusic.service.PlaylistService;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {
	@Autowired
	private PlaylistService playlistService;

	@GetMapping
	public String index(Model model) {
		List<Playlist> playlists = playlistService.searchAll();
		model.addAttribute("playlists",playlists);
		return "playlist/index";
	}

	@GetMapping("/addPlaylist")
	public String add(Playlist playlist, Model model) {
		model.addAttribute("playlists",new Playlist());
		return "playlist/addPlaylist";
	}

	

	@GetMapping("/editPlaylist/{id}")
	public String getPlaylistById(@PathVariable("id") Long id, Model model) {
		Playlist playlist = this.playlistService.searchById(id);
		model.addAttribute("playlist", playlist);
		return "playlist/editPlaylist";
	}
	

	@GetMapping("/deletePlaylist/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		this.playlistService.delete(id);
		return index(model);
	}

	@PostMapping("/savePlaylist")
	 public String save(@Valid Playlist playlist, BindingResult result, Model model) {
	if (result.hasErrors()) {
	 return add(playlist, model);
	 }
	if (playlist.getId() != 0) {
	this.playlistService.update(playlist);
	 } else {
	this.playlistService.create(playlist);
	 }
	return index(model);
	 }
	
}