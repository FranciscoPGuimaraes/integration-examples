
const readline = require('readline-sync');
const { createAluno, readAluno, readAllAlunos, deleteAluno } = require('./models/aluno');

async function main() {
    while (true) {
        console.log("\n1 - Adicionar");
        console.log("2 - Buscar por ID");
        console.log("3 - Listar todos");
        console.log("4 - Deletar");
        console.log("0 - Sair");

        const opcao = readline.question("Escolha: ");
        if (opcao === "1") {
            const nome = readline.question("Nome: ");
            const idade = readline.questionInt("Idade: ");
            const matricula = readline.question("Matrícula: ");
            const email = readline.question("Email: ");
            const id = await createAluno({ nome, idade, matricula, email });
            console.log(`Aluno criado com ID: ${id}`);
        } else if (opcao === "2") {
            const id = readline.questionInt("ID: ");
            const aluno = await readAluno(id);
            if (aluno) console.log(aluno);
            else console.log("Aluno não encontrado.");
        } else if (opcao === "3") {
            const alunos = await readAllAlunos();
            alunos.forEach(a => console.log(a));
        } else if (opcao === "4") {
            const id = readline.questionInt("ID: ");
            await deleteAluno(id);
            console.log("Aluno deletado.");
        } else if (opcao === "0") break;
    }
}

main();
