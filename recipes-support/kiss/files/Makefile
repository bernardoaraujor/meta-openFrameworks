all:
	${CC} ${CFLAGS} -Wall -fPIC -c kiss_fft.c -Dkiss_fft_scalar=float -o kiss_fft.o
	${AR} crus libkiss.a kiss_fft.o

clean:
	rm -f libkiss.a
