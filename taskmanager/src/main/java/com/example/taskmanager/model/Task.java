package com.example.taskmanager.model;


public class Task {
	private long id;
    private String title;
    private String description;
    private boolean completed;

    public Task() {
    }

    public Task(long id,String title, String description) {
    	this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false; // default to not completed
    }
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id= id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}


