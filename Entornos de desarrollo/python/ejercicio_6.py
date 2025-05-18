import math

def ejercicio6():
    print("Teclea el primer numero :")
    A = input()
    A = int(A)

    if A <=0:
        print("Saliendo del programa...")
        return None
    else:
        print("Del número ",A ,"su potencia es", A*A, "y su raíz", (math.sqrt(A)))
            
if __name__ == "__main__":
    ejercicio6()
        

        
        
      