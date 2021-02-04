package com.project.retail.Ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.retail.Ekart.Entity.Client;

@RepositoryRestResource(path = "clients")
public interface ClientRepository extends JpaRepository<Client, Integer> {


}
