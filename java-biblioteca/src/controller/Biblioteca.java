package controller;

//importa��es
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Autor;
import model.Data;
import model.Editora;
import model.Livro;
import model.Locacao;
import model.Usuario;

/**
 * Classe para controlar as op��es de acesso no sistema
 * 
 * @author Elisson Barbieri Machado
 * @since 18 de fev. de 2021
 */
public class Biblioteca {

	// declara��o de vetores
	private Livro livros[];
	private Usuario usuarios[];
	private Locacao locacoes[];

	// construtor
	public Biblioteca() {
		// chama o m�todo para executar o programa
		processar();
	}

	// variaveis auxiliares
	private int quantidadeLivros = 0;
	private int quantidadeUsuarios = 0;
	private int quantidadeLocacoes = 0;
	private String autor;
	private int auxiliar1;

	// metodo pincipal do programa
	public void processar() {

		// capturando do usuario o tamanho do estoque
		quantidadeLivros = Integer.parseInt(JOptionPane.showInputDialog("informe a quantidade de livros"));
		quantidadeUsuarios = Integer.parseInt(JOptionPane.showInputDialog("informe a quantidade de usuarios"));
		quantidadeLocacoes = Integer.parseInt(JOptionPane.showInputDialog("informe a quantidade de livros deseja locar"));

		// definindo o tamanho dos vetores
		livros = new Livro[quantidadeLivros];
		usuarios = new Usuario[quantidadeUsuarios];
		locacoes = new Locacao[quantidadeLocacoes];

		// processamento de looping do programa
		while (true) {
			escolhaUsuario();
		}
	}

	// metodo para capturara do usuario a op��o
	public void escolhaUsuario() {
		// menu com as op��es
		String menu = "informe a op��o desejada\n" + "OP��O 1: Cadastrar livro\n" + "OP��O 2: Cadastrar usuario\n"
				+ "OP��O 3: Efetuar loca��o de livros\n" + "OP��O 4: Efetuar devolu��o de livros\n"
				+ "OP��O 5: Listar todos os livros cadastrados\n" + "OP��O 6: Listar todos os usu�rios cadastrados\n"
				+ "OP��O 7: Pesquisar livros por editora\n" + "OP��O 8: Pesquisar livros por autor\n"
				+ "OP��O 9: Pesquisar loca��es por data\n" + "OP��O 10: Sair do sistema\n";
		// insere a escolha na variavel
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		escolhaProcessamento(escolha);

	}

	// metodo para sele��o das op��es do programa
	public void escolhaProcessamento(int opcao) {
		// escolhe o m�todo a ser chamado
		switch (opcao) {
		case 1:
			cadastrarLivro();
			break;

		case 2:
			cadastrarUsuario();
			break;

		case 3:
			locacaoDeLivro();
			break;

		case 4:
			devolucaoDeLivros();
			break;

		case 5:
			listarLivrosCadastrados();
			break;

		case 6:
			listarUsuariosCadastrados();
			break;

		case 7:
			pesquisarLivrosPorEditora();
			break;

		case 8:
			pesquisarLivrosPorAutor();
			break;

		case 9:
			pesquisarLocacoesPorData();
			break;

		case 10:
			sairDoSistema();
			break;
		default:
			JOptionPane.showInternalMessageDialog(null, "Op��o inv�lida!", "Controle de biblioteca", 0);// erro
			break;
		}
	}

	// m�todo para sair do sistema
	public void sairDoSistema() {
		// encerra o programa
		System.exit(0);
	}

