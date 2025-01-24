package com.ideabazaar.user.userserviceapi.dto;


import java.util.Date;

public class ProjectDTO {

    private Long id;
    private String title;
    private String description;
    private ProjectType projectType;
    private String downloadLinks;
    private String createdBy;
    private Date createdAt;
    private String price;
    private boolean isfree;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public String getDownloadLinks() {
        return downloadLinks;
    }

    public void setDownloadLinks(String downloadLinks) {
        this.downloadLinks = downloadLinks;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isIsfree() {
        return isfree;
    }

    public void setIsfree(boolean isfree) {
        this.isfree = isfree;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
