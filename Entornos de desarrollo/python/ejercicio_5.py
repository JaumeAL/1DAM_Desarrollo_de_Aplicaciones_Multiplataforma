if __name__ == "__main__":
        print("Teclea el primer numero :")
        A = input()
        A = int(A)

        print("Teclea el segundo numero :")
        B = input()
        B = int(B)

        print("Teclea el tercer numero :")
        C = input()
        C = int(C)

        if A < 0:
            print("Producto de los 3: ", A * B * C)
        else:
            print("La suma de los 3 es: ", A + B + C)