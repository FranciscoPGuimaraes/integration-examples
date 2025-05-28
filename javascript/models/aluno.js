
const db = require('../database/connection');

async function createAluno(aluno) {
    const [result] = await db.execute(
        "INSERT INTO alunos (nome, idade, matricula, email) VALUES (?, ?, ?, ?)",
        [aluno.nome, aluno.idade, aluno.matricula, aluno.email]
    );
    return result.insertId;
}

async function readAluno(id) {
    const [rows] = await db.execute(
        "SELECT * FROM alunos WHERE id = ?",
        [id]
    );
    return rows[0] || null;
}

async function readAllAlunos() {
    const [rows] = await db.execute("SELECT * FROM alunos");
    return rows;
}

async function deleteAluno(id) {
    await db.execute("DELETE FROM alunos WHERE id = ?", [id]);
}

module.exports = { createAluno, readAluno, readAllAlunos, deleteAluno };
