package com.bruno.api_restfull.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.bruno.api_restfull.dto.EscolaDTO;
import com.bruno.api_restfull.model.Curso;
import com.bruno.api_restfull.model.Escola;
import com.bruno.api_restfull.service.CursoService;
import com.bruno.api_restfull.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/escolas")
public class EscolaController {
    
    @Autowired
    private EscolaService escolaService;

    @Autowired
    private CursoService cursoService;
    
    @GetMapping
    public List<Escola> getAllEscolas(){
        return escolaService.getAllEscolas();
    }

    @GetMapping("/{codigo_escola}")
    public ResponseEntity<Escola> getEscolaByCodigo(@PathVariable int codigo_escola){
        Escola escola = escolaService.getEscolaByCodigo(codigo_escola);
        return ResponseEntity.ok(escola);
    }
    
    @GetMapping("/{codigo_escola}/cursos")
    public List<Curso> getCursosEscola(@PathVariable int codigo_escola){
        Escola escola = escolaService.getEscolaByCodigo(codigo_escola);
        return escola.getCursos();
    }

    @PostMapping()
    public ResponseEntity<Escola> salvar(@Valid @RequestBody Escola escola, HttpServletRequest request, UriComponentsBuilder builder){
        escola = escolaService.save(escola);
        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+escola.getCodigo_escola()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PostMapping("/{codigo_escola}/cursos")
    public ResponseEntity<Curso> salvar(@PathVariable int codigo_escola, @RequestBody Curso curso, HttpServletRequest request, UriComponentsBuilder builder){
        curso = cursoService.save(curso, codigo_escola);
        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+curso.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{codigo_escola}")
    public ResponseEntity<Escola> atualizar(@RequestBody EscolaDTO escolaDTO, @PathVariable int codigo_escola){
        Escola escola = escolaService.fromDTO(escolaDTO);
        escola.setCodigo_escola(codigo_escola);
        escola = escolaService.update(escola);
        return ResponseEntity.ok(escola);
    }

    @DeleteMapping("/{codigo_escola}")
    public ResponseEntity<Void> remover(@PathVariable int codigo_escola) {
        escolaService.removeByCodigo(codigo_escola);
        return ResponseEntity.noContent().build();
    }

    // @DeleteMapping("/{codigo_escola}/curso/{codigo_curso}")
    // public ResponseEntity<Void> remover(@PathVariable int codigo_escola,@PathVariable int codigo_curso) {
    //     escolaService.removeByCodigo(codigo_escola);
    //     return ResponseEntity.noContent().build();
    // }

}
