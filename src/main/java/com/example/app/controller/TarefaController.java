package com.example.app.controller;

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

import com.example.app.model.Tarefa;
import com.example.app.service.TarefaService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações com o Banco de Dados H2 em uma interface
 * simples e coesa (API REST).
 * 
 * @author Filipe Miranda
 */
@RestController
@RequestMapping("tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping()
	public ResponseEntity<Iterable<Tarefa>> buscarTarefas() {
		return ResponseEntity.ok(tarefaService.buscarTarefas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscarTarefa(@PathVariable Long id) {
		return ResponseEntity.ok(tarefaService.buscarTarefa(id));
	}

	@PostMapping
	public ResponseEntity<Tarefa> inserirTarefa(@RequestBody Tarefa tarefa) {
		tarefaService.inserirTarefa(tarefa);
		return ResponseEntity.ok(tarefa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> alterarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
		tarefaService.alterarTarefa(id, tarefa);
		return ResponseEntity.ok(tarefa);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
		tarefaService.excluirTarefa(id);
		return ResponseEntity.ok().build();
	}
}
