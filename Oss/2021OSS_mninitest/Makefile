CC=gcc
market: market.c product.o manager.o
	$(CC) -o market market.c product.o manager.o
product.o: product.h product.c
	$(CC) -c product.c
manager.o: manager.h manager.c
	$(CC) -c manager.c
clean:
	rm *.o market
