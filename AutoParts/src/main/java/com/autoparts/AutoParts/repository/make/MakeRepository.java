package com.autoparts.AutoParts.repository.make;

import com.autoparts.AutoParts.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {
}
