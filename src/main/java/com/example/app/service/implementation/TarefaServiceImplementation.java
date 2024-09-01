package com.example.app.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Tarefa;
import com.example.app.model.TarefaRepository;
import com.example.app.model.Usuario;
import com.example.app.model.UsuarioRepository;
import com.example.app.service.TarefaService;

/**
 * Implementação da <b>Strategy</b> {@link TarefaService}, que foi injetada
 * pelo Spring (via {@link Autowired}). Dessa forma, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author Filipe Miranda
 */
@Service
public class TarefaServiceImplementation implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Iterable<Tarefa> buscarTarefas() {
		return tarefaRepository.findAll();
	}

	@Override
	public Tarefa buscarTarefa(long idTarefa) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(idTarefa);
		return tarefa.get();
	}

	@Override
	public void inserirTarefa(Tarefa tarefa) {
		Optional<Usuario> usuario = usuarioRepository.findById(tarefa.getUsuario().getId());
		if (usuario.isPresent()) {
			tarefaRepository.save(tarefa);
		}

	}

	@Override
	public void alterarTarefa(Long idTarefa, Tarefa tarefa) {
		Optional<Tarefa> tarefaBd = tarefaRepository.findById(idTarefa);
		if (tarefaBd.isPresent()) {
			tarefaRepository.save(tarefa);
		}

	}

	@Override
	public void excluirTarefa(Long idTarefa) {
		tarefaRepository.deleteById(idTarefa);

	}

}
