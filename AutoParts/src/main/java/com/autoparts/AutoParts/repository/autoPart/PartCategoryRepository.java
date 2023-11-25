package com.autoparts.AutoParts.repository.autoPart;

import com.autoparts.AutoParts.entity.autoPart.PartCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartCategoryRepository extends JpaRepository<PartCategory, Long> {
}
