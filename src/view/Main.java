package view;

import java.util.concurrent.Semaphore;

import controller.CarControll;

public class Main 
{
	public static void main(String[] args)
	{
		Semaphore perm = new Semaphore(1);
		
		CarControll carro[] = 
		{
				new CarControll("Vermelho", "North", perm),
				new CarControll("Azul", "Sul", perm),
				new CarControll("Verde", "Leste", perm),
				new CarControll("Amarelo", "Oeste", perm)
		};
		
		for(int i = 0; i < 4; i++)
		{
			carro[i].inicioCar();
		}
		
	}

}
