package controller;

import java.util.concurrent.Semaphore;

public class CarControll
{
	
	private String cor = "";
	private Semaphore semaforo;
	private String direcao = "";
	public CarControll(String cor, String dir, Semaphore semaforo)
	{
		this.cor = cor;
		this.semaforo = semaforo;
		this.direcao = dir;
	}
	
	public void inicioCar()
	{
		new Thread()
		{
			public void run()
			{
				try {
					semaforo.acquire();
					moveCar();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					cruzamento();
					semaforo.release();
					
				}
			}
		}.start();;
	}
	
	public void moveCar()
	{
		
		System.out.println(this.cor + " comecou a andar no cruzamento.");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void cruzamento()
	{
		
		System.out.println("O carro " + this.cor + " passou no cruzamento para o " + this.direcao);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
