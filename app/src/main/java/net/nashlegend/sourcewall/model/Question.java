package net.nashlegend.sourcewall.model;

import android.text.TextUtils;

/**
 * Created by NashLegend on 2014/9/16 0016
 */
public class Question extends AceModel {

    private String id = "";
    private String title = "";
    private String url = "";
    private String authorAvatarUrl = "";
    private String author = "";
    private String authorID = "";
    private String tag = "";
    private String content = "";
    private String date = "";
    private String summary = "";
    private boolean answerable = true;
    private boolean featured = false;//热门、精彩
    private int commentNum = 0;
    private int recommendNum = 0;
    private int followNum = 0;
    private int answerNum = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        if (TextUtils.isEmpty(title)) {
            url = "科学人--果壳网";
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        if (!TextUtils.isEmpty(id) && TextUtils.isEmpty(url)) {
            url = "http://www.guokr.com/question/" + id + "/";
        }
        return url;
    }

    public void setUrl(String url) {
        if (url != null && url.startsWith("http://m.guokr.com")) {
            url.replace("http://m.guokr.com", "http://www.guokr.com");
        }
        this.url = url;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public boolean isAnswerable() {
        return answerable;
    }

    public void setAnswerable(boolean answerable) {
        this.answerable = answerable;
    }

    public int getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(int recommendNum) {
        this.recommendNum = recommendNum;
    }

    public int getFollowNum() {
        return followNum;
    }

    public void setFollowNum(int followNum) {
        this.followNum = followNum;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getSummary() {
        if (TextUtils.isEmpty(summary)) {
            summary = getTitle();
        }
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
}
