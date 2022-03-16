package com.cognizant.challenge.repository;

import com.cognizant.challenge.entity.Solution;
import com.cognizant.challenge.enums.SolutionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution,Long> {

    List<Solution> findTop3ByStatusOrderByCpuTimeAscMemoryAsc(SolutionStatus status);

    @Query(value = "select   *  from solution where user_name  in (select  top 3 distinct a.user_name from ( select  *  from solution order by cpu_time, memory ) a) AND status ='SUCCESS'  order by cpu_time, memory",nativeQuery = true)
    List<Solution> findAllByUserNameInAndStatusOrderByCpuTimeAscMemoryAsc();

}
