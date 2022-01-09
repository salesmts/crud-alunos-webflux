package com.osfdigital.reactivecrud.service;

import com.osfdigital.reactivecrud.model.Aluno;
import com.osfdigital.reactivecrud.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Flux<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Mono<Aluno> findById(Long id) {
        return alunoRepository.findById(id)
                .switchIfEmpty(monoResponseStatusNotFoundException());
    }

    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado!"));
    }

    public Mono<Aluno> save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Mono<Void> update(Aluno aluno) {
        return findById(aluno.getId())
                .map(alunoFound -> aluno.withId(alunoFound.getId()))
                .flatMap(alunoRepository::save)
                .thenEmpty(Mono.empty());
    }


    public Mono<Void> delete(Long id) {
        return findById(id)
                .flatMap(alunoRepository::delete);
    }
}