	// metodo para cadastrar livro
	public void cadastrarLivro() {
		// variavel auxiliar para verificar se gravou
		boolean gravado = false;

		// la�o para verificar espa�o em estoque
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] == null) {
				livros[i] = criarLivro();
				gravado = true;
				break;
			}
		}

		// exibindo o resultado para o usuario
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Livro gravado com sucesso", "Controle de biblioteca", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Biblioteca cheia", "Controle de biblioteca", 2);

		}

	}

	// m�todo para devolver um livro para cadastro de livro
	public Livro criarLivro() {
		Autor autor = new Autor();
		Editora editora = new Editora();
		Livro livro = new Livro();

		// recebendo do usuario o dados do livro
		livro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo")));
		livro.setTitulo((JOptionPane.showInputDialog("Informe o nome do titulo")));
		// recebe do usuario dados do autor pra atribuir ao livro
		autor.setNome(JOptionPane.showInputDialog("Informe o autor"));
		autor.setNacionalidade(JOptionPane.showInputDialog("Informe a nascionalidade do autor"));
		autor.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do autor")));
		// recebe do usuario dados da editora pra atribuir ao livro
		editora.setNome(JOptionPane.showInputDialog("Informe a editora"));
		editora.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("informe o codigo da editora")));
		editora.setPais(JOptionPane.showInputDialog("Informe o pais da editora"));
		// verifica se est� disponivel para loca��o
		int disponivel = Integer
				.parseInt(JOptionPane.showInputDialog("1 - Disponivel para loca��o \n2 - N�o disponivel para loca��o"));

		if (disponivel == 1) {
			livro.setDisponivel(true);
		} else {
			livro.setDisponivel(false);
		}

		// recebe mais dados do livro
		livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de publica��o")));
		livro.setEditora(editora);
		livro.setAutor(autor);
		return livro;
	}

	// metodo para fazer o cadastro de usuario
	public void cadastrarUsuario() {

		// variavel auxiliar para verificar se gravou
		boolean gravado = false;

		// la�o para verificar espa�o em estoque
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				usuarios[i] = criarUsuario();
				gravado = true;
				break;
			}
		}

		// exibindo o resultado para o usuario
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Usuario gravado com sucesso", "Controle de biblioteca", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Limite de usuarios cadastrados", "Controle de biblioteca", 2);

		}

	}

	// m�todo para criar usuario
	public Usuario criarUsuario() {

		Usuario usuario = new Usuario();
		Data dataNascimento = new Data();

		// capturando algumas informa��es do usuario e atribuindo no vetor de usuario
		usuario.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo de usuario")));
		usuario.setNome(JOptionPane.showInputDialog("Informe seu nome"));
		dataNascimento.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o seu ano de nascimento")));
		dataNascimento.setMes(Integer.parseInt(JOptionPane.showInputDialog("Informe o seu mes de nascimento")));
		dataNascimento.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe o seu dia de nascimento")));
		usuario.setTelefone(JOptionPane.showInputDialog("Informe seu telefone"));
		usuario.setEmail(JOptionPane.showInputDialog("Informe seu email"));
		// atribui a data ao usuario
		usuario.setDataNascimento(dataNascimento);

		return usuario;
	}

	// metodo para efetur a loca��o de livros
	public void locacaoDeLivro() {

		// cria��oo dos vetores e variaveis
		Data data = new Data();
		Locacao locacao = new Locacao();
		Livro livrosLocacao1[];
		boolean usuarioExiste = false;
		String mensagemUsuario = "";
		String mensagem = "";

		// mostrando os usuarios cadastrados
		for (int l = 0; l < usuarios.length; l++) {
			if (usuarios[l] != null) {
				mensagemUsuario += "Nome: " + usuarios[l].getNome() + "\n";
			}
		}

		// recebendo o codigo do usuario
		int auxiliarCodigo1 = Integer
				.parseInt(JOptionPane.showInputDialog(mensagemUsuario + "\nInforme o codigo do usuario"));

		// verificando se usuario ja esta cadastrado
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getCodigo() == auxiliarCodigo1) {
				usuarioExiste = true;
				// seta o usuario dentro do usuario de locacao
				locacao.setUsuario(usuarios[i]);
			}
		}

		if (usuarioExiste) {
			// biblioteca para setar o dia de locacao
			GregorianCalendar calendario = new GregorianCalendar();
			int dia = calendario.get(GregorianCalendar.DAY_OF_MONTH);
			int mes = calendario.get(GregorianCalendar.MONTH);
			int ano = calendario.get(GregorianCalendar.YEAR);

			// setando a data de locacao
			data.setDia(dia);
			data.setMes(mes + 1);
			data.setAno(ano);

			// setando a loca��o
			locacao.setDataLocacao(data);

			// perguntando a quantidades de livros que o usuario vai emprestar
			int quantidadeLivros = Integer
					.parseInt(JOptionPane.showInputDialog("Informe a quantidade de livros que deseja locar"));

			livrosLocacao1 = new Livro[quantidadeLivros];

			// laco para ver a quantidade de livros a ser emprestado
			for (int k = 0; k < quantidadeLivros;) {
				// mostrando todos os livros e codigos disponiveis
				for (int i = 0; i < livros.length; i++) {
					if ((livros[i] != null) && (livros[i].isDisponivel())) {
						mensagem += "C�digo: " + livros[i].getCodigo() + " - Nome do livro - " + livros[i].getTitulo()
								+ "\n";
					}
				}

				// variavel auxiliar para realizar a loca��o
				int auxiliarLocar = Integer.parseInt(JOptionPane
						.showInputDialog(mensagem + "Informe o Codigo do livro " + (k + 1) + "� que deseja locar"));

				// iniciando a variavel para verificar se o livro foi locado
				boolean empresta = false;

				// buscando o livro com o codigo solicitado
				for (int j = 0; j < livros.length; j++) {
					if (livros[j] != null && livros[j].getCodigo() == auxiliarLocar
							&& livros[j].isDisponivel() == true) {
						// setando livro indisponivel para emprestimo
						livros[j].setDisponivel(false);
						// setando o vetor livro no loca�ao
						livrosLocacao1[k] = livros[j];
						empresta = true;
						// incrementa o contador de loca��es
						k++;
					}

					// zerando a mensagem
					mensagem = "";
				}
				// mensagem para ver se o livro foi locado com sucesso
				if (empresta) {
					// codigo para o setar o codigo de loca��o
					auxiliar1++;
					JOptionPane.showMessageDialog(null,
							"Livro locado com sucesso!\n\n" + "Data de Loca��o: " + locacao.getDataLocacao().toString(),
							"Emprestimo de Livro", 1);
				} else {
					JOptionPane.showMessageDialog(null, "N�o foi possivel concluir a loca��o", "Emprestimo de Livro",
							2);
				}
			}
			// setando o vetor de livros no locacao
			locacao.setLivros(livrosLocacao1);
			locacao.setCodigo(auxiliar1);

			// percorre o vetor locacoes para encontrar espa�os nulos
			for (int i = 0; i < locacoes.length; i++) {
				if (locacoes[i] == null) {
					// adiciona no vetor locacoes o metodo Locacao
					locacoes[i] = locacao;
					break;
				}
			}
			// caso o usuario n�o esteja cadastrado
		} else {
			JOptionPane.showMessageDialog(null, "Usuario n�o Existe!", "Emprestimo de Livro", 0);
		}
	}

	public void devolucaoDeLivros() {
		// cria e inicializa as variaveis
		Locacao locacao = new Locacao();
		Data data = new Data();
		String mensagemUsuario = "";
		String mensagemLivros = "";
		int valor = 0;
		int alugado = 0;
		boolean usuarioExiste = false;
		boolean devolvido = false;
		int codigoUsuario;
		int quantidadeDevolucao;

		// mostra os usuarios cadastrados
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagemUsuario += "nome: " + usuarios[i].getNome() + "\n";
			}

		}
		// usuario insere o codigo
		codigoUsuario = Integer
				.parseInt(JOptionPane.showInputDialog(mensagemUsuario + "\ninforme o codigo do usuario"));

		// verifica se esta cadastrado
		for (int i = 0; i < locacoes.length; i++) {
			if (locacoes[i] != null && locacoes[i].getUsuario().getCodigo() == codigoUsuario) {
				usuarioExiste = true;
				valor = i;
			}
		}

		if (usuarioExiste) {
			// biblioteca para setar o dia de locacao
			GregorianCalendar calendario = new GregorianCalendar();
			int dia = calendario.get(GregorianCalendar.DAY_OF_MONTH);
			int mes = calendario.get(GregorianCalendar.MONTH);
			int ano = calendario.get(GregorianCalendar.YEAR);

			// setando a data de devolucao
			data.setDia(dia);
			data.setMes(mes + 1);
			data.setAno(ano);

			// setando a loca��o
			locacao.setDataDevolucao(data);

			// verificando quantos emprestimos o usuario possui
			for (int m = 0; m < locacoes.length; m++) {
				if ((locacoes[m] != null) && (locacoes[m].getUsuario().getCodigo() == codigoUsuario)) {
					// la�o para concatenar os livros que o usuario locou
					for (int j = 0; j < locacoes[m].getLivros().length; j++) {
						alugado++;
					}
				}
			}

			// recebe a quantidade de livros a devolver
			quantidadeDevolucao = Integer.parseInt(
					"voce tem que devolver o(s) " + alugado + " livros alugados \ninforme quantos deseja devolver");

			// retirando os livros
			for (int i = 0; i < quantidadeDevolucao;) {
				// listagem de livros indisponiveis
				for (int m = 0; m < locacoes.length; m++) {
					if ((locacoes[m] != null) && (locacoes[m].getUsuario().getCodigo() == codigoUsuario)) {
						// la�o para concatenar os livros locados na 'mensagemLivros"
						for (int j = 0; j < locacoes[m].getLivros().length; j++) {
							mensagemLivros += "C�digo: " + locacoes[m].getLivros()[j].getCodigo()
									+ " - Nome do livro - " + locacoes[m].getLivros()[j].getTitulo() + "\n";

						}
					}

				}

				// recebe o codgio do livro a devolver
				int codigoDevolucao = Integer.parseInt(JOptionPane.showInputDialog(
						mensagemLivros + "\nInforme o c�digo do " + (i + 1) + "� livro que deseja devolver"));

				// zera a mensagem
				mensagemLivros = "";

				for (int j = 0; j < livros.length; j++) {
					if (livros[j] != null && livros[j].getCodigo() == codigoDevolucao
							&& livros[j].isDisponivel() == false) {
						// deixa o livro disponivel para emprestimo
						livros[j].setDisponivel(true);
						devolvido = true;
						// incremente o contador de devolu��es
						i++;

					}
				}
				// mostrando se o livro foi devolvido ou n�o
				if (devolvido) {
					JOptionPane.showMessageDialog(null,
							"livro devolvido\n\nData de devolu��o: " + locacao.getDataDevolucao().toString(),
							"Devolu��o de livro", 1);
				} else {
					JOptionPane.showMessageDialog(null, "houve um erro na devolu��o", "Devolu��o de livro", 2);

				}

			}
			// caso o usuario nao esteja cadastrado
		} else {
			JOptionPane.showMessageDialog(null, "usuario nao possui emprestimo", "Devolu��o de livros", 2);
		}
		locacoes[valor] = null;
	}

	// metodo para listar todos os livros cadastrados
	public void listarLivrosCadastrados() {

		// variavel euxiliar para exibir os ilvros para o usuario
		String mensagem = "";

		// varrendo o estoque para ver se existe livros cadastrado
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				mensagem += (i + 1) + " - " + livros[i].getTitulo() + "\n";
			}
		} // fim do for

		// exibindo o estoque ao usuario
		JOptionPane.showMessageDialog(null, mensagem, "Controle de biblioteca", 1);

	}

	// m�todo para listar todos os usuarios cadastrados
	public void listarUsuariosCadastrados() {
		// variavel euxiliar para exibir ao usuario
		String mensagem = "";

		// varrendo o estoque para ver se existe usuario cadastrado e ja atribui a
		// mensagem
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagem += (i + 1) + " - " + usuarios[i].getNome() + "\n";
			}
		} // fim do for

		// exibindo o estoque ao usuario
		JOptionPane.showMessageDialog(null, mensagem, "Controle de biblioteca", 1);

	}

	// metodo para pesquisar livros por editora
	public void pesquisarLivrosPorEditora() {
		// recebendo do usuario qual editora a ser pesquisado
		String editora = JOptionPane.showInputDialog("Informe a editora a ser pesquisada");

		// variavel auxiliar para exibir o resultado apresentado
		String mensagem = "pesquisa por editora\n\n";

		// variavel auxiliar para verificar se existe a editora cadastrado
		boolean existe = false;

		// varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && livros[i].getEditora().getNome().equals(editora)) {
				mensagem += mensagem(livros[i]);
				existe = true;
			}
		}

		// exibindo o resultado da pesquisa
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Controle de biblioteca", 1);
		} else {
			JOptionPane.showMessageDialog(null, "nao existem livros cadastrados", "Controle de biblioteca", 2);
		}

	}

	// pesquisar livros por autor
	public void pesquisarLivrosPorAutor() {
		// auxiliar que recebe o nome do autor a ser pesquisado
		autor = JOptionPane.showInputDialog("Informe o autor a ser pesquisada");

		// variavel auxiliar para exibir o resultado apresentado
		String mensagem = "pesquisa por autor\n\n";

		// variavel auxiliar para verificar se existe a editora cadastrado
		boolean existe = false;

		// varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < livros.length; i++) {
			if ((livros[i] != null) && (livros[i].getAutor().getNome().equals(autor))) {
				mensagem += mensagem(livros[i]);
				existe = true;
			}
		}

		// exibindo o resultado da pesquisa
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Controle de biblioteca", 1);
		} else {
			JOptionPane.showMessageDialog(null, "nao existem livros cadastrados", "Controle de biblioteca", 2);
		}

	}

	// metodo para montar mensagem para o usuario
	public String mensagem(Livro livro) {
		// variavel auxiliar para retornar a mensagem formatada
		String msg = "\n";

		// formatando a mensagem
		msg += "codigo________:  " + livro.getCodigo() + "\n";
		msg += "titulo________:  " + livro.getTitulo() + "\n";
		msg += "editora_______:  " + livro.getEditora().getNome() + "\n";
		msg += "autor_________:  " + livro.getAutor().getNome() + "\n";
		msg += "Ano de publica��o:  " + livro.getAnoPublicacao() + "\n";

		// retornando a varivel formatada
		return msg;
	}

	// pesquisar loca��es por data
	public void pesquisarLocacoesPorData() {
		Data data = new Data();
		boolean verificaLocacao = false;
		// auxiliar string para exibir a mensagem
		String mensagem = "As datas de Locacao dos Livros\n\n";

		// recebe do usuario o dia que deseja porcurar as loca�oes
		data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe o dia de Loca��o")));
		data.setMes(Integer.parseInt(JOptionPane.showInputDialog("Informe o mes de Loca��o")));
		data.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de Loca��o")));

		// verificando as loca�oes
		for (int i = 0; i < locacoes.length; i++) {
			if (locacoes[i] != null && locacoes[i].getDataLocacao().toString().equals(data.toString())) {
				// la�o para mostrar os livros da data pesquisada
				for (int j = 0; j < locacoes[i].getLivros().length; j++) {
					mensagem += (i + 1) + " Titulo do Livro: " + locacoes[i].getLivros()[j].getTitulo()
							+ "  Locado Por:" + locacoes[i].getUsuario().getNome() + "\n";
					verificaLocacao = true;
				}
			}
		}
		// exibindo em tela
		if (verificaLocacao) {
			JOptionPane.showMessageDialog(null, mensagem, "Busca Por Data", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o h� loca��o nesse dia", "Busca Por Data", 2);
		}

	}

}
