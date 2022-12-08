package com.devsuperior.dslearnbds.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED) // anotação para entitade com herança, InheritanceType.JOINED diz que sera criado uma tabela para cada com chave estrangeira para referenciar
public abstract class Lesson implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToMany
    @JoinTable(
            name = "tb_lesson_done",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id"),
                    @JoinColumn(name = "offer_id")
            } // usado dessa forma pois a tabela de Enrollment é uma tabela composta por 2 chaves, então nesse caso são 3 colunas
    )
    private Set<Enrollment> enrollmentsDone = new HashSet<>();

    @OneToMany(mappedBy = "lesson")
    private List<Deliver> lesson = new ArrayList<>();

    @OneToMany(mappedBy = "lesson")
    private List<Topic> topics = new ArrayList<>();

    public Lesson() {
    }

    public Lesson(Long id, String title, Integer position, Section section) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.section = section;
    }

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<Enrollment> getEnrollmentsDone() {
        return enrollmentsDone;
    }

    public List<Deliver> getLesson() {
        return lesson;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson)) return false;
        Lesson lesson = (Lesson) o;
        return getId().equals(lesson.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
