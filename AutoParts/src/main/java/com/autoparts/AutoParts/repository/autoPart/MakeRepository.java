package com.autoparts.AutoParts.repository.autoPart;

import com.autoparts.AutoParts.entity.autoPart.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {
}
