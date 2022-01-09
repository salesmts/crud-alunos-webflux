package com.osfdigital.reactivecrud.repository;

import com.osfdigital.reactivecrud.model.Aluno;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AlunoRepository extends ReactiveCrudRepository<Aluno, Long> {

    Mono<Aluno> findById(Long id);
}
