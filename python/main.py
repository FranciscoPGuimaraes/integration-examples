from database.connection import get_connection
from models.aluno import Aluno

def adicionar_aluno(connection):
    nome = input("Nome: ")
    idade = int(input("Idade: "))
    matricula = input("Matrícula: ")
    email = input("Email: ")
    aluno = Aluno(None, nome, idade, matricula, email)
    id = aluno.create(connection)
    print(f"Aluno criado com ID: {id}")

def buscar_aluno(connection):
    id = int(input("ID do aluno: "))
    aluno = Aluno.read(connection, id)
    if aluno:
        print(f"ID: {aluno.id}, Nome: {aluno.nome}, Idade: {aluno.idade}, Matrícula: {aluno.matricula}, Email: {aluno.email}")
    else:
        print("Aluno não encontrado.")
        
def buscar_todos_alunos(connection):
    alunos = Aluno.read_all(connection)
    if alunos:
        for aluno in alunos:
            print(f"ID: {aluno.id}, Nome: {aluno.nome}, Idade: {aluno.idade}, Matrícula: {aluno.matricula}, Email: {aluno.email}")
    else:
        print("Nenhum aluno encontrado.")

def deletar_aluno(connection):
    id = int(input("ID do aluno a deletar: "))
    sucesso = Aluno.delete(connection, id)
    if sucesso:
        print("Aluno deletado com sucesso.")
    else:
        print("Aluno não encontrado.")

def main():
    connection = get_connection('escola')
    if not connection:
        raise Exception("Não foi possível conectar ao banco de dados.")

    while True:
        print("\nMenu:")
        print("1 - Adicionar aluno")
        print("2 - Buscar aluno por ID")
        print("3 - Buscar todos os alunos")
        print("4 - Deletar aluno")
        print("0 - Sair")
        opcao = input("Escolha uma opção: ")

        if opcao == '1':
            adicionar_aluno(connection)
        elif opcao == '2':
            buscar_aluno(connection)
        elif opcao == '3':
            buscar_todos_alunos(connection)
        elif opcao == '4':
            deletar_aluno(connection)
        elif opcao == '0':
            break
        else:
            print("Opção inválida.")

if __name__ == "__main__":
    main()