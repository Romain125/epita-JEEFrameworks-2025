package org.example;

import jakarta.persistence.Embeddable;

@Embeddable
public class Title {

    private String originalTitle;
    private String frenchTitle;

    public Title(String originalTitle) {
        this.originalTitle = originalTitle;
        this.frenchTitle = "No translation available";
    }

    public Title(String originalTitle, String frenchTitle) {
        this.originalTitle = originalTitle;
        this.frenchTitle = frenchTitle;
    }

    public Title() {
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getFrenchTitle() {
        return frenchTitle;
    }

    public void setFrenchTitle(String frenchTitle) {
        this.frenchTitle = frenchTitle;
    }

    @Override
    public String toString() {
        return "Title{" +
                "originalTitle='" + originalTitle + '\'' +
                ", frenchTitle='" + frenchTitle + '\'' +
                '}';
    }
}
