package com.springboot.springtest.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;



}
