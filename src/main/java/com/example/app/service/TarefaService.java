package com.example.app.service;

import com.example.app.model.Tarefa;

public interface TarefaService {
	
	Iterable<Tarefa> buscarTarefas();
	Tarefa buscarTarefa(long idTarefa);
	void inserirTarefa(Tarefa tarefa);
	void alterarTarefa(Long idTarefa,Tarefa tarefa);
	void excluirTarefa(Long idTarefa);

}
