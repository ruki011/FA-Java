package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Question extends AuditModel {
    @Id
    @GeneratedValue(generator = "quetion_generator")
    @SequenceGenerator(
            name = "quetion_generator",
            sequenceName = "Question_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    public Long getId(){
        return id;
    }


    public void  setDescription(String description){
        this.description =description;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
