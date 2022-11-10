package model.dto;

import java.util.Objects;

public class SkillDto {
    Integer id;
    String language;
    String level;

    public SkillDto(Integer id, String language, String level) {
        this.id = id;
        this.language = language;
        this.level = level;
    }

    public SkillDto(String language, String level) {
        this.language = language;
        this.level = level;
    }

    public SkillDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillDto skillDao = (SkillDto) o;
        return Objects.equals(language, skillDao.language) && Objects.equals(level, skillDao.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, level);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "language = '" + language + '\'' +
                ", level = '" + level + '\'' +
                '}';
    }
}

