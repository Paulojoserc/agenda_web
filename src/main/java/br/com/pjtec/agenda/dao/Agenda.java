package br.com.pjtec.agenda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pjtec.agenda.model.Contato;

public class Agenda {
	public String cadastrarContato(Contato contato) throws SQLException {
		// Valida os campos em branco
		if (contato.getNome().equals("")) {
			return "Preencha o campo nome";
		}
		if (contato.getEmail().equals("")) {
			return "Preencha o campo email";
		}
		if (contato.getFone().equals("")) {
			return "Prenecha o campo telefone";
		}

		// Envia o contato (preenchido para o Banco
		ContatoDAO dao = new ContatoDAO();

		return dao.cadastrarContatoDAO(contato) ? "Castro efetuado com sucesso!" : "Erro ao cadastrat o contato";
	}
	public ResultSet buscarCantato(int id) throws SQLException{
		ContatoDAO dao = new ContatoDAO();
		return dao.buscarContatoDAO(id); // 0 == Todos
	}
}
