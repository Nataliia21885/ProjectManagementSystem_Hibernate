package model.dao;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "skills")
public class SkillDao {
    Integer id;
    String language;
    String level;
    Set<DeveloperDao> developers;

    public SkillDao(Integer id, String language, String level) {
        this.id = id;
        this.language = language;
        this.level = level;
    }

    public SkillDao(String language, String level) {
        this.language = language;
        this.level = level;
    }

    public SkillDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "language", length = 50)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name = "level", length = 20)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @ManyToMany
    @JoinTable(
            name = "developers_skills",
            joinColumns = {@JoinColumn(name = "skill_id")},
            inverseJoinColumns = {@JoinColumn(name = "developer_id")}
    )
    public Set<DeveloperDao> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<DeveloperDao> developers) {
        this.developers = developers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillDao skillDao = (SkillDao) o;
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