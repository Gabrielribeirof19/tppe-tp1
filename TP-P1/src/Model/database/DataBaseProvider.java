package model.database;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Month;

import model.Venda;

/**
 * Classe utilizada como pseudo banco de dados para o armazenamento de dados das vendas.
 */
public class DatabaseProvider {
	private static final List<Venda> VENDAS = new ArrayList<>();

	/**
	 * Construtor privado, para evitar que outras classes possam estanciá-la ou
	 * herdá-la.
	 */
	private DatabaseProvider() {

	}

	public static List<Venda> getVendas() {
		return VENDAS;
	}

	/**
	 * Método para buscar em O(n) dentro do database um o valor gasto por um determinado cliente.
	 */
	public static boolean isEspecial(int idClient) 
		LocalDate currentDate = LocalDate.now();
		int currentMonth = currentDate.getMonthValue();
		int currentYear = correntDate.getYearValue();
		double spentMoney = 0;
		boolean[] mes = new boolean[3];
		for (int i=0; i < 3; i++) {
			int monthCheck = currentMonth-i-1;
			if (monthCheck <= 0) {
				monthCheck += 12;
				currentYear -= 1;
			}
			for (Venda currentVenda : DatabaseProvider.getVendas()) {
				if (currentVenda.getClient().getId().equals(idClient) && currentVenda.getData().getMonthValue() == monthCheck && currentVenda.getData().getYearValue() == currentYear) {
					spentMoney += currentVenda.getValor();
				}
			}
			mes[i] = spentMoney > 100;
			spentMoney = 0;
		}

		return mes[0] && mes[1] && mes[2];
	}
}
