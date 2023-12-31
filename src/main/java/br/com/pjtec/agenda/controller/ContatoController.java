package br.com.pjtec.agenda.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pjtec.agenda.dao.Agenda;
import br.com.pjtec.agenda.model.Contato;

@Controller
public class ContatoController {
	@PostMapping("/cadastrarContato")
	public String cadastrarContato(Model model, Contato contato) {
		Agenda agenda = new Agenda();
		try {
			String mensagem = agenda.cadastrarContato(contato);
			model.addAttribute("mensagem", mensagem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "cadastro";
	}
	@RequestMapping("/buscarContato")
	public String buscarContato(Model model) {
		Agenda agenda = new Agenda();
		try {
			ResultSet resultado = agenda.buscarCantato(0);
			
			if(!resultado.next()) {
				model.addAttribute("resultado", "Nenhum contato registrado");
				return"contato";
			}
			//Posiciona no início dos resultados
			resultado.beforeFirst();
			
			List<Contato> contatos = new ArrayList();
			while (resultado.next()) {
				//Preenche o objeto Contato com os daod cindos do navegador
				Contato contato = new Contato();
				contato.setId(resultado.getInt("id"));
				contato.setNome(resultado.getString("nome"));
				contato.setEmail(resultado.getString("email"));
				contato.setFone(resultado.getString("fone"));
				
				//Adiciona o Contato preenchido na lista
				contatos.add(contato);
				
			}
			//Guarda a lista preenchida no Model
			model.addAttribute("contatos", contatos);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return "contato";
	}
}
