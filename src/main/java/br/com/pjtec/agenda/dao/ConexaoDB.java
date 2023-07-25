package br.com.pjtec.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
//Abre a conexao com o banco
	public Connection abrirConexao() throws SQLException{
		//Atributos de conexão
		String servidor = "localhost";
		String porta = ":3307";
		String nomeBanco = "agenda_db";
		String usuario = "root";
		String senha = "Alura123";
		
		//Monta a URL de conexão
		String url = "jdbc:mysql://"+servidor+porta+"/"+nomeBanco;
					//jdbc:mysql://localhost:3306/agenda_db
		
		//Interface de conexão com o DB
		Connection conn = DriverManager.getConnection(url, usuario, senha);
		return conn;
	}
	
	//Fecha a conexão com o Banco
	
	public void fecharConexao(Connection conexaoAberta) throws SQLException{
		conexaoAberta.close();
	}
}
