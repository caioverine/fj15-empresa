package br.com.caelum.empresa.leitor;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class ImportadorDeGastos {
	
	SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyy");
	public List<Gasto> importa(InputStream entrada) throws ParseException {
		
		Scanner leitor = new Scanner(entrada);
		List<Gasto> gastos = new ArrayList<Gasto>();
		
		while (leitor.hasNextLine()) {
			
			String line = leitor.nextLine();
			String tipoDeGastoTxt = line.substring(0, 6);
			String dataDoGastoTxt = line.substring(6, 14);
			String valorDoGastoTxt = line.substring(14, 23);
			String matriculaTxt = line.substring(23, 26);
			String nome = line.substring(26, 56);
			String dataNascTxt = line.substring(56);
			
			double valor = Double.parseDouble(valorDoGastoTxt);
			int matricula = Integer.parseInt(matriculaTxt);
			
			Calendar dataNascimento = converteDataTxtParaCalendar(dataNascTxt);
			
			Calendar dataDespesa = converteDataTxtParaCalendar(dataDoGastoTxt);
			
			Funcionario funcionario = new Funcionario(nome, matricula, dataNascimento);
			gastos.add(new Gasto(valor, tipoDeGastoTxt, funcionario, dataDespesa));
		}
		leitor.close();
		return gastos;
	}
	private Calendar converteDataTxtParaCalendar(String dataNascTxt) throws ParseException {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(formatador.parse(dataNascTxt));
		return dataNascimento;
	}
}