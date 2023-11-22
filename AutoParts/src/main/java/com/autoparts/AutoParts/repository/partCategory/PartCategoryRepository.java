package com.autoparts.AutoParts.repository.partCategory;

import com.autoparts.AutoParts.entity.PartCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartCategoryRepository extends JpaRepository<PartCategory, Long> {
}
