if __name__ == "__main__":
    def check_day():
        day = int(input("Enter the day: "))
        month = int(input("Enter the month: "))
        
        days_of_month = {
            1: 31,
            2: 28,  
            3: 31,
            4: 30,
            5: 31,
            6: 30,
            7: 31,
            8: 31,
            9: 30,
            10: 31,
            11: 30,
            12: 31
        }

        if month in days_of_month:

            if 1 <= day <= days_of_month[month]:
                print("La data és correcta.")
            else:
                print("La data és incorrecta: el dia no és vàlid per al mes.")
        else:
            print("La data és incorrecta: el mes no és vàlid.")
    
    check_day()
