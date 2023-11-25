package com.autoparts.AutoParts.repository.autoPart;

import com.autoparts.AutoParts.entity.autoPart.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository <Part, Long> {
}
