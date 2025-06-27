
public class Notes {
  private String id;
  private String title;
  private String content;
  private String dateCreated;
  private String dateModified;

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getDateCreated() {
    return dateCreated;
  }

  public String getDateModified() {
    return dateModified;
  }

  public Notes(Builder builder) {
    this.id = builder.id;
    this.title = builder.title;
    this.content = builder.content;
    this.dateCreated = builder.dateCreated;
    this.dateModified = builder.dateModified;
  }

  public static class Builder {
    private String id;
    private String title;
    private String content;
    private String dateCreated;
    private String dateModified;

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder setContent(String content) {
      this.content = content;
      return this;
    }

    public Builder setDateCreated(String dateCreated) {
      this.dateCreated = dateCreated;
      return this;
    }

    public Builder setDateModified(String dateModified) {
      this.dateModified = dateModified;
      return this;
    }

    public Notes build() {
      return new Notes(this);
    }
  }

}
