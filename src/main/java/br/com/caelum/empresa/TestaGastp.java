package br.com.caelum.empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class TestaGastp {

	public static void main(String[] args) {
		
		Calendar dataNascimento = new GregorianCalendar(1995, 01, 23);
		Funcionario funcionario = new Funcionario("Vinicius", 89, dataNascimento );
		Calendar hoje = Calendar.getInstance();
		
		Gasto gasto1 = new Gasto(65, "uber", funcionario, hoje);
		Gasto gasto2 = new Gasto(89, "rango", funcionario, hoje);
		Gasto gasto3 = new Gasto(17, "balinha", funcionario, hoje);
		
		System.out.println(gasto1);
		System.out.println(gasto2);
		System.out.println(gasto3);
	}
}
