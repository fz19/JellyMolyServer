package com.jellymoly.server.service;

public class UserVO {
	private long seq;
	private String name;
	private String profileImage;
	private int age;
	private int sex;
	private String likeSound;
	private int jellyFrequency;
	private int JoinDate;
	
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getLikeSound() {
		return likeSound;
	}
	public void setLikeSound(String likeSound) {
		this.likeSound = likeSound;
	}
	public int getJellyFrequency() {
		return jellyFrequency;
	}
	public void setJellyFrequency(int jellyFrequency) {
		this.jellyFrequency = jellyFrequency;
	}
	public int getJoinDate() {
		return JoinDate;
	}
	public void setJoinDate(int joinDate) {
		JoinDate = joinDate;
	}
}
