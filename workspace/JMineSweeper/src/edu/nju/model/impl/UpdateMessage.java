package edu.nju.model.impl;

import java.io.Serializable;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import edu.nju.network.Player;

public class UpdateMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private Object value;
	private Player player;
	public UpdateMessage(String key, Object value,Player player) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player){
		this.player=player;
	}
}
