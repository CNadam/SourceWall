package net.nashlegend.sourcewall.model;

import java.util.ArrayList;

public class Post extends AceModel {

    private String id = "";
    private String title = "";
    private String url = "";
    private String titleImageUrl = "";
    private boolean authorExists = true;
    private String authorAvatarUrl = "";
    private String author = "";
    private String authorID = "";
    private String groupName = "";
    private String groupID = "";
    private String tag = "";
    private int likeNum = 0;
    private int replyNum = 0;
    private String content = "";
    private String date = "";
    private boolean featured = true;//是否展现在集合列表还是单个小组。true表示展示在单个小组列表中
    private boolean desc = false;

    private ArrayList<UComment> hotComments = new ArrayList<>();
    private ArrayList<UComment> comments = new ArrayList<>();

    public Post() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitleImageUrl() {
        return titleImageUrl;
    }

    public void setTitleImageUrl(String titleImageUrl) {
        this.titleImageUrl = titleImageUrl;
    }

    public String getAuthorAvatarUrl() {
        return authorAvatarUrl;
    }

    public void setAuthorAvatarUrl(String authorAvatarUrl) {
        this.authorAvatarUrl = authorAvatarUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<UComment> getHotComments() {
        return hotComments;
    }

    public void setHotComments(ArrayList<UComment> hotComments) {
        this.hotComments = hotComments;
    }

    public ArrayList<UComment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<UComment> comments) {
        this.comments = comments;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public boolean isAuthorExists() {
        return authorExists;
    }

    public void setAuthorExists(boolean authorExists) {
        this.authorExists = authorExists;
    }

    public boolean isDesc() {
        return desc;
    }

    public void setDesc(boolean desc) {
        this.desc = desc;
    }
}
