package com.project.mymusic.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Music {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String time;
	private String singer;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playlist_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Playlist playlist;
	
	
	public Music() {
	}

	public Music(long id, String name, String time, String singer, Playlist playlist) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.singer = singer;
		this.playlist = playlist;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	 @Override
	    public String toString() {
	        return "MusicEntity [id=" + id + ", name=" + name + 
	                ", singer=" + singer + ", time=" + time   + "]";
	    }
}