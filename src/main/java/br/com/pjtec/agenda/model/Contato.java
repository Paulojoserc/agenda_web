package br.com.pjtec.agenda.model;

import java.util.Objects;

public class Contato {
private int id;	
private String Nome;
private String Email;
private String Fone;
public Contato(){}
public Contato(String nome, String email, String fone) {
	Nome = nome;
	Email = email;
	Fone = fone;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return Nome;
}
public void setNome(String nome) {
	Nome = nome;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getFone() {
	return Fone;
}
public void setFone(String fone) {
	Fone = fone;
}
@Override
public int hashCode() {
	return Objects.hash(Email, Fone, Nome);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Contato other = (Contato) obj;
	return Objects.equals(Email, other.Email) && Objects.equals(Fone, other.Fone) && Objects.equals(Nome, other.Nome);
}
@Override
public String toString() {
	return "Contato [Nome=" + Nome + ", Email=" + Email + ", Fone=" + Fone + "]";
}


}
