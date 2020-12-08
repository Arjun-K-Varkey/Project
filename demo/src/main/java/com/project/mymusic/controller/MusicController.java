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
import com.project.mymusic.model.Music;
import com.project.mymusic.model.Playlist;
import com.project.mymusic.service.MusicService;
import com.project.mymusic.service.PlaylistService;

@Controller
@RequestMapping("/musics")
public class MusicController {
	@Autowired
	private MusicService musicService;

	@Autowired
	private PlaylistService playlistService;

	@RequestMapping("/")
	public String index(Model model) {
		List<Music> musics = musicService.searchAll();
		model.addAttribute("musics", musics);
		return "music/index";
	}

	@GetMapping("/addMusic")
	public String add(Music music, Model model) {
		model.addAttribute("musics", new Music());
		return "music/addMusic";
	}

	@GetMapping("/editMusic/{id}")
	public String getMusicById(@PathVariable("id") Long id, Model model) {
		Music music = this.musicService.searchById(id);
		model.addAttribute("music", music);
		return "music/editMusic";
	}

	@GetMapping("/deleteMusic/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		this.musicService.delete(id);
		List<Playlist> playlists = playlistService.searchAll();
		model.addAttribute("playlists", playlists);
		return "playlist/index";
	}

	@PostMapping("/saveMusic")
	public String save(@Valid Music music, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return add(music, model);
		}
		if (music.getId() != 0) {
			this.musicService.update(music);
		} else {
			this.musicService.create(music);
		}
		return index(model);
	}

}