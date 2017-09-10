package br.com.caelum.empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.empresa.modelo.Funcionario;

public class Principal {
	
	public static void main(String[] args) {
		
		Calendar dataNascimento = new GregorianCalendar(1995, 6, 17);
		Funcionario funcionario = new Funcionario("José", 25, dataNascimento);
		System.out.println(funcionario);
		
		Calendar dataNascimento2 = new GregorianCalendar(1995, 9, 3);
		Funcionario funcionario2 = new Funcionario("Caio", 100, dataNascimento2);
		
	}
}
