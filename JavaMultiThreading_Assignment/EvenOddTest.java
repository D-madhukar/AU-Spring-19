
public class EvenOddTest
{
	public static int number = 0;
	public static void main(String[] args)
	{
		Object lock = new Object();
		Even even = new Even(lock);
		Odd odd = new Odd(number, lock);

		even.start();
		odd.start();
	}

	static class Even extends Thread
	{
		private Object lock;

		public Even(Object lock)
		{
			this.lock = lock;
		}

		public void run()
		{
			for(int i = 0; i < 100; i++)
			{
				synchronized(lock)
				{
					while(number % 2 == 1)
					{
						try
						{
							lock.wait();
						}
						catch(InterruptedException e)
						{

						}
					}

					System.out.println("Even: " + number++);
					lock.notify();
				}

			}
		}
	}

	static class Odd extends Thread
	{
		private Object lock;

		public Odd(Integer number, Object lock)
		{
			this.lock = lock;
		}

		public void run()
		{
			for(int i = 0; i < 100; i++)
			{
				synchronized(lock)
				{
					while(number % 2 == 0)
					{
						try
						{
							lock.wait();
						}
						catch(InterruptedException e)
						{

						}
					}

					System.out.println("Odd: " + number++);
					lock.notify();
				}

			}
		}
	}

}
