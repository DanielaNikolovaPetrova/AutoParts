package com.autoparts.AutoParts.repository.autoPart;

import com.autoparts.AutoParts.entity.autoPart.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
