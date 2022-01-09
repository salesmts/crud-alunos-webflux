package com.osfdigital.reactivecrud.controller;

import com.osfdigital.reactivecrud.model.Aluno;
import com.osfdigital.reactivecrud.service.AlunoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("alunos")
@Slf4j
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public Flux<Aluno> listAll() {
        return alunoService.findAll();
    }

    @GetMapping(path = "{id}")
    public Mono<Aluno> findById(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Aluno> save(@Valid @RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> update(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
        return alunoService.update(aluno.withId(id));
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Long id) {
        return alunoService.delete(id);
    }
}
