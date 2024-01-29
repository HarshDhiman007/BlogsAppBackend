package com.blogs.dashboard.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class dashboardModel {
   @Id
   private String id;
   private String author;
   private String description;
   private String title;
   private String content;
   private String dob;
   private String imgName;

   public dashboardModel() {
      super();
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public boolean equals(Object obj) {
      return super.equals(obj);
   }

   @Override
   protected Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   @Override
   protected void finalize() throws Throwable {
      super.finalize();
   }

   public dashboardModel(String id, String author, String description, String title, String content, String dob, String imgName) {
      this.id = id;
      this.author = author;
      this.description = description;
      this.title = title;
      this.content = content;
      this.dob = dob;
      this.imgName = imgName;
   }

   @Override
   public String toString() {
      return "dashboardModel{" +
              "id=" + id +
              ", author='" + author + '\'' +
              ", description='" + description + '\'' +
              ", title='" + title + '\'' +
              ", content='" + content + '\'' +
              ", dob='" + dob + '\'' +
              ", imgName='" + imgName + '\'' +
              '}';
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getDob() {
      return dob;
   }

   public void setDob(String dob) {
      this.dob = dob;
   }

   public String getImgName() {
      return imgName;
   }

   public void setImgName(String imgName) {
      this.imgName = imgName;
   }
}