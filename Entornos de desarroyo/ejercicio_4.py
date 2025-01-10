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

        if A >= B >= C:
            print(A, "Es mayor")
        elif B >= C >= A:
            print(B, "Es mayor")
        elif C >= A >= B:
             print(C,"Es mayor")
        elif A==B==C:
             print("Los tres numeros son iguales")
        
      