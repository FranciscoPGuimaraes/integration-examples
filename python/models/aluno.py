from mysql.connector import MySQLConnection

class Aluno:
    
    def __init__(self, id, nome, idade, matricula, email):
        self.id = id
        self.nome = nome
        self.idade = idade
        self.matricula = matricula
        self.email = email

    def create(self, connection: MySQLConnection):
        cursor = connection.cursor()
        sql = "INSERT INTO alunos (nome, idade, matricula, email) VALUES (%s, %s, %s, %s)"
        values = (self.nome, self.idade, self.matricula, self.email)
        cursor.execute(sql, values)
        connection.commit()
        self.id = cursor.lastrowid
        cursor.close()
        return self.id

    def read(connection: MySQLConnection, aluno_id: int):
        cursor = connection.cursor()
        sql = "SELECT id, nome, idade, matricula, email FROM alunos WHERE id = %s"
        cursor.execute(sql, (aluno_id,))
        row = cursor.fetchone()
        cursor.close()
        if row:
            return Aluno(*row)
        return None
    
    def read_all(connection: MySQLConnection):
        cursor = connection.cursor()
        sql = "SELECT id, nome, idade, matricula, email FROM alunos"
        cursor.execute(sql)
        rows = cursor.fetchall()
        cursor.close()
        if rows:
            return [Aluno(*row) for row in rows]
        return []

    def update(self, connection: MySQLConnection):
        cursor = connection.cursor()
        sql = "UPDATE alunos SET nome = %s, idade = %s, matricula = %s, email = %s WHERE id = %s"
        values = (self.nome, self.idade, self.matricula, self.email, self.id)
        cursor.execute(sql, values)
        connection.commit()
        cursor.close()

    def delete(connection: MySQLConnection, aluno_id: int):
        cursor = connection.cursor()
        sql = "DELETE FROM alunos WHERE id = %s"
        cursor.execute(sql, (aluno_id,))
        connection.commit()
        cursor.close()