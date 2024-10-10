package com.projet.quizizback.app.ejemplocruduser.repository;

import com.projet.quizizback.app.ejemplocruduser.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<UserEntity, String> {

    /*@Query(value = """
        select  * from UserEntity u where u.id = :idValor
    """, nativeQuery = true)
    void elinarUser(@Param("idValor") String idValor);*/
}
