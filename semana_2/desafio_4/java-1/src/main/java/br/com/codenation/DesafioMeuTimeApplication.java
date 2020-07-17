package br.com.codenation;


import java.util.*;

import java.util.stream.Collectors;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;

import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;

import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;

import java.time.LocalDate;

import java.util.ArrayList;

import br.com.codenation.desafio.annotation.Desafio;

import br.com.codenation.desafio.app.MeuTimeInterface;


public class DesafioMeuTimeApplication implements MeuTimeInterface {


	private Set<Time> times = new HashSet<>();

	private Set<Jogador> jogadores = new HashSet<>();



	private Optional<Time> buscarIdTime(Long id) {

		return times.stream().filter(time -> time.getId().equals(id)).findFirst();

	}


	private Optional<Jogador> buscarIdJogador(Long id) {

		return jogadores.stream().filter(jogador -> jogador.getId().equals(id)).findFirst();

	}


	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

		if (buscarIdTime(id).isPresent()) {

			throw new IdentificadorUtilizadoException();

		} else {

			times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));

		}

	}


	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		if (buscarIdJogador(id).isPresent()) {

			throw new IdentificadorUtilizadoException();

		}

		if (!buscarIdTime(idTime).isPresent()){

			throw new TimeNaoEncontradoException();

		}


		jogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));

	}


	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {


		Jogador capitao = buscarIdJogador(idJogador).orElseThrow(JogadorNaoEncontradoException::new);

		buscarIdTime(capitao.getIdTime()).get().setIdCapitao(idJogador);

	}


	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		Time time = buscarIdTime(idTime).orElseThrow(TimeNaoEncontradoException::new);


		if (time.getIdCapitao() == null) throw new CapitaoNaoInformadoException();

		return time.getIdCapitao();

	}


	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {


		return buscarIdJogador(idJogador).map(Jogador::getNome).orElseThrow(JogadorNaoEncontradoException::new);


	}


	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {


		return buscarIdTime(idTime).map(Time::getNome).orElseThrow(TimeNaoEncontradoException::new);


	}


	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {


		if(!buscarIdTime(idTime).isPresent()) throw new TimeNaoEncontradoException();


		return jogadores.stream()

				.filter(jogador -> jogador.getIdTime().equals(idTime))

				.sorted(Comparator.comparingLong(Jogador::getId))

				.map(Jogador::getId).collect(Collectors.toList());

	}


	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {

		//Usando Comparator.comparing()

		if(!buscarIdTime(idTime).isPresent()) throw new TimeNaoEncontradoException();


		return jogadores.stream()

				.filter(jogador -> jogador.getIdTime().equals(idTime))

				.min(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))

				.get().getId();

	}


	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {

		if (!buscarIdTime(idTime).isPresent()) throw new TimeNaoEncontradoException();


		return jogadores.stream()

				.filter(jogador -> jogador.getIdTime().equals(idTime))

				.min(Comparator.comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId))

				.get().getId();

	}


	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {

		return times.stream()

				.sorted(Comparator.comparing(Time::getId))

				.map(Time::getId)

				.collect(Collectors.toList());

	}


	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {

		if (!buscarIdTime(idTime).isPresent()) throw new TimeNaoEncontradoException();


		return jogadores.stream()

				.filter(jogador -> jogador.getIdTime().equals(idTime))

				.sorted(Comparator.comparing(Jogador::getSalario).reversed().thenComparing(Jogador::getId))

				.findFirst().get().getId();

	}


	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {


		return buscarIdJogador(idJogador).map(Jogador::getSalario).orElseThrow(JogadorNaoEncontradoException::new);

	}


	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		return jogadores.stream().sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId)).limit(top).map(Jogador::getId).collect(Collectors.toList());

	}


	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		Optional<Time> timeCasa = buscarIdTime(timeDaCasa), timeFora = buscarIdTime(timeDeFora);

		if (!timeCasa.isPresent() || !timeFora.isPresent()) {

			throw new TimeNaoEncontradoException();

		}

		if (timeCasa.get().getCorUniformePrincipal().equals(timeFora.get().getCorUniformePrincipal())) {

			return timeFora.get().getCorUniformeSecundario();

		} else {

			return timeFora.get().getCorUniformePrincipal();

		}

	}

}

