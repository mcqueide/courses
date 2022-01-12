import random

def jogar():
    nome = 'John'
    print(f'Meu nome é {nome}')
    print(f'Meu nome é {nome.upper()}')
    print(f'Meu nome é {nome*2}')
    print(f'Meu nome é {"John"}')
    print(f"Meu nome é {'John'}")

    resposta = random.randrange(1, 101)
    tentativas = 0
    pontos = 1000

    print(f'A resposta é {resposta}')
    print('Qual o nível de dificuldade?')
    print('(1) Fácil (2) Médio (3) Difícil')
    nivel = int(input('Defina o nível: '))

    if (nivel == 1):
        tentativas = 20
    elif (nivel == 2):
        tentativas = 10
    else:
        tentativas = 5

    for tentativa in range(1, tentativas + 1):

        chute = int(input('Dá um lance de 1 a 100: '))

        if (chute < 1 or chute > 100):
            print('Número inválido.')
            continue

        if (chute == resposta):
            print(f'Você acertou e fez {pontos} pontos!')
            break
        else:
            if (chute < resposta):
                print('Chute mais alto')
            else:
                print('Chute mais baixo')

            if (tentativa == tentativas):
                print(f'O número secreto era {resposta}. Você fez {pontos}')

        pontos_perdidos = abs(resposta - chute)
        pontos = pontos - pontos_perdidos

    # while (tentativa <= tentativas):
    #     chute = int(input('Dá um lance: '))
    #     if (chute == resposta):
    #         print('Você acertou.')
    #         break
    #     elif (chute < resposta):
    #         print('Chute mais alto')
    #     elif (chute > resposta):
    #         print('Chute mais baixo')
    #     tentativas = tentativas - 1

    print("Fim do jogo")

if (__name__ == "__main__"):
    jogar()