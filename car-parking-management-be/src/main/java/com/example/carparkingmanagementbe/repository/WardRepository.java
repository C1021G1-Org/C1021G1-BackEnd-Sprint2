package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WardRepository extends JpaRepository<Ward,Long> {
    @Query(value = "SELECT ward.id,ward.name,ward.prefix,ward.id_district,ward.id_province " +
            "FROM ward ", nativeQuery = true)
    List<Ward> getAllWard();

    @Query(value = "SELECT ward.id,ward.name,ward.prefix,ward.id_district,ward.id_province " +
            "FROM ward " +
            "where ward.id_district = ?", nativeQuery = true)
   List<Ward> getWardById(Long id);
}
