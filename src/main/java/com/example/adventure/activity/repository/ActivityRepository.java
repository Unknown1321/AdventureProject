package com.example.adventure.activity.repository;

import com.example.adventure.activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Activity findByName(String name);

    @Query(value = "DELETE * FROM ACTIVITY WHERE ID = ?" +
            "INNER JOIN ",nativeQuery = true)
    void deleteActivity();


    @Modifying
    @Query("DELETE FROM Activity a WHERE a.id = ?1")
    void deleteActivityById(Long id);


}
