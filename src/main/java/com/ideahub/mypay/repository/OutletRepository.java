package com.ideahub.mypay.repository;

import com.ideahub.mypay.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletRepository extends JpaRepository<Outlet,Long> {

}
