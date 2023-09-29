// Importa os módulos 'http' e 'fs' para criar um servidor web e ler arquivos.
const http = require('http');
const fs = require('fs');

// Cria um servidor HTTP utilizando a função 'createServer' do módulo 'http'.
const server = http.createServer((req, res) => { // A função recebe uma callback que é executada sempre que uma requisição é feita ao servidor.
    if (req.url === '/') {
        // Verifica se a URL da requisição é a raiz ("/").
        fs.readFile('index.html', (err, data) => { // Lê o arquivo 'index.html' de forma assíncrona.
            if (err) { // Se ocorrer um erro ao ler o arquivo:
                res.writeHead(500, { 'Content-Type': 'text/plain' }); // Define o código de resposta HTTP como 500 (Erro Interno do Servidor).

                res.end('Erro interno do servidor'); // Envia uma mensagem de erro para o cliente.

            } else { // Se a leitura do arquivo for bem-sucedida:
                res.writeHead(200, { 'Content-Type': 'text/html' }); // Define o código de resposta HTTP como 200 (OK) e o tipo de conteúdo como HTML.

                res.end(data); // Envia o conteúdo do arquivo 'index.html' como resposta para o cliente.
            }
        });
    }
});