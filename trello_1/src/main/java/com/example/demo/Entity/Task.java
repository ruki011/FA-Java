package com.example.demo.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@Table(name = "S_TASKS")
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    private String title;
    private String body;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "developer_id", nullable = true)
    private User developer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "analyst_id", nullable = true)
    private User analyst;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tester_id", nullable = true)
    private User tester;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = true)
    private StatusTask statusTask;



}

