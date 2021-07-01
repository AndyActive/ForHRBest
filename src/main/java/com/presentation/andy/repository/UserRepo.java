package com.presentation.andy.repository;

import com.presentation.andy.model.Worker;
import com.presentation.andy.projects.Projects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Worker,Long> {
//    @Query("select u from Worker u where "
//            + "(:name is not null and u.name like concat('%', :name, '%') or :name is null) "
//            + "and (:completedTasks is not null and u.completedTasks like concat('%', :completedTasks, '%') or :completedTasks is null) "
//            + "and (:outstandingTasks is not null and u.outstandingTasks like concat('%', :outstandingTasks, '%') or :outstandingTasks is null) "
//            + "and (:workProjects is not null and u.workProjects like :workProjects or :workProjects is null) "
//            + "and (:online is not null and u.online = :online or :online is null) "
//            + "and (:salary is not null and u.salary >= :salary or :salary is null) ")
//
//
//    Page<Worker> findAllByParams(
//            @Param("name") String name,
//            @Param("salary") Integer salary,
//            @Param("completedTasks") String completedTasks,
//            @Param("outstandingTasks") String outstandingTasks,
//            @Param("workProjects") Projects workProjects,
//            @Param("online") Boolean online
//            );
//
////    @Override
////    Page<Worker> findAll(Pageable pageable);
//
//    @Query("select count(u) from Worker u where "
//            + "(:name is not null and u.name like concat('%', :name, '%') or :name is null) "
//            + "and (:completedTasks is not null and u.completedTasks like concat('%', :completedTasks, '%') or :completedTasks is null) "
//            + "and (:outstandingTasks is not null and u.outstandingTasks like concat('%', :outstandingTasks, '%') or :outstandingTasks is null) "
//            + "and (:workProjects is not null and u.workProjects like :workProjects or :workProjects is null) "
//            + "and (:online is not null and u.online = :online or :online is null) "
//            + "and (:salary is not null and u.salary >= :salary or :salary is null) ")
//
////    int countByParams(
////            @Param("name") String name,
////            @Param("salary") Integer salary,
////            @Param("completedTasks") String completedTasks,
////            @Param("outstandingTasks") String outstandingTasks,
////            @Param("workProjects") Projects workProjects,
////            @Param("online") Boolean online
////    );


}
