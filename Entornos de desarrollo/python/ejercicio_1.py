if __name__ == "__main__":
    print("Teclea el primer numero:")
      
    A = input()

    print("Teclea el segundo numero:")
    B= input()

    A, B = B, A
     
    print("El primer numero ahora es: " + A )
    print("El segundo numero ahora es: " + B )