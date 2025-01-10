if __name__ == "__main__":
        print("Teclea el primer numero a calcular:")
        A = input()
        A = int(A)

        print("Teclea el segundo numero a calcular:")
        B = input()
        B = int(B)

        Suma = A + B
        Resta = A - B
        Multiplicación = A * B
        if B == 0:
            print("No se puede dividir")
        else: 
            Division = A / B

        print("Suma: ", Suma )
        print("Resta: ", Resta )
        print("Multiplicacion: ", Multiplicación )
        print("División: ", Division )
            
