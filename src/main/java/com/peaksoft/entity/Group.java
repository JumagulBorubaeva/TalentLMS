package com.peaksoft.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_create")
    private String dateOfCreate;
    @Column(name = "date_of_finish")
    private String dateOfFinish;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.MERGE})
            @JoinTable(name = "course_group",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id"))
    List<Course>courses;

    @OneToMany(cascade = CascadeType.ALL)
    List<Student>students;

    @Transient
    private Long courseId;

}
