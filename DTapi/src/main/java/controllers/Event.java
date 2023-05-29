package controllers;

public class Event {
    private String uid;
    private String name;
    private String tagline;
    private String schedule;
    private String description;
    private String moderator;
    private String category;
    private String subCategory;
    private int rigorRank;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModerator() {
		return moderator;
	}
	public void setModerator(String moderator) {
		this.moderator = moderator;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public int getRigorRank() {
		return rigorRank;
	}
	public void setRigorRank(int rigorRank) {
		this.rigorRank = rigorRank;
	}
	public Event(String uid, String name, String tagline, String schedule, String description, String moderator,
			String category, String subCategory, int rigorRank) {
		super();
		this.uid = uid;
		this.name = name;
		this.tagline = tagline;
		this.schedule = schedule;
		this.description = description;
		this.moderator = moderator;
		this.category = category;
		this.subCategory = subCategory;
		this.rigorRank = rigorRank;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
   
    
}
