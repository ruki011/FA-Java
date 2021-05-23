package com.example.demo.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="S_STATUS_2")
@NoArgsConstructor
@Data
public class StatusTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rowId;

    @Column(nullable = false)
    private String name;

    @ManyToOne()
    @JoinColumn(name="status_id", nullable = false)
    private Status status;
}
