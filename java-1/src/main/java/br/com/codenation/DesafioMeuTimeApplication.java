package br.com.codenation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.exceptions.*;
import br.com.codenation.entidades.Jogador;
import br.com.codenation.entidades.Time;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
	private List<Time> listaTimes = new ArrayList<>();
	private List<Jogador> listaJogadores = new ArrayList<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		verificarIDTimeExistente(id);
		listaTimes.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		verificarIDJogadorExistente(id);
		verificarIDTimeNaoExistente(idTime);
		listaJogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		verificarIDJogadorNaoExistente(idJogador);
		Long idTime = listaJogadores.stream().filter(jogador1 -> jogador1.getId().equals(idJogador)).findAny().get().getIdTime();
		Time time = listaTimes.stream().filter(time1 -> time1.getId().equals(idTime)).findAny().get();
		time.setIdCapitao(idJogador);

	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = buscaTime(idTime);
		if (time.getIdCapitao() == null) throw new CapitaoNaoInformadoException("Capitao nao informado");
		return time.getIdCapitao();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		return jogador.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		Time time = buscaTime(idTime);
		return time.getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		verificarIDTimeNaoExistente(idTime);
		List<Long> jogadores = this.listaJogadores.stream()
				.sorted(Comparator.comparingLong(Jogador::getId))
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.map(Jogador::getId)
				.collect(Collectors.toList());
		return jogadores;
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		return listaJogadores.stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.max(Comparator.comparing(Jogador::getNivelHabilidade))
				.map(Jogador::getId).orElseThrow(()-> new TimeNaoEncontradoException("time nao encontrado"));
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		return listaJogadores.stream().filter(jogador -> jogador.getIdTime().equals(idTime))
				.min(Comparator.comparing(Jogador::getDataNascimento))
				.map(Jogador::getId).orElseThrow(()-> new TimeNaoEncontradoException("time nao encontrado"));
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return listaTimes.stream().sorted(Comparator.comparingLong(Time::getId))
				.map(Time::getId).collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		return listaJogadores.stream().filter(jogador -> jogador.getIdTime().equals(idTime))
				.max(Comparator.comparing(Jogador::getSalario)).map(Jogador::getId)
				.orElseThrow(() -> new TimeNaoEncontradoException("time nao encontrado"));
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		verificarIDJogadorNaoExistente(idJogador);
		return listaJogadores.stream().filter(jogador -> jogador.getId().equals(idJogador)).
				findAny().get().getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return listaJogadores.stream().sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
				.limit(top).map(Jogador::getId).collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		if (timeDaCasa == null || timeDeFora == null) throw new NullPointerException("time nulo");
		Time timeCasa = listaTimes.stream().filter(time -> time.getId().equals(timeDaCasa)).findFirst().get();
		Time timeFora = listaTimes.stream().filter(time -> time.getId().equals(timeDeFora)).findFirst().get();
		return timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())
				? timeFora.getCorUniformeSecundario() : timeFora.getCorUniformePrincipal();
	}

	private void verificarIDTimeExistente(Long id){
		if(listaTimes.stream().anyMatch(time->time.getId().equals(id)))
			throw new IdentificadorUtilizadoException("time nao encontrado");
	}
	private void verificarIDTimeNaoExistente(Long id){
		if(!listaTimes.stream().anyMatch(time->time.getId().equals(id)))
			throw new TimeNaoEncontradoException("time nao encontrado");
	}
	private void verificarIDJogadorExistente(Long id){
		if(listaJogadores.stream().anyMatch(jogador->jogador.getId().equals(id)))
			throw new IdentificadorUtilizadoException("identificador invalido");
	}
	private void verificarIDJogadorNaoExistente(Long id){
		if(!listaJogadores.stream().anyMatch(jogador->jogador.getId().equals(id)))
			throw new JogadorNaoEncontradoException("identificador invalido");
	}
	private Jogador buscarJogador(Long idJogador){
		verificarIDJogadorNaoExistente(idJogador);
		return listaJogadores.stream().filter(jogador -> jogador.getId().equals(idJogador)).findAny().get();
	}

	private Time buscaTime(Long idTime){
		verificarIDTimeNaoExistente(idTime);
		return listaTimes.stream().filter(time -> time.getId().equals(idTime)).findAny().get();
	}
}
