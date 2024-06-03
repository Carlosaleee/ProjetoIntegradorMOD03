package com.api.ProjetoIntegradorApiRest.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<InscricaoEntity, Integer> {
}
